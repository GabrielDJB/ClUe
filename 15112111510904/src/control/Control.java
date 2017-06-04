package control;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import gameui.UI;

public abstract class Control {
	public static Map mapa = Map.GetMapa();
	public static boolean JogoAtivo = false;
	public static Round rodada = Round.GetRodada();
	public static List<Player> jogadores = new ArrayList<Player>();
	
	public static void InitControl() {
		JogoAtivo = true;
	}
	
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
	
	public static Player getPlayer(String name){
		for(Player i:jogadores){
			if(i.getNome().equals(name)){
				return i;
			}
		}
		UI.Alert("Erro na busca por jogador!");
		return null;
	}
	
	public static Iterator<Player> getPlayersIt(){
		return jogadores.iterator();
	}
	
	public static Map getMap(){
		return mapa;
	}
	
	public static void printNP(){
		System.out.println(Integer.toString(jogadores.size()));
	}

}
