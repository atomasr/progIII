package punto4;

import punto1.Node;

public class LinkedList<T> {

    protected Node<T> first;
    protected Integer size;

    public LinkedList() {
        first = null;
        size = 0;
    }
    
    
    
    public Node<T> getFirst() {
		return first;
	}

    public int indexOf(T elem) {
    	if (first != null) {
    		int indice = 0;
    		Node<T> current = first;
    		while (current != null) {
    			if (current.getValue().equals(elem)) {
    				return indice;
    			} else {
    				indice++;
    				current = current.getNext();
    			}
    		}
    	}
    	return -1;
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
        		s = s + " " + current.getValue();
        		current = current.getNext();
        	}
        }
        return s;
    }

    public void print() {
        System.out.println("LinkedList(" + this.size() + "): " + this + " " + this.isEmpty());
    }
}