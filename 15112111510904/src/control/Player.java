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
	private int armas[] = { 0, 0, 0, 0, 0, 0 };
	private int suspeitos[] = { 0, 0, 0, 0, 0, 0 };
	private int comodos[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };

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
		Player.posVertex[_loc] = -321;
		color = c;
		posx = px;
		posy = py;
	}

	public Player(String name, int njogadas, int posV, int px, int py, Color c) {
		if (Player.posVertex == null) {
			Player.posVertex = new int[Control.rodada.getNumJogadores()];
		}

		this.name = name;
		posInicial = -321;
		jogadas = njogadas;
		_loc = arrayLoc++;
		Player.posVertex[_loc] = posV;
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
		if (Player.posVertex[_loc] == -321 && jogadas == 0) {
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

	public int[] getArmas() {
		return armas;
	}

	public int[] getComodos() {
		return comodos;
	}

	public int[] getSuspeitos() {
		return suspeitos;
	}

	public void setArmas(int[] array) {
		armas = array;
	}

	public void setComodos(int[] array) {
		comodos = array;
	}

	public void setSuspeitos(int[] array) {
		suspeitos = array;
	}

	// tipo 0 = armas; tipo 1 = suspeitos; tipo 2 = comodos
	public int addCard(int type, int card) {
		
		if ((type == 0 && (card < 0 || card > 5)) || (type == 1 && (card < 0 || card > 5))
				|| (type == 2 && (card < 0 || card > 8)) || type < 0 || type > 2)
			return -1;
		else {
			if (type == 0) {
				armas[card] = 1;
				return 1;
			} else if (type == 1) {
				suspeitos[card] = 1;
				return 1;
			} else {
				comodos[card] = 1;
				return 1;
			}
		}
		
	}

	// tipo 0 = armas; tipo 1 = suspeitos; tipo 2 = comodos
	public int hasCard(int type, int card) {
		
		if ((type == 0 && (card < 0 || card > 5)) || (type == 1 && (card < 0 || card > 5))
				|| (type == 2 && (card < 0 || card > 8)) || type < 0 || type > 2)
			return -1;
		else {
			if (type == 0) {
				if (armas[card] == 1)
					return 1;
				else
					return 0;
			} else if (type == 1) {
				if (suspeitos[card] == 1)
					return 1;
				else
					return 0;
			} else {
				if (comodos[card] == 1)
					return 1;
				else
					return 0;
			}
		}
		
	}

}
