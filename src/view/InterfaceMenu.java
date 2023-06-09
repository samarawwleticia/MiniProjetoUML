package view;

import javax.swing.*;
import java.awt.*;

public class InterfaceMenu {
	
	public static void main(String[] args) {
		
		//Vou agrupar os elementos parecidos 
		
		JFrame f = new JFrame();
		JButton b = new JButton("Cadastrar nova Filial");
		JButton b2 = new JButton("Cadastrar novo Produto");
		
		String[] nomes = { "Ana", "Beatriz", "Carlos", // Um vetor pra testar o container   
				"Daniel", "Elaine",  "Fernando", 
				"Gabriela", "Marcio", "Nair", 
				"Osvaldo", "Pedro", "Rita" }; 
		
		JList<String> jlst = new JList<String>(nomes); // Cria um objeto que é uma lista 
		JScrollPane jsp = new JScrollPane(jlst);       // Cria o container "rolável"
		
		
		b.setBounds(200,100,200, 80);
		b2.setBounds(200,200,200,80);
		jsp.setBounds(200, 300, 200, 80);
		
		//f.setSize(500,400);
		f.setBounds(0, 0,  600, 500); // (0, 0,  1920, 1080) pra ficar quase em tela cheia em um monitor full hd
		f.setLayout(null);
		f.setVisible(true);
		f.add(b);
		f.add(b2);
		f.add(jsp);
		
		
		
		
		
	}

	
}
