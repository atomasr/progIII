package punto_2_7;

public class ArbolDeArboles {
	private int valor;
	private ArbolDeArboles izquierda;
	private ArbolDeArboles derecha;
	 
	 
	public ArbolDeArboles(int valor) {
		this.valor = valor;
		this.izquierda = null;
		this.derecha = null;
	}
	
	public void insert(int newValue) {
		if (this.valor > newValue) {
			if (this.izquierda == null)
				this.izquierda = new ArbolDeArboles(newValue);
			else
				this.izquierda.insert(newValue);
			} else if (this.valor < newValue) {
				if (this.derecha == null)
					this.derecha = new ArbolDeArboles(newValue);
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
	
	public ArbolDeArboles getIzquierda() {
		return izquierda;
	}

	public ArbolDeArboles getDerecha() {
		return derecha;
	}

	public boolean hasElem(int valor, ArbolDeArboles a) {
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

	public void mostrar(ArbolDeArboles a) {
		if (a != null) {
			mostrar(a.getIzquierda());
			System.out.println(a.getValor());
			mostrar(a.getDerecha());
		}
		
	}
	
	
}
