package control;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

public final class SaveGame {
	private BufferedWriter savehere;

	public SaveGame(File _f) {

		try {
			savehere = new BufferedWriter(new FileWriter(_f));
			savehere.write(Control.rodada.getNumJogadores() + "");
			savehere.newLine();
			dump(Control.jogadores);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		} finally {
			try {
				savehere.flush();
				savehere.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(-1);
			}
		}

	}

	// Overloads

	// Dump dos jogadores, formato;
	// Nome
	// Numero de Jogadas
	// Posição no grafo
	// Posição x
	// Posição y
	// Array de int (armas)
	// Array de int (suspeitos)
	// Array de int (comodos)
	private void dump(List<Player> jogadores) {

		for (Player p : jogadores) {
			try {
				savehere.write("@");
				savehere.newLine();
				savehere.write(p.getNome());
				savehere.newLine();
				savehere.write(p.getNumJogadas() + "");
				savehere.newLine();
				savehere.write(p.getPosV() + "");
				savehere.newLine();
				savehere.write(p.getPos()[0] + "");
				savehere.newLine();
				savehere.write(p.getPos()[1] + "");
				savehere.newLine();
				dump(p.getArmas());
				dump(p.getComodos());
				dump(p.getSuspeitos());
				savehere.write(p.getStatus() + "");
				savehere.write("@");
				savehere.newLine();
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(-1);
			}
		}

	}

	private void dump(int array[]) {
		int i;

		for (i = 0; i < array.length; i++) {
			try {
				savehere.write(array[i] + "");
				savehere.newLine();
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(-1);
			}
		}

	}
}
