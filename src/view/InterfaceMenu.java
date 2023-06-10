package view;

import sistema.*; // importar as classes e os métodos de sistema pra usar aqui

import javax.swing.*;
//import java.awt.*;

public class InterfaceMenu {
	
	public static void main(String[] args) {
		
		//Vou agrupar os elementos parecidos 
		//N sei pq mas estou começando a ficar com medo desse código, tenho a impressão de que ele ainda vai me apunhalar pelas costas
		
		Empresa e1 = new Empresa("hdbvhdfbvhdfb", "1234567890");
		e1.adcFilial(new Filial("Gama", e1));
		e1.adcFilial(new Filial("Riacho Fundo", e1));
		e1.buscarFilial("Gama").adcItem(new Alimentacao("melancia", 20.5, 10,  "blablabla", 7, true ));
		e1.buscarFilial("Gama").adcItem(new UtilidadesDomesticas("colher", 2.45, 100, "blablabla", "madeira","7", "true" ));
		e1.buscarFilial("Gama").adcItem(new UtilidadesDomesticas("Vassoura", 15, 3, "blablabla", "aço","7", "true" ));
		 
		
		JFrame f = new JFrame();
		JButton b = new JButton("Cadastrar nova Filial");
		JButton b2 = new JButton("Cadastrar novo Produto"); 
		
		JList<String> listaNomesProdutos = new JList<String>(e1.buscarFilial("Gama").obterNomes()); // Cria um objeto que é uma lista e recebe o vetor anterior, infelizmente é obrigatório
		JList<String> listaNomesFiliais = new JList<String>(e1.obterNomes());
		JScrollPane painelProdutos = new JScrollPane(listaNomesProdutos);       // Cria o container "rolável" com a lista anterior dentro
		JScrollPane painelFiliais = new JScrollPane(listaNomesFiliais);       
		
		b.setBounds(500,100,200, 80);
		b2.setBounds(500,200,200,80);
		painelProdutos.setBounds(10, 100, 200, 200);
		painelFiliais.setBounds(250, 100, 200, 200);
		
		//f.setSize(500,400);
		f.setBounds(0, 0,  730, 500); // (0, 0,  1920, 1080) pra ficar quase em tela cheia em um monitor full hd
		f.setLayout(null);
		f.setVisible(true);
		f.add(b);
		f.add(b2);
		f.add(painelProdutos);
		f.add(painelFiliais);
		
		
		
		
		
	}

	
}
