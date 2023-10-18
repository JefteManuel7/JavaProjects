
package com.mycompany.ejercicioparcial_venta;
import java.util.Scanner;

/**
 *
 * @author jefte
 */
public class EjercicioParcial_venta {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar información de los vendedores
        System.out.print("Ingrese la cantidad de vendedores: ");
        int numVendedores = scanner.nextInt();
        scanner.nextLine();

        String[] codigos = new String[numVendedores];
        String[] nombres = new String[numVendedores];
        String[] apellidos = new String[numVendedores];
        double[][] ventas = new double[numVendedores][12];

        for (int i = 0; i < numVendedores; i++) {
            System.out.println("Ingrese los datos del vendedor " + (i + 1) + ":");
            System.out.print("Código: ");
            codigos[i] = scanner.nextLine();
            System.out.print("Nombre: ");
            nombres[i] = scanner.nextLine();
            System.out.print("Apellidos: ");
            apellidos[i] = scanner.nextLine();
            for (int j = 0; j < 12; j++) {
                System.out.print("Ventas de " + meses[j] + ": ");
                ventas[i][j] = scanner.nextDouble();
            }
            scanner.nextLine();
        }

        // Calcular la media de todas las ventas
        double mediaVentas = calcularMediaVentas(ventas);
        System.out.println("Media de todas las ventas: " + mediaVentas);

        // Calcular la sumatoria de todas las ventas
        double sumatoriaVentas = calcularSumatoriaVentas(ventas);
        System.out.println("Sumatoria de todas las ventas: " + sumatoriaVentas);

        // Calcular la sumatoria de las ventas del primer trimestre
        double sumatoriaPrimerTrimestre = calcularSumatoriaPrimerTrimestre(ventas);
        System.out.println("Sumatoria de las ventas del primer trimestre: " + sumatoriaPrimerTrimestre);

        // Imprimir las ventas de un mes X por cada vendedor
        System.out.print("Ingrese el mes (1-12): ");
        int mes = scanner.nextInt();
        System.out.println("Ventas del mes " + meses[mes - 1] + " por cada vendedor:");
        imprimirVentasPorMes(ventas, mes);

        // Determinar las ventas de un empleado X por cada mes
        System.out.print("Ingrese el código del vendedor: ");
        String codigoVendedor = scanner.next();
        System.out.println("Ventas del vendedor " + codigoVendedor + " por cada mes:");
        imprimirVentasPorVendedor(ventas, codigos, codigoVendedor);

        // Determinar la sumatoria de ventas mensual
        double[] sumatoriaMensual = calcularSumatoriaMensual(ventas);
        System.out.println("Sumatoria de ventas mensual:");
        imprimirSumatoriaMensual(sumatoriaMensual);

        // Determinar la sumatoria de ventas de un empleado
        System.out.print("Ingrese el código del vendedor: ");
        codigoVendedor = scanner.next();
        double sumatoriaVendedor = calcularSumatoriaVendedor(ventas, codigos, codigoVendedor);
        System.out.println("Sumatoria de ventas del vendedor " + codigoVendedor + ": " + sumatoriaVendedor);

        // Imprimir los nombres de los vendedores que superaron la media de las ventas anuales
        System.out.println("Vendedores que superaron la media de ventas anuales:");
        imprimirVendedoresPorEncimaDeMedia(ventas, codigos, mediaVentas);

        // Imprimir la cantidad de empleados que están debajo de la media anual
        int cantidadEmpleadosDebajoMedia = contarEmpleadosDebajoDeMedia(ventas, mediaVentas);
        System.out.println("Cantidad de empleados por debajo de la media anual: " + cantidadEmpleadosDebajoMedia);

