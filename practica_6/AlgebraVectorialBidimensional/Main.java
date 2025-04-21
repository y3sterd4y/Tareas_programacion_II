class Vector {
  private double x;
  private double y;

  public Vector(double x, double y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public String toString() {
    return "Vector{" + x + " " + y + "}";
  }

  public Vector suma(Vector v) {
    return new Vector(this.x + v.x, this.y + v.y);
  }

  public Vector resta(Vector v) {
    return new Vector(this.x - v.x, this.y - v.y);
  }

  public Vector productoEscalar(double escalar) {
    return new Vector(this.x * escalar, this.y * escalar);
  }

  public double productoPunto(Vector v) {
    return this.x * v.x + this.y * v.y;
  }

  public double productoCruz(Vector v) {
    return this.x * v.y - this.y * v.x;
  }

  public double magnitud() {
    return Math.sqrt(this.x * this.x + this.y * this.y);
  }

  public double angulo(Vector v) {
    return Math.acos(this.productoPunto(v) / (this.magnitud() * v.magnitud()));
  }

  public String esPerpendicular(Vector v) {
    return this.productoPunto(v) == 0 ? "Son perpendiculares" : "No son perpendiculares";
  }

  public String esParalelo(Vector v) {
    return this.productoCruz(v) == 0 ? "Son paralelos" : "No son paralelos";
  }

  public Vector proyeccion(Vector v) {
    return v.productoEscalar(this.productoPunto(v) / (v.magnitud() * v.magnitud()));
  }

  public double componente(Vector v) {
    return this.productoPunto(v) / v.magnitud();
  }
}

public class Main {
  public static void main(String[] args) {
    Vector v1 = new Vector(-2, 4);
    Vector v2 = new Vector(1, -2);
    
    Vector v3 = new Vector(3,2);
    Vector v4 = new Vector(-2,3);

    System.out.println(v1.esPerpendicular(v2));
    System.out.println(v1.esParalelo(v2));
    System.out.println(v1.proyeccion(v2));
    System.out.println("El componente de es " + v1.componente(v2));
    
    System.out.println();
    
    System.out.println(v3.esPerpendicular(v4));
    System.out.println(v3.esParalelo(v4));
    System.out.println(v3.proyeccion(v4));
    System.out.println("El componente de es " + v3.componente(v4));
  }
}
