package service.storage;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import service.beans.Cuenta;
import service.beans.Cliente;

public class CuentaStore {
    private static String[][] data =
  {{"1","1","HER-01","0001","20/9/12"},
     {"2","1","SJO-01","0002","20/9/12"},
     {"3","2","ALA-01","0003","20/9/12"},
     {"4","1","PUN-01","0004","20/9/12"},
     {"5","2","HER-01","0005","20/9/12"},
     {"6","2","SJO-01","0006","20/9/12"}};

    private static Map<String,Cuenta> store;
    private static CuentaStore instance = null;
    private CuentaStore() {
        store = new HashMap<String,Cuenta>();
        initStore();
    }
    public static Map<String,Cuenta> getStore() {
        if(instance==null) {
            instance = new CuentaStore();
        }
        return store;
    }
    private void initStore() {
        Map clientes = ClienteStore.getStore();
        for (int i=0;i<data.length;i++) {
		//(String id, String cliente, String sucursal, String numero,String fechaApertura)	
            Cuenta cuenta = new Cuenta();
			cuenta.setId(data[i][0]);
            cuenta.setCliente(data[i][1]);
            cuenta.setSucursal(data[i][2]);
            cuenta.setId(data[i][3]);
            cuenta.setFechaApertura(data[i][4]);
            store.put(cuenta.getId(),cuenta);
            Cliente cliente = (Cliente)clientes.get(data[i][6]);
            if (cliente!=null) {
              List cuentas = cliente.getCuentas();
              cuentas.add(cuenta);
            }
        }
    }
}