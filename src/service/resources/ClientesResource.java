package service.resources;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import service.beans.Cliente;
import service.beans.Cuenta;
import service.storage.ClienteStore;

@Path("/clientes")
public class ClientesResource {

    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Cliente> getClientes() {
        List<Cliente> clientes = new ArrayList<Cliente>();
        clientes.addAll( ClienteStore.getStore().values() );
        return clientes;
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String getCount() {
        int count = ClienteStore.getStore().size();
        return String.valueOf(count);
    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void newCliente(
            @FormParam("id") String id,
            @FormParam("apellido") String apellido,
            @FormParam("nombre") String nombre,
            @FormParam("ciudad") String ciudad,
            @FormParam("provincia") String provincia,
            @FormParam("telefono") String telefono,
            @Context HttpServletResponse servletResponse
    ) throws IOException {
        Cliente p = new Cliente(id,apellido,nombre,ciudad,provincia,telefono,new ArrayList<Cuenta>());
        ClienteStore.getStore().put(id, p);

        URI uri = uriInfo.getAbsolutePathBuilder().path(id).build();
        Response.created(uri).build();

        servletResponse.sendRedirect("../pages/new_cliente.html");
    }

    @Path("{Cliente}")
    public ClienteResource getCliente(
            @PathParam("Cliente") String Cliente) {
        return new ClienteResource(uriInfo, request, Cliente);
    }
}