package practico3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class CaminoCritico {
	/*3.10
	Implementar un algoritmo que obtenga la secuencia de ejecución crítica de estas tareas, es
	decir, la secuencia de tareas que resulta en el máximo tiempo empleado para su ejecución*/
	private Grafo<?> grafo;
	private ArrayList<Integer> resultado;
	private HashMap<Integer,Boolean> visitado;
	private HashMap<Integer,Integer> tiempoTareas;
	private int totalActual;
	private int totalResultado;
	
	
	
	public CaminoCritico(Grafo<?> grafo, HashMap<Integer,Integer> tiempoTareas) {
			this.grafo = grafo;
			this.resultado = new ArrayList<>();
			this.visitado = new HashMap<>();
			this.tiempoTareas = tiempoTareas;
			this.totalActual = 0;
			this.totalResultado = 0;
	}
	
	public ArrayList<Integer> getCaminoCritico(){
		ArrayList<Integer> critico = new ArrayList<>();
		Iterator<Integer> itVertices = grafo.obtenerVertices();
		while(itVertices.hasNext()) {
			Integer vertice = itVertices.next();
			visitado.put(vertice, false);
		}
		itVertices = grafo.obtenerVertices();
		if (itVertices.hasNext()) {
			Integer origen = itVertices.next();
			critico.add(origen);
			visitado.put(origen, true);
			return getCaminoCritico(origen, critico);
		}
		return null;
	}
	
	private boolean tieneArcos(int actual) {
		Iterator<?> itActual = grafo.obtenerArcos(actual);
		if (itActual.hasNext()) {
			return true;
		}
		return false;
	}
	
	private ArrayList<Integer> getCaminoCritico(int actual, ArrayList<Integer> caminoActual){
		if (!tieneArcos(actual)) {
			if (totalActual > totalResultado) {
				totalResultado = totalActual;
				resultado.clear();
				resultado.addAll(caminoActual);
				System.out.println(totalActual);
				totalActual = 0;
			} else {
				System.out.println(totalActual);
			}
		} else {
			Iterator<Integer> itAdyacentes = grafo.obtenerAdyacentes(actual);
			while(itAdyacentes.hasNext()) {
				Integer ady = itAdyacentes.next();
				if(visitado.get(ady).equals(false)) {
					caminoActual.add(ady);
					visitado.put(ady, true);
					Arco<?> arco = grafo.obtenerArco(actual, ady);
					totalActual = totalActual + tiempoTareas.get(ady) + (Integer) arco.getEtiqueta();
					
					getCaminoCritico(ady, caminoActual);
		
					totalActual = totalActual - tiempoTareas.get(actual);
					caminoActual.remove(ady);
					visitado.put(ady, false);
				}
			}
		}
		return resultado;
	}		
}