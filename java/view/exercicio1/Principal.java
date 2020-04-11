package view.exercicio1;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				

				
				try {	
					Principal frame = new Principal();
					frame.setResizable(false);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setTitle("Sistema Telefonia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 790, 440);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnClientes = new JMenu("  Clientes     ");
		mnClientes.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnClientes.setIcon(new ImageIcon("D:\\FACULDADE\\Eclipse - Senac\\Icones\\icons8-contatos-50.png"));
		menuBar.add(mnClientes);
		
		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar");
		mntmCadastrar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mntmCadastrar.setIcon(new ImageIcon("D:\\FACULDADE\\Eclipse - Senac\\Icones\\icons8-usuário-verificado-masculino-26.png"));
		mnClientes.add(mntmCadastrar);
		
		JMenuItem mntmListar = new JMenuItem("Listar");
		mntmListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaListagemClientes listarClientes = new TelaListagemClientes();
				listarClientes.frmListagemDeClientes.setVisible(true);				

			}
		});
		mntmListar.setIcon(new ImageIcon("D:\\FACULDADE\\Eclipse - Senac\\Icones\\icons8-cardápio-26.png"));
		mnClientes.add(mntmListar);
		
		JMenuItem mntmExcluir_2 = new JMenuItem("Excluir");
		mntmExcluir_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaExclusaoCliente exlcuirClientes = new TelaExclusaoCliente();
				exlcuirClientes.frmExclusaoCliente.setVisible(true);				

			}
		});
		mntmExcluir_2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
		mntmExcluir_2.setIcon(new ImageIcon("D:\\FACULDADE\\Eclipse - Senac\\Icones\\icons8-remover-usuário-masculino-26.png"));
		mnClientes.add(mntmExcluir_2);
		
		JMenuItem mntmRelatrio = new JMenuItem("Relatório");
		mntmRelatrio.setIcon(new ImageIcon("D:\\FACULDADE\\Eclipse - Senac\\Icones\\icons8-documento-26.png"));
		mnClientes.add(mntmRelatrio);
		
		JMenu mnProdutos = new JMenu("  Endereços     ");
		mnProdutos.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnProdutos.setIcon(new ImageIcon("D:\\FACULDADE\\Eclipse - Senac\\Icones\\icons8-endereço-50.png"));
		menuBar.add(mnProdutos);
		
		JMenuItem mntmCadastrar_1 = new JMenuItem("Cadastrar");
		mntmCadastrar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaCadastroEndereco cadastrarClientes = new TelaCadastroEndereco();
				cadastrarClientes.frmCadastroEnderecos.setVisible(true);	
				
			}
		});
		mnProdutos.add(mntmCadastrar_1);
		
		JMenuItem mntmExcluir = new JMenuItem("Excluir");
		mntmExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaExclusaoEndereco excluirEndereco = new TelaExclusaoEndereco();
				excluirEndereco.frmExclusaoEnderecos.setVisible(true);	
				
			}
		});
		mnProdutos.add(mntmExcluir);
		
		JMenu mnFuncionrios = new JMenu("  Números     ");
		mnFuncionrios.setIcon(new ImageIcon("D:\\FACULDADE\\Eclipse - Senac\\Icones\\icons8-telefone-celular-50.png"));
		mnFuncionrios.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(mnFuncionrios);
		
		JMenuItem mntmCadastar = new JMenuItem("Cadastar");
		mnFuncionrios.add(mntmCadastar);
		
		JMenuItem mntmConsultar = new JMenuItem("Consultar");
		mnFuncionrios.add(mntmConsultar);
		
		JMenuItem mntmExcluir_1 = new JMenuItem("Excluir");
		mnFuncionrios.add(mntmExcluir_1);
		
		JMenu mnSobre = new JMenu("  Sobre");
		mnSobre.setIcon(new ImageIcon("D:\\FACULDADE\\Eclipse - Senac\\Icones\\icons8-sobre-50.png"));
		mnSobre.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(mnSobre);
		
		JMenuItem mntmManual = new JMenuItem("Manual");
		mntmManual.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F10, 0));
		mnSobre.add(mntmManual);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JDesktopPane desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		JLabel lblDesenvolvidoPorAdrian = new JLabel("Desenvolvido por Adrian Salomon Ferreira Abdesalan");
		lblDesenvolvidoPorAdrian.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblDesenvolvidoPorAdrian.setToolTipText("");
		lblDesenvolvidoPorAdrian.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblDesenvolvidoPorAdrian, BorderLayout.SOUTH);
	}
}
