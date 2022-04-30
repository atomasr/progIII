package punto_2_7;

import java.util.ArrayList;

public class Arbol {
	private Nodo raiz;
	 
	public Arbol() {
		this.raiz = null;
	}
	public Arbol(Nodo raiz) {
		this.raiz = raiz;
	}
	
	public void insert(int valor) { //O(n)
		if (this.raiz == null)
			this.raiz = new Nodo(valor);
		else
			this.add(this.raiz, valor);
	}
	private void add(Nodo nodo, int valor) {
		if (nodo.getValor() > valor) {
			if (nodo.getIzquierda() == null) {
				Nodo temp = new Nodo(valor);
				nodo.setIzquierda(temp);
			} else {
				add(nodo.getIzquierda(), valor);
			}
		} else if (nodo.getValor() < valor) {
			if (nodo.getDerecha() == null) {
				Nodo temp = new Nodo(valor);
			nodo.setDerecha(temp);
			} else {
				add(nodo.getDerecha(), valor);
			}
		}
	}
	
	public Nodo getRaiz() {
		return raiz;
	}
	
	public Integer getRoot() { //O(1)
		if (!this.isEmpty())
			return this.getRaiz().getValor();
		else
			return null;
	}
	
	public void setRaiz(Nodo raiz) {
		this.raiz = raiz;
	}
	
	public boolean hasElem(Integer valor) { //O(n)
		return this.hasElem(valor, raiz);
	}
	public boolean hasElem(int valor, Nodo nodo) {
		if (nodo != null) {
            if (nodo.getValor() == valor) {
            	return true;
            }
            else {
                if (nodo.getValor() < valor) {
                    this.hasElem(valor, nodo.getDerecha());
                }
                else {
                	this.hasElem(valor, nodo.getIzquierda());
                }
            }
        }
        return false;
	}
	
	public boolean isEmpty() { //O(1)
		return this.raiz == null;
	}
	
	public boolean delete(int value) { //2 * O(n) = O(n)
		return delete(this.raiz,value);
	}
	private boolean delete(Nodo actual, int valor) {
		Nodo aux = actual;
		Nodo padre = actual;
		boolean esHijoIzquierdo = true;
		
		while (aux.getValor() != valor) { // busqueda del valor en arbol
			padre = aux;
			if (valor < aux.getValor()) { // buscando por la izquierda porque es menor
				esHijoIzquierdo = true;
				aux = aux.getIzquierda();
			} else { // es mayor entonces recorre por la derecha
				esHijoIzquierdo = false;
				aux = aux.getDerecha();
			}
			
			if (aux == null) { // si recorrio y llego a null retorna false
				return false;  // ya que no lo encontro por lo que no existe
			}
		} // fin del while
		
		if (aux.getIzquierda() == null && aux.getDerecha() == null) { //caso 1º nodo hoja
			if (aux == this.raiz) { // estamos en el unico nodo que tenemos
				this.raiz = null;
			} else if (esHijoIzquierdo) {
				padre.setIzquierda(null);
			} else {
				padre.setDerecha(null);
			}
		} else if (aux.getDerecha() == null) { //caso 2º tiene un hijo
			if (aux == this.raiz) { //estamos en el unico nodo que tenemos
				this.raiz = aux.getIzquierda();
			} else if (esHijoIzquierdo) {
				padre.setIzquierda(aux.getIzquierda());
			} else {
				padre.setDerecha(aux.getIzquierda());
			}
		} else if (aux.getIzquierda() == null) {
			if (aux == this.raiz) { //estamos en el unico nodo que tenemos
				this.raiz = aux.getDerecha();
			} else if (esHijoIzquierdo) {
				padre.setIzquierda(aux.getDerecha());
			} else {
				padre.setDerecha(aux.getDerecha());
			}
		} else { //caso 3º tiene ambos hijos
			Nodo reemplazo = obtenerReemplazo(aux);
			if (aux == this.raiz) {
				this.raiz = reemplazo;
			} else if (esHijoIzquierdo) {
				padre.setIzquierda(reemplazo);
			} else {
				padre.setDerecha(reemplazo);
			}
			reemplazo.setIzquierda(aux.getIzquierda());
		}
		return true;
	}
	private Nodo obtenerReemplazo(Nodo nodoReemp) {
		Nodo reemplazarPadre = nodoReemp;
		Nodo reemplazo = nodoReemp;
		Nodo aux = nodoReemp.getDerecha();
		while (aux != null) {
			reemplazarPadre = reemplazo;
			reemplazo = aux;
			aux = aux.getIzquierda();
		}
		if (reemplazo != nodoReemp.getDerecha()) {
			
			reemplazarPadre.setIzquierda(reemplazo.getDerecha());
			reemplazo.setDerecha(nodoReemp.getDerecha());
		}
		System.out.println("El nodo reemplazo es " + reemplazo);
		return reemplazo;
	}
	
