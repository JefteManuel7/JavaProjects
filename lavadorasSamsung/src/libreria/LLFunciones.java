
package libreria;

/**
 *
 * @author jefte
 */
public class LLFunciones {
    private int kilos = 0, llenadoCompleto = 0, TipoDeRopa = 0, lavadoCompleto = 0, secadoCompleto = 0;  
    
    public LLFunciones(int kilos, int TipoDeRopa){
        this.kilos = kilos; 
        this.TipoDeRopa = TipoDeRopa;
    }
    
    private void Llenado(){
        if(kilos <= 12){
            llenadoCompleto = 1;
            System.out.println("Llenado...");
            System.out.println("Llenado Completo");
        }else{
            System.out.println("La carga de ropa es muy pesada, reduce la carga");
        }
    }
    
    private void Lavado(){
        Llenado();
        if(llenadoCompleto == 1){
            if(TipoDeRopa == 1 ){
                System.out.println("Ropa blanca / Lavado suave");
                System.out.println("Lavando...");
                lavadoCompleto = 1;
            }
         else {
            if(TipoDeRopa == 2){
                    System.out.println("Ropa de color / lavado fuerte");
                    System.out.println("Lavando...");
                    lavadoCompleto = 1;
        
            } else{
                System.out.println("El tiempo de ropa no esta disponible");
                System.out.println("Lavando como ropa de color / lavado intenso");
                lavadoCompleto = 1; 
        }
        }
        }
    }
    private void Secado(){
        Lavado();
        if(lavadoCompleto == 1){
            System.out.println("Secando...");
            secadoCompleto =1;
        }
        
    }
    
    public void CicloFinalizado(){
        Secado();
        if(secadoCompleto == 1){
            System.out.println("Tu ropa esta lista.");
        }
    }
    
    public int getTipoDeRopa(){
        return TipoDeRopa;
    }
    
    public void setTipoDeRopa(int TipoDeRopa){
        this.TipoDeRopa = TipoDeRopa; 
    }
        
    }

