package view;

import java.awt.Font;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class InterfaceCadastroProduto {
	
	public static void main(String[] args) {
		//--------------------------------------------------------------------
		String[] listaTeste = {"Escolha uma opção", "Alimentação", "Utilidades Domésticas", "Vestuário"};
		
		//--------------------------------------------------------------------
		JFrame telaCadastroProduto = new JFrame("Cadastro de Produto");
		JLabel titulo = new JLabel("Cadastro de Produto");
		JLabel labelCategoria = new JLabel("Categoria:");
		JLabel labelNome = new JLabel("Nome:");
		JLabel labelPreco = new JLabel("Preço");
		JLabel labelQuantidade = new JLabel("Quantidade:");
		JLabel labelFilial = new JLabel("Filial:");
		JLabel labelDescricao = new JLabel("Descrição:");
		
		JComboBox dropdownCategoria = new JComboBox(listaTeste); 
		JTextField nome = new JTextField();
		JTextField preco = new JTextField();
		JTextField quantidade = new JTextField();
		JTextField filial = new JTextField();
		JTextArea descricao = new JTextArea();
		JScrollPane areaTexto = new JScrollPane(descricao);
		JButton salvarProduto = new JButton("Salvar");
		JButton excluirProduto = new JButton("Excluir");
		
		telaCadastroProduto.setBounds(0, 0,  600, 600); 
		telaCadastroProduto.setLayout(null);
		telaCadastroProduto.setVisible(true);
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
		
		
		telaCadastroProduto.add(labelCategoria);
		telaCadastroProduto.add(dropdownCategoria);
		telaCadastroProduto.add(labelNome);
		telaCadastroProduto.add(labelPreco);
		telaCadastroProduto.add(labelQuantidade);
		telaCadastroProduto.add(labelFilial);
		telaCadastroProduto.add(labelDescricao);
		telaCadastroProduto.add(nome);
		telaCadastroProduto.add(preco);
		telaCadastroProduto.add(quantidade);
		telaCadastroProduto.add(filial);
		telaCadastroProduto.add(areaTexto);
		telaCadastroProduto.add(titulo);
		telaCadastroProduto.add(excluirProduto);
		telaCadastroProduto.add(salvarProduto);
		
	}//Fim do método main
}//Fim da classe InterfaceCadastroProduto
