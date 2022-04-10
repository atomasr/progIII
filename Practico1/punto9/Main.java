package punto9;

public class Main {

	public static void main(String[] args) {
		String s1 = "reconocer";
		
		System.out.println("La palabra '" + s1 + "' es capicua: " + verificarCapicua(s1));
	}

	private static boolean verificarCapicua(String s) {
		int size = s.length();
		int mitad = size / 2;
		char c1, c2;
		int j = size - 1;
		for (int i = 0; i <= mitad && mitad <= j; i++) {
			c1 = s.charAt(i);
			c2 = s.charAt(j);
			if (c1 != c2) {
				return false;
			}
			j--;
		}
		return true;
	}

}
