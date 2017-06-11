package control;

import java.awt.*;

//
// Classe Player - Final
//
// Descrição: Classe representativa dos jogadores na partida.
//
// Variáveis: Não possui variáveis públicas.
//
// Métodos: Player (Construtor), setPosV, setPos, getNome, get PosV, getPos, getColor. 
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
	// Descrição: Construtor que inicializa as variáveis internas da instância.
	//
	// Parâmetros: String name - Nome do jogador, int posInicial - Posição inicial desse jogador, int px - Posição horizontal inicial, int py - Posição vertical inicial,
	//			   Color c - Cor da peça do jogador.
	//
	
	public Player(String name, int posInicial, int px, int py, Color c) {
		this.name = name;
		this.posInicial = posInicial;
		this.posVertex = -1; /* NÃ£o estÃ¡ no grafo do tabuleiro */
		this.color = c;
		this.posx = px;
		this.posy = py;
	}
	
	//
	// Método setPosV
	//
	// Descrição: Atualiza a posição do player em um vértice do grafo.
	//
	// Parâmetro: int pos - Posição a ser atualizada.
	//
	// Retorno: Sem retorno.
	//
	
	public void setPosV(int pos) {
		posVertex = pos;
	}
	
	//
	// Método setPos
	//
	// Descrição: Atualiza as posições horizontais e verticais no mapa.
	//
	// Parâmetros: int x - Nova posição horizontal do personagem, int y - Nova posição vertical do personagem.
	//
	// Retorno: Não retorna nada.
	//
	
	public void setPos(int x, int y){
		posx = x;
		posy = y;
	}
	
	//
	// Método getNome
	//
	// Descrição: Obtém o nome do jogador em questão.
	//
	// Parâmetro: Não recebe parâmetros.
	//
	// Retorno: String do nome do jogador em questão.
	//
	
	public String getNome() {
		return name;
	}
	
	//
	// Método getPosV
	//
	// Descrição: Obtém o vértice em que o jogador se localiza.
	//
	// Parâmetros: Sem parâmetros.
	//
	// Retorno: Número do vértice.
	//
	
	public int getPosV() {
		if (posVertex == -1) {
			return posInicial;
		}
		return posVertex;
	}
	
	//
	// Método getPos
	//
	// Descrição: Pega as posições horizontais e verticais do jogador.
	//
	// Parâmetro: Sem parâmetros.
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
	// Método getColor
	//
	// Descrição: Pega a cor do personagem em questão.
	//
	// Parâmetro: Não recebe parâmetros.
	//
	// Retorno: Tipo Color, correspondendo à cor do personagem.
	//
	
	public Color getColor(){
		return this.color;
	}
	
}
