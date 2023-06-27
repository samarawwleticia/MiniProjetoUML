package view;

import java.awt.*;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import controle.*;
import sistema.Empresa.*;

public class InterfaceCadastroProduto implements ActionListener {

	JFrame frameCadastroProduto = new JFrame("Cadastro de Produto");
	JLabel titulo = new JLabel("Cadastro de Produto");
	JLabel labelCategoria = new JLabel("Categoria:");
	JLabel labelNome = new JLabel("Nome:");
	JLabel labelPreco = new JLabel("Preço");
	JLabel labelQuantidade = new JLabel("Quantidade:");
	JLabel labelFilial = new JLabel("Filial:");
	JLabel labelDescricao = new JLabel("Descrição:");
	JLabel labelPeso = new JLabel("Peso:");
	JLabel labelVegetariano = new JLabel("Vegetariano:");
	JLabel labelTamanho = new JLabel("Tamanho:");
	JLabel labelGenero = new JLabel("Genero:");
	JLabel labelMaterial = new JLabel("Material:");
	JLabel labelMarca = new JLabel("Marca:");
	JLabel labelCaracteristica = new JLabel("Detalhes:");
	
	JButton botaoSalvar = new JButton("Salvar");
	JButton botaoExcluir = new JButton("Excluir");
	
	String[] listaOpcoesCategoria = { "Escolha uma opção", "Alimentação", "Vestuário", "Utilidades Domésticas" };
	String[] listaValoresBinarios = {"Não", "Sim"};
	JComboBox<String> dropdownCategoria = new JComboBox<>(listaOpcoesCategoria);
	JComboBox<String> vegetariano = new JComboBox<>(listaValoresBinarios);
	
	JTextField nome = new JTextField();
	JTextField preco = new JTextField();
	JTextField quantidade = new JTextField();
	JTextField filial = new JTextField();
	JTextField peso = new JTextField();
	JTextField tamanho = new JTextField();
	JTextField genero = new JTextField();
	JTextField material = new JTextField();
	JTextField marca = new JTextField();
	
	JTextArea descricao = new JTextArea();
	JTextArea caracteristica = new JTextArea();
	
	//JScrollPane areaDescricao = new JScrollPane(descricao);
	//JScrollPane areaCaracteristica = new JScrollPane(caracteristica);
	
	ControleEmpresa ce;

