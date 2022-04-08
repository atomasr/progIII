package punto3;

/**
 * Ejercicio 3.
 *
 * Implemente una Pila utilizando la Lista del ejercicio 1. A una pila se le pueden agregar
 * elementos utilizando el m�todo push(T o). Para retirar elementos de la colecci�n se utiliza el
 * m�todo pop(), que retorna el �ltimo elemento agregado a la colecci�n y lo elimina de la
 * misma. Es posible consultar el tope de la pila (sin eliminarlo) utilizando el m�todo top(). Por
 * �ltimo, es posible invertir el orden de los elementos de la pila mediante el m�todo reverse().
 */
public class Main {

    public static void main(String[] args) {
        Pila<String> p1 = new Pila<>();
        p1.print();
        p1.push("Hola ");
        p1.print();
        p1.push("C�mo ");
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