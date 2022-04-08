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
        
        LinkedList<Integer> lista3 = intersectionList(lista1, lista2);
        lista3.print();
        
        
    }
    
    public static LinkedList<Integer> intersectionList(LinkedList<Integer> lista1, LinkedList<Integer> lista2) {
    	LinkedList<Integer> listaFinal = new LinkedList<>();
    	Comparator<Node> c1 = new ComparatorNumero();
    	Node<Integer> current1 = lista1.getFirst();
    	boolean estaEnLista = false;
    	while (current1 != null) {
    		estaEnLista = lista2.buscar(current1.getValue());
    		if (estaEnLista) {
    			listaFinal.insertByOrder(current1.getValue(), c1);
    		}
    		current1 = current1.getNext();
    	}
    	return listaFinal;
    	
    }
}