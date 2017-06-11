package control;

//
// Classe Round - Singleton
//
// Descri��o: Classe respons�vel pela administra��o de rodadas. Estruturada de acordo com o design pattern de singletons.
//
// Vari�veis: N�o possui vari�veis vis�veis.
//
// M�todos: Round (Construtor), GetRodada, addNumP, nextTurn
//

public final class Round {
	private static Round instance = new Round();
	private static int turn;
	private static int nPlayers = 0;
	
	//
	// Construtor Round - Privado (Singleton)
	//
	// Descri��o: Cria a inst�ncia do singleton, iniciando o n�mero de rodadas em zero.
	//
	
	private Round() {
		turn = 0;
		/* Vazio */
	}
	
	//
	// M�todo GetRodada
	//
	// Descri��o: Retorna uma refer�ncia a essa �nica inst�ncia.
	//
	// Par�metros: Sem par�metros.
	//
	// Retorno: Refer�ncia � rodada.
	//
	
	public static Round GetRodada() {
		return instance;
	}
	
	//
	// M�todo addNumP
	//
	// Descri��o: Incrementa o n�mero de jogadores no jogo.
	//
	// Par�metros: Sem par�metros.
	//
	// Retorno: Sem retorno.
	//
	
	public static void addNumP(){
		nPlayers = nPlayers + 1;
	}
	
	//
	// M�todo nextTurn
	//
	// Descri��o: Atribui � vari�vel turn o n�mero do jogador que deve jogar na pr�xima.
	//
	// Par�metros: Sem par�metros.
	//
	// Retorno: Sem retornos.
	//
	
	public static void nextTurn(){
		turn = (turn + 1) % nPlayers;
	}
}
