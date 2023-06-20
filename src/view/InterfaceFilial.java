package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class InterfaceFilial implements ActionListener {
	
	
		JFrame f = new JFrame();
		JLabel titulo = new JLabel("Filiais");
		JTextField barrapesquisa = new JTextField("");
		JButton botaopesquisa = new JButton("pesquisar");
		JButton cadastrarFilial = new JButton ("cadastrar filial");
		
		InterfaceFilial() {
		
		String[] titulo2 = {"Cidade da Filial", "numero?"};
		String[][] listaFiliais = {
				{"Gama", "01"},{"Recanto das Emas", "02"},{"Taguatinga", "03"}
		};
		JTable tabelaFiliais = new JTable(listaFiliais, titulo2);
		JScrollPane painelFiliais = new JScrollPane(tabelaFiliais);
		
		f.setBounds(0, 0, 600, 600);
		f.setLayout(null);
		f.setVisible(true);
		f.add(titulo);
		titulo.setBounds(250,10, 200, 80);
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		
		f.add(barrapesquisa);
		barrapesquisa.setBounds(100, 70, 300, 20);
		
		f.add(botaopesquisa);
		botaopesquisa.setBounds(400,70,100,20);
		
		f.add(painelFiliais);
		painelFiliais.setBounds(100, 100, 400, 300);
		
		f.add(cadastrarFilial);
		cadastrarFilial.setBounds(200, 425, 200, 40);
		cadastrarFilial.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent evento) {
		Object elemento = evento.getSource();
		
		if (elemento == cadastrarFilial) {
			new InterfaceCadastroFilial();
		}
		
	}
	
}