	/*
	 * Construtor da interface para cadastrar/editar um produto. Recebe uma "opção"
	 * para decidir se edita um produto (1) ou cadastra um produto (2); Recebe um
	 * ControleEmpresa para editar ou recebe null para cadastrar um novo produto;
	 * Recebe um vetor de Strings que é o nome do produto e o nome da cidade da sua
	 * filial para editar um produto ou recebe null para cadastrar um novo produto.
	 */
	InterfaceCadastroProduto(int op, ControleEmpresa ce, String[] x) {
		
		frameCadastroProduto.setBounds(60, 60, 600, 600);
		
		titulo.setBounds(190, 10, 200, 80);
		
		labelCategoria.setBounds(150, 100, 70, 20);
		labelNome.setBounds(150, 130, 70, 20);
		labelPreco.setBounds(150, 160, 70, 20);
		labelQuantidade.setBounds(150, 190, 70, 20);
		labelFilial.setBounds(150, 220, 70, 20);
		labelPeso.setBounds(150, 250, 220, 20);
		labelVegetariano.setBounds(150, 280, 220, 20);
		labelMarca.setBounds(150, 250, 220, 20);
		labelMaterial.setBounds(150, 280, 220, 20);
		labelCaracteristica.setBounds(150, 310, 220, 20);
		labelGenero.setBounds(150, 250, 220, 20);
		labelTamanho.setBounds(150, 280, 220, 20);
		
		dropdownCategoria.setBounds(230, 100, 220, 20);
		nome.setBounds(230, 130, 220, 20);
		preco.setBounds(230, 160, 220, 20);
		quantidade.setBounds(230, 190, 220, 20);
		filial.setBounds(230, 220, 220, 20);
		peso.setBounds(230, 250, 220, 20);
		vegetariano.setBounds(230, 280, 220, 20);
		marca.setBounds(230, 250, 220, 20);
		material.setBounds(230, 280, 220, 20);
		caracteristica.setBounds(230, 310, 220, 20);
		genero.setBounds(230, 250, 220, 20);
		tamanho.setBounds(230, 280, 220, 20);
		
		botaoSalvar.setBounds(170, 425, 120, 80);
		botaoExcluir.setBounds(310, 425, 120, 80);
		
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		
		frameCadastroProduto.setLayout(null);
		frameCadastroProduto.setVisible(true);
		descricao.setLineWrap(true);
		botaoSalvar.addActionListener(this);
		botaoExcluir.addActionListener(this);
		
		
		if (op == 1) {
			
			this.ce = ce;
			
			String[] produto = ce.buscarItem(x[0], x[1]);
			
			nome.setText(produto[0]);
			preco.setText(produto[1]);
			quantidade.setText(produto[2]);
			filial.setText(produto[3]);
			descricao.setText(produto[4]);
			
			switch (produto[5]) {
			
				case "class sistema.Alimentacao":
					dropdownCategoria.setSelectedIndex(1);
					labelDescricao.setBounds(150, 310, 70, 20);
					descricao.setBounds(230, 310, 220, 35);
					frameCadastroProduto.add(labelVegetariano);
					frameCadastroProduto.add(labelPeso);
					frameCadastroProduto.add(vegetariano);
					frameCadastroProduto.add(peso);
					break;
					
				case "class sistema.Vestuario":
					dropdownCategoria.setSelectedIndex(2);
					labelDescricao.setBounds(150, 310, 70, 20);
					descricao.setBounds(230, 310, 220, 35);
					frameCadastroProduto.add(labelTamanho);
					frameCadastroProduto.add(labelGenero);
					frameCadastroProduto.add(tamanho);
					frameCadastroProduto.add(genero);
					break;
					
				case "class sistema.UtilidadesDomesticas":
					dropdownCategoria.setSelectedIndex(3);
					labelDescricao.setBounds(150, 340, 70, 20);
					descricao.setBounds(230, 340, 220, 35);
					frameCadastroProduto.add(labelMaterial);
					frameCadastroProduto.add(labelMarca);
					frameCadastroProduto.add(labelCaracteristica);
					frameCadastroProduto.add(material);
					frameCadastroProduto.add(marca);
					frameCadastroProduto.add(caracteristica);
					break;
					
				default:
					JOptionPane.showMessageDialog(null, "Não existe a opção: " + produto[5]);
			}

			filial.setEditable(false);
			dropdownCategoria.setEnabled(false);
			frameCadastroProduto.add(descricao);
			
		} else {
			
			labelDescricao.setBounds(150, 250, 70, 20);
			descricao.setBounds(230, 250, 220, 35);
			
			botaoExcluir.setEnabled(false);
			
			dropdownCategoria.addActionListener(this);
			
		}
		
		frameCadastroProduto.add(labelCategoria);
		frameCadastroProduto.add(labelNome);
		frameCadastroProduto.add(labelPreco);
		frameCadastroProduto.add(labelQuantidade);
		frameCadastroProduto.add(labelFilial);
		frameCadastroProduto.add(labelDescricao);
		
		frameCadastroProduto.add(titulo);
		frameCadastroProduto.add(dropdownCategoria);
		frameCadastroProduto.add(nome);
		frameCadastroProduto.add(preco);
		frameCadastroProduto.add(quantidade);
		frameCadastroProduto.add(filial);
		frameCadastroProduto.add(descricao);
		
		frameCadastroProduto.add(botaoSalvar);
		frameCadastroProduto.add(botaoExcluir);
	}

