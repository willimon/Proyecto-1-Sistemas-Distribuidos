package service.resources;
import java.util.ArrayList;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;
import service.beans.Cuenta;
import service.beans.Cliente;
import service.storage.ClienteStore;
import service.util.ParamUtil;

import com.sun.jersey.api.NotFoundException;

public class ClienteResource {
    @Context
    UriInfo uriInfo;
    @Context
    Request request;
    String cliente;

    public ClienteResource(UriInfo uriInfo, Request request, String cliente) {
        this.uriInfo = uriInfo;
        this.request = request;
        this.cliente = cliente;
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Cliente getCliente() {
        Cliente client = ClienteStore.getStore().get(cliente);
        if(client==null)
            throw new NotFoundException("No Existe el Cliente.");
        return client;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public Response putCliente(JAXBElement<Cliente> jaxbCliente) {
        Cliente c = jaxbCliente.getValue();
        return putAndGetResponse(c);
    }

    @PUT
    public Response putCliente(@Context HttpHeaders herders, byte[] in) {
        Map<String,String> params = ParamUtil.parse(new String(in));
        Cliente c = new Cliente(params.get("id"), params.get("apellido"), params.get("nombre"), params.get("ciudad"), params.get("provincia"), params.get("telefono"),
                new ArrayList<Cuenta>());
        return putAndGetResponse(c);
    }

    private Response putAndGetResponse(Cliente p) {
        Response res;
        if(ClienteStore.getStore().containsKey(p.getId())) {
            res = Response.noContent().build();
        } else {
            res = Response.created(uriInfo.getAbsolutePath()).build();
        }
        ClienteStore.getStore().put(p.getId(), p);
        return res;
    }

    @DELETE
    public void deleteCliente() {
        Cliente p = ClienteStore.getStore().remove(cliente);
        if(p==null)
            throw new NotFoundException("No existe el cliente.");
    }
}