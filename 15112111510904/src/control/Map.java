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

		for (i = 0; i < 182; i++)
			v[i].visitado = false;
	}

}

final class Comodos {
	Point pontos[] = new Point[9];

	public Comodos(String filename) {
		File __f = new File(filename);
		Scanner f = null;
		int i = 0;

		try {
			f = new Scanner(__f);

			while (f.hasNext()) {
				f.next();
				pontos[i] = new Point(f.nextInt(), f.nextInt(), f.nextInt(), f.nextInt());
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	public int isInside(int x, int y) {
		int i;

		for (i = 0; i < 9; i++) {
			if (pontos[i].isInside(x, y))
				return -(i + 1);
		}
		return 0;
	}

}

/* Singleton */

public final class Map {
	private static Map instance = new Map();
	private Graph g;
	private Comodos c;

	private Map() {
		g = new Graph(182);
		c = new Comodos("comodos.txt");
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
		if (destino < 0) {
			if (origem == 36 && destino == -1)
				return true;
			if (origem == 116 && destino == -2)
				return true;
			if (origem == 143 && destino == -3)
				return true;
			if (origem == 55 || origem == 20 && destino == -4)
				return true;
			if (origem == 133 && destino == -5)
				return true;
			if (origem == 22 && destino == -6)
				return true;
			if (origem == 76 && destino == -7)
				return true;
			if (origem == 121 && destino == -8)
				return true;
			if (origem == 163 && destino == -9)
				return true;
		} else if (origem < 0) {
			if (origem == -1 && destino == 36)
				return true;
			if (origem == -2 && destino == 116)
				return true;
			if (origem == -3 && destino == 143)
				return true;
			if (origem == -4 && destino == 20 || destino == 55)
				return true;
			if (origem == -5 && destino == 133)
				return true;
			if (origem == -6 && destino == 22)
				return true;
			if (origem == -7 && destino == 76)
				return true;
			if (origem == -8 && destino == 121)
				return true;
			if (origem == -9 && destino == 163)
				return true;
		} else {
			boolean v = g.evalPath(origem, destino, dado);
			g.resetVertexs();
			return v;
		}
		return false;
	}

	/* Retorna vértice correspondente a x,y */
	public int coordTransform(int x, int y) {
		int ret = c.isInside(x, y);

		if (ret < 0)
			return ret;

		if (x < 59 || x > 810)
			return -123;

		if (y < 80 || y > 940)
			return -123;

		return g.searchVertex(x, y);
	}
}
