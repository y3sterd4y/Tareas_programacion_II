class Ecuacion {
  private double a;
  private double b;
  private double c;

  public Ecuacion(double a, double b, double c) {
    this.a = a;
    this.b = b;
    this.c = c;
  }

  private double getDiscriminante() {
    return b * b - 4 * a * c;
  }

  private double getRaiz1() {
    return (-b + Math.sqrt(getDiscriminante())) / (2 * a);
  }

  private double getRaiz2() {
    return (-b - Math.sqrt(getDiscriminante())) / (2 * a);
  }

  public void salida() {
    if (getDiscriminante() > 0) {
      System.out.println("La ecuacion tiene dos raices " + getRaiz1() + " y " + getRaiz2());
    } else if (getDiscriminante() == 0) {
      System.out.println("La ecuacion tiene una Raiz: " + getRaiz1());
    } else {
      System.out.println("No hay raices reales");
    }
  } 

}

public class Main {
  public static void main(String[] args) {
    Ecuacion ecuacion = new Ecuacion(1, 3, 2);
    ecuacion.salida();
    Ecuacion ecuacion2 = new Ecuacion(1, 2, 1);
    ecuacion2.salida();
    Ecuacion ecuacion3 = new Ecuacion(1, 2, 3);
    ecuacion3.salida();
  }
}