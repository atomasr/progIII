package punto6;

import java.util.Comparator;

/**
	Ejercicio 6.
	Escriba un procedimiento que dadas dos listas construya otra con los elementos comunes,
	suponiendo que: a) Las listas están desordenadas y la lista resultante debe quedar
	ordenada. b) Las listas están ordenadas y la lista resultante debe mantenerse ordenada.
**/

public class Main {

    public static void main(String[] args) {
    	//A
        LinkedList<Integer> lista1 = new LinkedList<>();
        lista1.insertFront(2);
        lista1.insertFront(12);
        lista1.insertFront(8);
        lista1.insertFront(20);
        lista1.insertFront(84);
        lista1.insertFront(55);
        lista1.insertFront(10);
        lista1.print();
        
        LinkedList<Integer> lista2 = new LinkedList<>();
        lista2.insertFront(3);
        lista2.insertFront(10);
        lista2.insertFront(5);
        lista2.insertFront(20);
        lista2.insertFront(8);
        lista2.insertFront(12);
        lista2.print();
        
        LinkedList<Integer> lista3 = mergeDisorderLists(lista1, lista2);
        lista3.print();
        
        System.out.println("");
      //B
        LinkedList<Integer> lista4 = new LinkedList<>();
        lista4.insertLast(1);
        lista4.insertLast(2);
        lista4.insertLast(3);
        lista4.insertLast(4);
        lista4.insertLast(5);
        lista4.insertLast(6);
        lista4.insertLast(7);
        lista4.print();
        
        LinkedList<Integer> lista5 = new LinkedList<>();
        lista5.insertLast(1);
        lista5.insertLast(3);
        lista5.insertLast(5);
        lista5.insertLast(7);
        lista5.insertLast(8);
        lista5.insertLast(9);
        lista5.print();
        
        LinkedList<Integer> lista6 = intersectionListOrder(lista4, lista5);
        lista6.print();
        
    }
    
    //Metodo Tomás
    /** public static LinkedList<Integer> intersectionList(LinkedList<Integer> lista1, LinkedList<Integer> lista2) {
    	LinkedList<Integer> listaFinal = new LinkedList<>();
    	Comparator<Node> c1 = new ComparatorNumero();
    	Node<Integer> current1 = lista1.getFirst();
    	boolean estaEnLista = false;
    	while (current1 != null) {
    		estaEnLista = lista2.buscar(current1.getValue());
    		if (estaEnLista) {
    			listaFinal.insertByOrder(current1.getValue(), c1); //falta ver como insertar correctamente
    		}
    		current1 = current1.getNext();
    	}
    	return listaFinal;
    } **/
    //Metodo Sofía
    public static <T> LinkedList<T> mergeDisorderLists(LinkedList<T> lista1, LinkedList<T> lista2) {
		LinkedList<T> listaCombinada = new LinkedList<>();
		Node<T> current = lista1.getFirst();
		while (current.getNext() != null) {
			if (lista2.isIn(current.getValue())) {
				listaCombinada.insertOrder(current.getValue());
			}
			current = current.getNext();
		}
		return listaCombinada;

	}
    
    public static LinkedList<Integer> intersectionListOrder(LinkedList<Integer> lista1, LinkedList<Integer> lista2) {
    	LinkedList<Integer> listaFinal = new LinkedList<>();
    	Iterador<Integer> iter1 = lista1.iniciarRecorrido();
    	Iterador<Integer> iter2 = lista2.iniciarRecorrido();
    	while (iter1.hasNext()) {
    		if (iter2.obtener() < iter1.obtener())
        		iter2.avanzar();
        	if (iter1.obtener() < iter2.obtener())
        		iter1.avanzar();
        	if (iter1.obtener() == iter2.obtener()) {
        		listaFinal.insertLast(iter1.obtener());
        		iter1.avanzar();
        		iter2.avanzar();
        	}
    	}
    	return listaFinal;
    } //O(n) con iteradores, peor caso O(n^2)
}