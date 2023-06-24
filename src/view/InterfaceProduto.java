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
	private ControleEmpresa ce = new ControleEmpresa();
	
		public InterfaceProduto(ControleEmpresa ce) {
		
		label.setBounds(250, 10, 200, 80);
		label.setFont(new Font("Arial", Font.BOLD, 20));
		
		entradaPesquisa.setBounds(100, 70, 300, 20);
		
		botaoPesquisar.setBounds(400, 70, 100, 20);
		botaoPesquisar.addActionListener(this);
		
		botaoCadastrar.setBounds(305,425,194,80);
		botaoCadastrar.setFont(new Font("Arial", Font.BOLD, 15));
		botaoCadastrar.addActionListener(this);
		botaoEditar.setBounds(100,425,195,80);
		botaoEditar.setFont(new Font("Arial", Font.BOLD, 15));
		botaoEditar.addActionListener(this);
		
		listaProdutos = ce.getCaracteristicasPrincipais();
		
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
		frameInterfaceProduto.add(entradaPesquisa);
		frameInterfaceProduto.add(label);
		frameInterfaceProduto.add(painelProdutos);
		}
		
		public void actionPerformed(ActionEvent evento) {
			Object elemento = evento.getSource();
			
			if (elemento == botaoCadastrar) {
				new InterfaceCadastroProduto(ce, 2, new String[0]);
			
			} else if(elemento == botaoEditar) {
				//TODO: fazer algo para verificar se um elemento da lista foi verificado;
				String[] x = {(String)tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 0),
						(String)tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 3) };
				new InterfaceCadastroProduto(ce, 1, x);
			
			} else if(elemento == botaoPesquisar) {
				if(entradaPesquisa.getText().equals("")) {
					tabelaProdutos.setModel(new JTable(listaProdutos, cabecalho).getModel());
				} else {
					tabelaProdutos.setModel(new JTable(ce.buscaItemGeral(entradaPesquisa.getText()), cabecalho).getModel());
				}
			}
		}
		
		public void mouseClicked(MouseEvent e) {
			/*	
			String[] x = {(String)tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 0),
					(String)tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 3) };
			new InterfaceCadastroProduto(ce, 1, x);
			//System.out.print(tabelaProdutos.getSelectedRow()+ " " );
			//System.out.println(tabelaProdutos.getEditingColumn());
			 */
		}

}//Fim da classe InterfaceProduto