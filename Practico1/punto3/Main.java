package punto3;

/**
 * Ejercicio 3.
 *
 * Implemente una Pila utilizando la Lista del ejercicio 1. A una pila se le pueden agregar
 * elementos utilizando el método push(T o). Para retirar elementos de la colección se utiliza el
 * método pop(), que retorna el último elemento agregado a la colección y lo elimina de la
 * misma. Es posible consultar el tope de la pila (sin eliminarlo) utilizando el método top(). Por
 * último, es posible invertir el orden de los elementos de la pila mediante el método reverse().
 */
public class Main {

    public static void main(String[] args) {
        Pila<String> p1 = new Pila<>();
        p1.print();
        p1.push("Hola ");
        p1.print();
        p1.push("Cómo ");
        p1.print();
        p1.push("Estan ");
        p1.print();
        System.out.println(p1.top().getValue());
        p1.pop();
        p1.print();
        p1.push("Estas ");
        p1.print();
        p1.reverse();
        p1.print();
    }
}