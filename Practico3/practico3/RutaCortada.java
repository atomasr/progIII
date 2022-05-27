package practico3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class RutaCortada {
	/*3.9
	Dado un grafo no orientado que modela las rutas de la provincia de Buenos Aires, devolver
	todos los caminos alternativos que se pueden tomar para ir desde la ciudad de Buenos
	Aires a la ciudad de Tandil, considerando que en el tramo Las Flores-Rauch está cortado al
	tránsito
	 */
	private Grafo<?> grafo;
	private ArrayList<ArrayList<Integer>> resultado;
	private HashMap<Integer, Boolean> visitado;
	
	public RutaCortada(Grafo<?> grafo) {
		this.grafo = grafo;
		this.resultado = new ArrayList<>();
		this.visitado = new HashMap<>();
	}
	
	public ArrayList<ArrayList<Integer>> getRutas(int origen, int destino, Arco<Integer> rutaCortada) {
		ArrayList<Integer> caminoInicial = new ArrayList<>();
		Iterator<Integer> itVertices = grafo.obtenerVertices();
		while(itVertices.hasNext()) {
			Integer vertice = itVertices.next();
			if (vertice == origen) {
				visitado.put(vertice, true);
			}else {
				visitado.put(vertice, false);
			}
		}
		caminoInicial.add(origen);
		return getRutas(origen, destino, caminoInicial, rutaCortada);
	}
	
	public ArrayList<ArrayList<Integer>> getRutas(int origen, int destino, ArrayList<Integer> caminoActual, Arco<Integer> rutaCortada) {
		if (origen == destino) {
			ArrayList<Integer> caminoUnico = new ArrayList<>();
			caminoUnico.addAll(caminoActual);
			resultado.add(caminoUnico);
		} else {
			Iterator<Integer> itAdyacentes = grafo.obtenerAdyacentes(origen);
			while(itAdyacentes.hasNext()) {
				Integer adyacente = itAdyacentes.next();
				if ((origen != rutaCortada.getVerticeDestino()) || (adyacente != rutaCortada.getVerticeOrigen())) {
				if ((origen != rutaCortada.getVerticeOrigen()) || (adyacente != rutaCortada.getVerticeDestino())) {
					if (visitado.get(adyacente).equals(false)) {
						caminoActual.add(adyacente);
						visitado.put(adyacente, true);
						
						getRutas(adyacente, destino, caminoActual, rutaCortada);
						
						caminoActual.remove(adyacente);
						visitado.put(adyacente, false);
					}
				}
				}
			}
		}
		return resultado;
	}
}
