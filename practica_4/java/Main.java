import java.util.Scanner;

class CalculadoraDeAreas {

    public double calcularArea(double radio) {
        return Math.PI * radio * radio;
    }

    public int calcularArea(int base, int altura) {
        return base * altura;
    }

    public double calcularArea(double base, double altura, boolean esTriangulo) {
        if (esTriangulo) {
            return 0.5 * base * altura;
        } else {
            throw new IllegalArgumentException("El parámetro esTriangulo debe ser verdadero para calcular el área de un triángulo.");
        }
    }

    public double calcularArea(double baseMayor, double baseMenor, double altura) {
        return 0.5 * (baseMayor + baseMenor) * altura;
    }

    public double calcularArea(double lado, double apotema) {
        return (5 * lado * apotema) / 2;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CalculadoraDeAreas calculadora = new CalculadoraDeAreas();

        System.out.println("Seleccione la figura para calcular el área:");
        System.out.println("1. Círculo");
        System.out.println("2. Rectángulo");
        System.out.println("3. Triángulo Rectángulo");
        System.out.println("4. Trapecio");
        System.out.println("5. Pentágono Regular");

        int opcion = input.nextInt();

        switch (opcion) {
            case 1:
                System.out.print("Ingrese el radio del círculo: ");
                double radio = input.nextDouble();
                System.out.println("Área del círculo: " + calculadora.calcularArea(radio));
                break;
            case 2:
                System.out.print("Ingrese la base del rectángulo: ");
                double baseRectangulo = input.nextDouble();
                System.out.print("Ingrese la altura del rectángulo: ");
                double alturaRectangulo = input.nextDouble();
                System.out.println("Área del rectángulo: " + calculadora.calcularArea(baseRectangulo, alturaRectangulo));
                break;
            case 3:
                System.out.print("Ingrese la base del triángulo: ");
                double baseTriangulo = input.nextDouble();
                System.out.print("Ingrese la altura del triángulo: ");
                double alturaTriangulo = input.nextDouble();
                System.out.println("Área del triángulo rectángulo: " + calculadora.calcularArea(baseTriangulo, alturaTriangulo, true));
                break;
            case 4:
                System.out.print("Ingrese la base mayor del trapecio: ");
                double baseMayor = input.nextDouble();
                System.out.print("Ingrese la base menor del trapecio: ");
                double baseMenor = input.nextDouble();
                System.out.print("Ingrese la altura del trapecio: ");
                double alturaTrapecio = input.nextDouble();
                System.out.println("Área del trapecio: " + calculadora.calcularArea(baseMayor, baseMenor, alturaTrapecio));
                break;
            case 5:
                System.out.print("Ingrese el lado del pentágono: ");
                double ladoPentagono = input.nextDouble();
                System.out.print("Ingrese el apotema del pentágono: ");
                double apotemaPentagono = input.nextDouble();
                System.out.println("Área del pentágono regular: " + calculadora.calcularArea(ladoPentagono, apotemaPentagono));
                break;
            default:
                System.out.println("Opción no válida.");
        }

        input.close();
    }
}


