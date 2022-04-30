package punto_2_7;

public class Nodo {
	private Integer valor;
	private Nodo izquierda;
	private Nodo derecha;
	
	
	public Nodo(int value) {
		this.valor = value;
		this.izquierda = null;
		this.derecha = null;
	}


	public int getValor() {
		return valor;
	}


	public void setValor(int valor) {
		this.valor = valor;
	}


	public Nodo getIzquierda() {
		return izquierda;
	}


	public void setIzquierda(Nodo izquierda) {
		this.izquierda = izquierda;
	}


	public Nodo getDerecha() {
		return derecha;
	}


	public void setDerecha(Nodo derecha) {
		this.derecha = derecha;
	}


	@Override
	public String toString() {
		return "Nodo [valor=" + valor + "]";
	}
	
	
}
