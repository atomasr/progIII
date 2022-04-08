package punto3;

import punto1.LinkedList;
import punto1.Node;

public class Pila<T> {

    private LinkedList<T> list = new LinkedList<>();

    public void push(T o) {
        list.insertFront(o);
    }

    public Node<T> pop() {
        return list.extractFront();
    }

    public Node<T> top() {
    	if (list.getFirst() != null) {
    		return list.getFirst();
    	}
    	return null;
    }

    public void reverse() {
        LinkedList<T> reverse = new LinkedList<>();
        Node<T> current = list.getFirst();
        while (current != null) {
            current = this.pop();
            reverse.insertFront(current.getValue());
            current = this.top();
        }
        this.list = reverse;
    }

    public void print() {
        this.list.print();
    }

}