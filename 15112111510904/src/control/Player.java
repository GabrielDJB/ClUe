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
	private int _loc;
	private static int arrayLoc = 0;
	private static int posVertex[] = null;
	private int posx;
	private int posy;
	private String name = new String();
	private Color color;
	private boolean isActive = false;
	private int jogadas = 0;

	//
	// Construtor Player
	//
	// Descrição: Construtor que inicializa as variáveis internas da instância.
	//
	// Parâmetros: String name - Nome do jogador, int posInicial - Posição
	// inicial desse jogador, int px - Posição horizontal inicial, int py -
	// Posição vertical inicial,
	// Color c - Cor da peça do jogador.
	//

	public Player(String name, int posInicial, int px, int py, Color c) {
		if (Player.posVertex == null) {
			Player.posVertex = new int[Control.rodada.getNumJogadores()];
		}

		this.name = name;
		this.posInicial = posInicial;
		_loc = arrayLoc++;
		Player.posVertex[_loc] = -1;
		color = c;
		posx = px;
		posy = py;
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
		Player.posVertex[_loc] = pos;
	}

	//
	// Método setPos
	//
	// Descrição: Atualiza as posições horizontais e verticais no mapa.
	//
	// Parâmetros: int x - Nova posição horizontal do personagem, int y - Nova
	// posição vertical do personagem.
	//
	// Retorno: Não retorna nada.
	//

	public void setPos(int x, int y) {
		posx = x;
		posy = y;
		jogadas++;
	}

	//
	// Método getNome
	//
	// Descrição: Obtém o nome do jogador em questão.
	//
	// Parâmetro: Não recebe Parâmetros.
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
	// Parâmetros: Sem Parâmetros.
	//
	// Retorno: Número do vértice.
	//

	public int getPosV() {
		if (Player.posVertex[_loc] == -1 && jogadas == 0) {
			return posInicial;
		}
		return Player.posVertex[_loc];
	}

	//
	// Método getPos
	//
	// Descrição: Pega as posições horizontais e verticais do jogador.
	//
	// Parâmetro: Sem Parâmetros.
	//
	// Retorno: Vetor de inteiros com as coordenadas, no formato {x,y}
	//

	public int[] getPos() {
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
	// Parâmetro: Não recebe Parâmetros.
	//
	// Retorno: Tipo Color, correspondendo á cor do personagem.
	//

	public Color getColor() {
		return this.color;
	}

	public static boolean checkCollision(int v) {
		int i;

		for (i = 0; i < Player.posVertex.length; i++) {
			if (Player.posVertex[i] == v)
				return true;
		}

		return false;
	}

	public void setActive(boolean v) {
		isActive = v;
	}

	public void addJogada() {
		jogadas++;
	}

	public boolean isActive() {
		return isActive;
	}

	public int getNumJogadas() {
		return jogadas;
	}

}
