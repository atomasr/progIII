package punto6;

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
}