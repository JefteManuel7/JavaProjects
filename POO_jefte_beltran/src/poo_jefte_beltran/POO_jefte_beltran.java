
package poo_jefte_beltran;

/**
 *
 * @author jefte
 */
public class POO_jefte_beltran {

    public static void main(String[] args) {
        //declaracion de variables
       Trabajador trabajador; 
        Empleado empleado; 
        Consultor consultor; 
        
        //crear objetos
        trabajador = new Trabajador("Jorge");
        empleado = new Empleado("Alejandro", 5000.00);
        consultor = new Consultor("Andrea", 40, 75.00);
        
        
        //mostrar en pantalla
        System.out.println(trabajador);
        System.out.println(empleado);
        System.out.println(consultor); 
       
       Trabajador[] trabajadores = new Trabajador[2];
       
       trabajadores[0] = new Empleado("Jorge", 8000);
       trabajadores[1] = new Consultor("Alejandro", 40, 150.00);
       
       
       
        for (int i = 0; i < 2; i++) {
            System.out.println(trabajadores[i].CalcularPaga());
        }
       
       
    }   
    
}
