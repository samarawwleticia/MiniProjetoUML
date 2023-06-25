package view;

import java.awt.Font;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import controle.*;

public class InterfaceCadastroProduto {
	
	//--------------------------------------------------------------------
	String[] listaTeste = {"Escolha uma opção", "Alimentação", "Vestuario", "Utilidades Domésticas"};
		
	//--------------------------------------------------------------------
	JFrame frameCadastroProduto = new JFrame("Cadastro de Produto");
	JLabel titulo = new JLabel("Cadastro de Produto");
	JLabel labelCategoria = new JLabel("Categoria:");
	JLabel labelNome = new JLabel("Nome:");
	JLabel labelPreco = new JLabel("Preço");
	JLabel labelQuantidade = new JLabel("Quantidade:");
	JLabel labelFilial = new JLabel("Filial:");
	JLabel labelDescricao = new JLabel("Descrição:");
	
	JComboBox<String> dropdownCategoria;// = new JComboBox<>(listaTeste); 
	JTextField nome;// = new JTextField();
	JTextField preco;// = new JTextField();
	JTextField quantidade;// = new JTextField();
	JTextField filial;// = new JTextField();
	JTextArea descricao;// = new JTextArea();
	JScrollPane areaTexto;// = new JScrollPane(descricao);
	JButton salvarProduto = new JButton("Salvar");
	JButton excluirProduto = new JButton("Excluir");
	ControleEmpresa ce;
	
	/* Construtor da interface para cadastrar/editar um produto.
	 * Recebe uma "opção" para decidir se edita um produto (1) ou cadastra um produto (2);
	 * Recebe um ControleEmpresa para editar ou recebe null para cadastrar um novo produto;
	 * Recebe um vetor de Strings que é o nome do produto e o nome da cidade da sua filial 
	 * para editar um produto ou recebe null para cadastrar um novo produto.
	 */
	InterfaceCadastroProduto(int op, ControleEmpresa ce, String[] x) {
		this.ce = ce;
		dropdownCategoria = new JComboBox<>(listaTeste);
		if(op == 1) {
			
			String[] produto = ce.buscarItem(x[0], x[1]);
			
			switch(produto[5]) {
			case "class sistema.Alimentacao":dropdownCategoria.setSelectedIndex(1); break;
			case "class sistema.Vestuario": dropdownCategoria.setSelectedIndex(2); break;
			case "class sistema.UtilidadesDomesticas": dropdownCategoria.setSelectedIndex(3); break;
			default: JOptionPane.showMessageDialog(null, "Não existe a opção: " + produto[5]);
			}
			dropdownCategoria.setEnabled(false);
			nome = new JTextField(produto[0]);
			preco = new JTextField(produto[1]);
			quantidade = new JTextField(produto[2]);
			filial = new JTextField(produto[3]);
			filial.setEditable(false);
			//filial.setEnabled(false);
			descricao = new JTextArea(produto[4]);
			areaTexto = new JScrollPane(descricao);
			}
			
			if(op == 2) {
				dropdownCategoria = new JComboBox<>(listaTeste);
				nome = new JTextField();
				preco = new JTextField();
				quantidade = new JTextField();
				filial = new JTextField();
				descricao = new JTextArea();
				areaTexto = new JScrollPane();
			}
		
		frameCadastroProduto.setBounds(60, 60,  600, 600); 
		frameCadastroProduto.setLayout(null);
		frameCadastroProduto.setVisible(true);
		titulo.setBounds(190, 10, 200, 80);
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		labelCategoria.setBounds(150, 100, 70, 20);
		dropdownCategoria.setBounds(230, 100, 220, 20);
		labelNome.setBounds(150, 130, 70, 20);
		nome.setBounds(230, 130, 220, 20);
		labelPreco.setBounds(150, 160, 70, 20);
		preco.setBounds(230, 160, 220, 20);
		labelQuantidade.setBounds(150, 190, 70, 20);
		quantidade.setBounds(230, 190, 220, 20);
		labelFilial.setBounds(150, 220, 70, 20);
		filial.setBounds(230, 220, 220, 20);
		labelDescricao.setBounds(150, 250, 70, 20);
		areaTexto.setBounds(230, 250, 220, 80);
		descricao.setLineWrap(true);
		salvarProduto.setBounds(170,425,120,80);
		excluirProduto.setBounds(310,425,120,80);
		
		
		frameCadastroProduto.add(labelCategoria);
		frameCadastroProduto.add(dropdownCategoria);
		frameCadastroProduto.add(labelNome);
		frameCadastroProduto.add(labelPreco);
		frameCadastroProduto.add(labelQuantidade);
		frameCadastroProduto.add(labelFilial);
		frameCadastroProduto.add(labelDescricao);
		frameCadastroProduto.add(nome);
		frameCadastroProduto.add(preco);
		frameCadastroProduto.add(quantidade);
		frameCadastroProduto.add(filial);
		frameCadastroProduto.add(areaTexto);
		frameCadastroProduto.add(titulo);
		frameCadastroProduto.add(excluirProduto);
		frameCadastroProduto.add(salvarProduto);
		
	}
	
	public void preencherDados(String[] x, int op) {
		
		
		
	}
}//Fim da classe InterfaceCadastroProduto
