package view;


import javax.swing.*;

import java.awt.*;

public class InterfaceMenu {
	
	public static void main(String[] args) {
		
		//private static JLabel titulo = new JLabel("Menu Principal");
		//Vou agrupar os elementos parecidos 
		//N sei pq mas estou começando a ficar com medo desse código, tenho a impressão de que ele ainda vai me apunhalar pelas costas
		
		JLabel g = new JLabel("MENU PRINCIPAL");
		JFrame f = new JFrame();
		JButton b = new JButton(" Filial");
		JButton b2 = new JButton(" Produto"); 
		
		b.setBounds(200,100,200, 80);
		b.setFont(new Font("Arial", Font.BOLD, 15));
		b2.setBounds(200,200,200,80);
		b2.setFont(new Font("Arial", Font.BOLD, 15));
		g.setBounds(218,30,200,80);
		g.setFont(new Font("Arial", Font.BOLD, 20));

		
		
		//f.setSize(500,400);
		f.setBounds(0, 0,  730, 500); // (0, 0,  1920, 1080) pra ficar quase em tela cheia em um monitor full hd
		f.setLayout(null);
		f.setVisible(true);
		f.add(b);
		f.add(b2);
		f.add(g);

		
		
		
		
		
	}

	
}
