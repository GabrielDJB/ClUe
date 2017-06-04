package control;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Edge {
	/*
	 * Arestas de casas permitidas tem peso > 0;
	 * Arestas de casas não permitidas tem peso -1 ( infinito );
	 */
	private int weight;
	/*
	 * Arestas contém referência para seus respectivos Start nodes e End nodes;
	 */
	Vertex start;
	Vertex end;
	
	public Edge(int weight, Vertex start, Vertex end) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public Vertex getEnd() {
		return end;
	}
	
}
class Vertex {
	/* 
	 * Vértices podem ter até 4 arestas;
	 * As arestas são norte, sul, leste, oeste. Respectivamente;
	 */
	Edge edges[];
	private boolean visitado = false;
	
	public Vertex() {
		edges = new Edge[4];
	}
	
	public void setNorthEdge(Vertex end, int weight) {
		edges[0] = new Edge(weight, this, end);
	}
	
	public void setEastEdge(Vertex end, int weight) {
		edges[2] = new Edge(weight, this, end);
	}
	
	public void setWestEdge(Vertex end, int weight) {
		edges[3] = new Edge(weight, this, end);
	}
	
	public void setSouthEdge(Vertex end, int weight) {
		edges[1] = new Edge(weight, this, end);
	}
	
	public void foiVisitado() {
		visitado = true;
	}
	
	public void clearVisitado() {
		visitado = false;
	}
	
	public boolean getVisitado() {
		return visitado;
	}

}

class Graph {
	Vertex vertices[];
	
	public Graph(int qtdvertices) {
		vertices = new Vertex[qtdvertices];
		for (int i = 0; i < qtdvertices; i++) {
			vertices[i] = new Vertex();
		}
	}
	
	private void setDir(String dir, int index, int vizinho, int weight) {
		if (dir.charAt(0) == 'n') {
				vertices[index].setNorthEdge(vertices[vizinho], weight);
		} else if (dir.charAt(0) == 's') {
			vertices[index].setSouthEdge(vertices[vizinho], weight);
		} else if (dir.charAt(0) == 'l') {
			vertices[index].setEastEdge(vertices[vizinho], weight);
		} else {
				vertices[index].setWestEdge(vertices[vizinho], weight);
		}
	}
	
	public void Generate(String filename) {
		File _f = new File(filename);
		Scanner f;
		String dir;
		int vizinho;
		int weight;
		int index;
		
		try {
			f = new Scanner(_f);
			while (f.hasNext() == true) {
				if (f.next().charAt(0) != '$') {
					break;
				}
				index = f.nextInt() - 1;
				while (true) {
					dir = f.next();
					if (dir.charAt(0) == '$') {
						break;
					}
					vizinho = f.nextInt();
					f.next();
					weight = f.nextInt();
					setDir(dir, index, vizinho, weight);
				}
			}
			f.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Retorna true se a menor distância entre os vértices v1 e v2 é menor ou igual a d;
	 */
	public boolean evalPath(int v1, int v2, int d) {
		int tmp;
		int hops = 1;
		int i;
		
		if ( v1 > v2 ) {
			tmp = v1;
			v1 = v2;
			v2 = tmp;
		}
		
		for (i = 0; i < 4; i++) {
			if (vertices[v1].edges[i] != null && vertices[v1].edges[i].getEnd() == vertices[v2]) {
				return true;
			}
			vertices[v1].foiVisitado();
		}
		
		
		
		if ( hops <= d ) {
			return true;
		}
		
		return false;
	}
	
}

/* Singleton */

public final class Map {
	private static Map instance = new Map();
	private Graph g;
	
	private Map() {
		g = new Graph(23*23 + 1);
		g.Generate("map.txt");
	}
	
	public static Map GetMapa() {
		return instance;
	}
	
	public boolean evalPath(int origem, int destino, int dado) {
		return g.evalPath(origem - 1 , destino - 1, dado);
	}
}
