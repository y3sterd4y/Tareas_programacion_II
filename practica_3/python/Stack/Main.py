class Tarea:
    next_id = 0

    def __init__(self, descripcion, prioridad):
        Tarea.next_id += 1
        self.id = Tarea.next_id
        self.descripcion = descripcion
        self.prioridad = prioridad

    def get_prioridad(self):
        return self.prioridad

    def __str__(self):
        return f"Tarea{{id={self.id}, descripcion={self.descripcion}, prioridad={self.prioridad}}}"

class GestoraDeTareas:
    def __init__(self):
        self.tareas = []

    def agregar_tarea(self, tarea):
        self.tareas.append(tarea)

    def eliminar_tarea(self):
        if not self.tareas:
            print("Gestor de tareas vacio")
        else:
            tarea_eliminada = self.tareas.pop()
            print(tarea_eliminada)
            print("ELIMINADO")

    def ver_siguiente_tarea(self):
        if not self.tareas:
            print("Gestor de tareas vacio")
        else:
            print(self.tareas[-1])

    def tareas_pendientes(self):
        print(f"Tienes {len(self.tareas)} tareas pendientes")

    def mostrar_tareas(self):
        if not self.tareas:
            print("Gestor de tareas vacio")
        else:
            for tarea in self.tareas:
                print(tarea)

    def tarea_de_mayor_prioridad(self):
        if not self.tareas:
            print("Gestor de tareas vacio")
        else:
            mayor_tarea = max(self.tareas, key=lambda t: t.get_prioridad())
            print(mayor_tarea)

def show_options():
    opciones = [
        "1. Mostrar Tareas",
        "2. Agregar Tarea",
        "3. Ver Ultima Tarea",
        "4. Ver Cant. de Tareas Pendientes",
        "5. Eliminar Ultima Tarea Ingresada",
        "6. Mostrar Tarea de mayor Prioridad",
        "7. Salir"
    ]
    print("\n=============================")
    print("ELIGA UNA OPCION")
    for opcion in opciones:
        print(opcion)
    print("=============================\n")
    return int(input())

def agregador_de_tarea(gestor):
    descripcion = input("Ingrese una descripcion a su tarea: ")
    prioridad = int(input("En un rango del 1 al 10 que tan importante es la tarea: "))
    gestor.agregar_tarea(Tarea(descripcion, prioridad))

def main():
    gestor = GestoraDeTareas()

    gestor.agregar_tarea(Tarea("Respirar", 10))
    gestor.agregar_tarea(Tarea("Tomar agua", 5))
    gestor.agregar_tarea(Tarea("Despertar", 2))

    while True:
        numerito = show_options()

        if numerito == 7:
            break

        if numerito == 1:
            gestor.mostrar_tareas()
        elif numerito == 2:
            agregador_de_tarea(gestor)
        elif numerito == 3:
            gestor.ver_siguiente_tarea()
        elif numerito == 4:
            gestor.tareas_pendientes()
        elif numerito == 5:
            gestor.eliminar_tarea()
        elif numerito == 6:
            gestor.tarea_de_mayor_prioridad()

if __name__ == "__main__":
    main()
