import math

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

    def dibujar_linea(self):
        ekis = self.p2.get_x() - self.p1.get_x()
        ies = self.p2.get_y() - self.p1.get_y()

        pendiente = ies / ekis
        distancia = math.sqrt((ekis * ekis) + (ies * ies))

        print(f"La línea tiene una pendiente {pendiente} y la distancia de punto a punto es {distancia}")

# Clase Circulo
class Circulo:
    def __init__(self, centro, radio):
        self.centro = centro
        self.radio = radio

    def __str__(self):
        return f"Circulo{{centro = {self.centro} radio = {self.radio}}}"

    def dibujar_circulo(self):
        area = math.pi * math.pow(self.radio, 2)
        print(f"El área del círculo es {area} con centro en {self.centro}")

# Clase Principal
def main():
    pp1 = Punto(3, 4)
    pp2 = Punto(6, 5)

    print(pp1)
    pp1.coord_cartesianas()
    pp1.coord_polares()

    print("--------------------------------------------")

    l1 = Linea(pp1, pp2)
    print(l1)
    l1.dibujar_linea()

    print("--------------------------------------------")

    c1 = Circulo(pp1, 3)
    print(c1)
    c1.dibujar_circulo()

# función principal
main()