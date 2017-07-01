package gameui;

import control.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.io.*;

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
		Player current = Control.GetCurrP();
		int pos[] = current.getPos();

		if (Control.rodada.getDado() == 0) {
			UI.Alert(Control.jogadores.get(0).getNome() + " --JOGUE O DADO!");
		}

		if (current.isActive() == false) {
			int x = e.getX();
			int y = e.getY();

			if (x >= pos[0] - 5 && x <= pos[0] + 5 && y >= pos[1] - 5 && y <= pos[1] + 5) {
				current.setActive(true);
				UI.RefreshMap();
			}

		} else if (Control.rodada.getDado() != 0) {
			int destino = Control.mapa.coordTransform(e.getX(), e.getY());
			int origem = Control.mapa.coordTransform(pos[0], pos[1]);

			if (current.getNumJogadas() == 0) {
				origem = current.getPosV();
			}
			if (origem == destino && current.getNumJogadas() != 0) {
				UI.Alert("A peça tem de ser movida!");
				current.setActive(false);
			} else if (origem == -123 || destino == -123) {
				current.setActive(false);
			} else if (origem < 0 && destino < 0) {

				if (Player.checkCollision(destino) != true) {
					if (origem == -1 && destino == -9 || origem == -9 && destino == -1) {
						current.setPos(e.getX(), e.getY());
					} else if (origem == -3 && destino == -6 || origem == -6 && destino == -3) {
						current.setPos(e.getX(), e.getY());
					}
				}

				current.setActive(false);
			} else if (Control.mapa.evalPath(origem, destino, Control.rodada.getDado())
					&& Player.checkCollision(destino) != true) {
				current.setActive(false);
				current.setPos(e.getX(), e.getY());
				current.setPosV(destino);
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

		for (Player p : Control.jogadores) {
			int pos[] = p.getPos();
			int cx = pos[0];
			int cy = pos[1];
			Color c = p.getColor();
			Ellipse2D circ = new Ellipse2D.Double();
			Ellipse2D interior = new Ellipse2D.Double();

			circ.setFrameFromCenter(cx, cy, cx + r, cy + r);
			interior.setFrameFromCenter(cx, cy, cx + 12, cy + 12);
			g2d.setColor(c);
			g2d.fill(circ);
			g2d.draw(circ);

			if (p.isActive()) {
				g2d.setColor(Color.BLACK);
				g2d.setStroke(new BasicStroke(2.0f));
				g2d.draw(interior);
			}

		}

	}

}