	public int getHeight() { //O(n)
		int altura = getHeight(this.raiz, 0, 0);
		return altura;
	}
	private int getHeight(Nodo n, int altura, int nivel) {
		if (n != null) {
			altura = getHeight(n.getIzquierda(), altura, nivel + 1);
			if(nivel > altura) {
				altura = nivel;
			}
			altura = getHeight(n.getDerecha(), altura, nivel + 1);
		}
		return altura;
	}
	
	public ArrayList<Integer> getFrontera(){ //O(n)
		ArrayList<Integer> lista = new ArrayList<>();
		getFrontera(this.raiz, lista);
		return lista;
	}
	public void getFrontera(Nodo actual, ArrayList<Integer> lista){

		if (actual.getIzquierda() == null && actual.getDerecha() == null) {
			lista.add(actual.getValor());
		}
		if (actual.getIzquierda() != null) {
			getFrontera(actual.getIzquierda(), lista);
		}
		if (actual.getDerecha() != null) {
			getFrontera(actual.getDerecha(), lista);
		}
	}
	
	public Integer getMaxElem() {//O(n)
		if (this.isEmpty()) {
			return null;
		} else {
			return this.getMaxElem(this.raiz, 0);
		}
	}
	private int getMaxElem(Nodo actual, int max) {
		if (actual != null) {
			max = actual.getValor();
			max = getMaxElem(actual.getDerecha(), max);
		}
        return max;
	}
	
	public void printPosOrder() {//O(n)
	    this.printPosOrder(this.raiz);
	}
	private void printPosOrder(Nodo actual) {
		if(actual != null) {
			printPosOrder(actual.getIzquierda());
			printPosOrder(actual.getDerecha());
			System.out.print(actual.getValor() + " ");
		}
	}
	
	public void printPreOrder() {//O(n)
		this.printPreOrder(this.raiz);
	}
	private void printPreOrder(Nodo actual) {
		if (actual != null) {
			System.out.print(actual.getValor() + " ");
			printPreOrder(actual.getIzquierda());
			printPreOrder(actual.getDerecha());
		}
	}
	
	public void printInOrder() {//O(n)
		this.printInOrder(this.raiz);
	}
	private void printInOrder(Nodo actual) {
		if (actual != null) {
			printInOrder(actual.getIzquierda());
			System.out.print(actual.getValor() + " ");
			printInOrder(actual.getDerecha());
		}
	}
	
	public ArrayList<Integer> getLongestBranch() {//O(n)
		if (!this.isEmpty()) {
			return getLongestBranch(this.raiz);
		} else {
			return null;
		}	
	}
	private ArrayList<Integer> getLongestBranch(Nodo actual) {
		if (actual.getIzquierda() == null && actual.getDerecha() == null) { //si es hoja
			ArrayList<Integer> ramaHoja = new ArrayList<>();
			ramaHoja.add(actual.getValor());
			return ramaHoja;
		}
		
		ArrayList<Integer> izquierda = new ArrayList<>();
		ArrayList<Integer> derecha = new ArrayList<>();

		if (actual.getIzquierda() != null) {
			izquierda.add(actual.getValor());
			izquierda.addAll(getLongestBranch(actual.getIzquierda()));
		}
		if (actual.getDerecha() != null){
			derecha.add(actual.getValor());
			derecha.addAll(getLongestBranch(actual.getDerecha()));
		}
		
		if (izquierda.size() < derecha.size()) {
			return derecha;
		} else {
			return izquierda;
		}
	}
	
	public ArrayList<Integer> getElemAtLevel(int nivel){//O(n)
		if (!this.isEmpty()) {
			return getElemAtLevel(this.raiz, nivel, 0);
		} else {
			return null;
		}
	}
	private ArrayList<Integer> getElemAtLevel(Nodo actual, int nivelBuscado, int nivel ) {
		ArrayList<Integer> resultado = new ArrayList<>();
		if (nivelBuscado == nivel) {
			resultado.add(actual.getValor());
		}
		if (actual.getIzquierda() != null) {
			resultado.addAll(getElemAtLevel(actual.getIzquierda(), nivelBuscado, nivel + 1));
		}
		if (actual.getDerecha() != null) {
			resultado.addAll(getElemAtLevel(actual.getDerecha(), nivelBuscado, nivel + 1));
		}
		return resultado;
	}
}
