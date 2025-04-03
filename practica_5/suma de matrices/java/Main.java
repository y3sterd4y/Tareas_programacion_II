import java.util.Arrays;

class Matriz {
	private int[][] matriz;
	private int filas;
	private int columnas;

	public Matriz(int[][] matriz) {
		this.matriz = matriz;
		this.filas = matriz.length;
		this.columnas = matriz[0].length;
	}
	
	public void imprimirMatriz() {
	    for (int[] fila : matriz) {
	        System.out.println(Arrays.toString(fila));
	    }
	    System.out.println();
	}
	
	public Matriz sumarMatriz(Matriz m) {
	    if (this.filas != m.filas || this.columnas != m.columnas) {
	        throw new IllegalArgumentException("Las matrices son de diferente tamaño, no se pueden sumar");
	    }
	    
	    int[][] resultado = new int[filas][columnas];
	    for (int i = 0; i < filas; i++){
	        for (int a = 0; a < columnas; a++) {
	            resultado[i][a] = this.matriz[i][a] + m.matriz[i][a];
	        }
	    }
	    return new Matriz(resultado);
	}


}

public class Main {
    public static void main (String[] args) {
        int[][] data1 = {{1, 2, 7}, {3, 4, 8}};
        int[][] data2 = {{9, 8, 7}, {6, 5, 4}};
        
        Matriz m1 = new Matriz(data1);
        Matriz m2 = new Matriz(data2);
        
        m1.imprimirMatriz();
        m2.imprimirMatriz();
        
        Matriz m3 = m1.sumarMatriz(m2);
        m3.imprimirMatriz();
    }
}
