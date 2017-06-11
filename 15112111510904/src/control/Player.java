package control;

import java.awt.*;

//
// Classe Player - Final
//
// Descri��o: Classe representativa dos jogadores na partida.
//
// Vari�veis: N�o possui vari�veis p�blicas.
//
// M�todos: Player (Construtor), setPosV, setPos, getNome, get PosV, getPos, getColor. 
//

public final class Player {
	private int posInicial;
	private int posVertex;
	private int posx;
	private int posy;
	private String name = new String();
	private Color color;
	
	//
	// Constutor Player
	//
	// Descri��o: Construtor que inicializa as vari�veis internas da inst�ncia.
	//
	// Par�metros: String name - Nome do jogador, int posInicial - Posi��o inicial desse jogador, int px - Posi��o horizontal inicial, int py - Posi��o vertical inicial,
	//			   Color c - Cor da pe�a do jogador.
	//
	
	public Player(String name, int posInicial, int px, int py, Color c) {
		this.name = name;
		this.posInicial = posInicial;
		this.posVertex = -1; /* Não está no grafo do tabuleiro */
		this.color = c;
		this.posx = px;
		this.posy = py;
	}
	
	//
	// M�todo setPosV
	//
	// Descri��o: Atualiza a posi��o do player em um v�rtice do grafo.
	//
	// Par�metro: int pos - Posi��o a ser atualizada.
	//
	// Retorno: Sem retorno.
	//
	
	public void setPosV(int pos) {
		posVertex = pos;
	}
	
	//
	// M�todo setPos
	//
	// Descri��o: Atualiza as posi��es horizontais e verticais no mapa.
	//
	// Par�metros: int x - Nova posi��o horizontal do personagem, int y - Nova posi��o vertical do personagem.
	//
	// Retorno: N�o retorna nada.
	//
	
	public void setPos(int x, int y){
		posx = x;
		posy = y;
	}
	
	//
	// M�todo getNome
	//
	// Descri��o: Obt�m o nome do jogador em quest�o.
	//
	// Par�metro: N�o recebe par�metros.
	//
	// Retorno: String do nome do jogador em quest�o.
	//
	
	public String getNome() {
		return name;
	}
	
	//
	// M�todo getPosV
	//
	// Descri��o: Obt�m o v�rtice em que o jogador se localiza.
	//
	// Par�metros: Sem par�metros.
	//
	// Retorno: N�mero do v�rtice.
	//
	
	public int getPosV() {
		if (posVertex == -1) {
			return posInicial;
		}
		return posVertex;
	}
	
	//
	// M�todo getPos
	//
	// Descri��o: Pega as posi��es horizontais e verticais do jogador.
	//
	// Par�metro: Sem par�metros.
	//
	// Retorno: Vetor de inteiros com as coordenadas, no formato {x,y}
	//
	
	public int[] getPos(){
		int pos[] = new int[2];
		pos[0] = posx;
		pos[1] = posy;
		return pos;
	}
	
	//
	// M�todo getColor
	//
	// Descri��o: Pega a cor do personagem em quest�o.
	//
	// Par�metro: N�o recebe par�metros.
	//
	// Retorno: Tipo Color, correspondendo � cor do personagem.
	//
	
	public Color getColor(){
		return this.color;
	}
	
}
