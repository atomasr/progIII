package practico3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ExisteCamino {
	/*3.5
	Escriba un algoritmo que dado un grafo G y un vértice v de dicho grafo, devuelva una lista
	con todos los vértices a partir de los cuales exista un camino en G que termine en v*/
	private Grafo<?> grafo;
	private ArrayList<Integer> solucion;
	private HashMap<Integer,Boolean> visitado;
	
	public ExisteCamino(Grafo<?> grafo) {
		super();
		this.grafo = grafo;
		this.solucion = new ArrayList<>();
		this.visitado = new HashMap<>();
	}
	
	public ArrayList<Integer> dfs(int destino){
		ArrayList<Integer> caminoInicial = new ArrayList<Integer>();
		Iterator<Integer> itVertices = grafo.obtenerVertices();
		while(itVertices.hasNext()) { //inicializado en no visitado
			Integer vertice = itVertices.next();			
			visitado.put(vertice, false);
		}
		itVertices = grafo.obtenerVertices();
		while(itVertices.hasNext()) {
			Integer vertice = itVertices.next();
			if(visitado.get(vertice).equals(false)) {
				caminoInicial.add(vertice);
				visitado.put(vertice, true);
				this.dfs(vertice, destino, caminoInicial);
			}
		}
		return solucion;
	}
	
	private ArrayList<Integer> dfs(int origen, int destino, ArrayList<Integer> caminoActual){
		Iterator<Integer> itAdyacentes = grafo.obtenerAdyacentes(origen);
		while (itAdyacentes.hasNext()) {
			Integer adyacente = itAdyacentes.next();
			if (visitado.get(adyacente).equals(false)) {
				if (adyacente == destino) {
					for (Integer elem : caminoActual) {
						if(!solucion.contains(elem)) {
							solucion.add(elem);
						}
					}
				} else {
					caminoActual.add(adyacente);
					visitado.put(adyacente, true);
					dfs(adyacente,destino,caminoActual);
				}
				caminoActual.remove(adyacente);
				visitado.put(adyacente, false);
			}
		}
		return solucion;
	}
}
