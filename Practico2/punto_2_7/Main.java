package punto_2_7;

public class Main {

	public static void main(String[] args) {
		Arbol a1 = new Arbol(new Nodo(4));
		
		a1.insert(2);
		a1.insert(1);
		a1.insert(3);
		a1.insert(6);
		a1.insert(5);
		a1.insert(8);
		a1.insert(7);
		
		System.out.println(a1.getHeight());
		
		System.out.println(a1.getFrontera());
		
		System.out.println(a1.getMaxElem());
		
		System.out.println(a1.getLongestBranch());
		
		System.out.println(a1.getElemAtLevel(2));
		
		a1.printInOrder();;
	}

}
