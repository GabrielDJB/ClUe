package gameui;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

final class DiceOKHandler implements ActionListener {
	
	JRadioButton dado1, dado2, dado3, dado4, dado5, dado6;
	int value;
	
	public DiceOKHandler(JRadioButton d1, JRadioButton d2, JRadioButton d3, JRadioButton d4, JRadioButton d5, JRadioButton d6) {
		dado1 = d1;
		dado2 = d2;
		dado3 = d3;
		dado4 = d4;
		dado5 = d5;
		dado6 = d6;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(dado1.isSelected()){
			value = 1;
			UI.switchDice(value);
			UI.DiceClose();
		} else if (dado2.isSelected()) {
			value = 2;
			UI.switchDice(value);
			UI.DiceClose();
		} else if (dado3.isSelected()) {
			value = 3;
			UI.switchDice(value);
			UI.DiceClose();
		} else if (dado4.isSelected()) {
			value = 4;
			UI.switchDice(value);
			UI.DiceClose();
		} else if (dado5.isSelected()) {
			value = 5;
			UI.switchDice(value);
			UI.DiceClose();
		} else if (dado6.isSelected()) {
			value = 6;
			UI.switchDice(value);
			UI.DiceClose();
		} else {
			UI.Alert("N�o escolheu um valor!");
		}
	}
}

final class DiceCancelHandler implements ActionListener {
	
	public void actionPerformed(ActionEvent e) {
		UI.DiceClose();
	}
}

public class TempDiceSelect extends JPanel {
	int value;
	JRadioButton d1;
	JRadioButton d2;
	JRadioButton d3;
	JRadioButton d4;
	JRadioButton d5;
	JRadioButton d6;
	
	public TempDiceSelect(Container c){
		super(null);
		d1 = new JRadioButton("Dado 1");
		d2 = new JRadioButton("Dado 2");
		d3 = new JRadioButton("Dado 3");
		d4 = new JRadioButton("Dado 4");
		d5 = new JRadioButton("Dado 5");
		d6 = new JRadioButton("Dado 6");
		
		ButtonGroup bg = new ButtonGroup();
		
		bg.add(d1);
		bg.add(d2);
		bg.add(d3);
		bg.add(d4);
		bg.add(d5);
		bg.add(d6);
		
		d1.setBounds(50,50,100,30);
		d2.setBounds(50,90,100,30);
		d3.setBounds(50,130,100,30);
		d4.setBounds(50,170,100,30);
		d5.setBounds(50,210,100,30);
		d6.setBounds(50,250,100,30);
		
		this.add(d1);
		this.add(d2);
		this.add(d3);
		this.add(d4);
		this.add(d5);
		this.add(d6);
		
		c.add(this);
		
	}
	
	public void DiceButtons() {
		
		JButton ok = new JButton("OK");
		JButton cancelar = new JButton("Cancelar");
		
		ok.addActionListener(new DiceOKHandler(this.d1, this.d2, this.d3, this.d4, this.d5, this.d6));
		cancelar.addActionListener(new DiceCancelHandler());
		
		ok.setBounds(300, 300, 100, 50);
		cancelar.setBounds(425, 300, 100, 50);
		
		this.add(ok);
		this.add(cancelar);
	}
}
