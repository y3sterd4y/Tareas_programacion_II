import math

class Vector:
    def __init__(self, x, y):
        self.x = x
        self.y = y

    def __str__(self):
        return f"Vector{{{self.x} {self.y}}}"

    def suma(self, v):
        return Vector(self.x + v.x, self.y + v.y)

    def resta(self, v):
        return Vector(self.x - v.x, self.y - v.y)

    def producto_escalar(self, escalar):
        return Vector(self.x * escalar, self.y * escalar)

    def producto_punto(self, v):
        return self.x * v.x + self.y * v.y

    def producto_cruz(self, v):
        return self.x * v.y - self.y * v.x

    def magnitud(self):
        return math.sqrt(self.x * self.x + self.y * self.y)

    def angulo(self, v):
        return math.acos(self.producto_punto(v) / (self.magnitud() * v.magnitud()))

    def es_perpendicular(self, v):
        return "Son perpendiculares" if self.producto_punto(v) == 0 else "No son perpendiculares"

    def es_paralelo(self, v):
        return "Son paralelos" if self.producto_cruz(v) == 0 else "No son paralelos"

    def proyeccion(self, v):
        return v.producto_escalar(self.producto_punto(v) / (v.magnitud() * v.magnitud()))

    def componente(self, v):
        return self.producto_punto(v) / v.magnitud()

# Ejemplo de uso
if __name__ == "__main__":
    v1 = Vector(-2, 4)
    v2 = Vector(1, -2)

    v3 = Vector(3, 2)
    v4 = Vector(-2, 3)

    print(v1.es_perpendicular(v2))
    print(v1.es_paralelo(v2))
    print(v1.proyeccion(v2))
    print("El componente de es", v1.componente(v2))

    print()

    print(v3.es_perpendicular(v4))
    print(v3.es_paralelo(v4))
    print(v3.proyeccion(v4))
    print("El componente de es", v3.componente(v4))
