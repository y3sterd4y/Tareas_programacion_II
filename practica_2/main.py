import math
import matplotlib.pyplot as plt
import numpy as np

# Clase Punto
class Punto:
    def __init__(self, x, y):
        self.x = x
        self.y = y

    def get_x(self):
        return self.x

    def get_y(self):
        return self.y

    def coord_cartesianas(self):
        print(f"Las coordenadas cartesianas del punto son: ({self.x}, {self.y})")

    def coord_polares(self):
        r = math.sqrt(self.x * self.x + self.y * self.y)
        C = math.atan2(self.y, self.x)
        print(f"Las coordenadas polares del punto son: ({r}, {C})")

    def imprimir_punto(self):
        return f"({self.x}, {self.y})"

    def __str__(self):
        return f"Punto{{x = {self.x}, y = {self.y}}}"

# Clase Linea
class Linea:
    def __init__(self, p1, p2):
        self.p1 = p1
        self.p2 = p2

    def __str__(self):
        return f"Linea{{punto1 = {self.p1.imprimir_punto()} punto2 = {self.p2.imprimir_punto()}}}"

    def dibujar_linea(self, ax):
        x_values = [self.p1.get_x(), self.p2.get_x()]
        y_values = [self.p1.get_y(), self.p2.get_y()]
        ax.plot(x_values, y_values, 'b-', label="Línea")  # Línea azul
        ax.scatter(x_values, y_values, color='red', zorder=3)  # Puntos en rojo

        ekis = self.p2.get_x() - self.p1.get_x()
        ies = self.p2.get_y() - self.p1.get_y()
        pendiente = ies / ekis if ekis != 0 else None
        distancia = math.sqrt((ekis * ekis) + (ies * ies))

        print(f"La línea tiene una pendiente {pendiente} y la distancia de punto a punto es {distancia}")

# Clase Circulo
class Circulo:
    def __init__(self, centro, radio):
        self.centro = centro
        self.radio = radio

    def __str__(self):
        return f"Circulo{{centro = {self.centro} radio = {self.radio}}}"

    def dibujar_circulo(self, ax):
        area = math.pi * math.pow(self.radio, 2)
        print(f"El área del círculo es {area} con centro en {self.centro}")

        # Dibujar círculo en la gráfica
        circle = plt.Circle((self.centro.get_x(), self.centro.get_y()), self.radio, color='green', fill=False)
        ax.add_patch(circle)
        ax.scatter(self.centro.get_x(), self.centro.get_y(), color='red', zorder=3)  # Centro en rojo

# Función principal
def main():
    pp1 = Punto(3, 4)
    pp2 = Punto(6, 5)

    print(pp1)
    pp1.coord_cartesianas()
    pp1.coord_polares()

    print("--------------------------------------------")

    l1 = Linea(pp1, pp2)
    print(l1)

    print("--------------------------------------------")

    c1 = Circulo(pp1, 3)
    print(c1)

    # Configurar la gráfica
    fig, ax = plt.subplots()
    ax.set_xlim(0, 10)
    ax.set_ylim(0, 10)
    ax.set_aspect('equal', adjustable='datalim')
    ax.grid(True)

    # Dibujar elementos
    l1.dibujar_linea(ax)
    c1.dibujar_circulo(ax)

    plt.legend()
    plt.show()

# Ejecutar la función principal
main()
