package view;

import controle.*;
import javax.swing.event.*;
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
	private JButton botaoEditar = new JButton("Editar Produto");
	private JButton botaoCadastrar = new JButton("Cadastrar Produto");	
	private JButton botaoAtualizar = new JButton("Listar Produtos/Atualizar Lista");
	private ControleEmpresa ce1 = new ControleEmpresa();
	
		public InterfaceProduto(ControleEmpresa ce) {
		
		label.setBounds(250, 10, 200, 80);
		label.setFont(new Font("Arial", Font.BOLD, 20));
		
		entradaPesquisa.setBounds(100, 70, 300, 20);
		
		botaoPesquisar.setBounds(400, 70, 100, 20);
		botaoPesquisar.addActionListener(this);
		
		botaoCadastrar.setBounds(305,410,194,50);
		botaoCadastrar.setFont(new Font("Arial", Font.BOLD, 15));
		botaoCadastrar.addActionListener(this);
		botaoEditar.setBounds(100,410,195,50);
		botaoEditar.setFont(new Font("Arial", Font.BOLD, 15));
		botaoEditar.addActionListener(this);
		
		botaoAtualizar.setBounds(100,470,398,50);
		botaoAtualizar.setFont(new Font("Arial", Font.BOLD, 15));
		botaoAtualizar.addActionListener(this);

		listaProdutos = ce1.getCaracteristicasPrincipais();
		
		tabelaProdutos = new JTable(listaProdutos, cabecalho);
		tabelaProdutos.setDefaultEditor(Object.class, null);
		tabelaProdutos.getTableHeader().setReorderingAllowed(false);
		//tabelaProdutos.addMouseListener(this);
		
		painelProdutos = new JScrollPane(tabelaProdutos);
		painelProdutos.setBounds(100, 100, 400, 300);
		
		frameInterfaceProduto.setBounds(30, 30,  600, 600); 
		frameInterfaceProduto.setLayout(null);
		frameInterfaceProduto.setVisible(true);
		frameInterfaceProduto.add(botaoPesquisar);
		frameInterfaceProduto.add(botaoCadastrar);
		frameInterfaceProduto.add(botaoEditar);
		frameInterfaceProduto.add(botaoAtualizar);
		frameInterfaceProduto.add(entradaPesquisa);
		frameInterfaceProduto.add(label);
		frameInterfaceProduto.add(painelProdutos);
		}
		
		public void actionPerformed(ActionEvent evento) {
			Object elemento = evento.getSource();
			
			if (elemento == botaoCadastrar) {
				new InterfaceCadastroProduto(2, ce1, null);
			
			} else if(elemento == botaoEditar) {
				if(tabelaProdutos.getSelectionModel().isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null, "Você não selecionou o produto que quer editar/excluir!", "Erro: selecione algum produto", 0);
				}else {
				String[] x = {(String)tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 0),
						(String)tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 3) };
				new InterfaceCadastroProduto(1,ce1, x);
				}
			} else if(elemento == botaoPesquisar) {
				if(entradaPesquisa.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Digite algum nome!");
					//tabelaProdutos.setModel(new JTable(listaProdutos, cabecalho).getModel());
				} else {
					tabelaProdutos.setModel(new JTable(ce1.buscaItemGeral(entradaPesquisa.getText()), cabecalho).getModel());
				}
			} else if(elemento == botaoAtualizar) {
				listaProdutos = ce1.getCaracteristicasPrincipais();
				tabelaProdutos.setModel(new JTable(listaProdutos, cabecalho).getModel());
			}
		}

}//Fim da classe InterfaceProduto