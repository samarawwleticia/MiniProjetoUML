package view;
import java.awt.*;
import javax.swing.*;

public class InterfaceCadastroFilial {
	
	public static void main(String[] args) {
		
		// criando jframe --------------------------------------------------------
		JFrame telaCadastroFilial = new JFrame("Cadastro Filial");
		
		telaCadastroFilial.setBounds(0, 0, 600, 600);
		telaCadastroFilial.setLayout(null);
		telaCadastroFilial.setVisible(true);
		
		//titulo da pagina
		
		JLabel titulo = new JLabel("Filial");
		
		telaCadastroFilial.add(titulo);
		titulo.setBounds(250,10, 200, 80);
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		
		// espaço para colocar a cidade que a filial pertence
	
		JLabel cidade = new JLabel("Cidade");
		
		telaCadastroFilial.add(cidade);
		cidade.setBounds(150, 130, 100, 20);
		
		JTextField textoCidade = new JTextField("");
		
		telaCadastroFilial.add(textoCidade);
		textoCidade.setBounds(250, 130, 120, 20);
		
		// espaço para colocar o CNPJ da empresa
		
		JLabel CNPJ = new JLabel("CNPJ");
		
		telaCadastroFilial.add(CNPJ);
		CNPJ.setBounds(150, 160, 100, 20);
		
		JTextField textoCNPJ = new JTextField("");
		
		telaCadastroFilial.add(textoCNPJ);
		textoCNPJ.setBounds(250, 160, 120, 20);
		
		// tabela q mostra os produtos na filial
		
		JLabel produtosDisponiveis = new JLabel("Produtos Disponiveis:");
		
		telaCadastroFilial.add(produtosDisponiveis);
		produtosDisponiveis.setBounds(150, 190, 150, 20);
		
		String[] titulo2 = {"Nome", "Quantidade", "Tipo","Preço"};
		String[][] listaProdutos = {
				{"Blusa", "01", "Vestuario", "R$44,90"},{"Paçoquita", "300", "Alimentacao", "R$02,00"},{"Flanela", "03", "Utilidades", "R$15,00"}
		};
		JTable tabelaProdutos = new JTable(listaProdutos, titulo2);
		JScrollPane painelProdutos = new JScrollPane(tabelaProdutos);
		
		telaCadastroFilial.add(painelProdutos);
		painelProdutos.setBounds(150, 210, 300, 200);
		
		// botao para colocar mais um produto
		
		JButton addProduto = new JButton("Novo Produto");
		
		telaCadastroFilial.add(addProduto);
		addProduto.setBounds(200, 430, 200, 40);
		
		JButton salvar = new JButton("Salvar");
		
		telaCadastroFilial.add(salvar);
		salvar.setBounds(100, 480, 180, 40);
		
		JButton deletar = new JButton("Deletar");
		
		telaCadastroFilial.add(deletar);
		deletar.setBounds(300, 480, 180, 40);
		
	}

}
