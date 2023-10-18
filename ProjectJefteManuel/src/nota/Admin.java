package nota;

import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author jefte
 */
public class Admin extends Menu {

    Scanner entrada = new Scanner(System.in);
    String claveAcceso = "contra";
    String usuarioAcceso = "AdminOficial";

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
                    accesoCorrecto = true;
                } else {
                    throw new Exception("Clave de acceso incorrecta");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    protected void Menu() {
        boolean salir = false;
        while (!salir) {
            int opcion;
            System.out.println("---------------------");
            System.out.println("Menu de Administrador");
            System.out.println("---------------------");
            System.out.println("Seleccione una opcion");
            System.out.println("    1. Agregar profesores");
            System.out.println("    2. Agregar alumnos");
            System.out.println("    3. Agregar curso");
            System.out.println("    4. Salir ");
            opcion = entrada.nextInt();
            try {
                switch (opcion) {
                    case 1:
                        AgregarProfesor();
                        break;
                    case 2:
                        AgregarAlumno();
                        break;
                    case 3:
                        AgregarMateria();
                        break;

                    case 4:
                        System.out.println("Gracias, vuelva pronto");
                        salir = true;

                    default:
                        System.out.println("Clave de acceso incorrecta");
                        
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    protected void AgregarProfesor() {
        String nameProfesor, materiaEjercer, sexo, nivelAcademico;
        int edad;
        System.out.println("Ingrese el nombre del profesor: ");
        nameProfesor = entrada.next();
        System.out.println("Ingrese el nivel academico o ingenieria: ");
        nivelAcademico = entrada.next();
        System.out.println("Ingrese el sexo del profesor");
        sexo = entrada.next();
        System.out.println("Ingrese la edad del profesor");
        edad = entrada.nextInt();
        System.out.println("Ingrese la materia que ejercera");
        materiaEjercer = entrada.next();

        System.out.println("---------------------------");
        System.out.println("El profesor: " + nameProfesor);
        System.out.println("Del sexo " + sexo);
        System.out.println("Con el nivel academico: " + nivelAcademico);
        System.out.println("Con la edad de: " + edad);
        System.out.println("Impartira el curso/materia de: " + materiaEjercer);
        System.out.println("-------------------------------");
    }

    protected void AgregarAlumno() {
        String nameAlumno, materia, sexo;
        int edad, año;
        System.out.println("Ingrese el nombre del alumno: ");
        nameAlumno = entrada.next();
        System.out.println("Ingrese la edad del alumno: ");
        edad = entrada.nextInt();
        System.out.println("Ingrese el sexo del alumno: ");
        sexo = entrada.next();
        System.out.println("Ingrese la materia en la que se inscribira: ");
        materia = entrada.next();
        System.out.println("Ingrese el año escolar que el alumno tiene: ");
        año = entrada.nextInt();

        System.out.println("---------------------------------");
        System.out.println("El alumno con el nombre de: " + nameAlumno);
        System.out.println("De sexo: " + sexo);
        System.out.println("Con la edad : " + edad);
        System.out.println("Se inscribio en la materia de: " + materia);
        System.out.println("El cual cursa el año: " + año);
        System.out.println("--------------------------------");

    }

    protected void AgregarMateria() {
        String nameMateria, codigoMateria;
        System.out.println("Ingrese el nombre de la materia: ");
        nameMateria = entrada.next();
        System.out.println("Ingrese el codigo de la materia: ");
        codigoMateria = entrada.next();
        System.out.println("Ingrese la fecha (formato: AAAA-MM-DD):");

        System.out.println("------------------------");
        System.out.println("La materia: " + nameMateria);
        System.out.println("Con el codigo de: " + codigoMateria);
        System.out.println("-----------------------");
    }
}
