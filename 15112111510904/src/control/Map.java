package control;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

final class MapaGenerateException extends Exception {
	public MapaGenerateException() {
		super("Erro de parsing na geração do mapa");
	}
}

final class Point {
	int xmin, xmax;
	int ymin, ymax;

	public Point(int x1, int x2, int y1, int y2) {
		xmin = x1;
		xmax = x2;
		ymin = y1;
		ymax = y2;
	}

	public boolean isInside(int x, int y) {
		System.out.println(x >= xmin && x <= xmax);
		System.out.println(y >= ymin  && y <= ymax);
		if (x >= xmin && x <= xmax && y >= ymin && y <= ymax)
			return true;

		return false;
	}
}

final class Vertex {
	private List<Vertex> neighbours;
	private Point p;
	boolean visitado;
	int index;

	public Vertex(int idx) {
		index = idx;
		visitado = false;
		neighbours = new ArrayList<Vertex>();
	}

	public void addNeighbour(Vertex v) {
		neighbours.add(v);
	}

	public List<Vertex> getNeighbours() {
		List<Vertex> optimizedNeighbours = new ArrayList<Vertex>();

		for (Vertex v : neighbours) {
			if (v.visitado == false)
				optimizedNeighbours.add(v);
		}

		return optimizedNeighbours;
	}

	public void setPoint(int x1, int x2, int y1, int y2) {
		p = new Point(x1, x2, y1, y2);
	}

	public boolean isVertex(int x, int y) {
		return p.isInside(x, y);
	}

}

final class Graph {
	private Vertex v[];

	public Graph(int vcount) {
		int i;

		v = new Vertex[vcount];

		for (i = 0; i < 182; i++) {
			v[i] = new Vertex(i);
		}
	}

	public void Generate(String filename) throws MapaGenerateException {
		File __f = new File(filename);
		Scanner f = null;
		int index, count;

		try {
			f = new Scanner(__f);

			while (f.hasNext()) {
				if (f.next().compareTo("$") != 0)
					throw new MapaGenerateException();

				index = f.nextInt() - 1;
				System.out.println("Id " + index);
				count = f.nextInt();
				System.out.println("Vizi " + count);

				while (count != 0) {
					v[index].addNeighbour(v[f.nextInt() - 1]);
					count--;
				}

				if (f.next().compareTo("$") != 0)
					throw new MapaGenerateException();

				if (f.next().compareTo("#") != 0)
					throw new MapaGenerateException();

				v[index].setPoint(f.nextInt(), f.nextInt(), f.nextInt(), f.nextInt());

				if (f.next().compareTo("#") != 0)
					throw new MapaGenerateException();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		} finally {
			f.close();
		}
	}

	public int searchVertex(int x, int y) {
		int i;

		for (i = 0; i < 182; i++) {
			if (v[i].isVertex(x, y))
				return i;
		}

		return -1;
	}

	public boolean evalPath(int origem, int destino, int hops) {
		List<Vertex> neighbours = new ArrayList<Vertex>();
		List<Vertex> newNeighbours = new ArrayList<Vertex>();

		if (origem > destino) {
			int tmp;
			tmp = destino;
			destino = origem;
			origem = tmp;
		}

		neighbours.addAll(v[origem].getNeighbours());

		while (hops != 0) {
			for (Vertex tmp : neighbours) {
				if (tmp.index == v[destino].index)
					return true;
				tmp.visitado = true;
				newNeighbours.addAll(tmp.getNeighbours());
			}
			neighbours = new ArrayList<Vertex>(newNeighbours);
			newNeighbours.clear();
			hops--;
		}

		return false;
	}

	public void resetVertexs() {
		int i;

		for (i = 0; i < 182; i++) {
			v[i].visitado = false;
		}
	}

}

/* Singleton */

public final class Map {
	private static Map instance = new Map();
	private Graph g;

	private Map() {
		g = new Graph(182);
		System.out.println("Working Directory = " + System.getProperty("user.dir"));
		try {
			g.Generate("map.txt");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(-1);
		}
	}

	public static Map GetMapa() {
		return instance;
	}

	public boolean evalPath(int origem, int destino, int dado) {
		boolean v = g.evalPath(origem, destino, dado);
		g.resetVertexs();
		return v;
	}

	/* Retorna vértice correspondente a x,y */
	public int coordTransform(int x, int y) {

		if (x < 59 || x > 810)
			return -1;

		if (y < 80 || y > 940)
			return -1;

		return g.searchVertex(x, y);
	}
}
