package view.exercicio1;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import controller.exercicio1.ClienteController;
import controller.exercicio1.TelefoneController;
import model.vo.exercicio1.Cliente;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class PainelCadastroTelefone extends JPanel {
	private JTextField txtPais;
	private JTextField txtDDD;
	private JTextField txtNumero;
	private JRadioButton rdbtnSim;
	private JRadioButton rdbtnNao;
	private ButtonGroup movel;
	private boolean vrMovel;
	private JComboBox cbClientes;

	public PainelCadastroTelefone() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,FormSpecs.DEFAULT_COLSPEC,FormSpecs.RELATED_GAP_COLSPEC,ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,FormSpecs.DEFAULT_ROWSPEC,FormSpecs.RELATED_GAP_ROWSPEC,FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,FormSpecs.DEFAULT_ROWSPEC,FormSpecs.RELATED_GAP_ROWSPEC,FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,FormSpecs.DEFAULT_ROWSPEC,FormSpecs.RELATED_GAP_ROWSPEC,FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblCdigoPas = new JLabel("C\u00F3digo Pa\u00EDs:");
		add(lblCdigoPas, "2, 2, right, default");
		
		txtPais = new JTextField();
		add(txtPais, "4, 2, 3, 1, fill, default");
		txtPais.setColumns(10);
		
		JLabel lblDdd = new JLabel("DDD:");
		add(lblDdd, "2, 4, right, default");
		
		txtDDD = new JTextField();
		add(txtDDD, "4, 4, 3, 1, fill, default");
		txtDDD.setColumns(10);
		
		JLabel lblNmero = new JLabel("N\u00FAmero:");
		add(lblNmero, "2, 6, right, default");
		
		txtNumero = new JTextField();
		add(txtNumero, "4, 6, 3, 1, fill, default");
		txtNumero.setColumns(10);
		
		JLabel lblMvel = new JLabel("M\u00F3vel?");
		add(lblMvel, "2, 8, right, default");
		
		movel = new ButtonGroup();
		
		rdbtnSim = new JRadioButton("Sim", true);
		add(rdbtnSim, "4, 8, left, default");
		
		rdbtnNao = new JRadioButton("Não", false);
		add(rdbtnNao, "6, 8, left, default");
		
		movel.add(rdbtnSim);
		movel.add(rdbtnNao);
		
		if(rdbtnSim.isSelected()){
			vrMovel = true;
		}
		if(rdbtnNao.isSelected()){
			vrMovel = false;
		}
		
		JLabel lblDonoDaLinha = new JLabel("Dono da Linha:");
		add(lblDonoDaLinha, "2, 10, right, default");
		
		ClienteController controller = new ClienteController();
		ArrayList<Cliente> clientes = controller.listarTodosOsClientes();
		cbClientes = new JComboBox(clientes.toArray());
		cbClientes.setSelectedIndex(-1);
		add(cbClientes, "4, 10, 3, 1, fill, default");
		
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
				TelefoneController controller = new TelefoneController();
				String mensagem = controller.salvar(txtPais.getText(), txtDDD.getText(), txtNumero.getText(), vrMovel, (Cliente) cbClientes.getSelectedItem());
					
				JOptionPane.showMessageDialog(null, mensagem);
			}
		});
		add(btnSalvar, "4, 12, 3, 1");

	}
	
	private void limparCampos() {

		this.txtPais.setText("");
		this.txtDDD.setText("");
		this.txtNumero.setText("");
		this.cbClientes.setSelectedIndex(-1);
		
	}

}
