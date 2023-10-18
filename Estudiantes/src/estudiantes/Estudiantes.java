/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estudiantes;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Estudiantes extends Thread {

    public static void main(String[] args) {
        List<String> ListaAlumnos = new ArrayList<>();
        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingrese la cantidad de alumnos a ingresar: ");
        int num_alumnos = entrada.nextInt();

        for (int i = 0; i < num_alumnos; i++) {
            System.out.println("Ingrese el nombre del alumno: ");
            String Alumno = entrada.next();
            ListaAlumnos.add(Alumno);
        }

        Thread listadoHilo = new Thread(() -> {
            for (String alumno : ListaAlumnos) {
                System.out.println("Alumno: " + alumno);

                // Creamos y ejecutamos un hilo para solicitar el promedio del alumno actual
                Thread promedioHilo = new Thread(() -> {
                    double promedio = 0;

                    System.out.print("Ingrese la cantida de notas del alumno " + alumno + ": ");
                    int cantidadNotas = entrada.nextInt();
                    int sumaNotas = 0;

                    for (int i = 0; i < cantidadNotas; i++) {
                        System.out.println("Ingrese la nota: ");
                        int notas = entrada.nextInt();
                        sumaNotas += notas;
                    }
                    if (cantidadNotas > 0) {
                        promedio = (double) sumaNotas / cantidadNotas;

                    }
                    System.out.println("El promedio de " + alumno + " es: " + promedio);
                });

                promedioHilo.start(); // Iniciamos el hilo para el promedio
                try {
                    promedioHilo.join(); // Esperamos a que termine el hilo del promedio antes de continuar
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        listadoHilo.start(); // Iniciamos el hilo para el listado

        try {
            listadoHilo.join(); // Esperamos a que termine el hilo del listado antes de terminar el programa
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        entrada.close();
    }
}
