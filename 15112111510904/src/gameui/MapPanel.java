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
// Descrição: Listener do mouse em cima do mapa. Certos Métodos são deixados vazios para satisfazer a interface MouseListener.
//
// Métodos: mouseClicked
//

final class MapHandler implements MouseListener {

	//
	// Método mouseClicked
	//
	// Descrição: Decide o que é feito quando ocorre um clique do mouse em cima
	// do mapa.
	//
	// Parâmetro: MouseEvent e - Referência ao evento do mouse.
	//
	// Retorno: Sem retorno.
	//

	public void mouseClicked(MouseEvent e) {
		Player current = Control.jogadores.get(0);
		int pos[] = current.getPos();
		System.out.println(current.isActive);
		System.out.println(e.getX());
		System.out.println(e.getY());
		System.out.println(pos[0]);
		System.out.println(pos[1]);

		if (Control.rodada.dado == 0) {
			UI.Alert(Control.jogadores.get(0).getNome() + " -> JOGUE O DADO!");
		}

		if (current.isActive == false) {
			int x = e.getX();
			int y = e.getY();

			if (x >= pos[0] - 5 && x <= pos[0] + 5 && y >= pos[1] - 5 && y <= pos[1] + 5)
				current.isActive = true;

		} else if (Control.rodada.dado != 0) {
			int destino = Control.mapa.coordTransform(e.getX(), e.getY());
			int origem = Control.mapa.coordTransform(pos[0], pos[1]);

			if (Control.jogadores.get(0).jogadas == 0) {
				/* Jogador está na posição inicial */
				origem = Control.jogadores.get(0).getPosV();
			}
			if (origem == destino && Control.jogadores.get(0).jogadas != 0) {
				UI.Alert("A peça tem de ser movida!");
				current.isActive = false;
			} else if (origem == -1 || destino == -1) {
				current.isActive = false;
				return;
			} else if (Control.mapa.evalPath(origem, destino, Control.rodada.dado)
					&& Player.checkCollision(destino) != true) {
				current.isActive = false;
				current.setPos(e.getX(), e.getY());
				Control.rodada.nextTurn();
			}
			UI.RefreshMap();
		}
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

}

//
// Classe MapPanel - JPanel
//
// Descrição: Painel do mapa, responsável por identificar o ações sobre o mapa e
// passar para o módulo de controle quando for apropriado.
//
// Métodos: MapPanel (Construtor), paintComponent
//

public class MapPanel extends JPanel {
	int width;
	int height;
	Image map;

	//
	// Construtor MapPanel
	//
	// Descrição: Inicializa o painel do mapa, definindo suas dimensões e
	// adicionando a relações com o listener.
	//
	// Parâmetros: int w - Largura do painel do mapa, int h - Altura do painel
	// do mapa.
	//

	public MapPanel(int w, int h) {
		super(null);
		this.width = 3 * w / 4;
		this.height = h;

		try {
			map = ImageIO.read(new File("img/Tabuleiros/Tabuleiro-Original.JPG"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(-1);
		}
		this.addMouseListener(new MapHandler());
	}

	//
	// Método paintComponent
	//
	// Descrição: Método chamado automaticamente ao instanciar a classe e
	// chamado posteriormente pelo Método de JPanel repaint(). Esse Método
	// normalmente não é chamado explícitamente.
	//
	// Parâmetros: Graphics g - Referência ao módulo de gráficos do Swing.
	//
	// Retorno: Sem retorno.
	//

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(map, 0, 0, width, height, null);

		// Daqui começa o desenho dos jogadores
		int r = 15;
		Graphics2D g2d = (Graphics2D) g;

		Iterator<Player> players = Control.jogadores.iterator();

		while (players.hasNext()) {
			Player p = players.next();
			int pos[] = p.getPos();
			int cx = pos[0];
			int cy = pos[1];
			Color c = p.getColor();
			Ellipse2D circ = new Ellipse2D.Double();
			circ.setFrameFromCenter(cx, cy, cx + r, cy + r);
			g2d.setColor(c);
			g2d.fill(circ);
		}
	}

}
