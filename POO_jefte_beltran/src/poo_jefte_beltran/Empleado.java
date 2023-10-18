
package poo_jefte_beltran;

/**
 *
 * @author jefte
 */
public class Empleado extends Trabajador {
    private double sueldo;
    private double igss;
    
    public Empleado(String nombre, double sueldo) {
        super(nombre);
        this.sueldo = sueldo; 
        this.igss = 0.483 * sueldo; 
    }
    
    
    public double CalcularPaga(){
        return(sueldo - igss);
    }
    
    public String toString(){
    return "Empleado: " + super.toString();
    }
    
}
