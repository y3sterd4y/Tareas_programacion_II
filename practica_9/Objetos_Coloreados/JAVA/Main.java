import java.util.ArrayList;

interface Coloreado {
    String comoColorear();
}

/////////////////////////////////////////////////////////////////////////

abstract class Figura {
    protected String color;
    
    public Figura() {
        
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public String getColor() {
        return color;
    }
    
    public abstract double area();
    public abstract double perimetro();
    
    @Override
    public String toString() {
        return "Figura{color=" + color +"}";
    }
}

/////////////////////////////////////////////////////////////////////////

class Cuadrado extends Figura implements Coloreado {
    private int lado;
    
    public Cuadrado(String color) {
        this.lado = (int) (Math.random() * 100) + 1;
        this.color = color;
    }
    
    public double area() {
        return lado * lado;
    }
    
    public double perimetro() {
        return 4 * lado;
    }
    
    @Override
    public String comoColorear() {
        return "Colorear los cuatro colores de " + color;
    } 
    
    @Override
    public String toString() {
        return "Cuadrado{color=" + color +", lado=" + lado + "}";
    }
}

/////////////////////////////////////////////////////////////////////////

class Circulo extends Figura implements Coloreado {
    private int radio;
    
    public Circulo(String color) {
        this.radio = (int) (Math.random() * 100) + 1;
        this.color = color;
    }
    
    public double area() {
        return (radio * radio) * Math.PI;
    }
    
    public double perimetro() {
        return 2 * Math.PI * radio;
    }    
    
    @Override
    public String comoColorear() {
        return "Colorear el circulo de " + color;
    }   
    
    @Override
    public String toString() {
        return "Circulo{color=" + color +", radio=" + radio + "}";
    }    
}

/////////////////////////////////////////////////////////////////////////

public class Main
{
	public static void main(String[] args) {
	    ArrayList<Figura> figuritas = new ArrayList<>();
	    
		Cuadrado c1 = new Cuadrado("rojo");
		Cuadrado c2 = new Cuadrado("amarillo");
		Cuadrado c3 = new Cuadrado("azul");
		
		Circulo cir1 = new Circulo("verde");
		Circulo cir2 = new Circulo("negro");
		Circulo cir3 = new Circulo("rosa");
		
		figuritas.add(c1);
		figuritas.add(c2);
		figuritas.add(c3);
		figuritas.add(cir1);
		figuritas.add(cir2);
		figuritas.add(cir3);
		
		for (Figura f : figuritas) {
		    System.out.println(f);
		    System.out.println(f.area());
		    System.out.println(f.perimetro());
		    
            if (f instanceof Cuadrado) {
                System.out.println(((Cuadrado) f).comoColorear());
            } else if (f instanceof Circulo) {
                System.out.println(((Circulo) f).comoColorear());
            }
            
		    System.out.println();
		    
		}
	}
}
