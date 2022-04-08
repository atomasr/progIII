package punto4;

/**
 * Ejercicio 4.
 *
 * A la implementación de la clase Lista realizada en el ejercicio 1, agregue un método
 * indexOf, que reciba un elemento y retorne el índice donde está almacenado ese elemento, o
 * -1 si el elemento no existe en la lista.
 */
public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> myLinkedList = new LinkedList<>();
        myLinkedList.insertFront(3);
        myLinkedList.insertFront(2);
        myLinkedList.insertFront(1);
        myLinkedList.print();
        System.out.println(myLinkedList.indexOf(1));
        System.out.println(myLinkedList.indexOf(2));
        System.out.println(myLinkedList.indexOf(3));
        System.out.println(myLinkedList.indexOf(null));
        System.out.println(myLinkedList.indexOf(4));
    }
}
