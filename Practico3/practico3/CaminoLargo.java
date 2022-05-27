package practico3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class CaminoLargo {
	/*3.4
	Escribir un algoritmo que, dado un grafo dirigido y dos vértices i, j de este grafo, devuelva el
	camino simple (sin ciclos) de mayor longitud del vértice i al vértice j. Puede suponerse que
	el grafo de entrada es acíclico*/
	private Grafo<?> grafo;
	private int origen;
	private int destino;
	private ArrayList<Integer> solucion;
	private HashMap<Integer,Boolean> visitado;
	
	
	public CaminoLargo(Grafo<?> grafo, int origen, int destino) {
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
		ArrayList<Integer> largo = new ArrayList<>();
		Iterator<Integer> itVertices = grafo.obtenerVertices();
		while(itVertices.hasNext()) {
			Integer vertice = itVertices.next();
			visitado.put(vertice, false);
		}
		largo.add(this.origen);
		visitado.put(this.origen, true);
		return dfs(this.origen, largo);
	}
	
	private ArrayList<Integer> dfs(int actual, ArrayList<Integer> caminoActual){
		if (actual == this.destino) {
			if (caminoActual.size() > solucion.size()) {
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