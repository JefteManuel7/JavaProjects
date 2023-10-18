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
public class Profesor extends Menu {

    Scanner entrada = new Scanner(System.in);
    String claveAcceso = "contra";
    String usuarioAcceso = "admin";
    private int promedio;
    private String MateriaIns;

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
            System.out.println("Menu de profesor: por favor seleccione una opcion");
            System.out.println("    1. Agregar alumno");
            System.out.println("    2. Agregar notas de alumno");
            System.out.println("    3. Agregar comentarios sobre alumno");
            System.out.println("    4. Agregar nuevo curso");
            System.out.println("    5. Salir del sistema");
            opcion = entrada.nextInt();
            try {
                switch (opcion) {
                    case 1:
                        AgregarAlumno();
                        break;
                    case 2:
                        NotasAlumno();
                        break;
                    case 3:
                        ComentariosAlumno();
                        break;

                    case 4:
                        NuevoCurso();
                        break;
                    case 5:
                        salir = true;
                        break;

                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }

    protected void AgregarAlumno() {
        String nameAlumno, sexo, materia;
        int numCurso, edad;

        System.out.print("Ingrese el nombre del alumno: ");
        nameAlumno = entrada.next();
        System.out.print("Ingrese el sexo del alumno: ");
        sexo = entrada.next();
        System.out.print("Ingrese la edad del alumno: ");
        edad = entrada.nextInt();
        System.out.print("Ingrese la materia que cursara el alumno: ");
        materia = entrada.next();

        System.out.println("----------------------------------------------------------------");
        System.out.println("El alumno: " + nameAlumno);
        System.out.println("De sexo: " + sexo);
        System.out.println("Con la edad de: " + edad);
        System.out.println("Cursara el curso sobre: " + materia);
        System.out.println("----------------------------------------------------------------");
        setMateriaIns(materia);
    }

    protected void NotasAlumno() {
        int cantNota, notas = 0, Promedio, sumNotas = 0;
        System.out.println("Ingrese la cantidad de notas a evaluar?");
        cantNota = entrada.nextInt();

        for (int i = 0; i < cantNota; i++) {
            System.out.println("Ingrese la nota");
            notas = entrada.nextInt();
            sumNotas += notas;
        }
        Promedio = sumNotas / cantNota;
        System.out.println("--------------------------------------");
        System.out.println("El promedio del alumno es: " + Promedio);
        System.out.println("-----------------------------------------");
        setPromedio(Promedio);

    }

    protected void ComentariosAlumno() {
        AgregarAlumno();
        String comentario;
        System.out.println("Agregue el comentario sobre el alumno");
        comentario = entrada.nextLine();

    }

    protected void NuevoCurso() {
        int codigoCurso;
        String nombreCurso, Facilitador, Horario;
        System.out.println("Ingrese el nombre del curso/materia");
        nombreCurso = entrada.nextLine();
        System.out.println("Ingrese el codigo del curso");
        codigoCurso = entrada.nextInt();
        System.out.println("Ingrese el nombre del facilitador que impartira el curso");
        Facilitador = entrada.nextLine();
        System.out.println("Ingrese el horario en el que se impartira el curso");
        Horario = entrada.nextLine();
    }

    public int getPromedio() {
        return promedio;
    }

    public void setPromedio(int promedio) {
        this.promedio = promedio;
    }

    public String getMateriaIns() {
        return MateriaIns;
    }

    public void setMateriaIns(String MateriaIns) {
        this.MateriaIns = MateriaIns;
    }

}
