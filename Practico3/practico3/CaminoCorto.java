package practico3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class CaminoCorto {
	/*3.7
	Supongamos que una ciudad se encuentra modelada mediante un grafo, donde cada nodo
	es una esquina, y las aristas representan las calles. Diseñe un algoritmo tal que dadas dos
	esquinas, devuelva el camino más corto entre ambas de manera de caminar la menor
	cantidad de cuadras posible*/
	private Grafo<?> grafo;
	private int origen;
	private int destino;
	private ArrayList<Integer> solucion;
	private HashMap<Integer,Boolean> visitado;
	
	
	public CaminoCorto(Grafo<?> grafo, int origen, int destino) {
			super();
			this.grafo = grafo;
			this.origen = origen;
			this.destino = destino;
			this.solucion = new ArrayList<>();
			this.visitado = new HashMap<>();
	}
	
	//hago un dfs para que cuando entro a un adyacente, entre a su primer adyacente y asi pueda ir
	//formando el camino. Con el bfs es complicado no perder al padre
	public ArrayList<Integer> dfs(){
		ArrayList<Integer> corto = new ArrayList<>();
		Iterator<Integer> itVertices = grafo.obtenerVertices();
		while(itVertices.hasNext()) {
			Integer vertice = itVertices.next();
			visitado.put(vertice, false);
		}
		corto.add(this.origen);
		visitado.put(this.origen, true);
		return dfs(this.origen, corto);
	}
	
	private ArrayList<Integer> dfs(int actual, ArrayList<Integer> caminoActual){
		if (actual == this.destino) {
			if(solucion.isEmpty()) {
				solucion.addAll(caminoActual);
			}
			if (caminoActual.size() < solucion.size()) {
				solucion.clear(); //lo vacio para que no se me vayan acumulando las mejores soluciones hasta el momento
				solucion.addAll(caminoActual);
			}
		} else {
			Iterator<Integer> itAdyacentes = grafo.obtenerAdyacentes(actual);
			while(itAdyacentes.hasNext()) {
				Integer ady = itAdyacentes.next();
				if(visitado.get(ady).equals(false)) {
					caminoActual.add(ady);
					visitado.put(ady, true);
					dfs(ady, caminoActual);
					caminoActual.remove(ady);
					visitado.put(ady, false);
				}
			}
		}
		return solucion;
	}		
}