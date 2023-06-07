package view;

import javax.swing.*;

public class InterfaceMenu {
	
	public static void main(String[] args) {
		
		JFrame f=new JFrame();
		JButton b=new JButton("Cadastrar nova Filial");
		b.setBounds(500,100,200, 80);
		f.add(b);
		f.setSize(200,180);
		f.setLayout(null);
		f.setVisible(true);
		
		JButton b2=new JButton("Cadastrar novo Produto");
		b2.setBounds(500,200,200,80);
		f.add(b2);
		
	}

	
}
