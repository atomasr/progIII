package punto_2_1;

public class Recursion {
	private int[] arreglo;

	public Recursion(int[] arreglo) {
		super();
		this.arreglo = arreglo;
	}

	public boolean IsOrder(int pos) {
		int length = arreglo.length;
		if (pos == length - 1) {
			return true;
		} else {
			if((pos < length) && arreglo[pos] < arreglo[pos + 1]) {
				return IsOrder(pos + 1);
			} else {
				return false;
			}
		}
	}
}
