
package poo_jefte_beltran;
import java.util.Date; 

public class Trabajador {
    private String nombre;
    private String puesto;
    private String direccion;
    private String telefono;
    private Date fechaNacimiento; 
    private Date fechaContrato; 
    
    //constructor
    public Trabajador(String nombre){
        this.nombre = nombre; 
    
    }

     //metodos
    public String toString(){
    return nombre; 
    
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(Date fechaContrato) {
        this.fechaContrato = fechaContrato;
    }
    
    public double CalcularPaga(){
    return 0.0; 
    }
}
