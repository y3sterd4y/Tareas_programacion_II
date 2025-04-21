import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    JuegoAdivinaNumero juego = new JuegoAdivinaNumero(3);
    
    while (true) {
      System.out.println("Adivina el numero (1-10): ");
      juego.juega(input.nextInt());
      if (juego.getNumeroVidas() == 0) {
        break;
      }
    }
  }
}
