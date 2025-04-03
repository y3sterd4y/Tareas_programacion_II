from queue import Queue

class TrabajoDeImpresora:
    contador = 0

    def __init__(self, nombre, n_paginas):
        TrabajoDeImpresora.contador += 1
        self.id_documento = TrabajoDeImpresora.contador
        self.nombre_documento = nombre
        self.numero_paginas = n_paginas

    def __str__(self):
        return f"TrabajoDeImpresora{{id={self.id_documento}, nombre={self.nombre_documento}, paginas={self.numero_paginas}}}"

class Impresora:
    def __init__(self):
        self.cola_impresion = Queue()

    def agregar_impresion(self, trabajo):
        print(f"Se agregó {trabajo}")
        self.cola_impresion.put(trabajo)

    def imprimir_trabajo(self):
        if not self.cola_impresion.empty():
            trabajo_impreso = self.cola_impresion.get()
            print(f"Se imprimió el trabajo {trabajo_impreso}")
        else:
            print("La cola de impresión está vacía.")

    def ver_cola_impresion(self):
        cola_actual = list(self.cola_impresion.queue)
        print(cola_actual)

def main():
    imp = Impresora()

    imp.agregar_impresion(TrabajoDeImpresora("hola mundito", 7))
    imp.agregar_impresion(TrabajoDeImpresora("cosas que deberia estar haciendo", 7))
    imp.agregar_impresion(TrabajoDeImpresora("adios mundo cruel", 7))
    imp.agregar_impresion(TrabajoDeImpresora("se supone que no ahy salida", 7))
    imp.agregar_impresion(TrabajoDeImpresora("como??? jajaj Comes!" , 7))

    imp.ver_cola_impresion()
    imp.imprimir_trabajo()
    imp.ver_cola_impresion()

if __name__ == "__main__":
    main()
