package punto_3_1;

import java.util.Iterator;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;

public class GrafoDirigido<T> implements Grafo<T> {
	private HashMap<Integer, ArrayList<Arco<T>>> grafo;

	@Override
	public void agregarVertice(int verticeId) {
		grafo.put(verticeId, new ArrayList<>());
	}

	@Override
	public void borrarVertice(int verticeId) {
		grafo.remove(verticeId);
	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		if (this.contieneVertice(verticeId1) && this.contieneVertice(verticeId2)) {
			ArrayList<Arco<T>> arcos = grafo.get(verticeId1);
			Arco<T> arco = new Arco<>(verticeId1, verticeId2, etiqueta);
			if (!arcos.contains(arco))
				arcos.add(arco);
		}
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		int i = 0;
		if (this.contieneVertice(verticeId1) && this.contieneVertice(verticeId2)) {
			ArrayList<Arco<T>> arcos = this.grafo.get(verticeId1);
			while ((i < arcos.size()) && (arcos.get(i).getVerticeDestino() != verticeId2)) {
				if (arcos.get(i).getVerticeDestino() == verticeId2) {
					arcos.remove(i);
				}
				i++;
			}
		}
	}

	@Override
	public boolean contieneVertice(int verticeId) {
		return this.grafo.containsKey(verticeId);
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		if ((this.contieneVertice(verticeId1) && this.contieneVertice(verticeId2))) {
			Arco<Integer> arco = new Arco<>(verticeId1, verticeId2, null);
			ArrayList<Arco<T>> arcos = this.grafo.get(verticeId1);
			return arcos.contains(arco);
		}
		return false;
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		if ((this.contieneVertice(verticeId1) && this.contieneVertice(verticeId2))) {
			ArrayList<Arco<T>> arcos = this.grafo.get(verticeId1);
			for (int i = 0; i < arcos.size(); i++) {
				if ((arcos.get(i).getVerticeOrigen() == verticeId1) && (arcos.get(i).getVerticeDestino() == verticeId2))
					return arcos.get(i);
			}
		}
		return null;
	}

	@Override
	public int cantidadVertices() {
		return grafo.size();
	}

	@Override
	public int cantidadArcos() {
		int contador = 0;
		for (Integer v : grafo.keySet()) {
			contador += grafo.get(v).size();
		}
		return contador;
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		Set<Integer> vertices = grafo.keySet();
		return vertices.iterator();
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		ArrayList<Arco<T>> arcos = grafo.get(verticeId);
		ArrayList<Integer> adyacentes = new ArrayList<>();
		for (Arco<T> a: arcos) {
			adyacentes.add(a.getVerticeDestino());
		}
		return adyacentes.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		ArrayList<Arco<T>> arcos = new ArrayList<>();
		for (Integer v : grafo.keySet()) {
			  arcos.addAll(grafo.get(v));
		}
		return arcos.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		ArrayList<Arco<T>> arcos = grafo.get(verticeId);
		return arcos.iterator();
	}

}