import java.util.Queue; 
import java.util.LinkedList;

class Impresora {
    private Queue<TrabajoDeImpresora> cola_impresion;
    
    public Impresora() {
        this.cola_impresion = new LinkedList<>();
    }
    
    public void agregarImpresion(TrabajoDeImpresora t) {
        System.out.println("Se agrego " + t);        
        cola_impresion.add(t);
    }
    
    public void imprimirTrabajo() {
        System.out.println("Se imprimio el trabajo " + cola_impresion.remove());
    }
    
    public void verColaImpresion() {
        System.out.println(cola_impresion);
    }
}