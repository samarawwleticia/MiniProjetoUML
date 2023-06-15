package view;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InterfaceMenu implements ActionListener {
	
	InterfaceMenu() {
		
		//private static JLabel titulo = new JLabel("Menu Principal");
		//Vou agrupar os elementos parecidos 
		//N sei pq mas estou começando a ficar com medo desse código, tenho a impressão de que ele ainda vai me apunhalar pelas costas
		
		JLabel labelMenu = new JLabel("MENU PRINCIPAL");
		JFrame frameMenu = new JFrame();
		JButton botaoFiliais = new JButton("Filiais");
		JButton botaoProdutos = new JButton("Produtos"); 
		
		frameMenu.setBounds(0, 0,  600, 600); 
		frameMenu.setLayout(null);
		frameMenu.setVisible(true);
		frameMenu.add(botaoFiliais);
		frameMenu.add(botaoProdutos);
		frameMenu.add(labelMenu);
		
		botaoFiliais.setBounds(200,100,200, 80);
		botaoFiliais.setFont(new Font("Arial", Font.BOLD, 15));
		botaoProdutos.setBounds(200,200,200,80);
		botaoProdutos.setFont(new Font("Arial", Font.BOLD, 15));
		labelMenu.setBounds(218,30,200,80);
		labelMenu.setFont(new Font("Arial", Font.BOLD, 20));
		
		botaoFiliais.addActionListener(this);
		botaoProdutos.addActionListener(this);
		
		//b.addActionListener(this); // Isso gera um monte de baboseiras no terminal
	
	}//Fim do construtor
	
	public void actionPerformed(ActionEvent evento) {
		if(evento.getActionCommand().equals("Filial")) {
			new InterfaceFilial();
		} else {
			new InterfaceProduto();
		}
	}

	public static void main(String[]args) {
		new InterfaceMenu();
	}
	
}//Fim da classe InterfaceMenu
