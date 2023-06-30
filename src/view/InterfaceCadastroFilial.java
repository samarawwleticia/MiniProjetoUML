package view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controle.*;

/**
 * Essa classe é uma Interface Gráfica que permite o cadastro de uma nova filial
 * assim como  editar ou deletar uma filial existente.
 * @author Samara Leticia
 *
 */

public class InterfaceCadastroFilial implements ActionListener {
	
	private JFrame telaCadastroFilial;
	private JLabel cidade = new JLabel("Filial:");
	private JLabel titulo = new JLabel("Filial");
	private JLabel produtosCadastradosFilial = new JLabel("Produtos Disponiveis:");
	private JButton salvar = new JButton("Salvar");
	private JButton deletar = new JButton("Deletar");
	private JTextField textoCidade = new JTextField(200);
	private JTable tabelaProdutos = new JTable();
	private JScrollPane painelProdutos = new JScrollPane(tabelaProdutos);
	private static ControleEmpresa empresa;
	private static ControleFilial fili;
	private int posicao;
	private int opcao;
	private String s;
	
	/**
	 * Esse método funciona para a criação da JFrame, caso op seja = 1, será criada uma Interface
	 * com o objetivo de Cadastrar uma nova Filial. Caso op seja = 2, será criada uma Interface
	 * com o objetivo de Editar ou Excluir uma filial existente. Além disso, o parametro posicao irá indicar
	 * qual filial foi selecionada na InterfaceFilial.
	 * 
	 * @param op
	 * @param ce
	 * @param pos
	 */
	public void inserirEditar(int op, ControleEmpresa ce,  
			 int pos) {
		
		opcao = op;
		posicao = pos;
		empresa = ce;
		fili = new ControleFilial(ce);
		
		if (op == 1) s = "Cadastro de Filial";
		if (op == 2) s = "Detalhes da Filial";
		
		
		telaCadastroFilial = new JFrame(s);
		
		if (op == 2) {
			
			textoCidade    = new JTextField(String.valueOf(empresa.getNomesFiliais()[pos].toString()));
			
			String[] cabecalho = {
					"Nome", "Preço", "Quantidade", "Filial"
			};
								
			tabelaProdutos = new JTable(ce.getEmpresa().getFilial()[pos].obterCaracteristicasPrincipais(), cabecalho);
			
			painelProdutos = new JScrollPane(tabelaProdutos);
			
			
						
		
		
		} else { //Não preenche com dados
			
			String[] cabecalho = {
					"Nome", "Quantidade", "Tipo", "Preço"
			};
			String[][] coisas = {
					{"", "", "", ""}
			};
			tabelaProdutos = new JTable(coisas, cabecalho);
			painelProdutos = new JScrollPane(tabelaProdutos);
			textoCidade = new JTextField(200);
			salvar.setBounds(100, 480, 180, 40);
			
		}
		
		if (op == 2) {
			
			salvar.setBounds(100, 480, 180, 40);
			deletar.setBounds(245, 480, 180, 40);
			this.telaCadastroFilial.add(deletar);

			
		} else {
			
			salvar.setBounds(100, 480, 180, 40);
			this.telaCadastroFilial.add(salvar);
		}
		
		
		this.telaCadastroFilial.setLayout(null);
		this.telaCadastroFilial.setVisible(true);
		
		this.telaCadastroFilial.setBounds(0, 0, 600, 600);
		
		titulo.setBounds(250,10, 200, 80);
		cidade.setBounds(150, 130, 100, 20);
		textoCidade.setBounds(250, 130, 120, 20);
		produtosCadastradosFilial.setBounds(150, 190, 150, 20);
		painelProdutos.setBounds(150, 210, 300, 200);
		salvar.setBounds(100, 480, 180, 40);
		deletar.setBounds(300, 480, 180, 40);

		
		this.telaCadastroFilial.add(titulo);
		this.telaCadastroFilial.add(cidade);
		this.telaCadastroFilial.add(textoCidade);
		this.telaCadastroFilial.add(produtosCadastradosFilial);
		this.telaCadastroFilial.add(painelProdutos);
		this.telaCadastroFilial.add(salvar);
		
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		
		salvar.addActionListener(this);
		deletar.addActionListener(this);
		
				
	}
	/**
	 * Nesse void há o sinal para excluir uma filial de acordo com sua posição através de um método
	 * localizado no pacote sistema na classe Empresa.
	 * Em seguida, há o sinal para cadastrar e editar respectivamente uma filial já existente, de acordo 
	 * com sua posição novamente.
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
			boolean res;
			Object src = e.getSource();
			if(src == deletar) {
				res = false;
			 if (opcao == 2) {
	
				res = fili.excluirFilial(posicao);
				if(res) mensagemSucessoExclusao();
				else mensagemErroExclusao();
			} 
			 
		}	if(src == salvar) {
			
			if(textoCidade.getText().equals("")) {
				mensagemErroCadastro();
			}
			
			try {
				
				if(opcao == 2) {
				empresa.getEmpresa().getFilial()[posicao].setNomeCidade(textoCidade.getText());//CADASTRAR
				mensagemSucessoCadastro();
				
				} else {
					
					fili.cadastrarFilial(textoCidade.getText()); //EDITAR
					mensagemSucessoCadastro();
				}
				
			} catch (NullPointerException exc1) {
				mensagemErro1();
			} catch (NumberFormatException exc2) {
				mensagemErro2();
			}
			
		}		
			
	}
	
	/*
	 * Mensagens que indicam o resultado da operação realizada no action event.
	 */
		
	public void mensagemSucessoExclusao() {
		JOptionPane.showMessageDialog(null, "Filial excluída com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		telaCadastroFilial.dispose();
	}
	
	public void mensagemErroExclusao() {
		JOptionPane.showMessageDialog(null, "Os dados não puderam ser excluídos!", null,
				JOptionPane.ERROR_MESSAGE);
	}
	
	public void mensagemSucessoCadastro() {
		JOptionPane.showMessageDialog(null,"Os dados foram salvos com sucesso!",null,
				JOptionPane.INFORMATION_MESSAGE);
		telaCadastroFilial.dispose();
	}
	
	public void mensagemErroCadastro() {
		JOptionPane.showMessageDialog(null, "Os dados não puderam ser salvos!", null,
				JOptionPane.ERROR_MESSAGE);
	}
	
	public void mensagemErro1() {
		JOptionPane.showMessageDialog(null, "Erro Null Exception!", null,
				JOptionPane.ERROR_MESSAGE);
	}
	
	public void mensagemErro2() {
		JOptionPane.showMessageDialog(null, "Erro Number Format!", null,
				JOptionPane.ERROR_MESSAGE);
	}

}

