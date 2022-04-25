package punto_2_7;

public class Arbol {
	private int valor;
	private Arbol izquierda;
	private Arbol derecha;
	 
	 
	public Arbol(int valor) {
		this.valor = valor;
		this.izquierda = null;
		this.derecha = null;
	}
	
	public void insert(int newValue) {
		if (this.valor > newValue) {
			if (this.izquierda == null)
				this.izquierda = new Arbol(newValue);
			else
				this.izquierda.insert(newValue);
			} else if (this.valor < newValue) {
				if (this.derecha == null)
					this.derecha = new Arbol(newValue);
				else
					this.derecha.insert(newValue);
		}
	}
	
	
	public int getValor() {
		return valor;
	}

	public int getRoot() {
		return this.getValor();
	}
	
	public Arbol getIzquierda() {
		return izquierda;
	}

	public Arbol getDerecha() {
		return derecha;
	}

	public boolean hasElem(int valor, Arbol a) {
		if (!isEmpty()) {
            if (this.getValor() == valor) {
            	return true;
            }
            else {
                if (this.getValor() < valor) {
                    this.hasElem(valor, a.getDerecha());
                }
                else {
                	this.hasElem(valor, a.getIzquierda());
                }
            }
        }
        return false;
	}
	
	public boolean isEmpty() {
		return this != null;
	}
}
