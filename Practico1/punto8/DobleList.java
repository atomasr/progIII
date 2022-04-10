package punto8;

public class DobleList<T> {

    protected Node<T> first;
    protected Node<T> last;
    protected Integer size;

    public DobleList() {
        first = null;
        last = null;
        size = 0;
    }
    
    
    
    public Node<T> getFirst() {
		return first;
	}
    public Node<T> getLast() {
		return last;
	}

	public void insertFront(T o) {
    	Node<T> tmp = new Node<>(o, null, null);
        tmp.setNext(first);
        first.setPrevious(tmp);
        first = tmp;
        size++;
    }

    public Node<T> extractFront() {
        if (first != null) {
            Node<T> tmp = first;
            Node<T> second = first.getNext();
            first = second;
            first.setPrevious(null);
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
