package control;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import gameui.UI;

//
// Classe Control - Abstrata (N�o Instanci�vel)
//
// Fu��o: Classe respons�vel pela delega��o de comandos l�gicos do jogo.
//
// Visibilidade: Vis�vel por todas as classes no package control.
//
// Vari�veis Vis�veis: mapa, JogoAtivo, rodada, jogadores.
//
// M�todos: AddPlayer, getPlayer, getPlayersIt, getMap, printNP
//

public abstract class Control {
	public static Map mapa = Map.GetMapa(); // Mapa do jogo
	public static boolean JogoAtivo = false; // Determina se o jogo est� rodando
	public static Round rodada = Round.GetRodada(); // Manager de rodadas do jogo
	public static List<Player> jogadores = new ArrayList<Player>(); // Lista dos jogadores dessa inst�ncia do jogo
	
	//
	// M�todo InitControl - Abstrato
	//
	// Descri��o: Atribui o valor verdadeiro � vari�vel JogoAtivo, indicando que o jogo come�ou.
	//
	// Sem par�metros ou retornos.
	//
	
	public static void InitControl() {
		JogoAtivo = true;
	}
	
	//
	// M�todo AddPlayer - Abstrato
	//
	// Descri��o: Adiciona um jogador na lista de jogadores.
	//
	// Par�metros: name - Nome do jogador que deve ser adicionado.
	//
	// Retorno: Nada � retornado.
	//
	
	public static void AddPlayer(String name) {
		Player p;
		
		if (name.compareTo(new String("Pele")) == 0) {
			p = new Player(name, 0, 370, 75, Color.white);
		} else if (name.compareTo(new String("Maradona")) == 0) {
			p = new Player(name, 0, 525, 75, Color.green);		
		} else if (name.compareTo(new String("Eric Cantona")) == 0) {
			p = new Player(name, 0, 820, 290, Color.blue);
		} else if (name.compareTo(new String("Zinedine Zidane")) == 0) {
			p = new Player(name, 0, 820, 745, Color.cyan);
		} else if (name.compareTo(new String("Ronaldinho Gaucho")) == 0) {
			p = new Player(name, 0, 305, 930, Color.red);
		} else if (name.compareTo(new String("Taffarel")) == 0) {
			p = new Player(name, 0, 75, 680, Color.yellow);
		} else {
			p = new Player(name, 0, 450, 150, Color.yellow);
		}
		
		jogadores.add(p);
		Round.addNumP();
	}
	
	//
	// M�todo getPlayer - Abstrato
	//
	// Descri��o: Pega um jogador espec�fico na lista de jogadores pelo nome do jogador desejado.
	//
	// Par�metros: name - Nome do jogador cuja refer�ncia dev ser retornada.
	//
	// Retorno: Refer�ncia � inst�ncia do jogador desejado.
	//
	
	public static Player getPlayer(String name){
		for(Player i:jogadores){
			if(i.getNome().equals(name)){
				return i;
			}
		}
		UI.Alert("Erro na busca por jogador!");
		return null;
	}
	
	//
	// M�todo getPlayersIt - Abstrato
	//
	// Descri��o: Retorna um iterador na lista de jogadores, afim de possibilitar a varredura da lista.
	//
	// Par�metros: N�o recebe par�metros.
	//
	// Retorno: Retorna um iterador da lista de jogadores.
	//
	
	public static Iterator<Player> getPlayersIt(){
		return jogadores.iterator();
	}
	
	//
	// M�todo getMap - Abstrato
	//
	// Descri��o: Obt�m acesso ao mapa, atrav�s de sua refer�ncia.
	//
	// Par�metros: N�o possui par�metros.
	//
	// Retorno: Retorna uma refer�ncia ao mapa.
	//
	
	public static Map getMap(){
		return mapa;
	}
	
	//
	// M�todo printNP - Abstrato
	//
	// Descri��o: Imprime no console o n�mero de jogadores na partida.
	//
	
	public static void printNP(){
		System.out.println(Integer.toString(jogadores.size()));
	}

}
