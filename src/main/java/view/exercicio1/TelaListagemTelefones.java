package view.exercicio1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

public class TelaListagemTelefones extends JFrame {

	JFrame frmListagemTelefones;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListagemTelefones window = new TelaListagemTelefones();
					window.frmListagemTelefones.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaListagemTelefones() {
		initialize();
	}

	
	public void initialize() {
		frmListagemTelefones = new JFrame();
		frmListagemTelefones.setTitle("Listagem de Telefones");
		frmListagemTelefones.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmListagemTelefones.setBounds(100, 100, 721, 249);
		frmListagemTelefones.getContentPane().setLayout(new MigLayout("", "[80px][10px][150px]", "[20px][70px]"));
		
		
	}

}
