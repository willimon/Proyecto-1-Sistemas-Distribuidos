package service.beans;
import java.util.List;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Cliente {
  private String id;
  private String apellido;
  private String nombre;
  private String ciudad;
  private String provincia;
  private String telefono;
  private List<Cuenta> cuentas;

  public Cliente() {
    cuentas = new ArrayList<Cuenta>();
  }
  public Cliente(String id, String apellido, String nombre,
					String ciudad, String provincia, 
                    String telefono, List<Cuenta> cuentas) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.telefono = telefono;
        this.cuentas = cuentas;
    }
  public void setId(String id) {this.id = id;}
  public void setApellido(String ced) {this.apellido = ced;}
  public void setNombre(String nomb) {this.nombre = nomb;}
  public void setCiudad(String ciudad) {this.ciudad = ciudad;}
  public void setProvincia(String corr) {this.provincia = corr;}
  public void setTelefono(String tel) {this.telefono = tel;}
  public String getId() { return id; }
  public String getApellido() { return apellido; }
  public String getNombre() { return nombre; }
  public String getCiudad() { return ciudad; }
  public String getProvincia() { return provincia; }
  public String getTelefono() { return telefono; }
  @XmlElement(name="cuenta")
  public List<Cuenta> getCuentas() { return cuentas; }
  public void setCuentas(List<Cuenta> cuentas) { this.cuentas = cuentas;}
}