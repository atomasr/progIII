package punto6;

import java.util.Comparator;
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
    
    @Override
    public Iterator<T> iterator() {
        return new Iterador<T>(this.getFirst());
    }
    
    public Node<T> getFirst() {
		return first;
	}

	public void insertFront(T o) {
    	Node<T> tmp = new Node<>(o, null);
        tmp.setNext(first);
        first = tmp;
        size++;
    }
	public void insertLast(T o) {
		Node<T> tmp = new Node<>(o, null);
		if (first == null) {
			first = tmp;
		} else {
			Node<T> current = first;
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(tmp);
		}
        size++;
	}
	
	public boolean buscar(T value) {
		Node<T> current = first;
    	while (current != null) {
    		if (current.getValue() == value) {
    			return true;
    		} else {
    			current = current.getNext();
    		}
    	}
		return false;
	}
	
	//Metodo Sofía
	public boolean isIn(T value) {
		Node<T> current = first;
		for (int i = 0; i < size; i++) {
			if (current.getValue() == value) {
				return true;
			}
			current = current.getNext();
		}
		return false;
	}
	public void insertOrder(T o) {
		Node<T> tmp = new Node<>(o, null);
		if (first == null) {
			first = tmp;
		} else {
			if (first.compareTo(tmp) >= 0) {
				this.insertFront(o);
			} else {
				Node<T> current = first;
				while (current.getNext() != null && current.getNext().compareTo(tmp) < 0) {
					current = current.getNext();
				}
				if (current.getNext() != null) {
					Node<T> next = current.getNext();
					current.setNext(new Node<>(o, next));
				} else {
					current.setNext(tmp);
				}
			}
		}
		size++;
	}
	
	//Metodo Tomás
	/** public void insertByOrder(T o, Comparator<Node> comp) {
    	Node<T> tmp = new Node<>(o, null);
    	Node<T> current = first;
    	if (current != null) {
	    	while ((current.getNext() != null)&&(comp.compare(tmp, current) >= 0)) {
	    		current = current.getNext();
	    	}
	    	if (current.getNext() == null) {
	    		current.setNext(tmp);
	    	} else {
	    		tmp.setNext(current.getNext());
	            current.setNext(tmp);
	    	}
    	} else {
    		first = tmp;
    	}
    	
        size++;
    }**/

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
