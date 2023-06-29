package view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import controle.ControleEmpresa;

public class InterfaceFilial implements ActionListener, ListSelectionListener {
	private JFrame janela;
	private JLabel titulo;
	private JButton cadastroFilial;
	private JButton refreshFilial;
	private static ControleEmpresa empresa;
	
	private JList<String> listaFiliais;
	private String[] listaNomes = new String[50];
	
	public InterfaceFilial(ControleEmpresa ce ) {
		empresa = ce;
		
		
		listaNomes = new ControleEmpresa().getNomesFiliais();
		listaFiliais = new JList<String>(listaNomes);
		
		janela = new JFrame("Filiais");
		titulo = new JLabel("Filiais Cadastradas");
		cadastroFilial = new JButton("Cadastrar Filial");
		refreshFilial = new JButton("refresh");
		
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		
		titulo.setBounds(90, 10, 250, 30);
		cadastroFilial.setBounds(70, 177, 100, 30);
		refreshFilial.setBounds(200, 177, 100, 30);
		listaFiliais.setBounds(20, 50, 350, 120);
		
		listaFiliais.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaFiliais.setVisibleRowCount(10);
		
		
		janela.setLayout(null);
		janela.add(titulo);
		janela.add(listaFiliais);
		janela.add(cadastroFilial);
		janela.add(refreshFilial);
		
		janela.setSize(400, 250);
		janela.setVisible(true);
		
		cadastroFilial.addActionListener(this);
		listaFiliais.addListSelectionListener(this);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
			Object src	= ev.getSource();
			
			if(src == cadastroFilial) {
				new InterfaceCadastroFilial().inserirEditar(1, empresa, 0);
			}
	}
	
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
		
		if(e.getValueIsAdjusting() && src == listaFiliais) {
			new InterfaceCadastroFilial().inserirEditar(2, empresa,
					 listaFiliais.getSelectedIndex());
			
		}
		
		//adicionar o refresh;
	}
	
}
