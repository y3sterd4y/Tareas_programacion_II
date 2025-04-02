import java.util.Stack;

public class GestoraDeTareas {
    private Stack<Tarea> tareas;
    
    public GestoraDeTareas() {
        this.tareas = new Stack<>();
    }
    
    public void agregarTarea(Tarea tarea) {
        tareas.push(tarea);
    }
    
    public void eliminarTarea() {
        if (tareas.isEmpty()) {
            System.out.println("Gestor de tareas vacio");
        } else {
            System.out.println(tareas.pop());
            System.out.println("ELIMINADO");
        }
    }
    
    public void verSiguienteTarea() {
        Tarea sigTarea;
        if (tareas.isEmpty()) {
            System.out.println("Gestor de tareas vacio");
        } else {
            System.out.println(tareas.peek());
            
        }
        
    }
    
    public void tareasPendientes() {
        System.out.println("Tienes " + tareas.size() + " tareas pendientes");;
    }
    
    public void mostrarTareas() {
        if (tareas.isEmpty()) {
            System.out.println("Gestor de tareas vacio");
        } else {
            for (Tarea t : tareas) {
                System.out.println(t);
            }
        }
    }
    
    public void TareaDeMayorPriority() {
        Tarea mayorTarea = null;
        int mayor = 0;
        for (Tarea t : tareas) {
            if (t.getPrioridad() >= mayor) {
                mayorTarea = t;
                mayor = t.getPrioridad();
            }
        }
        
        System.out.println(mayorTarea);
    }
    
    
}

