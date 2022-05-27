package practico3;

import java.util.HashMap;
import java.util.Iterator;

public class Ciclo {
	private Grafo<?> grafo;
	private HashMap<Integer, String> colores;
	//3.3
	public Ciclo(Grafo<?> grafo) {
		super();
		this.grafo = grafo;
		this.colores = new HashMap<>();
	}
	
	public boolean dfs() {
		boolean hayCiclo = false;
		Iterator<Integer> verticesBlanco = grafo.obtenerVertices();
		while (verticesBlanco.hasNext()) {
			Integer verticeBlanco = verticesBlanco.next();
			colores.put(verticeBlanco, "blanco");
		}
		Iterator<Integer> vertices = grafo.obtenerVertices();
		while ((vertices.hasNext())&&(!hayCiclo)) {
			Integer vertice = vertices.next();
			if (colores.get(vertice).equals("blanco")) {
				hayCiclo = dfs_visit(vertice);
			}
		}
		return hayCiclo;
	}


	private boolean dfs_visit(Integer vertice) {
		boolean encontrado = false;
		colores.put(vertice, "amarillo");
		Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(vertice);
		while ((adyacentes.hasNext())&&(!encontrado)) {
			Integer adyacente = adyacentes.next();
			if (colores.get(adyacente).equals("blanco")) {
				encontrado = dfs_visit(adyacente);
			} else if (colores.get(adyacente).equals("amarillo")) {
				encontrado = true;
			}
		}
		colores.put(vertice, "negro");
		return encontrado;
	}
}