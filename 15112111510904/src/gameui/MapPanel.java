package gameui;
import control.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.io.*;
import java.util.*;

//
// Classe MapHandler - MouseListener
//
// Descri��o: Listener do mouse em cima do mapa. Certos m�todos s�o deixados vazios para satisfazer a interface MouseListener.
//
// M�todos: mouseClicked
//

final class MapHandler implements MouseListener{
	
	//
	// M�todo mouseClicked
	//
	// Descri��o: Decide o que � feito quando ocorre um clique do mouse em cima do mapa.
	//
	// Par�metro: MouseEvent e - Refer�ncia ao evento do mouse.
	//
	// Retorno: Sem retorno.
	//
	
	public void mouseClicked(MouseEvent e){
		Iterator<Player> players = Control.getPlayersIt();
		Player first = players.next();
		int px = e.getX();
		int py = e.getY();
		first.setPos(px, py);
		UI.RefreshMap();
	}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	
}

//
// Classe MapPanel - JPanel
//
// Descri��o: Painel do mapa, respons�vel por identificar o a��es sobre o mapa e passar para o m�dulo de controle quando for apropriado.
//
// M�todos: MapPanel (Construtor), paintComponent
//

public class MapPanel extends JPanel {
	int width;
	int height;
	Image map;
	
	//
	// Construtor MapPanel
	//
	// Descri��o: Inicializa o painel do mapa, definindo suas dimens�es e adicionando a rela��es com o listener.
	//
	// Par�metros: int w - Largura do painel do mapa, int h - Altura do painel do mapa.
	//
	
	public MapPanel(int w, int h){
		super(null);
		this.width = 3*w/4;
		this.height = h;

		try {
			map = ImageIO.read(new File("img/Tabuleiros/Tabuleiro-Original.JPG"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		this.addMouseListener(new MapHandler());
	}
	
	//
	// M�todo paintComponent
	//
	// Descri��o: M�todo chamado automaticamente ao instanciar a classe e chamado posteriormente pelo m�todo de JPanel repaint(). Esse m�todo normalmente n�o � chamado expl�citamente.
	//
	// Par�metros: Graphics g - Refer�ncia ao m�dulo de gr�ficos do Swing.
	//
	// Retorno: Sem retorno.
	//
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(map, 0, 0, width, height, null);

		//Daqui come�a o desenho dos jogadores
		int r = 15;
		Graphics2D g2d = (Graphics2D) g;
		
		Iterator<Player> players = Control.getPlayersIt();
		
		while(players.hasNext()){	
			Player p = players.next();
			int pos[] = p.getPos();
			int cx = pos[0];
			int cy = pos[1];
			Color c = p.getColor();
			Ellipse2D circ = new Ellipse2D.Double();
			circ.setFrameFromCenter(cx, cy, cx+r, cy+r);
			g2d.setColor(c);
			g2d.fill(circ);
		}
	}

}
