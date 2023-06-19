package view;


import javax.swing.*;

import sistema.Alimentacao;
import sistema.Empresa;
import sistema.Filial;
import sistema.Vestuario;

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
		
		frameMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
			
	}//Fim do construtor
	
	public void actionPerformed(ActionEvent evento) {
		if(evento.getActionCommand().equals("Filial")) {
			new InterfaceFilial();
		} else if(evento.getActionCommand().equals("Produtos")){
			new InterfaceProduto();
		}
	}

	public static void main(String[]args) {
		Empresa e1 = new Empresa("Comercio geral ltda", "12.345.678/0001-23");
		e1.adcFilial(new Filial("lugar1", e1));
		e1.adcFilial(new Filial("lugar3", e1));
		e1.adcFilial(new Filial("lugar2", e1));
		
		e1.buscarFilial("lugar1").adcItem(new Vestuario("blusa", 60, 10, "preta basica", 7, "helicoptero" ));
		e1.buscarFilial("lugar2").adcItem(new Vestuario("calça", 100, 7,"sarja", 42, "unissex" ));
		e1.buscarFilial("lugar3").adcItem(new Alimentacao("Leite", 5, 1, "blablabla", 7, false));
		e1.buscarFilial("lugar1").adcItem(new Vestuario("mouse", 60, 10, "preta basica", 7, "helicoptero" ));
		e1.buscarFilial("lugar2").adcItem(new Vestuario("teclado", 100, 7,"sarja", 42, "unissex" ));
		e1.buscarFilial("lugar3").adcItem(new Alimentacao("caderno", 5, 1, "blablabla", 7, false));

		new InterfaceMenu();
	}
	
}//Fim da classe InterfaceMenu
