package view;

import javax.swing.*;

import java.awt.*;

public class InterfaceProduto {
	
		public static void main(String[] args) {
		
		
		JLabel g = new JLabel(" FILIAL ");
		JFrame f = new JFrame();
		JButton b2 = new JButton(" Cadastrar Filial"); 
		//tem q usar jtable ou jlist 
		
		b2.setBounds(200,200,200,80);
		b2.setFont(new Font("Arial", Font.BOLD, 15));
		g.setBounds(260,100,200,80);
		g.setFont(new Font("Arial", Font.BOLD, 20));

		
		
		//f.setSize(500,400);
		f.setBounds(0, 0,  730, 500); // (0, 0,  1920, 1080) pra ficar quase em tela cheia em um monitor full hd
		f.setLayout(null);
		f.setVisible(true);
		f.add(b2);
		f.add(g);

		

}
}