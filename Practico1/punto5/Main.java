package punto5;

/**
 * Ejercicio 5.
 *
 * A partir de la clase Lista implementada en el ejercicio 1, implemente el patrón
 * iterator-iterable, para que la lista sea iterable. ¿Existe alguna ventaja computacional a la
 * hora de recorrer la lista de principio a fin si se cuenta con un iterador?
 */
public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> myLinkedList = new LinkedList<>();
        myLinkedList.insertFront(3);
        myLinkedList.insertFront(2);
        myLinkedList.insertFront(1);
        System.out.print(myLinkedList.toString()); //O(n)
        
        System.out.println("");

        //O(n * 1) = O(n)
        Iterador<Integer> i1 = myLinkedList.iniciarRecorrido();
        for (int i=0; i <= myLinkedList.size(); i++) { //O(n)
        	int val = i1.obtener(); //O(1)
        	i1.avanzar(); //O(1)
        	System.out.print(val + " ");
        }
    }
}