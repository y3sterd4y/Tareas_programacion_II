public class Tarea {
    private static int nextId = 0;
    private int id;
    private String descripcion;
    private int prioridad;
    
    public Tarea(String descripcion, int prioridad) {
        this.id = ++nextId;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
    }
    
    public int getPrioridad() {
        return prioridad;
    }
    
    @Override
    public String toString() {
        return "Tarea{id=" + id + ", descripcion=" + descripcion + ", prioridad=" + prioridad + "}";
    }
}