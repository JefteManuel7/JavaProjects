/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nota;

import java.util.Scanner;

/**
 *
 * @author jefte
 */
public class main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int opcion = 0;
        boolean salir = false;
        do {
            System.out.println("Por favor seleccione una opcion");
            System.out.println("    1. Menu del Admin");
            System.out.println("    2. Menu de Profesor");
            System.out.println("    3. Menu del Alumno");
            System.out.println("    4. Salir del sistema");
            opcion = entrada.nextInt();
           
            
            if (opcion == 1) {
                Admin mensajero = new Admin();
                mensajero.Login();
                System.out.println();
                mensajero.Menu();
            } else if (opcion == 2) {
                Profesor mensajero = new Profesor();
                mensajero.Login();
                System.out.println();
                mensajero.Menu(); 

            } else if (opcion == 3) {
                Alumno mensajero = new Alumno();
                mensajero.Login();
                System.out.println("");
                mensajero.Menu();

            } else if (opcion == 4) {
                System.out.println("Gracias, vuelva pronto");
                salir = true; 
            }
        } while (!salir);
    }

}
