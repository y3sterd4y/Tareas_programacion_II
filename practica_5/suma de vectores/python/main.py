class Vector:
    def __init__(self, x=0, y=0, z=0):
        self.x = x
        self.y = y
        self.z = z

    def __add__(self, other):
        return Vector(self.x + other.x, self.y + other.y, self.z + other.z)

    def __sub__(self, other):
        return Vector(self.x - other.x, self.y - other.y, self.z - other.z)

    def __mul__(self, scalar):
        return Vector(self.x * scalar, self.y * scalar, self.z * scalar)

    def __repr__(self):
        return f"Vector({self.x}, {self.y}, {self.z})"

    def magnitud(self):
        return (self.x**2 + self.y**2 + self.z**2)**0.5


v1 = Vector(1, 2, 3)
v2 = Vector(4, 5, 6)

v3 = v1 + v2
print(v3)

v4 = v1 * 2
print(v4)

print(v1.magnitud())


