package control;

import java.awt.*;


public final class Player {
	private int posInicial;
	private int posVertex;
	private int posx;
	private int posy;
	private String name = new String();
	private Color color;
	
	public Player(String name, int posInicial, int px, int py, Color c) {
		this.name = name;
		this.posInicial = posInicial;
		this.posVertex = -1; /* Não está no grafo do tabuleiro */
		this.color = c;
		this.posx = px;
		this.posy = py;
	}
	
	public void setPosV(int pos) {
		posVertex = pos;
	}
	
	public void setPos(int x, int y){
		posx = x;
		posy = y;
	}
	
	public String getNome() {
		return name;
	}
	
	public int getPosV() {
		if (posVertex == -1) {
			return posInicial;
		}
		return posVertex;
	}
	
	public int[] getPos(){
		int pos[] = new int[2];
		pos[0] = posx;
		pos[1] = posy;
		return pos;
	}
	
	public Color getColor(){
		return this.color;
	}
	
}
