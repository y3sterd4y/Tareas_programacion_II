from abc import ABC, abstractmethod
import random
import math

# Interfaz Coloreado
class Coloreado(ABC):
    @abstractmethod
    def comoColorear(self):
        pass

# Clase abstracta Figura
class Figura(ABC):
    def __init__(self, color):
        self.color = color

    def setColor(self, color):
        self.color = color

    def getColor(self):
        return self.color

    @abstractmethod
    def area(self):
        pass

    @abstractmethod
    def perimetro(self):
        pass

    def __str__(self):
        return f"Figura{{color={self.color}}}"

# Clase Cuadrado
class Cuadrado(Figura, Coloreado):
    def __init__(self, color):
        super().__init__(color)
        self.lado = random.randint(1, 100)

    def area(self):
        return self.lado * self.lado

    def perimetro(self):
        return 4 * self.lado

    def comoColorear(self):
        return f"Colorear los cuatro colores de {self.color}"

    def __str__(self):
        return f"Cuadrado{{color={self.color}, lado={self.lado}}}"

# Clase Circulo
class Circulo(Figura, Coloreado):
    def __init__(self, color):
        super().__init__(color)
        self.radio = random.randint(1, 100)

    def area(self):
        return (self.radio * self.radio) * math.pi

    def perimetro(self):
        return 2 * math.pi * self.radio

    def comoColorear(self):
        return f"Colorear el circulo de {self.color}"

    def __str__(self):
        return f"Circulo{{color={self.color}, radio={self.radio}}}"

# Función principal
def main():
    figuritas = []

    c1 = Cuadrado("rojo")
    c2 = Cuadrado("amarillo")
    c3 = Cuadrado("azul")

    cir1 = Circulo("verde")
    cir2 = Circulo("negro")
    cir3 = Circulo("rosa")

    figuritas.append(c1)
    figuritas.append(c2)
    figuritas.append(c3)
    figuritas.append(cir1)
    figuritas.append(cir2)
    figuritas.append(cir3)

    for f in figuritas:
        print(f)
        print(f.area())
        print(f.perimetro())

        if isinstance(f, Cuadrado):
            print(f.comoColorear())
        elif isinstance(f, Circulo):
            print(f.comoColorear())

        print()

# Ejecutar la función principal
if __name__ == "__main__":
    main()

