package view.exercicio1;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controller.ControladoraUsuario;
import controller.exercicio1.ClienteController;
import controller.exercicio1.EnderecoController;
import model.vo.TipoUsuarioVO;
import model.vo.exercicio1.Endereco;
import net.miginfocom.swing.MigLayout;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;

public class TelaCadastroCliente extends JFrame {

	JFrame frmCadastroClientes;
	private JTextField txtNome;
	private JLabel lblSobrenome;
	private JTextField txtSobrenome;
	private JLabel lblCpf;
	private JFormattedTextField txtCpf;
	private JLabel lblEndereo;
	private JComboBox cbEnderecos;
	private JButton btnSalvar;
	private JButton btnLimpar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroCliente window = new TelaCadastroCliente();
					window.frmCadastroClientes.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaCadastroCliente() {
		initialize();
	}
	
	public void initialize() {
		frmCadastroClientes = new JFrame();
		frmCadastroClientes.setTitle("Cadastro de Cliente");
		frmCadastroClientes.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCadastroClientes.setBounds(100, 100, 527, 249);
		frmCadastroClientes.getContentPane().setLayout(new MigLayout("", "[80px][10px][150px,grow]", "[20px][70px][][][][]"));
		
		JLabel lblNome = new JLabel("Primeiro Nome:  ");
		lblNome.setBounds(10, 17, 100, 13);
		frmCadastroClientes.getContentPane().add(lblNome, "cell 0 0,alignx right");
		
		txtNome = new JTextField();
		frmCadastroClientes.getContentPane().add(txtNome, "cell 2 0,growx");
		txtNome.setColumns(10);
		
		lblSobrenome = new JLabel("Sobrenome:  ");
		frmCadastroClientes.getContentPane().add(lblSobrenome, "cell 0 1");
		
		txtSobrenome = new JTextField();
		txtSobrenome.setColumns(10);
		frmCadastroClientes.getContentPane().add(txtSobrenome, "cell 2 1,growx");
		
		lblCpf = new JLabel("CPF:  ");
		frmCadastroClientes.getContentPane().add(lblCpf, "cell 0 2");
		
		try {
			MaskFormatter mascaraCPF = new MaskFormatter("###.###.###-##");

			txtCpf = new JFormattedTextField(mascaraCPF);
			frmCadastroClientes.getContentPane().add(txtCpf, "cell 2 2,growx");

		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		lblEndereo = new JLabel("Endere\u00E7o:");
		frmCadastroClientes.getContentPane().add(lblEndereo, "cell 0 3");
		
		ArrayList<String> enderecos = consultarEnderecos();
		cbEnderecos = new JComboBox(enderecos.toArray());
		frmCadastroClientes.getContentPane().add(cbEnderecos, "cell 2 3,growx");
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});
		frmCadastroClientes.getContentPane().add(btnLimpar, "cell 0 5");		
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteController controller = new ClienteController();
				String mensagem = controller.salvar(txtNome.getText(), txtSobrenome.getText(), txtCpf.getText(), (String) cbEnderecos.getSelectedItem());

				JOptionPane.showMessageDialog(null, mensagem);
			}
		});
		frmCadastroClientes.getContentPane().add(btnSalvar, "cell 2 5,growx");
	}

	private ArrayList<String> consultarEnderecos() {
		
		ArrayList<String> enderecos = new ArrayList<String>();
		
		EnderecoController controller = new EnderecoController();
		ArrayList<Endereco> listEnderecos = controller.listarTodosOsEnderecos();
		
		for(int i = 0; i < listEnderecos.size(); i++) {
			enderecos.add(listEnderecos.toString());
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
