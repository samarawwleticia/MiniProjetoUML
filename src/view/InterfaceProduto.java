package view;

import javax.swing.*;

import java.awt.*;

public class InterfaceProduto {
	
		public static void main(String[] args) {
		
		JFrame telaInterfaceProduto = new JFrame("Produtos");
		JLabel label = new JLabel("Produtos");
		JTextField entradaPesquisa = new JTextField();
		JButton botaoPesquisar = new JButton("Pesquisar");
		String[] cabecalho = {"Produto", "Quantidade", "Filial"};
		String[][] listaProdutos = {
				{"Melancia", "10", "Taguatinga"}, {"Blusa", "15", "Gama"}, {"Colher", "100", "Riacho Fundo"} };
		JTable tabelaProdutos = new JTable(listaProdutos, cabecalho);
		JScrollPane painelProdutos = new JScrollPane(tabelaProdutos);
		JButton botaoCadastrar = new JButton("Cadastrar Produto");
		
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
		
		}//Fim do método main (Não esquecer de apagar o método)
}//Fim da classe InterfaceProdut