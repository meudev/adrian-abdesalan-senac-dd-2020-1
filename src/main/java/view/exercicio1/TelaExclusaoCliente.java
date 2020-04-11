package view.exercicio1;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controller.exercicio1.ClienteController;
import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

public class TelaExclusaoCliente extends JFrame {

	JFrame frmExclusaoCliente;
	private JPanel contentPane;
	private JFormattedTextField textCPF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					TelaExclusaoCliente window = new TelaExclusaoCliente();
					window.frmExclusaoCliente.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaExclusaoCliente() {
		initialize();
	}
	
	
	private void initialize() {
		
		frmExclusaoCliente = new JFrame();
		frmExclusaoCliente.setTitle("Exclusão de Cliente");
		frmExclusaoCliente.setBounds(100, 100, 310, 200);
		frmExclusaoCliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmExclusaoCliente.getContentPane().setLayout(new MigLayout("", "[80px][grow][][grow][10px][150px]", "[20px][70px]"));
		
		JLabel lblCPF = new JLabel("Informe o CPF:  ");
		lblCPF.setBounds(10, 17, 100, 13);
		frmExclusaoCliente.getContentPane().add(lblCPF, "cell 0 0,alignx trailing");
		
		try {
		
			MaskFormatter mascaraCPF = new MaskFormatter("###.###.###-##");

			textCPF = new JFormattedTextField(mascaraCPF);
			frmExclusaoCliente.getContentPane().add(textCPF, "cell 1 0 5 1,growx");
			textCPF.setColumns(10);
			
		} catch (ParseException ex) {
		    ex.printStackTrace();
		}
		
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(71, 57, 85, 21);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClienteController controladora = new ClienteController();

				String mensagem = controladora.excluirCPF(textCPF.getText());

				JOptionPane.showMessageDialog(null, mensagem);
			}
		});
		
		frmExclusaoCliente.getContentPane().add(btnExcluir, "cell 0 1 6 1,grow");
	}
	
	
	
}
