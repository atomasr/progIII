package punto6;

import java.util.Comparator;

public class ComparatorNumero implements Comparator<Node>{

	public ComparatorNumero() {
	}

	@Override
	public int compare(Node o1, Node o2) {
		return (int) o1.getValue() - (int) o2.getValue();
	}

}
