package view;

import controle.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

public class InterfaceProduto implements ActionListener{
	
	private JFrame frameInterfaceProduto = new JFrame("Produtos");
	private JLabel label = new JLabel("Produtos");
	private JTextField entradaPesquisa = new JTextField();
	private JButton botaoPesquisar = new JButton("Pesquisar");
	private String[] cabecalho = {"Produto", "Preço", "Quantidade", "Filial"};
	private String[][] listaProdutos;
	private JTable tabelaProdutos;
	private JScrollPane painelProdutos;
	private JButton botaoCadastrar = new JButton("Cadastrar Produto");	
	String[][] lista = {{"ffefede", "fefefefef", "wdwdwdwdw", "qwqwqwqwq"},{"ffefede", "fefefefef", "wdwdwdwdw", "qwqwqwqwq"}};
		
		public InterfaceProduto(ControleEmpresa ce) {
		listaProdutos = ce.getCaracteristicasPrincipais();
		tabelaProdutos = new JTable(listaProdutos, cabecalho);
		painelProdutos = new JScrollPane(tabelaProdutos);
		frameInterfaceProduto.setBounds(30, 30,  600, 600); 
		frameInterfaceProduto.setLayout(null);
		frameInterfaceProduto.setVisible(true);
		
		label.setBounds(250, 10, 200, 80);
		label.setFont(new Font("Arial", Font.BOLD, 20));
		entradaPesquisa.setBounds(100, 70, 300, 20);
		botaoPesquisar.setBounds(400, 70, 100, 20);
		botaoPesquisar.addActionListener(this);
		tabelaProdutos.setDefaultEditor(Object.class, null);
		tabelaProdutos.getTableHeader().setReorderingAllowed(false);
		painelProdutos.setBounds(100, 100, 400, 300);
		botaoCadastrar.setBounds(200,425,200,80);
		botaoCadastrar.setFont(new Font("Arial", Font.BOLD, 15));
		botaoCadastrar.addActionListener(this);
		
		frameInterfaceProduto.add(botaoPesquisar);
		frameInterfaceProduto.add(botaoCadastrar);
		frameInterfaceProduto.add(entradaPesquisa);
		frameInterfaceProduto.add(label);
		frameInterfaceProduto.add(painelProdutos);
		
		}
		
		public void actionPerformed(ActionEvent evento) {
			Object elemento = evento.getSource();
			
			if (elemento == botaoCadastrar) {
				new InterfaceCadastroProduto();
			} else if (elemento == botaoPesquisar) {
				TableModel tabelaNova = new DefaultTableModel();
				tabelaProdutos.setModel(tabelaNova);
			}
			
		}
		
}//Fim da classe InterfaceProdut