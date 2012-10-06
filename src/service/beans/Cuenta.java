package service.beans;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Cuenta {
    private String id;//numero de cuenta
    private String cliente;
    private String sucursal;
    private String tipoCuenta;
    private String fechaApertura;
	//private List<Transaccion> transacciones;

    public Cuenta() {}   
    public Cuenta(String id, String cliente, String sucursal, String numero,
                 String fechaApertura) {
        this.id = id;
        this.cliente = cliente;
        this.sucursal = sucursal;
        this.tipoCuenta = tipoCuenta;
        this.fechaApertura = fechaApertura;
    }
    public void setId(String id) {this.id=id;}
    public String getId() {return id;}
    public void setCliente(String cliente) {this.cliente=cliente;}
    public String getCliente() {return cliente;}
    public void setSucursal(String sucursal) {this.sucursal=sucursal;}
    public String getSucursal() {return sucursal;}
    public void setTipoCuenta(String tipoCuenta) {this.tipoCuenta=tipoCuenta;}
    public String getTipoCuenta() {return tipoCuenta;}
    public void setFechaApertura(String fechaApertura) {this.fechaApertura=fechaApertura;}
    public String getFechaApertura() {return fechaApertura;}
}