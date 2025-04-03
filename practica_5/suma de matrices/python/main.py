class Matriz:
    def __init__(self, matriz):
        self.matriz = matriz
        self.filas = len(matriz)
        self.columnas = len(matriz[0])

    def imprimir_matriz(self):
        for fila in self.matriz:
            print(fila)
        print()

    def sumar_matriz(self, m):
        if self.filas != m.filas or self.columnas != m.columnas:
            raise ValueError("Las matrices son de diferente tamaño, no se pueden sumar")

        resultado = [[0] * self.columnas for _ in range(self.filas)]
        for i in range(self.filas):
            for j in range(self.columnas):
                resultado[i][j] = self.matriz[i][j] + m.matriz[i][j]

        return Matriz(resultado)

# Ejemplo de uso
if __name__ == "__main__":
    data1 = [[1, 2, 7], [3, 4, 8]]
    data2 = [[9, 8, 7], [6, 5, 4]]

    m1 = Matriz(data1)
    m2 = Matriz(data2)

    m1.imprimir_matriz()
    m2.imprimir_matriz()

    m3 = m1.sumar_matriz(m2)
    m3.imprimir_matriz()
