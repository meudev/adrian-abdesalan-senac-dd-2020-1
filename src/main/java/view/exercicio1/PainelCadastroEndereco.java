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
import javax.swing.text.MaskFormatter;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JButton;

public class PainelCadastroEndereco extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtNumero;
	private JTextField txtRua;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JComboBox cbSiglaEstado;
	private JFormattedTextField txtCEP;
	private JButton btnSalvar;
	private JButton btnLimpar;

	public PainelCadastroEndereco() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,FormSpecs.DEFAULT_COLSPEC,FormSpecs.RELATED_GAP_COLSPEC,ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,FormSpecs.DEFAULT_COLSPEC,FormSpecs.RELATED_GAP_COLSPEC,FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,FormSpecs.DEFAULT_COLSPEC,FormSpecs.RELATED_GAP_COLSPEC,FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,FormSpecs.DEFAULT_COLSPEC,FormSpecs.RELATED_GAP_COLSPEC,FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,FormSpecs.DEFAULT_COLSPEC,FormSpecs.RELATED_GAP_COLSPEC,FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,FormSpecs.DEFAULT_COLSPEC,FormSpecs.RELATED_GAP_COLSPEC,ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,FormSpecs.DEFAULT_ROWSPEC,FormSpecs.RELATED_GAP_ROWSPEC,FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,FormSpecs.DEFAULT_ROWSPEC,FormSpecs.RELATED_GAP_ROWSPEC,FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblRua = new JLabel("Rua:");
		add(lblRua, "2, 2, right, default");
		
		txtRua = new JTextField();
		add(txtRua, "4, 2, 19, 1, fill, default");
		txtRua.setColumns(10);
		
		JLabel lblNmero = new JLabel("N\u00FAmero:");
		add(lblNmero, "24, 2, right, default");
		
		txtNumero = new JTextField();
		add(txtNumero, "26, 2, fill, top");
		txtNumero.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro:");
		add(lblBairro, "2, 4, right, default");
		
		txtBairro = new JTextField();
		add(txtBairro, "4, 4, 19, 1, fill, default");
		txtBairro.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP:");
		add(lblCep, "24, 4, right, default");
		
		try {
			MaskFormatter mascaraCep = new MaskFormatter("#####-###");

			txtCEP = new JFormattedTextField(mascaraCep);
			add(txtCEP, "26, 4, fill, default");
			txtCEP.setColumns(10);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		JLabel lblCidade = new JLabel("Cidade:");
		add(lblCidade, "2, 6, right, default");
		
		txtCidade = new JTextField();
		add(txtCidade, "4, 6, 19, 1, fill, default");
		txtCidade.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado:");
		add(lblEstado, "24, 6, right, default");
		
		ArrayList<String> siglasEstados = consultarEstados();
		cbSiglaEstado = new JComboBox(siglasEstados.toArray());
		add(cbSiglaEstado, "26, 6, fill, default");
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
			
		});
		add(btnLimpar, "2, 8, 7, 1");
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnderecoController controller = new EnderecoController();
				String mensagem = controller.salvar(txtRua.getText(), txtBairro.getText(), txtNumero.getText(),
						txtCEP.getText(),
						txtCidade.getText(), (String) cbSiglaEstado.getSelectedItem());
				
				JOptionPane.showMessageDialog(null, mensagem);
			}
		});
		add(btnSalvar, "10, 8, 17, 1");
		
	}
	
	//LIMPAR OS CAMPOS
	protected void limparCampos() {
		this.txtRua.setText("");
		this.txtBairro.setText("");
		this.txtCidade.setText("");
		this.txtNumero.setText("");
		this.txtCEP.setText("");
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
