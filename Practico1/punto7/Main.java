package punto7;

public class Main {
	
	public static void main(String[] args) {
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
        
        LinkedList<Integer> lista3 = createListBySubtraction(lista1, lista2);
        lista3.print();
        
        
    }
	
	public static LinkedList<Integer> createListBySubtraction(LinkedList<Integer> l1, LinkedList<Integer> l2) {
		LinkedList<Integer> listaFinal = new LinkedList<>();
		Node<Integer> first1 = l1.getFirst();
		if (first1 != null) {
			Node<Integer> current = first1;
			while (current != null) {
				if (current.estaEnSegunda(l2) == false) {
					listaFinal.insertFront(current.getValue());
				}
				current = current.getNext();
			}
		}
		return listaFinal;
	}
}
