package view;

import javax.swing.*;

import java.awt.*;

public class InterfaceProduto {
	
		public static void main(String[] args) {
		
		//tem q usar jtable ou jlist 
		JLabel label = new JLabel("Produtos");
		JFrame telaInterfaceProduto = new JFrame();
		JButton botaoCadastrar = new JButton("Cadastrar Produto");
		String[] cabecalho = {"Produto", "Quantidade", "Filial"};
		String[][] listaProdutos = {
				{"Melancia", "10", "Taguatinga"}, {"Blusa", "15", "Gama"}, {"Colher", "100", "Riacho Fundo"},
		};
		JTable tabelaProdutos = new JTable(listaProdutos, cabecalho);
		JScrollPane painelProdutos = new JScrollPane(tabelaProdutos);
		
		label.setBounds(260,100,200,80);
		label.setFont(new Font("Arial", Font.BOLD, 20));
		painelProdutos.setBounds(200, 200, 400, 300);
		botaoCadastrar.setBounds(200,550,200,80);
		botaoCadastrar.setFont(new Font("Arial", Font.BOLD, 15));
		telaInterfaceProduto.setBounds(0, 0,  800, 700); // (0, 0,  1920, 1080) pra ficar quase em tela cheia em um monitor full hd
		telaInterfaceProduto.setLayout(null);
		telaInterfaceProduto.setVisible(true);
		
		telaInterfaceProduto.add(botaoCadastrar);
		telaInterfaceProduto.add(label);
		//telaInterfaceProduto.add(tabelaProdutos);
		telaInterfaceProduto.add(painelProdutos);
		
		

		}//Fim do método main (Não esquecer de apagar o método)
}//Fim da classe InterfaceProdut