package view.exercicio1;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import controller.exercicio1.ClienteController;
import model.vo.exercicio1.Cliente;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

public class PainelListagemClientes extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable tblClientes;
	private ArrayList<Cliente> clientes;
	private String[] nomesColunas = { "Nome completo", "CPF", "Qtde. Telefones" };

	public PainelListagemClientes() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,FormSpecs.DEFAULT_ROWSPEC,FormSpecs.RELATED_GAP_ROWSPEC,RowSpec.decode("default:grow"),}));
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteController controller = new ClienteController();
				clientes = controller.listarTodosOsClientes();

				atualizarTabelaClientes();
			}
		});
		add(btnBuscar, "2, 2, center, default");
		
		tblClientes = new JTable();
		add(tblClientes, "2, 4, fill, fill");

	}
	
	private void limparTabelaClientes() {
		tblClientes.setModel(new DefaultTableModel(new Object[][] { nomesColunas, }, nomesColunas));
	}

	private void atualizarTabelaClientes() {
		limparTabelaClientes();
		DefaultTableModel model = (DefaultTableModel) tblClientes.getModel();

		for (Cliente c : clientes) {

			Object[] novaLinhaDaTabela = new Object[3];
			novaLinhaDaTabela[0] = c.getNomeCompleto();
			novaLinhaDaTabela[1] = c.getCpf();
			novaLinhaDaTabela[2] = c.getTelefones().size();

			model.addRow(novaLinhaDaTabela);
		}

	}

}
