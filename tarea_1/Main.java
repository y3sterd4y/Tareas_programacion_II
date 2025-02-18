///////////////////////// ESTA ES LA CLASE PUNTO (Punto.JS) //////////////////////////

class Punto {
    private double x;
    private double y;
    
    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public void  cordCartesianas() {
        System.out.println("Las cordenadas cartesianas del punto son: (" + x + "," + y +")" );
    }
    
    public void  cordPolares() {
        double r = Math.sqrt(x*x + y*y);
        double C = Math.atan(y/x);
        System.out.println("Las cordenadas Polares del punto son : (" + r + "," + C + ")");
    }
    
    @Override
    public String toString() {
        return "Punto{x= " + x + "y= " + y +"}";
    }
    
}

///////////////////////// ESTA ES LA CLASE PRINCIPAL (Main.JS) //////////////////////////

public class Main
{
	public static void main(String[] args) {
		Punto puntito = new Punto(3, 4);
		
		puntito.cordCartesianas();
		puntito.cordPolares();
		
		System.out.println(puntito);
		
		
	}
}











