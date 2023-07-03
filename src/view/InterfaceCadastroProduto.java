package view;

import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import controle.*;
/**
 * Tela que permite o cadastro ou edição de um produto no sistema.
 * @author João Pedro e Samara
 * @since 2023
 * @version 1.1
 *
 */
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
	JComboBox<String> dropdownVegetariano = new JComboBox<>(listaValoresBinarios);
	
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
	
	int op;
	int indiceProduto;
	ControleEmpresa ce;
	ControleProdutos cp;

	/**
	 * Construtor da interface para cadastrar/editar um produto. Recebe uma "opção"
	 * para decidir se edita um produto (1) ou cadastra um produto (2); Recebe um
	 * ControleEmpresa para editar ou recebe null para cadastrar um novo produto;
	 * Recebe um vetor de Strings que é o nome do produto e o nome da cidade da sua
	 * filial para editar um produto ou recebe null para cadastrar um novo produto.
	 * As posições fixas e instâncias de cada componente na interface gráfica já ficam prontos e
	 * na hora de mudar o que há ou não na tela baseado no tipo de produto, basta colocar ou 
	 * remover esses compoonentes do JFrame.
	 */
	InterfaceCadastroProduto(int op, ControleEmpresa ce, String[] x) {
		
		this.ce = ce;
		this.op = op;
		cp = new ControleProdutos(this.ce);
		
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
		dropdownVegetariano.setBounds(230, 280, 220, 20);
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
		dropdownCategoria.addActionListener(this);
		botaoSalvar.addActionListener(this);
		botaoExcluir.addActionListener(this);
		
		
		if (op == 1) {
			
			String[] produto = ce.buscarItem(x[0], x[1]);
			
			nome.setText(produto[0]);
			preco.setText(produto[1]);
			quantidade.setText(produto[2]);
			filial.setText(produto[3]);
			descricao.setText(produto[4]);
			indiceProduto = Integer.parseInt(produto[9]);
			
			switch (produto[5]) {
			
				case "class sistema.Alimentacao":
					dropdownCategoria.setSelectedIndex(1);
					peso.setText(produto[6]);
					if(produto[7].equals("true")) {
						dropdownVegetariano.setSelectedIndex(1); }
					labelDescricao.setBounds(150, 310, 70, 20);
					descricao.setBounds(230, 310, 220, 60);
					frameCadastroProduto.add(labelVegetariano);
					frameCadastroProduto.add(labelPeso);
					frameCadastroProduto.add(dropdownVegetariano);
					frameCadastroProduto.add(peso);
					break;
					
				case "class sistema.Vestuario":
					dropdownCategoria.setSelectedIndex(2);
					tamanho.setText(produto[6]);
					genero.setText(produto[7]);
					labelDescricao.setBounds(150, 310, 70, 20);
					descricao.setBounds(230, 310, 220, 60);
					frameCadastroProduto.add(labelTamanho);
					frameCadastroProduto.add(labelGenero);
					frameCadastroProduto.add(tamanho);
					frameCadastroProduto.add(genero);
					break;
					
				case "class sistema.UtilidadesDomesticas":
					dropdownCategoria.setSelectedIndex(3);
					material.setText(produto[6]);
					marca.setText(produto[7]);
					caracteristica.setText(produto[8]);
					labelDescricao.setBounds(150, 340, 70, 20);
					descricao.setBounds(230, 340, 220, 60);
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
	
	/**
	 * Método para detectar interações nos componentes do JFrame.
	 * A cada alteração no JComboBox, a tela é modificada para se adequal a classe selecionada.
	 * Pressionar o botão de salvar detecta se o campo de nome do produto está vazio, se não,
	 * tenta fazer o cadastro transfornmando os Strings nos campos de texto em numeros. Caso o
	 * cadastro seja bem sucedido, aparecerá uma mensagem de sucesso, se não, aparece uma mensagem de eroo.
	 */
	
	public void actionPerformed(ActionEvent e) {

		Object elemento = e.getSource();

		if (elemento == dropdownCategoria) {

			switch (dropdownCategoria.getSelectedItem().toString()) {

			case ("Alimentação"):
				labelDescricao.setBounds(150, 310, 70, 20);
				descricao.setBounds(230, 310, 220, 60);
				frameCadastroProduto.remove(labelTamanho);
				frameCadastroProduto.remove(labelGenero);
				frameCadastroProduto.remove(labelMaterial);
				frameCadastroProduto.remove(labelMarca);
				frameCadastroProduto.remove(labelCaracteristica);
				frameCadastroProduto.add(labelVegetariano);
				frameCadastroProduto.add(labelPeso);
				frameCadastroProduto.add(dropdownVegetariano);
				frameCadastroProduto.add(peso);
				frameCadastroProduto.remove(tamanho);
				frameCadastroProduto.remove(genero);
				frameCadastroProduto.remove(material);
				frameCadastroProduto.remove(marca);
				frameCadastroProduto.remove(caracteristica);
				break;

			case ("Utilidades Domésticas"):
				labelDescricao.setBounds(150, 340, 70, 20);
				descricao.setBounds(230, 340, 220, 60);
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
				frameCadastroProduto.remove(dropdownVegetariano);
				frameCadastroProduto.remove(peso);
				break;

			case ("Vestuário"):
				labelDescricao.setBounds(150, 310, 70, 20);
				descricao.setBounds(230, 310, 220, 60);
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
				frameCadastroProduto.remove(dropdownVegetariano);
				frameCadastroProduto.remove(peso);
				break;
			default:
				labelDescricao.setBounds(150, 250, 70, 20);
				descricao.setBounds(230, 250, 220, 60);
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
				frameCadastroProduto.remove(dropdownVegetariano);
				frameCadastroProduto.remove(peso);
			}

			frameCadastroProduto.repaint();

		} else if (elemento == botaoSalvar) {
			
			if(nome.getText().isBlank()||filial.getText().isBlank()) {
				mensagemErroNome();
			} else {
			
				try {
					boolean b;
					
					if(dropdownVegetariano.getSelectedItem().equals("Sim")) {
						b = true;
					} else {
						b = false;
					}
			
					switch(dropdownCategoria.getSelectedItem().toString()) {
				
					case ("Alimentação"):
				
						cp.cadastrarEditarProduto(filial.getText(), nome.getText(), Double.parseDouble(preco.getText()), 
							Integer.parseInt(quantidade.getText()), descricao.getText(), 
							Double.parseDouble(peso.getText()), b, 0, null, null, null, null, op, indiceProduto);
						
						if(op == 1) {
							mensagemEdicaoSucesso();
						}else {
							mensagemCadastroSucesso();
						}

							break;
						
					case ("Utilidades Domésticas"):
					
						cp.cadastrarEditarProduto(filial.getText(), nome.getText(), Double.parseDouble(preco.getText()), 
							Integer.parseInt(quantidade.getText()), descricao.getText(), 0, false, 0, null, 
							material.getText(), marca.getText(), caracteristica.getText(), op, indiceProduto);
							
						if(op == 1) {
							mensagemEdicaoSucesso();
						}else {
							mensagemCadastroSucesso();
						}
							break;

					case ("Vestuário"):
					
						cp.cadastrarEditarProduto(filial.getText(), nome.getText(), Double.parseDouble(preco.getText()), 
							Integer.parseInt(quantidade.getText()), descricao.getText(), 
							0, false, Integer.parseInt(tamanho.getText()), genero.getText(), null, null, null, op, indiceProduto);
						if(op == 1) {
							mensagemEdicaoSucesso();
						}else {
							mensagemCadastroSucesso();
						}
							break;
			
					default:
						JOptionPane.showMessageDialog(null, "Selecione uma categoria para o produto.");
				
					}		
				} catch(NullPointerException npe) {
					
					if(op == 1) {
						mensagemEdicaoErro();
					}else {
						mensagemCadastroErro();
					}
					
				} catch(NumberFormatException nfe) {
					
					if(op == 1) {
						mensagemEdicaoErro();
					}else {
						mensagemCadastroErro();
					}
				}
			}

		}else if (elemento == botaoExcluir) {
			
			cp.excluirProduto(filial.getText(), indiceProduto);
			mensagemExclusaoSucesso();
		}

	}
	/**
	 * Métodos para enviar mensagens de erro e de sucesso a depender do que ocorrer ao tentar cadastrar um produto. 
	 */
	public void mensagemCadastroErro() {
		JOptionPane.showMessageDialog(null, "O cadastro do produto não foi concluído."
				+ "Verifique se o nome da filial está correto e se os campos numéricos "
				+ "como preço, quantidade, peso e/ou tamanho foram digitados corretamente.");
	}
	public void mensagemErroNome() {
		JOptionPane.showMessageDialog(null, "O nome do produto ou da filial não pode ser vazio.");
	}
	public void mensagemEdicaoErro() {
		JOptionPane.showMessageDialog(null, "A edição do produto não foi concluída."
				+ "Verifique se o nome da filial está correto e se os campos numéricos"
				+ "como preço, quantidade, peso e/ou tamanho foram digitados corretamente.");
	}
	public void mensagemCadastroSucesso() {
		JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso, "
				+ "atualize a lista para ver seu novo produto cadastrado.");
		frameCadastroProduto.dispose();
	}
	
	public void mensagemEdicaoSucesso() {
		JOptionPane.showMessageDialog(null, "Produto editado com sucesso, "
				+ "atualize a lista para ver a modificação.");
		frameCadastroProduto.dispose();
	}
	
	public void mensagemExclusaoSucesso() {
		JOptionPane.showMessageDialog(null, "Produto excluído com sucesso, "
				+ "atualize a lista.");
		frameCadastroProduto.dispose();
	}
	
}// Fim da classe InterfaceCadastroProduto
