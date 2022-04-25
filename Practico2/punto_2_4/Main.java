package punto_2_4;

public class Main {

	public static void main(String[] args) {
		int[] arreglo = {1, 5, 7, 2, 6};
		
		seleccion(arreglo);
		burbujeo(arreglo);
	}
	
	// 1. Ambos son metodos O(n^2)
	
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
		mostrar(arreglo);
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
		mostrar(arreglo);
	}

}
