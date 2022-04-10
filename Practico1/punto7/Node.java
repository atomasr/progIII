package punto7;

public class Node<T> {
    private T value;
    private Node<T> next;

    public Node(T value, Node<T> n) {
        setValue(value);
        setNext(n);
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> n) {
        next = n;
    }

	public boolean estaEnSegunda(LinkedList<T> l2) {
		Node<T> first = l2.getFirst();
		if (first != null) {
			Node<T> current = first;
			while (current != null) {
				if (this.getValue() == current.getValue()) {
					return true;
				} else {
					current = current.getNext();
				}
			}
		}
		return false;
	}
}
