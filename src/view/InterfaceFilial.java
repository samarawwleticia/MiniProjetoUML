package view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import controle.*;


public class InterfaceFilial implements ActionListener{
	private JFrame janela;
	private JLabel titulo;
	private JButton cadastroFilial;
	
	private static ControleEmpresa empresa;
	private JList<String> listaFiliais;
	private String[] listaNomes = new String[50];
	
	public InterfaceFilial( ) {
		
		listaNomes = new ControleEmpresa().empresa.getNomesFiliais();
		listaFiliais = new JList<String>(listaNomes);
		
		janela = new JFrame("Filiais");
		titulo = new JLabel("Filiais Cadastradas");
		cadastroFilial = new JButton("Cadastrar Filial");
		
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(90, 10, 250, 30);
		listaFiliais.setBounds(20, 50, 350, 120);
		listaFiliais.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaFiliais.setVisibleRowCount(10);
		
		cadastroFilial.setBounds(70, 177, 100, 30);
		
		janela.setLayout(null);
		
		janela.add(titulo);
		janela.add(listaFiliais);
		janela.add(cadastroFilial);
		
		janela.setSize(400, 250);
		janela.setVisible(true);
		
		cadastroFilial.addActionListener(this);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
			Object src	= ev.getSource();
			
			if(src == cadastroFilial)
				new InterfaceCadastroFilial();
	}
	
}
