package practico3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class DFS {
	private Grafo<?> grafo;
	private int tiempo;
	private HashMap<Integer, String> colores;
	private HashMap<Integer, Integer> tiempoinicio;
	private HashMap<Integer, Integer> tiempofin;
	private ArrayList<Integer> recorrido;
	
	
	
	public DFS(Grafo<?> grafo) {
		super();
		this.grafo = grafo;
		this.colores = new HashMap<>();
		this.tiempoinicio = new HashMap<>();
		this.tiempofin = new HashMap<>();
		this.recorrido = new ArrayList<>();
	}


	public ArrayList<Integer> dfs() {
		Iterator<Integer> verticesBlanco = grafo.obtenerVertices();
		while (verticesBlanco.hasNext()) {
			Integer verticeBlanco = verticesBlanco.next();
			colores.put(verticeBlanco, "blanco");
		}
		tiempo = 0;
		Iterator<Integer> vertices = grafo.obtenerVertices();
		while (vertices.hasNext()) {
			Integer vertice = vertices.next();
			recorrido.add(vertice);
			if (colores.get(vertice) == "blanco") {
				dfs_visit(vertice);
			}
		}
		return recorrido;
	}


	private void dfs_visit(Integer vertice) {
		colores.put(vertice, "amarillo");
		tiempo++;
		tiempoinicio.put(vertice, tiempo);
		Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(vertice);
		while (adyacentes.hasNext()) {
			Integer adyacente = adyacentes.next();
			if (colores.get(adyacente) == "blanco") {
				dfs_visit(adyacente);
			}
		}
		colores.put(vertice, "negro");
		tiempo++;
		tiempofin.put(vertice, tiempo);
	}
}
