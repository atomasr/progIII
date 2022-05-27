package practico3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class BFS {
	private Grafo<?> grafo;
	private HashMap<Integer, Boolean> visitado;
	private ArrayList<Integer> recorrido;
	
	public BFS(Grafo<?> grafo) {
		super();
		this.grafo = grafo;
		this.visitado = new HashMap<>();
		this.recorrido = new ArrayList<>();
	}


	public ArrayList<Integer> bfs() {
		Iterator<Integer> noVisitados = grafo.obtenerVertices();
		while (noVisitados.hasNext()) {
			Integer noVisitado = noVisitados.next();
			visitado.put(noVisitado, false);
		}
		Iterator<Integer> vertices = grafo.obtenerVertices();
		while (vertices.hasNext()) {
			Integer vertice = vertices.next();
			recorrido.add(vertice);
			if (visitado.get(vertice).equals(false)) {
				bfs_visit(vertice);
			}
		}
		return recorrido;
	}


	private void bfs_visit(Integer vertice) {
		ArrayList<Integer> fila = new ArrayList<Integer>();
		visitado.put(vertice, true);
		fila.add(vertice);
		
		while (!fila.isEmpty()) {
			Integer verticeFila = fila.remove(0);
			Iterator<Integer> filaAdy = grafo.obtenerAdyacentes(verticeFila);
			while (filaAdy.hasNext()) {
				Integer adyacente = filaAdy.next();
				if (visitado.get(adyacente).equals(false)) {
					visitado.put(adyacente, true);
					fila.add(adyacente);
				}
			}
		}
	}
}
