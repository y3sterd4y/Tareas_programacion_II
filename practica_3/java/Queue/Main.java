import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        
        Impresora imp = new Impresora();
        
        imp.agregarImpresion(new TrabajoDeImpresora("hola mundito", 7));
        imp.agregarImpresion(new TrabajoDeImpresora("joder que rico", 7));
        imp.agregarImpresion(new TrabajoDeImpresora("adios mundo cruel", 7));
        imp.agregarImpresion(new TrabajoDeImpresora("que estoy haciendo", 7));
        imp.agregarImpresion(new TrabajoDeImpresora("todo esto puede ser???", 7));
        
        
        imp.verColaImpresion();
        imp.imprimirTrabajo();
        imp.verColaImpresion();
        
    }
}
