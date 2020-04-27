package view.exercicio1;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import controller.exercicio1.ClienteController;
import controller.exercicio1.EnderecoController;
import model.vo.exercicio1.Endereco;

import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;

public class TelaCadastroCliente_JInternalFrame extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	private JTextField txtNome;
	private JTextField txtSobrenome;
	private JFormattedTextField txtCpf;
	private JComboBox cbEnderecos;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroCliente_JInternalFrame frame = new TelaCadastroCliente_JInternalFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaCadastroCliente_JInternalFrame() {
		setClosable(true);
		setResizable(true);
		setMaximizable(true);
		setTitle("Cadastrar de Cliente");
		setBounds(100, 100, 604, 206);
		getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
				
		JLabel lblNome = new JLabel("Primeiro Nome:  ");
		getContentPane().add(lblNome, "6, 2");

		txtNome = new JTextField();
		getContentPane().add(txtNome, "10, 2, fill, default");
		txtNome.setColumns(10);
		
		JLabel lblSobrenome = new JLabel("Sobrenome:  ");
		getContentPane().add(lblSobrenome, "6, 4");

		txtSobrenome = new JTextField();
		getContentPane().add(txtSobrenome, "10, 4, fill, bottom");
		txtSobrenome.setColumns(10);

		JLabel lblCpf = new JLabel("CPF:  ");
		getContentPane().add(lblCpf, "6, 6");
		
		try {
			MaskFormatter mascaraCPF = new MaskFormatter("###.###.###-##");

			txtCpf = new JFormattedTextField(mascaraCPF);
			getContentPane().add(txtCpf, "cell 2 2,growx");

		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o:");
		getContentPane().add(lblEndereco, "6, 8");
		
		ArrayList<String> enderecos = consultarEnderecos();
		cbEnderecos = new JComboBox(enderecos.toArray());
		getContentPane().add(cbEnderecos, "cell 2 3,growx");
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteController controller = new ClienteController();
							
				String mensagem = controller.salvar(txtNome.getText(), txtSobrenome.getText(), txtCpf.getText(), (Endereco) cbEnderecos.getSelectedItem());

				JOptionPane.showMessageDialog(null, mensagem);
			}
		});
		getContentPane().add(btnSalvar, "cell 2 5,growx");
				
	}
	
	private ArrayList<String> consultarEnderecos() {
		
		ArrayList<String> enderecos = new ArrayList<String>();
		
		EnderecoController controller = new EnderecoController();
		ArrayList<Endereco> listEnderecos = controller.listarTodosOsEnderecos();
		
		for(int i = 0; i < listEnderecos.size(); i++) {
			enderecos.add(listEnderecos.get(i).toString());
		}
		
		return enderecos;
	}
	
	private void limparCampos() {

		this.txtNome.setText("");
		this.txtSobrenome.setText("");
		this.txtCpf.setText("");

		this.cbEnderecos.setSelectedIndex(0);
		
	}

}
