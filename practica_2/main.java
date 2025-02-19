*/  
    Practica 2
    Nombre: Alex Gabriel Nina Aliaga
    
    Las clases Linea y Circulo fueron aumentadas al la practica anterior 
*/

/////////////////////////  CLASE PUNTO  /////////////////////////////////////////
class Punto {
    private double x;
    private double y;
    
    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }
    
    public void  cordCartesianas() {
        System.out.println("Las cordenadas cartesianas del punto son: (" + x + ", " + y +")" );
    }
    
    public void  cordPolares() {
        double r = Math.sqrt(x*x + y*y);
        double C = Math.atan(y/x);
        System.out.println("Las cordenadas Polares del punto son : (" + r + ", " + C + ")");
    }
    
    public String imprimirPunto() {
        return "(" + x + ", " + y + ")";
    }
    
    @Override
    public String toString() {
        return "Punto{x = " + x + ",y = " + y +"}";
    }
}

//////////////////////  CLASE LINEA //////////////////////////////////////////

class Linea {
    private Punto p1;
    private Punto p2;
    
    public Linea(Punto p1, Punto p2) {
        this.p1 = p1;
        this.p2 = p2;
    }
    
    @Override
    public String toString() {
        return "Linea{punto1 = " + p1.imprimirPunto() + " punto2 = " + p2.imprimirPunto() + "}";
    }
    
    public void dibujarLinea() {
        double ekis = p2.getX() - p1.getX();
        double ies = p2.getY() - p1.getY();
        
        double pendiente = ies / ekis;
        double distancia = Math.sqrt((ekis*ekis) + (ies*ies));
        
        System.out.println("La linea tiene una pendiente " + pendiente + " la distancia de punto a punto es " + distancia);
    }
    
}

//////////////////////////// CLASE CIRCULO //////////////////////////////////////////////

class Circulo {
    private Punto centro;
    private float radio;
    
    public Circulo(Punto centro, float radio) {
        this.centro = centro;
        this.radio = radio;
    }
    
    @Override
    public String toString() {
        return "Circulo{centro = " + centro + " radio = " + radio;
    }
    
    public void dibujarCirculo() {
        double area = 3.14 * Math.pow(radio, 2);
        System.out.println("El area del circulo " + area + " con centro en el " + centro);
    }
}

///////////////////////// CLASE PRINCIPAL (IMPORTANTE)//////////////////////////

public class Main
{
	public static void main(String[] args) {
		Punto pp1 = new Punto(3, 4);
		Punto pp2 = new Punto(6, 5);
		
		System.out.println(pp1);
		pp1.cordCartesianas();
		pp1.cordPolares();
		
		System.out.println("--------------------------------------------");
		
		Linea l1 = new Linea(pp1, pp2);
		System.out.println(l1);
		l1.dibujarLinea();
		
		System.out.println("--------------------------------------------");
		
		Circulo c1 = new Circulo(pp1, 3);
		System.out.println(c1);
		c1.dibujarCirculo();
		
		
	}
}