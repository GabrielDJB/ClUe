package gameui;
import control.Control;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

final class TratadorOK implements ActionListener {
	
	JCheckBox boxes[];
	
	public TratadorOK(JCheckBox b[]) {
		boxes = b;
	}
	
	public void actionPerformed(ActionEvent e) {
		for (JCheckBox b : boxes) {
			if (b.isSelected()) {
				Control.AddPlayer(b.getText());
			}
		}
		Control.printNP();
		UI.mainf.dispose();
		UI.GameStart();
	}
}

final class TratadorCancelar implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		UI.mainf.dispose();
		UI.IniFrame();
	}
}

public class CharSelectPanel extends JPanel {
	int width;
	int height;
	JCheckBox boxes[];
	
	public CharSelectPanel(int w, int h) {
		this.width = w;
		this.height = h;
		boxes = new JCheckBox[7];
	}
	
	public void IniCharList() {
		JLabel l = new JLabel("Selecione os personagens da partida: ");
		l.setFont(new Font("Calibri", Font.PLAIN, 20));
		l.setBounds(100, 75, 600, 50);
		
		boxes[0] = new JCheckBox("Pele");
		boxes[1] = new JCheckBox("Maradona");
		boxes[2] = new JCheckBox("Eric Cantona");
		boxes[3] = new JCheckBox("Zinedine Zidane");
		boxes[4] = new JCheckBox("Ronaldinho Gaucho");
		boxes[5] = new JCheckBox("Taffarel");
		boxes[6] = new JCheckBox("Zico");
		
		
		boxes[0].setBounds(100, 150, 200, 30);
		boxes[1].setBounds(100, 200, 200, 30);
		boxes[2].setBounds(100, 250, 200, 30);
		boxes[3].setBounds(100, 300, 200, 30);
		boxes[4].setBounds(100, 350, 200, 30);
		boxes[5].setBounds(100, 400, 200, 30);
		boxes[6].setBounds(100, 450, 200, 30);
		
		this.add(l);
		
		for (JCheckBox b : boxes) {
			this.add(b);
		}
	}
	
	public void UserButtons() {
		JButton ok = new JButton("OK");
		JButton cancelar = new JButton("Cancelar");
		
		ok.addActionListener(new TratadorOK(this.boxes));
		cancelar.addActionListener(new TratadorCancelar());
		
		ok.setBounds(600, 600, 100, 50);
		cancelar.setBounds(700, 600, 100, 50);
		
		this.add(ok);
		this.add(cancelar);
	}
}
