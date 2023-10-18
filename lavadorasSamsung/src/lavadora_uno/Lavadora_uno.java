
package lavadora_uno;
import libreria.LLFunciones;
import java.util.Scanner;
/**
 *
 * @author jefte
 */
public class Lavadora_uno {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        System.out.println("La ropa es blanca o de color?");
        System.out.println("Presiona 1-para ropa blanca / 2-para color");
        int TipoDeRopa = entrada.nextInt();
        
        System.out.println("Cuantos de kilo de ropa?");
        int kilos = entrada.nextInt();
        
        
        LLFunciones mensajero = new LLFunciones(kilos, TipoDeRopa);
        mensajero.setTipoDeRopa(2);
        System.out.println("El tipo de ropa es: " + mensajero.getTipoDeRopa());
        mensajero.CicloFinalizado();
    }
    
}
