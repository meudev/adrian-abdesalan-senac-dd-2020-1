package view.exercicio1;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.exercicio1.ClienteController;
import controller.exercicio1.EnderecoController;
import controller.exercicio1.TelefoneController;
import model.vo.exercicio1.Cliente;
import model.vo.exercicio1.Endereco;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroTelefone extends JFrame {

	JFrame frmCadastroTelefones;
	private JTextField txtDdd;
	private JTextField txtNumero;
	private JComboBox cbClientes;
	private JButton btnSalvar;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroTelefone window = new TelaCadastroTelefone();
					window.frmCadastroTelefones.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaCadastroTelefone() {
		initialize();
	}
	
	public void initialize() {
		frmCadastroTelefones = new JFrame();
		frmCadastroTelefones.setTitle("Cadastro de Telefone");
		frmCadastroTelefones.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCadastroTelefones.setBounds(100, 100, 542, 249);
		frmCadastroTelefones.getContentPane().setLayout(new MigLayout("", "[80px][10px][150px,grow]", "[20px][70px][][][][]"));
	
		JLabel lblDdd = new JLabel("DDD:  ");
		lblDdd.setBounds(10, 17, 100, 13);
		frmCadastroTelefones.getContentPane().add(lblDdd, "cell 0 0,alignx right");
		
		ClienteController controller = new ClienteController();
		ArrayList<Cliente> clientes = controller.listarTodosOsClientes();
			
			txtDdd = new JTextField();
			frmCadastroTelefones.getContentPane().add(txtDdd, "cell 2 0,alignx left");
			txtDdd.setColumns(10);
			
			JLabel lblNumero = new JLabel("N\u00FAmero:  ");
			lblNumero.setBounds(10, 17, 100, 13);
			frmCadastroTelefones.getContentPane().add(lblNumero, "cell 0 1,alignx right");
			lblNumero.setBounds(10, 17, 100, 13);
			
			txtNumero = new JTextField();
			frmCadastroTelefones.getContentPane().add(txtNumero, "cell 2 1,alignx left");
			txtNumero.setColumns(10);
		
			JLabel lblCliente = new JLabel("Dono da Linha:  ");
			frmCadastroTelefones.getContentPane().add(lblCliente, "cell 0 2,alignx right");
		
		cbClientes = new JComboBox(clientes.toArray());
		frmCadastroTelefones.getContentPane().add(cbClientes, "cell 2 2,alignx left");
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelefoneController controller = new TelefoneController();
				String mensagem = controller.salvar(txtDdd.getText(), txtNumero.getText(), (Cliente) cbClientes.getSelectedItem());

				JOptionPane.showMessageDialog(null, mensagem);
			}
		});
		frmCadastroTelefones.getContentPane().add(btnSalvar, "cell 2 4");

	}


}
