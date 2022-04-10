package punto8;

public class Node<T> {
    private T value;
    private Node<T> previous;
    private Node<T> next;

    public Node(T value, Node<T> n1, Node<T> n2) {
        setValue(value);
        setPrevious(n1);
        setNext(n2);
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
    

    public Node<T> getPrevious() {
		return previous;
	}

	public void setPrevious(Node<T> previous) {
		this.previous = previous;
	}

	public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> n) {
        next = n;
    }
}
