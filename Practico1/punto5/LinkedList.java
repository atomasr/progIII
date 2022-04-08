package punto5;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {

    protected Node<T> first;
    //private Node<T> current;
    protected Integer size;

    public LinkedList() {
        first = null;
        //current = null;
        size = 0;
    }
    
    public Iterador<T> iniciarRecorrido() {
    	return new Iterador<T>(first);
    }
    
    /*public T obtener() {
    	return current.getValue();
    }
    
    public void avanzar() {
    	current = current.getNext();
    }*/
    
    public Node<T> getFirst() {
		return first;
	}

	public void insertFront(T o) {
    	Node<T> tmp = new Node<>(o, null);
        tmp.setNext(first);
        first = tmp;
        size++;
    }

    public Node<T> extractFront() {
        if (first != null) {
            Node<T> tmp = first;
            Node<T> cursor = first.getNext();
            first = cursor;
            return tmp;
        }
        return null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public T get(Integer index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getValue();
    }

    public String toString() {
    	String s = "";
        if (first != null) {
        	Node<T> current = first;
        	while (current != null) {
        		s = s + current.getValue() + " ";
        		current = current.getNext();
        	}
        }
        return s;
    }

    public void print() {
        System.out.println("LinkedList(" + this.size() + "): " + this + " " + this.isEmpty());
    }



    @Override
    public Iterator<T> iterator() {
        return new Iterador<T>(this.getFirst());
    }

}