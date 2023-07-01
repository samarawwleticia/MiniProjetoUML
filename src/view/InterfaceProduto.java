package view;

import controle.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Essa classe gera uma interface grafica para apresentar todos os produtos cadastrados, 
 * bem como as opções para cadastrar e editar produtos, pesquisar um produto e atualizar 
 * a lista de produtos.
 *  
 * @author João Pedro e Samara. 
 * @since 2023
 * @version 1.1
 */
public class InterfaceProduto implements ActionListener{
	
	private JFrame frameInterfaceProduto = new JFrame("Produtos");
	private JLabel label = new JLabel("Produtos");
	private JButton botaoEditar = new JButton("Editar Produto");
	private JButton botaoCadastrar = new JButton("Cadastrar Produto");	
	private JButton botaoAtualizar = new JButton("Listar Produtos/Atualizar Lista");
	private JButton botaoPesquisar = new JButton("Pesquisar");
	private JTextField entradaPesquisa = new JTextField();
	private JTable tabelaProdutos;
	private JScrollPane painelProdutos;
	private String[] cabecalho = {"Produto", "Preço", "Quantidade", "Filial"};
	private String[][] listaProdutos;
	private ControleEmpresa ce;
	
		public InterfaceProduto(ControleEmpresa ce) {
		
		this.ce = ce;
			
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

		listaProdutos = ce.getCaracteristicasPrincipais();
		
		tabelaProdutos = new JTable(listaProdutos, cabecalho);
		tabelaProdutos.setDefaultEditor(Object.class, null);
		tabelaProdutos.getTableHeader().setReorderingAllowed(false);
		
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
		
		/**
		 * Método para detectar interações nos componentes do JFrame.
		 */
		public void actionPerformed(ActionEvent evento) {
			Object elemento = evento.getSource();
			
			if(elemento == botaoPesquisar) {
				
				if(entradaPesquisa.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Digite algum nome!");
				} else {
					tabelaProdutos.setModel(new JTable(ce.pesquisaItens(entradaPesquisa.getText()), 
							cabecalho).getModel());
				}
				
			} else if (elemento == botaoCadastrar) {
				new InterfaceCadastroProduto(2, ce, null);
			
			} else if(elemento == botaoEditar) {
				
				if(tabelaProdutos.getSelectionModel().isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null, "Você não selecionou o produto que quer editar/excluir!", "Erro: selecione algum produto", 0);
				}else {					
				String[] x = {(String)tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 0),
						(String)tabelaProdutos.getValueAt(tabelaProdutos.getSelectedRow(), 3) };
				new InterfaceCadastroProduto(1,ce, x);
				}
				
			} else if(elemento == botaoAtualizar) {
				
				listaProdutos = ce.getCaracteristicasPrincipais();
				tabelaProdutos.setModel(new JTable(listaProdutos, cabecalho).getModel());
			}
		}

}//Fim da classe InterfaceProduto