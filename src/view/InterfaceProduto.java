package view;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class InterfaceProduto implements ActionListener{
	
	private JFrame telaInterfaceProduto = new JFrame("Produtos");
	private JLabel label = new JLabel("Produtos");
	private JTextField entradaPesquisa = new JTextField();
	private JButton botaoPesquisar = new JButton("Pesquisar");
	private String[] cabecalho = {"Produto", "Quantidade", "Filial"};
	private String[][] listaProdutos = {
			{"Melancia", "10", "Taguatinga"}, {"Blusa", "15", "Gama"}, {"Colher", "100", "Riacho Fundo"} };
	private JTable tabelaProdutos = new JTable(listaProdutos, cabecalho);
	private JScrollPane painelProdutos = new JScrollPane(tabelaProdutos);
	private JButton botaoCadastrar = new JButton("Cadastrar Produto");	
		
		InterfaceProduto() {
				
		telaInterfaceProduto.setBounds(0, 0,  600, 600); 
		telaInterfaceProduto.setLayout(null);
		telaInterfaceProduto.setVisible(true);
		
		label.setBounds(250, 10, 200, 80);
		label.setFont(new Font("Arial", Font.BOLD, 20));
		entradaPesquisa.setBounds(100, 70, 300, 20);
		botaoPesquisar.setBounds(400, 70, 100, 20);
		painelProdutos.setBounds(100, 100, 400, 300);
		botaoCadastrar.setBounds(200,425,200,80);
		botaoCadastrar.setFont(new Font("Arial", Font.BOLD, 15));
		
		telaInterfaceProduto.add(botaoPesquisar);
		telaInterfaceProduto.add(botaoCadastrar);
		telaInterfaceProduto.add(entradaPesquisa);
		telaInterfaceProduto.add(label);
		telaInterfaceProduto.add(painelProdutos);
		
		botaoCadastrar.addActionListener(this);
		
		}
		
		public void actionPerformed(ActionEvent evento) {
			Object elemento = evento.getSource();
			
			if (elemento == botaoCadastrar) {
				new InterfaceCadastroProduto();
			}
			
		}
		
}//Fim da classe InterfaceProdut