import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
		GestoraDeTareas gestor = new GestoraDeTareas();
        
		gestor.agregarTarea(new Tarea("Respirar", 10));
		gestor.agregarTarea(new Tarea("Tomar agua", 5));
		gestor.agregarTarea(new Tarea("Despertar", 2));
				
        // metodos
        // gestor.agregarTarea(Tarea t);
        // gestor.eliminarTarea();
        // gestor.verSiguienteTarea();
        // gestor.tareasPendientes()
        // gestor.mostrarTareas()

        int numerito;
        while (true) {
            numerito = showOptions();
            
            if (numerito == 7) {
                break;
            }
            
            switch (numerito) {
                case 1:
                    gestor.mostrarTareas();
                    break;
                case 2:
                    agregadorDeTarea(gestor);
                    break;
                case 3:
                    gestor.verSiguienteTarea();
                    break;
                case 4:
                    gestor.tareasPendientes();
                    break;
                case 5:
                    gestor.eliminarTarea();
                    break;
                case 6:
                    gestor.TareaDeMayorPriority();
                    break;
            }
        }
        
	}
	
	public static int showOptions() {
	    Scanner input = new Scanner(System.in);
        String[] opciones = {"1. Mostrar Tareas", "2. Agregar Tarea", "3. Ver Ultima Tarea", "4. Ver Cant. de Tareas Pendientes", "5. Eliminar Ultima Tarea Ingresada", "6. Mostrar Tarea de mayor Prioridad", "7. Salir"};
        System.out.println("\n=============================");
        System.out.println("ELIGA UNA OPCION");
        for (int i = 0; i < opciones.length; i++) {
            System.out.println(opciones[i]);
        }
        System.out.println("=============================\n");
        int owo = input.nextInt();
        return owo;
	}
	
	public static void agregadorDeTarea(GestoraDeTareas gestor) {
	    Scanner input = new Scanner(System.in);
	    System.out.println("Ingrese una descripcion a su tarea");
	    String descripcion = input.nextLine();
	    System.out.println("En un rango del 1 al 10 que tan importante es la tarea");
	    int priority = input.nextInt();
	    gestor.agregarTarea(new Tarea(descripcion, priority));
	}
}










