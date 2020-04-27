package view.exercicio1;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import controller.exercicio1.ClienteController;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;

public class PainelExclusaoCliente extends JPanel {

	private static final long serialVersionUID = 1L;
	private JFormattedTextField txtCPF;

	public PainelExclusaoCliente() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,FormSpecs.DEFAULT_COLSPEC,FormSpecs.RELATED_GAP_COLSPEC,ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,FormSpecs.DEFAULT_ROWSPEC,FormSpecs.RELATED_GAP_ROWSPEC,FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblCpf = new JLabel("CPF:");
		add(lblCpf, "2, 2, right, default");
		
		try {
			
			MaskFormatter mascaraCPF = new MaskFormatter("###.###.###-##");

			txtCPF = new JFormattedTextField(mascaraCPF);
			add(txtCPF, "4, 2, fill, default");
			txtCPF.setColumns(10);
			
		} catch (ParseException ex) {
		    ex.printStackTrace();
		}
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClienteController controladora = new ClienteController();

				String mensagem = controladora.excluirCPF(txtCPF.getText());

				JOptionPane.showMessageDialog(null, mensagem);
			}
		});
		add(btnExcluir, "4, 4");

		
		
	}

}
