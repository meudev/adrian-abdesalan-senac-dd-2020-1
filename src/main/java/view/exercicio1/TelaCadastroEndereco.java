package view.exercicio1;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import controller.exercicio1.EnderecoController;
import net.miginfocom.swing.MigLayout;

public class TelaCadastroEndereco {

	JFrame frmCadastroEnderecos;
	private JTextField txtRua;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtNumero;
	private JFormattedTextField txtCep;
	private JComboBox cbSiglaEstado;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroEndereco window = new TelaCadastroEndereco();
					window.frmCadastroEnderecos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaCadastroEndereco() {
		initialize();
	}

	private void initialize() {
		
		frmCadastroEnderecos = new JFrame();
		frmCadastroEnderecos.setTitle("Cadastro de endereço");
		frmCadastroEnderecos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCadastroEnderecos.setBounds(100, 100, 721, 249);
		frmCadastroEnderecos.getContentPane().setLayout(new MigLayout("", "[80px][10px][150px]", "[20px][70px]"));


		frmCadastroEnderecos.setLayout(new FormLayout(
				new ColumnSpec[] { FormSpecs.UNRELATED_GAP_COLSPEC, ColumnSpec.decode("80px"),
						FormSpecs.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("200px:grow"),
						FormSpecs.UNRELATED_GAP_COLSPEC, ColumnSpec.decode("15px"), FormSpecs.UNRELATED_GAP_COLSPEC,
						ColumnSpec.decode("80px"), ColumnSpec.decode("200px:grow"), },
				new RowSpec[] { FormSpecs.UNRELATED_GAP_ROWSPEC, RowSpec.decode("28px"),
						FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC, RowSpec.decode("28px"),
						FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC, RowSpec.decode("28px"), RowSpec.decode("25px"),
						RowSpec.decode("29px"), FormSpecs.UNRELATED_GAP_ROWSPEC, RowSpec.decode("16px"), }));

		//RUA
		JLabel lblRua = new JLabel("Rua (*): ");
		frmCadastroEnderecos.add(lblRua, "2, 2, right, center");
		
		txtRua = new JTextField();
		frmCadastroEnderecos.add(txtRua, "4, 2, fill, top");
		txtRua.setColumns(10);
		
		//NUMERO
		JLabel lblNumero = new JLabel("Número (*):");
		frmCadastroEnderecos.add(lblNumero, "8, 2, right, center");

		txtNumero = new JTextField();
		frmCadastroEnderecos.add(txtNumero, "9, 2, left, top");
		txtNumero.setColumns(10);

		//BAIRRO
		JLabel lblBairro = new JLabel("Bairro (*):");
		frmCadastroEnderecos.add(lblBairro, "2, 4, right, center");
		
		txtBairro = new JTextField();
		frmCadastroEnderecos.add(txtBairro, "4, 4, fill, top");
		txtBairro.setColumns(10);
		
		//CEP
		JLabel lblCep = new JLabel("CEP (*):");
		frmCadastroEnderecos.add(lblCep, "8, 4, right, center");

		try {
			MaskFormatter mascaraCep = new MaskFormatter("#####-###");

			txtCep = new JFormattedTextField(mascaraCep);
			frmCadastroEnderecos.add(txtCep, "9, 4, fill, center");

		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		//CIDADE
		JLabel lblCidade = new JLabel("Cidade (*):");
		frmCadastroEnderecos.add(lblCidade, "2, 6, right, center");

		txtCidade = new JTextField();
		frmCadastroEnderecos.add(txtCidade, "4, 6, fill, top");
		txtCidade.setColumns(10);
		
		//ESTADOS
		JLabel lblEstado = new JLabel("Estado (*):");
		frmCadastroEnderecos.add(lblEstado, "8, 6, right, bottom");
		
		ArrayList<String> siglasEstados = consultarEstados();
		cbSiglaEstado = new JComboBox(siglasEstados.toArray());
		frmCadastroEnderecos.add(cbSiglaEstado, "9, 6, fill, fill");

		//ALERT CAMPOS OBRIGATÓRIOS
		JLabel lblCamposObrigatorios = new JLabel("(*) campos obrigatórios");
		lblCamposObrigatorios.setFont(new Font("Lucida Grande", Font.ITALIC, 11));
		frmCadastroEnderecos.add(lblCamposObrigatorios, "2, 10, 3, 1, fill, fill");
		
		//BUTTON SALVAR
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnderecoController controller = new EnderecoController();
				String mensagem = controller.salvar(txtRua.getText(), txtBairro.getText(), txtNumero.getText(),
						txtCep.getText(),
						txtCidade.getText(), (String) cbSiglaEstado.getSelectedItem());
				
				JOptionPane.showMessageDialog(null, mensagem);
			}
		});
		frmCadastroEnderecos.add(btnSalvar, "2, 8, 3, 1, fill, fill");
		
		//BUTTON LIMPAR CAMPOS
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
			
		});
		frmCadastroEnderecos.add(btnLimpar, "6, 8, 4, 1, fill, fill");
	}

	//LIMPAR OS CAMPOS
	protected void limparCampos() {
		this.txtRua.setText("");
		this.txtBairro.setText("");
		this.txtCidade.setText("");
		this.txtNumero.setText("");
		this.txtCep.setText("");
		this.cbSiglaEstado.setSelectedIndex(0);
	}

	//MONTAR LISTA DE ESTADOS
	private ArrayList<String> consultarEstados() {

		ArrayList<String> siglasEstados = new ArrayList<String>();

		siglasEstados.add("AC");
		siglasEstados.add("BA");
		siglasEstados.add("CE");
		siglasEstados.add("DF");
		siglasEstados.add("GO");
		siglasEstados.add("PR");
		siglasEstados.add("SC");
		siglasEstados.add("RS");

		return siglasEstados;
	}
}
