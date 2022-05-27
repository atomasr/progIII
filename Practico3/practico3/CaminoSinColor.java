package practico3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class CaminoSinColor {
	/*3.8
	Dados un grafo G con sus vértices rotulados con colores y dos vértices v1 y v2, escriba un
	algoritmo que encuentre un camino desde el vértice v1 al vértice v2 tal que no pase por
	vértices rotulados con el color rojo*/
	private Grafo<?> grafo;
	private ArrayList<Integer> solucion;
	private HashMap<Integer,Boolean> visitado;
	private HashMap<Integer,String> colores;
	private int origen;
	private int destino;
	
	public CaminoSinColor(Grafo<?> grafo, HashMap<Integer,String> colores, int origen, int destino) {
		super();
		this.grafo = grafo;
		this.solucion = new ArrayList<>();
		this.visitado = new HashMap<>();
		this.colores = colores;
		this.origen = origen;
		this.destino = destino;
	}
	public ArrayList<Integer> dfs(){
		ArrayList<Integer> camino = new ArrayList<>();
		Iterator<Integer> itVertices = grafo.obtenerVertices();
		while(itVertices.hasNext()) {
			Integer vertice = itVertices.next();
			if ((colores.get(vertice) != null)&&(colores.get(vertice).equals("rojo"))) {
				visitado.put(vertice, true);
			} else {
				visitado.put(vertice, false);
			}
		}
		camino.add(this.origen);
		visitado.put(this.origen, true);
		return dfs(this.origen, camino);
	}

	private ArrayList<Integer> dfs(int actual, ArrayList<Integer> caminoActual){
		if (actual == this.destino) {
			solucion.addAll(caminoActual);
			return solucion;
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