	public void actionPerformed(ActionEvent e) {

		Object elemento = e.getSource();

		if (elemento == dropdownCategoria) {

			switch (dropdownCategoria.getSelectedItem().toString()) {

			case ("Alimentação"):
				labelDescricao.setBounds(150, 310, 70, 20);
				descricao.setBounds(230, 310, 220, 35);
				peso.setBounds(230, 250, 70, 20);
				vegetariano.setBounds(230, 280, 70, 20);
				frameCadastroProduto.remove(labelTamanho);
				frameCadastroProduto.remove(labelGenero);
				frameCadastroProduto.remove(labelMaterial);
				frameCadastroProduto.remove(labelMarca);
				frameCadastroProduto.remove(labelCaracteristica);
				frameCadastroProduto.add(labelVegetariano);
				frameCadastroProduto.add(labelPeso);
				frameCadastroProduto.add(vegetariano);
				frameCadastroProduto.add(peso);
				frameCadastroProduto.remove(tamanho);
				frameCadastroProduto.remove(genero);
				frameCadastroProduto.remove(material);
				frameCadastroProduto.remove(marca);
				frameCadastroProduto.remove(caracteristica);
				break;

			case ("Utilidades Domésticas"):
				labelDescricao.setBounds(150, 340, 70, 20);
				descricao.setBounds(230, 340, 220, 35);
				frameCadastroProduto.remove(labelTamanho);
				frameCadastroProduto.remove(labelGenero);
				frameCadastroProduto.add(labelMaterial);
				frameCadastroProduto.add(labelMarca);
				frameCadastroProduto.add(labelCaracteristica);
				frameCadastroProduto.remove(labelVegetariano);
				frameCadastroProduto.remove(labelPeso);
				frameCadastroProduto.add(material);
				frameCadastroProduto.add(marca);
				frameCadastroProduto.add(caracteristica);
				frameCadastroProduto.remove(tamanho);
				frameCadastroProduto.remove(genero);
				frameCadastroProduto.remove(vegetariano);
				frameCadastroProduto.remove(peso);
				break;

			case ("Vestuário"):
				labelDescricao.setBounds(150, 310, 70, 20);
				descricao.setBounds(230, 310, 220, 35);
				frameCadastroProduto.add(labelTamanho);
				frameCadastroProduto.add(labelGenero);
				frameCadastroProduto.remove(labelMaterial);
				frameCadastroProduto.remove(labelMarca);
				frameCadastroProduto.remove(labelCaracteristica);
				frameCadastroProduto.remove(labelVegetariano);
				frameCadastroProduto.remove(labelPeso);
				frameCadastroProduto.add(tamanho);
				frameCadastroProduto.add(genero);
				frameCadastroProduto.remove(material);
				frameCadastroProduto.remove(marca);
				frameCadastroProduto.remove(caracteristica);
				frameCadastroProduto.remove(vegetariano);
				frameCadastroProduto.remove(peso);
				break;
			default:
				labelDescricao.setBounds(150, 250, 70, 20);
				descricao.setBounds(230, 250, 220, 35);
				frameCadastroProduto.remove(labelTamanho);
				frameCadastroProduto.remove(labelGenero);
				frameCadastroProduto.remove(labelMaterial);
				frameCadastroProduto.remove(labelMarca);
				frameCadastroProduto.remove(labelCaracteristica);
				frameCadastroProduto.remove(labelVegetariano);
				frameCadastroProduto.remove(labelPeso);
				frameCadastroProduto.remove(tamanho);
				frameCadastroProduto.remove(genero);
				frameCadastroProduto.remove(material);
				frameCadastroProduto.remove(marca);
				frameCadastroProduto.remove(caracteristica);
				frameCadastroProduto.remove(vegetariano);
				frameCadastroProduto.remove(peso);
			}

			frameCadastroProduto.repaint();

		} else if (elemento == botaoExcluir) {

		}

	}
}// Fim da classe InterfaceCadastroProduto
