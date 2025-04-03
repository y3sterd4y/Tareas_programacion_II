class Vector {
    private double x;
    private double y;
    private double z;
    
    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public Vector suma(Vector v) {
        return new Vector(this.x + v.x, this.y + v.y, this.z + v.z);
    }
    
    public Vector resta(Vector v) {
        return new Vector(this.x - v.x, this.y - v.y, this.z - v.z);
    }  
    
    public Vector multPorEscalar(double numero) {
        return new Vector(this.x * numero, this.y * numero, this.z * numero);
    }
    
    public double magnitud() {
        return Math.sqrt(x*x + y*y + z*z);
    }
    
    @Override
    public String toString() {
        return String.format("Vector(%.2f, %.2f, %.2f)", x, y, z);
    }
}

public class Main
{
	public static void main(String[] args) {
		Vector v1 = new Vector(1,2,3);
		Vector v2 = new Vector(4,5,6);
		
		Vector v3 = v1.suma(v2);
		System.out.println(v3);
		
		Vector v4 = v1.multPorEscalar(2);
		System.out.println(v4);
		
		System.out.println(v1.magnitud());
	}
}




           