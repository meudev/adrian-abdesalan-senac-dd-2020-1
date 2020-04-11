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

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class TelaCadastroTelefone extends JFrame {

	JFrame frmCadastroTelefones;
	private JTextField txtDdd;
	private JTextField txtNumero;
	private JComboBox cbClientes;
	private JButton btnSalvar;
	private JLabel lblCodigoPais;
	private JTextField txtCodigoPais;
	private JLabel lblMovel;
	private JRadioButton rdbtnSim;
	private JRadioButton rdbtnNao;
	private ButtonGroup movel;
	private boolean vrAtivo;
	
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
		frmCadastroTelefones.setBounds(100, 100, 542, 399);
		frmCadastroTelefones.getContentPane().setLayout(new MigLayout("", "[80px][10px][150px,grow]", "[20px][70px][][][][][][][][][]"));
		
			
			//CODIDO DO PAIS
			lblCodigoPais = new JLabel("C\u00F3digo do Pa\u00EDs:");
			frmCadastroTelefones.getContentPane().add(lblCodigoPais, "cell 0 2");
			
			txtCodigoPais = new JTextField();
			txtCodigoPais.setText("55");
			txtCodigoPais.setColumns(10);
			frmCadastroTelefones.getContentPane().add(txtCodigoPais, "cell 2 2,alignx left");
			
			//DDD
			JLabel lblDdd = new JLabel("DDD:  ");
			lblDdd.setBounds(10, 17, 100, 13);
			frmCadastroTelefones.getContentPane().add(lblDdd, "cell 0 3,alignx right");
			
			txtDdd = new JTextField();
			frmCadastroTelefones.getContentPane().add(txtDdd, "cell 2 3,alignx left");
			txtDdd.setColumns(10);
			
			//NUMERO
			JLabel lblNumero = new JLabel("N\u00FAmero:  ");
			lblNumero.setBounds(10, 17, 100, 13);
			frmCadastroTelefones.getContentPane().add(lblNumero, "cell 0 4,alignx right");
			
			txtNumero = new JTextField();
			frmCadastroTelefones.getContentPane().add(txtNumero, "cell 2 4,alignx left");
			txtNumero.setColumns(10);
			
			//MOVEL?
			lblMovel = new JLabel("M\u00F3vel?  ");
			frmCadastroTelefones.getContentPane().add(lblMovel, "cell 0 5,alignx right");
			
			movel = new ButtonGroup();
			
			rdbtnSim = new JRadioButton("Sim", true);
			frmCadastroTelefones.getContentPane().add(rdbtnSim, "flowx,cell 2 5");
			
			rdbtnNao = new JRadioButton("N\u00E3o", false);
			frmCadastroTelefones.getContentPane().add(rdbtnNao, "cell 2 5");
			
			movel.add(rdbtnSim);
			movel.add(rdbtnNao);
			
			if(rdbtnSim.isSelected()){
		         vrAtivo = true;
			}
			if(rdbtnNao.isSelected()){
				vrAtivo = false;
			}

			//CLIENTE OU DONA DA LINHA
			JLabel lblCliente = new JLabel("Dono da Linha:  ");
			frmCadastroTelefones.getContentPane().add(lblCliente, "cell 0 8,alignx right");
		
			ClienteController controller = new ClienteController();
			ArrayList<Cliente> clientes = controller.listarTodosOsClientes();
			cbClientes = new JComboBox(clientes.toArray());
			frmCadastroTelefones.getContentPane().add(cbClientes, "cell 2 8,alignx left");
		
		//BUTTON SALVAR
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelefoneController controller = new TelefoneController();
				String mensagem = controller.salvar(txtCodigoPais.getText(), txtDdd.getText(), txtNumero.getText(), vrAtivo, (Cliente) cbClientes.getSelectedItem());
					
				JOptionPane.showMessageDialog(null, mensagem);
			}
		});
		frmCadastroTelefones.getContentPane().add(btnSalvar, "cell 2 10");

	}


}
