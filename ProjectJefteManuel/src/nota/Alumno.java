package nota;

import java.util.Scanner;

/**
 *
 * @author jefte
 */
public class Alumno extends Menu {

    Scanner entrada = new Scanner(System.in);
    String claveAcceso = "contra";
    String usuarioAcceso = "alumno";

    @Override
    protected void Login() {
        boolean accesoCorrecto = false;

        while (!accesoCorrecto) {
            String clave, usuario;
            System.out.println("Ingrese la clave de acceso: ");
            clave = entrada.nextLine();
            System.out.println("Ingrese el usuario de acceso: ");
            usuario = entrada.nextLine();

            try {
                if (clave.equals(claveAcceso) && usuario.equals(usuarioAcceso)) {
                    System.out.println("----------------------------------");
                    System.out.println("Clave de acceso y usuario correctos");
                    System.out.println("Bienvenido");
                    System.out.println("-----------------------------------");
                    accesoCorrecto = true; // Cambia el estado a "true" para salir del ciclo
                } else {
                    throw new Exception("Clave de acceso incorrecta"); // Lanza una excepción
                }
            } catch (Exception e) {
                System.out.println(e.getMessage()); // Muestra el mensaje de la excepción
            }
        }

    }

    @Override
    protected void Menu() {
        boolean salir = false;

        while (!salir) {
            int opcion = 0;
            System.out.println("--------------------");
            System.out.println("Menu para alumnos: ");
            System.out.println("--------------------");
            System.out.println("    1. Ver Notas. ");
            System.out.println("    2. Materias Inscritas");
            System.out.println("    3. Agregar comentarios sobre Facilitador");
            System.out.println("    4. Salir");
            opcion = entrada.nextInt();

            try {
                switch (opcion) {
                    case 1:
                        VerNotas();
                        break;
                    case 2:
                        VerMaterias();
                        break;
                    case 3:
                        AgregarComentarios();
                        break;

                    case 4:
                        System.out.println("Saliendo del sistema...");
                        salir = true;

                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

    protected void VerNotas() {
        Profesor mensajero = new Profesor();
        mensajero.setPromedio(8);
        mensajero.getPromedio();
        System.out.println("Tu promedio es: " + mensajero.getPromedio());
    }

    protected void VerMaterias() {
        Profesor mensajero = new Profesor();
        mensajero.setMateriaIns("Matematicas");
        mensajero.getMateriaIns();
        System.out.println("La materia a cual estas inscrito es: " + mensajero.getMateriaIns());
    }

    protected void AgregarComentarios() {
        int opcion = 0;
        String Comentarios, materia = "";
        System.out.println("Seleccione la materia: ");
        System.out.println("    1. Matematicas");
        System.out.println("    2. Ciencias");
        System.out.println("    3. Fisica");
        System.out.println("    4. Lenguaje");
        opcion = entrada.nextInt();
        if (opcion == 1) {
            System.out.println("Has escogido matematicas");
            materia = "Matematicas";
        } else if (opcion == 2) {
            System.out.println("Has escogido Ciencias");
            materia = "Ciencias";
        } else if (opcion == 3) {
            System.out.println("Has escogido Fisica");
            materia = "Fisica";
        } else if (opcion == 4) {
            System.out.println("Has escogido Lenguaje");
            materia = "Lenguaje";
        }
        System.out.println("------------------------------------------");
        System.out.println("Ingrese el comentario sobre su facilitador");
        Comentarios = entrada.next();

        System.out.println();
        System.out.println("-----------------------------------------------");
        System.out.println("Su comentario acerca del facilitador: " + Comentarios);
        System.out.println("de la Materia: " + materia);
        System.out.println("------------------------------------------------");

    }

}
