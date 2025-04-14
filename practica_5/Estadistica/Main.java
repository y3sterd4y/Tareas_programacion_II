class Estadistica {
  private String datos;  
  private double[] numeros; 

  public Estadistica(String datos) {
    this.datos = datos;
    this.numeros = convertirDatosANumeros(datos);
  }

  public double[] convertirDatosANumeros(String datos) {
    String[] partes = datos.split(" ");
    double[] numeros = new double[partes.length];
    for (int i = 0; i < partes.length; i++) {
      numeros[i] = Double.parseDouble(partes[i]);
    }
    return numeros;
  }

  public double calcularMedia() {
    double suma = 0;
    for (double numero : numeros) {
      suma += numero;
    }
    return suma / numeros.length;
  }

  public double calcularDesviacionEstandar() {
    double media = calcularMedia();
    double sumaCuadrados = 0;
    for (double numero : numeros) {
      sumaCuadrados += Math.pow(numero - media, 2);
    }
    return Math.sqrt(sumaCuadrados / numeros.length);
  }
    
}

public class Main {
  public static void main(String[] args) {
    String datos = "1.9 2.5 3.7 2 1 6 3 4 5 2";
    Estadistica estadistica = new Estadistica(datos);
    double media = estadistica.calcularMedia();
    double desviacionEstandar = estadistica.calcularDesviacionEstandar();
    System.out.printf("Media: %.4f%n", media);
    System.out.printf("Desviación estandar: %.4f%n", desviacionEstandar);
  }
}