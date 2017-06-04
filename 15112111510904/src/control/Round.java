package control;

/* Singleton */

public final class Round {
	private static Round instance = new Round();
	private static int turn;
	private static int nPlayers = 0;
	
	private Round() {
		turn = 0;
		/* Vazio */
	}
	
	public static Round GetRodada() {
		return instance;
	}
	
	public static void addNumP(){
		nPlayers = nPlayers + 1;
	}
	
	public static void nextTurn(){
		turn = (turn + 1) % nPlayers;
	}
}
