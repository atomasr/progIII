package punto_2_6;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int[] arreglo = createRandomArray(5);
		
		long startTime1 = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			convertInBinary(i, "");
		}
		long endTime1 = System.nanoTime();
	    System.out.println("Binary time: " + (endTime1 - startTime1) + " nanosegundos");
	    
	    long startTime3 = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			seleccion(arreglo);
		}
		long endTime3 = System.nanoTime();
		System.out.println("Selección time: " + (endTime3 - startTime3) + " nanosegundos");
	    
	    long startTime2 = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			burbujeo(arreglo);
		}
		long endTime2 = System.nanoTime();
		System.out.println("Burbujeo time: " + (endTime2 - startTime2) + " nanosegundos");

		long startTime4 = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			Arrays.sort(arreglo);
		}
		long endTime4 = System.nanoTime();
		System.out.println("Array Sort time: " + (endTime4 - startTime4) + " nanosegundos");
	}
	public static int[] createRandomArray(int n) {
		int[] arreglo = new int[n];
		for (int i = 0; i < n; i++) {
			arreglo[i] = (int) Math.floor(Math.random() * 20);
		}
		return arreglo;
	}
	public static String convertInBinary(int numero, String binary) {
		if (numero > 0) {
			if (numero % 2 == 0) {
				binary = binary + "0";
			} else {
				binary = binary + "1";
			}
			return convertInBinary(numero/2, binary);
		}
		return new StringBuilder(binary).reverse().toString(); //para invertir
	}
	public static void mostrar(int[] arreglo) {
		for(int i = 0; i < arreglo.length; i++){
	         System.out.print(arreglo[i] + " ");
	    }
		System.out.println(" ");
	}
	
	public static void seleccion(int[] arreglo) {
		int i, j, menor, pos, tmp;
		for (i = 0; i < arreglo.length - 1; i++) {      
		      menor = arreglo[i];					// toma como menor el primero de los elementos que quedan por ordenar                    
		      pos = i;							// y guarda su posición
		      for (j = i + 1; j < arreglo.length; j++){ // se busca en el resto del array un elemento menor
		            if (arreglo[j] < menor) {
		                menor = arreglo[j];
		                pos = j;
		            }
		      }
		      if (pos != i){                      // si hay alguno menor se intercambia                         
		          tmp = arreglo[i];
		          arreglo[i] = arreglo[pos];
		          arreglo[pos] = tmp;
		      }
		}
	}
	
	public static void burbujeo(int[] arreglo) {
		boolean swapped = true;
		int j = 0;
		int tmp;
		while (swapped) {
			swapped = false;
			j++;
			for (int i = 0; i<arreglo.length - j; i++) { //al fondo se va dejando el elemento mayor
				if (arreglo[i] > arreglo[i + 1]) {
					tmp = arreglo[i];
					arreglo[i] = arreglo[i + 1];
					arreglo[i + 1] = tmp;
					swapped = true;
				}
			} //una vez que esta ordenado no hay mas swap por lo que se termina el ordenamiento
		}
	}
}
