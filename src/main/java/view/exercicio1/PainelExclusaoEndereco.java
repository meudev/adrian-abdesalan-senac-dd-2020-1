package view.exercicio1;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import controller.exercicio1.EnderecoController;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class PainelExclusaoEndereco extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtID;

	public PainelExclusaoEndereco() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,FormSpecs.DEFAULT_COLSPEC,FormSpecs.RELATED_GAP_COLSPEC,ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,FormSpecs.DEFAULT_ROWSPEC,FormSpecs.RELATED_GAP_ROWSPEC,FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblInformeOId = new JLabel("Informe o ID:");
		add(lblInformeOId, "2, 2, right, default");
		
		txtID = new JTextField();
		add(txtID, "4, 2, fill, default");
		txtID.setColumns(10);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EnderecoController controladora = new EnderecoController();

				String mensagem = controladora.excluir(txtID.getText());

				JOptionPane.showMessageDialog(null, mensagem);
			}
		});
		add(btnExcluir, "4, 4");

	}

}
