import math

class CalculadoraDeAreas:

    def calcular_area_circulo(self, radio):
        return math.pi * radio * radio

    def calcular_area_rectangulo(self, base, altura):
        return base * altura

    def calcular_area_triangulo(self, base, altura):
        return 0.5 * base * altura

    def calcular_area_trapecio(self, base_mayor, base_menor, altura):
        return 0.5 * (base_mayor + base_menor) * altura

    def calcular_area_pentagono(self, lado, apotema):
        return (5 * lado * apotema) / 2

def main():
    calculadora = CalculadoraDeAreas()

    print("Seleccione la figura para calcular el área:")
    print("1. Círculo")
    print("2. Rectángulo")
    print("3. Triángulo Rectángulo")
    print("4. Trapecio")
    print("5. Pentágono Regular")

    opcion = int(input())

    if opcion == 1:
        radio = float(input("Ingrese el radio del círculo: "))
        print("Área del círculo:", calculadora.calcular_area_circulo(radio))
    elif opcion == 2:
        base_rectangulo = float(input("Ingrese la base del rectángulo: "))
        altura_rectangulo = float(input("Ingrese la altura del rectángulo: "))
        print("Área del rectángulo:", calculadora.calcular_area_rectangulo(base_rectangulo, altura_rectangulo))
    elif opcion == 3:
        base_triangulo = float(input("Ingrese la base del triángulo: "))
        altura_triangulo = float(input("Ingrese la altura del triángulo: "))
        print("Área del triángulo rectángulo:", calculadora.calcular_area_triangulo(base_triangulo, altura_triangulo))
    elif opcion == 4:
        base_mayor = float(input("Ingrese la base mayor del trapecio: "))
        base_menor = float(input("Ingrese la base menor del trapecio: "))
        altura_trapecio = float(input("Ingrese la altura del trapecio: "))
        print("Área del trapecio:", calculadora.calcular_area_trapecio(base_mayor, base_menor, altura_trapecio))
    elif opcion == 5:
        lado_pentagono = float(input("Ingrese el lado del pentágono: "))
        apotema_pentagono = float(input("Ingrese el apotema del pentágono: "))
        print("Área del pentágono regular:", calculadora.calcular_area_pentagono(lado_pentagono, apotema_pentagono))
    else:
        print("Opción no válida.")

if __name__ == "__main__":
    main()
