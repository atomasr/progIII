package punto1;

/**
 * Ejercicio 1.
 *
 * Implemente los m�todos indicados del esqueleto de Lista desarrollado en Teor�a
 * (insertFront, extractFront, isEmpty, size, toString). Agregar tambi�n el m�todo: T get(index)
 */

public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> myLinkedList = new LinkedList<>();
        myLinkedList.print();
        myLinkedList.insertFront(2);
        myLinkedList.print();
        myLinkedList.insertFront(3);
        myLinkedList.print();
        myLinkedList.extractFront();
        myLinkedList.print();
        myLinkedList.insertFront(1);
        myLinkedList.print();
        System.out.println(myLinkedList.get(0));
        System.out.println(myLinkedList.get(1));
    }
}
