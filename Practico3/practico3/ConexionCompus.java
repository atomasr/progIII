package practico3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ConexionCompus {
	 /* 3.6
		Supongamos una conexión entre computadoras (1, ... ,n) que se encuentra modelada
		mediante un grafo. Se requiere, si existe, dar una conexión entre dos computadoras a y b
		existentes sabiendo que la computadora i está fuera de servicio
	 */
	private Grafo<?> grafo;
	private HashMap<Integer,Boolean> visitado;
	private ArrayList<ArrayList<Integer>> solucion;
	
	public ConexionCompus(Grafo<?> grafo) {
		this.grafo = grafo;
		this.visitado = new HashMap<>();
		this.solucion = new ArrayList<>();
	}

	public ArrayList<ArrayList<Integer>> conexionComputadorasEntre(int origen, int destino, int fueraServicio){
		ArrayList<Integer> caminoInicial = new ArrayList<Integer>();
		Iterator<Integer> itVertices = grafo.obtenerVertices();
		while (itVertices.hasNext()) {
			Integer vertice = itVertices.next();			
			if (vertice == origen || vertice == fueraServicio) {
				visitado.put(vertice, true);				
			} else {
				visitado.put(vertice, false);
			}
		}
		caminoInicial.add(origen);
		return conexionComputadorasEntre(origen, destino, caminoInicial);
	}
	private ArrayList<ArrayList<Integer>> conexionComputadorasEntre(int origen, int destino, ArrayList<Integer> caminoActual){
		if (origen == destino) {
			ArrayList<Integer> caminoUnico = new ArrayList<Integer>();
			caminoUnico.addAll(caminoActual);
			solucion.add(caminoUnico);
			visitado.put(origen, false);
			return solucion;
			
		} else {
			Iterator<Integer> itAdyacentes = grafo.obtenerAdyacentes(origen);
			while(itAdyacentes.hasNext()) {
				Integer adyacente = itAdyacentes.next();
				if(visitado.get(adyacente).equals(false)) {
					caminoActual.add(adyacente);
					visitado.put(adyacente, true);
					conexionComputadorasEntre(adyacente,destino,caminoActual);		
					caminoActual.remove(adyacente);
					visitado.put(adyacente, false);
				}
			}
		}
		return solucion;
	}	
}
