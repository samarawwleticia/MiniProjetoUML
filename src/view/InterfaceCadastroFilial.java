package view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import controle.*;

public class InterfaceCadastroFilial {
	
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
	private int posicao;
	private int opcao;
	private String s;
	
	//private JButton addProduto = new JButton("Novo Produto");
	
	
	public void inserirEditar(int op, ControleEmpresa ce,
			InterfaceFilial f, int pos) {
		
		opcao = op;
		posicao = pos;
		empresa = ce;
			
		
		if (op == 1) s = "Cadastro de Filial";
		if (op == 2) s = "Detalhes da Filial";
		
		
		telaCadastroFilial = new JFrame(s);
		
		if (op == 2) {
			
			//colocar a posicao
			String[] cabecalho = {
					"Nome", "Quantidade", "Tipo", "Preço"
			};
			String[][] coisas = {
					{"vou", "mudas", "pros", "produtos"}
			};
			tabelaProdutos = new JTable(coisas, cabecalho);
			painelProdutos = new JScrollPane(tabelaProdutos);
			textoCidade    = new JTextField(String.valueOf(empresa.getNomesFiliais()[pos].toString()));
			

			
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
		//addProduto.setBounds(200, 430, 200, 40);

		
		this.telaCadastroFilial.add(titulo);
		this.telaCadastroFilial.add(cidade);
		this.telaCadastroFilial.add(textoCidade);
		this.telaCadastroFilial.add(produtosCadastradosFilial);
		this.telaCadastroFilial.add(painelProdutos);
		this.telaCadastroFilial.add(salvar);
		this.telaCadastroFilial.add(deletar);
		
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		
		
		// espaço para colocar o CNPJ da empresa - talvez eu tire
		//JLabel CNPJ = new JLabel("CNPJ");
		//telaCadastroFilial.add(CNPJ);
		//CNPJ.setBounds(150, 160, 100, 20);
		//JTextField textoCNPJ = new JTextField("");
		//telaCadastroFilial.add(textoCNPJ);
		//textoCNPJ.setBounds(250, 160, 120, 20);
	
		
		// botao para colocar mais um produto
		//telaCadastroFilial.add(addProduto);
		//addProduto.addActionListener(this);
				
	}
		
	
	

}
