package view.exercicio1;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import controller.exercicio1.ClienteController;
import controller.exercicio1.EnderecoController;
import model.vo.exercicio1.Endereco;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

public class PainelCadastroCliente extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtNome;
	private JTextField txtSobrenome;
	private JTextField txtCPF;
	private JComboBox cbEnderecos;

	public PainelCadastroCliente() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,FormSpecs.DEFAULT_COLSPEC,FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,FormSpecs.DEFAULT_ROWSPEC,FormSpecs.RELATED_GAP_ROWSPEC,FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,FormSpecs.DEFAULT_ROWSPEC,FormSpecs.RELATED_GAP_ROWSPEC,FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,FormSpecs.DEFAULT_ROWSPEC,FormSpecs.RELATED_GAP_ROWSPEC,FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblNome = new JLabel("Nome:");
		add(lblNome, "2, 2, right, default");
		
		txtNome = new JTextField();
		add(txtNome, "4, 2, fill, default");
		txtNome.setColumns(10);
		
		JLabel lblSobrenome = new JLabel("Sobrenome:");
		add(lblSobrenome, "2, 4, right, default");
		
		txtSobrenome = new JTextField();
		add(txtSobrenome, "4, 4, fill, default");
		txtSobrenome.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		add(lblCpf, "2, 6, right, default");
		
		txtCPF = new JTextField();
		add(txtCPF, "4, 6, fill, default");
		txtCPF.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		add(lblEndereo, "2, 8, right, default");
		
		EnderecoController controllerEndereco = new EnderecoController();
		ArrayList<Endereco> listEnderecos = controllerEndereco.listarTodosOsEnderecos();
		cbEnderecos = new JComboBox(listEnderecos.toArray());
		add(cbEnderecos, "4, 8, fill, default");
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});
		add(btnLimpar, "2, 12");
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteController controller = new ClienteController();
							
				String mensagem = controller.salvar(txtNome.getText(), txtSobrenome.getText(), txtCPF.getText(), (Endereco) cbEnderecos.getSelectedItem());

				JOptionPane.showMessageDialog(null, mensagem);
			}
		});
		add(btnSalvar, "4, 12");

	}
	
	private void limparCampos() {

		this.txtNome.setText("");
		this.txtSobrenome.setText("");
		this.txtCPF.setText("");
		this.cbEnderecos.setSelectedIndex(0);
		
	}

}
