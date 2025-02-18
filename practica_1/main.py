import math

class Punto:
    def __init__(self, x, y):
        self.x = x
        self.y = y

    def cord_cartesianas(self):
        print(f"Las coordenadas cartesianas del punto son: ({self.x}, {self.y})")

    def cord_polares(self):
        r = math.sqrt(self.x**2 + self.y**2)
        C = math.atan(self.y / self.x)
        print(f"Las coordenadas polares del punto son: ({r}, {C})")

    def __str__(self):
        return f"Punto(x= {self.x}, y= {self.y})"

if __name__ == "__main__":
    puntito = Punto(3, 4)
    puntito.cord_cartesianas()
    puntito.cord_polares()
    print(puntito)








