package punto_2_5;

public class Main {

	public static void main(String[] args) {
		int[] arreglo = {3, 1, 4, 5, 2};
		
		System.out.println("Mergesort: ");
		mergesort(arreglo, 0, arreglo.length - 1);
		System.out.println("Quick-Sort: ");
		quicksort(arreglo, 0, arreglo.length - 1);
	}
	
	// 1. Peor caso: Merge Sort O(n log n) y Quick Sort (n^2)
	// 2. Promedio: Merge Sort O(n log n) y Quick Sort (n log n)
	
	public static void mostrar(int[] arreglo) {
		for(int i = 0; i < arreglo.length; i++){
	         System.out.print(arreglo[i] + " ");
	    }
		System.out.println(" ");
	}
	
	public static void mergesort(int arreglo[], int izq, int der){
	    if (izq < der){
	            int mitad = (izq + der) / 2;
	            mergesort(arreglo, izq, mitad);			//ordenar primera mitad
	            mergesort(arreglo, mitad + 1, der);		//ordenar segunda mitad                                                                           
	            merge(arreglo, izq, mitad, der);		//juntar mitades                                                                            
	    }
	    mostrar(arreglo);
	}
	public static void merge(int arreglo[],int izq, int mitad, int der){
		   int i, j, k;
		   int[] aux = new int[arreglo.length];
		   for (i = izq; i <= der; i++)		//copia ambas mitades en el array auxiliar                                       
		        aux[i] = arreglo[i];

		   i = izq; j = mitad + 1; k = izq;
		     
		   while (i <= mitad && j <= der)	//copia el siguiente elemento más grande                                      
		          if (aux[i] <= aux[j])
		              arreglo[k++] = aux[i++];
		          else
		              arreglo[k++] = aux[j++];
		        
		   while (i <= mitad)				//copia los elementos que quedan de la
		         arreglo[k++] = aux[i++];	//primera mitad (si los hay)
		}
	
	public static void quicksort(int arreglo[], int izq, int der) {

		  int pivote = arreglo[izq]; // tomamos primer elemento como pivote
		  int i = izq;         		 // i realiza la búsqueda de izquierda a derecha
		  int j = der;         		 // j realiza la búsqueda de derecha a izquierda
		  int aux;
		 
		  while (i < j) { // mientras no se crucen las búsquedas                                   
			  	while(arreglo[i] <= pivote && i < j) 
			  		i++; // busca elemento mayor que pivote
		     	while(arreglo[j] > pivote) 
		     		j--; // busca elemento menor que pivote
	     		if (i < j) { // si no se han cruzado los intercambia                   
			        aux = arreglo[i];
			        arreglo[i] = arreglo[j];
			        arreglo[j] = aux;
			    }
		   }
		   
		   arreglo[izq] = arreglo[j];	// se coloca el pivote en su lugar de forma que tendremos                                    
		   arreglo[j] = pivote;			// los menores a su izquierda y los mayores a su derecha
		   
		   if (izq < j-1)
		      quicksort(arreglo, izq, j - 1); // ordenamos subarray izquierdo
		   if (j+1 < der)
		      quicksort(arreglo, j + 1, der); // ordenamos subarray derecho
		   
		   mostrar(arreglo);
	}
	
}
