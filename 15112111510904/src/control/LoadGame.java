package control;

import java.io.File;
import java.util.Scanner;

public final class LoadGame {
	private Scanner readthis = null;
	private int lengtharmas = 6;
	private int lengthsusp = 6;
	private int lengthcomodos = 9;
	private int playeridx = 0;
	private int qtdplayers = 0;

	// Parser do Arquivo cdata
	public LoadGame(File _f) {

		try {
			readthis = new Scanner(_f);
			qtdplayers = readthis.nextInt();
			for (; qtdplayers > 0; qtdplayers--) {
				readthis.next();
				loadPlayer();
				readthis.next();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}

	}

	private void loadPlayer() {
		Control.AddPlayer(readthis.next(), readthis.nextInt(), readthis.nextInt(), readthis.nextInt(),
				readthis.nextInt());
		populateArmas();
		populateComodos();
		populateSuspeitos();
	}

	private void populateArmas() {
		int[] tmp = new int[lengtharmas];
		int i;

		for (i = 0; i < lengtharmas; i++) {
			tmp[i] = readthis.nextInt();
		}

		Control.jogadores.get(playeridx).setArmas(tmp);
	}

	private void populateComodos() {
		int[] tmp = new int[lengthcomodos];
		int i;

		for (i = 0; i < lengthcomodos; i++) {
			tmp[i] = readthis.nextInt();
		}

		Control.jogadores.get(playeridx).setComodos(tmp);
	}

	private void populateSuspeitos() {
		int[] tmp = new int[lengthsusp];
		int i;

		for (i = 0; i < lengthsusp; i++) {
			tmp[i] = readthis.nextInt();
		}

		Control.jogadores.get(playeridx).setSuspeitos(tmp);
	}

}
