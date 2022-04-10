package punto6;

import java.util.Iterator;

public class Iterador<T> implements Iterator<T> {

    private Node<T> current;

    public Iterador (Node<T> first) {
        this.current = first;
    }
    
    public T obtener() {
    	return current.getValue();
    }
    
    public void avanzar() {
    	current = current.getNext();
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

	@Override
	public T next() {
		// TODO Auto-generated method stub
		return null;
	}
}
