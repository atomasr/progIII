package punto_2_1;

public class Main {
	
	private static int[] arreglo = {1, 2, 3, 4, 5};
	private static int max = arreglo.length;;
	/* public static void main(String[] args) {
		
		System.out.println("El arreglo " + arreglo + " esta ordenado: " + estaOrdenado(0));
		// Stack Overflow :(
	}*/
	
	public static void main(String[] args) {
		int[] arr = {1,3,54,89,90};
		Recursion r1 = new Recursion(arr);
		System.out.println(r1.IsOrder(0));

	}
	
	public static boolean estaOrdenado(int pos) {
		if ((pos < max)&&(arreglo[pos] <= arreglo[pos+1])) {
			return estaOrdenado(pos++);
		} else {
			if (pos >= max) {
				return true;
			} else {
				return false;
			}
		}
	}
	public static boolean estaOrdenado2(int pos1, int pos2) {
		if (pos2 > arreglo.length) {
			return true;
		} else if (pos1 < pos2){
			return estaOrdenado2(pos1++,pos2++);
		} else {
			return false;
		}
	}
	
	/*
	 * 1) O(n)
	 * 2) El hilo computacional se puede sobrecargar antes
	 * 3) public boolean estaOrdenado(Node n, int contador) {
	 * 		if ((contador < size)&&(n.getValue() < n.getNext().getValue())) {
	 * 			return estaOrdenado(n.getNext(), contador++); 
	 * 		} else {
	 * 			return (contador >= size);
	 * 		}
	 * 	}
	 * 
	 * */
	
	
}