        // Imprimir el nombre del vendedor que más vendió en el mes de diciembre
        int indiceVendedorMasVentasDiciembre = obtenerIndiceVendedorMasVentasMes(ventas, 12);
        String nombreVendedorMasVentasDiciembre = nombres[indiceVendedorMasVentasDiciembre];
        System.out.println("Vendedor con más ventas en diciembre: " + nombreVendedorMasVentasDiciembre);
    }

    // Array de meses
    static String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
            "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

    // Calcular la media de todas las ventas
    static double calcularMediaVentas(double[][] ventas) {
        double sumatoria = 0;
        int contador = 0;

        for (double[] vendedorVentas : ventas) {
            for (double venta : vendedorVentas) {
                sumatoria += venta;
                contador++;
            }
        }

        return sumatoria / contador;
    }

    // Calcular la sumatoria de todas las ventas
    static double calcularSumatoriaVentas(double[][] ventas) {
        double sumatoria = 0;

        for (double[] vendedorVentas : ventas) {
            for (double venta : vendedorVentas) {
                sumatoria += venta;
            }
        }

        return sumatoria;
    }

    // Calcular la sumatoria de las ventas del primer trimestre
    static double calcularSumatoriaPrimerTrimestre(double[][] ventas) {
        double sumatoria = 0;

        for (double[] vendedorVentas : ventas) {
            for (int i = 0; i < 3; i++) {
                sumatoria += vendedorVentas[i];
            }
        }

        return sumatoria;
    }

    // Imprimir las ventas de un mes X por cada vendedor
    static void imprimirVentasPorMes(double[][] ventas, int mes) {
        for (int i = 0; i < ventas.length; i++) {
            System.out.println("Vendedor " + (i + 1) + ": " + ventas[i][mes - 1]);
        }
    }

    // Determinar las ventas de un empleado X por cada mes
    static void imprimirVentasPorVendedor(double[][] ventas, String[] codigos, String codigoVendedor) {
        int indiceVendedor = -1;
        for (int i = 0; i < codigos.length; i++) {
            if (codigos[i].equals(codigoVendedor)) {
                indiceVendedor = i;
                break;
            }
        }

        if (indiceVendedor != -1) {
            for (int i = 0; i < 12; i++) {
                System.out.println(meses[i] + ": " + ventas[indiceVendedor][i]);
            }
        } else {
            System.out.println("Vendedor no encontrado.");
        }
    }

    // Determinar la sumatoria de ventas mensual
    static double[] calcularSumatoriaMensual(double[][] ventas) {
        double[] sumatoriaMensual = new double[12];

        for (double[] vendedorVentas : ventas) {
            for (int i = 0; i < 12; i++) {
                sumatoriaMensual[i] += vendedorVentas[i];
            }
        }

        return sumatoriaMensual;
    }

    // Imprimir la sumatoria de ventas mensual
    static void imprimirSumatoriaMensual(double[] sumatoriaMensual) {
        for (int i = 0; i < 12; i++) {
            System.out.println(meses[i] + ": " + sumatoriaMensual[i]);
        }
    }

    // Determinar la sumatoria de ventas de un empleado
    static double calcularSumatoriaVendedor(double[][] ventas, String[] codigos, String codigoVendedor) {
        int indiceVendedor = -1;
        for (int i = 0; i < codigos.length; i++) {
            if (codigos[i].equals(codigoVendedor)) {
                indiceVendedor = i;
                break;
            }
        }

        if (indiceVendedor != -1) {
            double sumatoriaVendedor = 0;
            for (int i = 0; i < 12; i++) {
                sumatoriaVendedor += ventas[indiceVendedor][i];
            }
            return sumatoriaVendedor;
        } else {
            return 0;
        }
    }

    // Imprimir los nombres de los vendedores que superaron la media de las ventas anuales
    static void imprimirVendedoresPorEncimaDeMedia(double[][] ventas, String[] codigos, double mediaVentas) {
        for (int i = 0; i < ventas.length; i++) {
            double sumatoriaVendedor = 0;
            for (double venta : ventas[i]) {
                sumatoriaVendedor += venta;
            }
            double mediaVendedor = sumatoriaVendedor / ventas[i].length;
            if (mediaVendedor > mediaVentas) {
                System.out.println(codigos[i]);
            }
        }
    }

    // Contar la cantidad de empleados que están debajo de la media anual
    static int contarEmpleadosDebajoDeMedia(double[][] ventas, double mediaVentas) {
        int contador = 0;
        for (double[] vendedorVentas : ventas) {
            double sumatoriaVendedor = 0;
            for (double venta : vendedorVentas) {
                sumatoriaVendedor += venta;
            }
            double mediaVendedor = sumatoriaVendedor / vendedorVentas.length;
            if (mediaVendedor < mediaVentas) {
                contador++;
            }
        }
        return contador;
    }

    // Obtener el índice del vendedor que más vendió en un mes específico
    static int obtenerIndiceVendedorMasVentasMes(double[][] ventas, int mes) {
        int indiceVendedor = 0;
        double maxVentas = ventas[0][mes - 1];

        for (int i = 1; i < ventas.length; i++) {
            if (ventas[i][mes - 1] > maxVentas) {
                maxVentas = ventas[i][mes - 1];
                indiceVendedor = i;
            }
        }

        return indiceVendedor;
    }
}

    

