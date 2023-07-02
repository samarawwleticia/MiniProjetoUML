package view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import controle.*;

/** Essa classe exibe uma interface gráfica que mostra todas as filiais cadastradas no sistema
 * e que também permite a edição de uma filial existente e o cadastro de uma nova filial.
 * 
 * @author João Pedro e Samara 
 *
 */
public class InterfaceFilial implements ActionListener, ListSelectionListener {
	private JFrame janela;
	private JLabel titulo;
	private JButton cadastroFilial;
	private JButton refreshFilial;
	private static ControleEmpresa empresa;
	
	private JList<String> listaFiliais;
	private String[] listaNomes = new String[50];
	
	/**
	 * Interface da Filial que possui o JFrame, a lista com os nomes das filiais,
	 * o botão de cadastro que serve para cadastrar uma nova filial e o botão de
	 * refresh que atualiza a lista de filiais
	 * @param ce
	 */
	
	public InterfaceFilial(ControleEmpresa ce ) {
		empresa = ce;
		
		
		
		listaNomes = ce.getNomesFiliais();
		listaFiliais = new JList<String>(listaNomes);
		
		janela = new JFrame("Filiais");
		titulo = new JLabel("Filiais Cadastradas");
		cadastroFilial = new JButton("Cadastrar Filial");
		refreshFilial = new JButton("Atualizar Lista");
		
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		
		titulo.setBounds(250, 10, 200, 80);
		cadastroFilial.setBounds(305,410,194,50);
		refreshFilial.setBounds(100,410,195,50);
		listaFiliais.setBounds(100, 100, 400, 300);
		
		listaFiliais.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaFiliais.setVisibleRowCount(10);
		
		
		janela.setLayout(null);
		janela.add(titulo);
		janela.add(listaFiliais);
		janela.add(cadastroFilial);
		janela.add(refreshFilial);
		
		janela.setBounds(30,30,600,600);
		janela.setVisible(true);
		
		cadastroFilial.addActionListener(this);
		refreshFilial.addActionListener(this);
		listaFiliais.addListSelectionListener(this);
		
		
		
	}
	
	/**
	 * Esses métodos agem quando uma ação é executada no JFrame
	 * Se a pessoa clica no JButton cadastroFilial ela é redirecionada para
	 * a view InterfaceCadastroFilial para cadastrar uma nova Filial.
	 * Se a pessoa clica no JButton refresh a lista de filiais é atualizada.
	 */

	@Override
	public void actionPerformed(ActionEvent ev) {
			Object src	= ev.getSource();
			
			if(src == cadastroFilial) {
				new InterfaceCadastroFilial().inserirEditar(1, empresa, 0);
			} if (src == refreshFilial) {
				listaFiliais.setListData(new ControleFilial(empresa).getNomeFilial());
				listaFiliais.updateUI();
			}
	}
	
	/**
	 * Nesse método, o usuário verá os detalhes exatamente da filial que ele deseja.
	 */
	
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
		
		if(e.getValueIsAdjusting() && src == listaFiliais) {
			new InterfaceCadastroFilial().inserirEditar(2, empresa,
					 listaFiliais.getSelectedIndex());
			
		}
			}
	
}
