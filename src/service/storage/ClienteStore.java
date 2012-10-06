package service.storage;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import service.beans.Cuenta;
import service.beans.Cliente;

public class ClienteStore {
    private static String[][] data = {
    {"1","Fernandez","Fernando","Heredia","Heredia","3456-7890"},
    {"2","Martinez","Martin","Perez Zeledon","San Jose","6677-3456"},
    {"3","Rodriguez","Rodriga","Palmares","Alajuela","67455-7788"},
    {"4","Andrade","Andrea","Barranca","Puntarenas","3333-7890"}};
    private static Map<String,Cliente> store;
    private static ClienteStore instance = null;
    private ClienteStore() {
        store = new HashMap<String,Cliente>();
        initStore();
    }
    public static Map<String,Cliente> getStore() {
        if(instance==null) {
            instance = new ClienteStore();
            CuentaStore.getStore();
        }
        return store;
    }
    private void initStore() {
        for (int i=0;i<data.length;i++) {
		//(String id, String apellido, String nombre,String ciudad, String provincia, String telefono, List<Cuenta> cuentas) 
            Cliente cliente = new Cliente();
            cliente.setId(data[i][0]);
			cliente.setApellido(data[i][1]);
            cliente.setNombre(data[i][2]);
            cliente.setCiudad(data[i][3]);
            cliente.setProvincia(data[i][4]);
            cliente.setTelefono(data[i][5]);
            store.put(cliente.getId(),cliente);
        }
    }
}