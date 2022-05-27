package practico3;

import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		GrafoDirigido<Integer> grafo = new GrafoDirigido<Integer>();
		
		grafo.agregarVertice(1);
		grafo.agregarVertice(2);
		grafo.agregarVertice(3);
		grafo.agregarVertice(4);
		grafo.agregarVertice(5);
		grafo.agregarVertice(6);
		grafo.agregarVertice(7);
		
		grafo.agregarArco(1, 2, null);
		grafo.agregarArco(1, 6, null);
		grafo.agregarArco(2, 4, null);
		grafo.agregarArco(2, 5, null);
		grafo.agregarArco(6, 3, null);
		grafo.agregarArco(3, 1, null);
		grafo.agregarArco(6, 7, null);
		grafo.agregarArco(3, 5, null);
		grafo.agregarArco(7, 5, null);
		grafo.agregarArco(5, 4, null);
		
		//3.2
		DFS d = new DFS(grafo);
		System.out.println(d.dfs());
		
		BFS b = new BFS(grafo);
		System.out.println(b.bfs());
		
		//3.3
		Ciclo ciclo = new Ciclo(grafo);
		System.out.println(ciclo.dfs());
		
		//3.4
		CaminoLargo caminoLargo = new CaminoLargo(grafo, 1, 5);
		System.out.println(caminoLargo.dfs());
		
		//3.5
		ExisteCamino existeCamino = new ExisteCamino(grafo);
		System.out.println(existeCamino.dfs(5));
		
		//3.6
		ConexionCompus conexionCompus = new ConexionCompus(grafo);
		System.out.println(conexionCompus.conexionComputadorasEntre(1, 7, 6));
		
		//3.7
		CaminoCorto caminoCorto = new CaminoCorto(grafo, 1, 5);
		System.out.println(caminoCorto.dfs());
		
		//3.8
		HashMap<Integer,String> colores = new HashMap<>();
		colores.put(3, "rojo");
		colores.put(2, "rojo");
		CaminoSinColor caminoSinColor = new CaminoSinColor(grafo, colores, 1, 5);
		System.out.println(caminoSinColor.dfs());
		
		//3.9
		GrafoNoDirigido<Integer> grafoNo = new GrafoNoDirigido<Integer>();
		
		grafoNo.agregarVertice(1);
		grafoNo.agregarVertice(2);
		grafoNo.agregarVertice(3);
		grafoNo.agregarVertice(4);
		grafoNo.agregarVertice(5);
		grafoNo.agregarVertice(6);
		grafoNo.agregarVertice(7);
		
		grafoNo.agregarArco(1, 2, null);
		grafoNo.agregarArco(1, 5, null);
		grafoNo.agregarArco(2, 3, null);
		grafoNo.agregarArco(3, 4, null);
		grafoNo.agregarArco(2, 4, null);
		grafoNo.agregarArco(5, 7, null);
		grafoNo.agregarArco(7, 4, null);
		grafoNo.agregarArco(6, 5, null);
		grafoNo.agregarArco(6, 4, null);
		
		RutaCortada rutaCortada = new RutaCortada(grafoNo);
		Arco<Integer> arco = new Arco<Integer>(5, 7, null);
		System.out.println(rutaCortada.getRutas(7, 4, arco));
		
		//3.10
		GrafoDirigido<Integer> tareas = new GrafoDirigido<Integer>();
		
		tareas.agregarVertice(0);
		tareas.agregarVertice(1);
		tareas.agregarVertice(2);
		tareas.agregarVertice(3);
		tareas.agregarVertice(4);
		tareas.agregarVertice(5);
		tareas.agregarVertice(6);
		tareas.agregarVertice(7);
		tareas.agregarVertice(8);
		tareas.agregarVertice(9);
		tareas.agregarVertice(10);
		tareas.agregarVertice(11);
		tareas.agregarVertice(12);
		
		tareas.agregarArco(0, 1, 0);
		tareas.agregarArco(0, 2, 0);
		tareas.agregarArco(1, 3, 3);
		tareas.agregarArco(2, 5, 1);
		tareas.agregarArco(2, 7, 18);
		tareas.agregarArco(3, 4, 5);
		tareas.agregarArco(3, 6, 8);
		tareas.agregarArco(4, 11, 3);
		tareas.agregarArco(11, 12, 9);
		tareas.agregarArco(5, 6, 2);
		tareas.agregarArco(6, 12, 2);
		tareas.agregarArco(6, 10, 6);
		tareas.agregarArco(7, 8, 7);
		tareas.agregarArco(8, 9, 4);
		tareas.agregarArco(9, 10, 1);
		
		HashMap<Integer, Integer> tiempoTareas = new HashMap<>();
		tiempoTareas.put(0, 0);
		tiempoTareas.put(1, 4);
		tiempoTareas.put(2, 18);
		tiempoTareas.put(3, 4);
		tiempoTareas.put(4, 13);
		tiempoTareas.put(5, 22);
		tiempoTareas.put(6, 18);
		tiempoTareas.put(7, 12);
		tiempoTareas.put(8, 3);
		tiempoTareas.put(9, 2);
		tiempoTareas.put(10, 3);
		tiempoTareas.put(11, 1);
		tiempoTareas.put(12, 5);
		
		CaminoCritico caminoCritico = new CaminoCritico(tareas, tiempoTareas);
		System.out.println(caminoCritico.getCaminoCritico());
	}

}
