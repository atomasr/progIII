package punto_2_3;

public class Main {

	public static void main(String[] args) {
		System.out.print(convertInBinary(10, "")); //me falta en el caso de que sea 0
	}
	
	public static String convertInBinary(int numero, String binary) {
		if (numero > 0) {
			if (numero % 2 == 0) {
				binary = binary + "0";
			} else {
				binary = binary + "1";
			}
			return convertInBinary(numero/2, binary);
		}
		return new StringBuilder(binary).reverse().toString(); //para invertir
	}
}
