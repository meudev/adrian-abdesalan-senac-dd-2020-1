package view.exercicio1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

public class Principal_JInternalFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JDesktopPane desktopPane;
	private TelaCadastroCliente cadastrarClientes;	
	private TelaCadastroTelefone cadastrarTelefone;	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal_JInternalFrame frame = new Principal_JInternalFrame();
					frame.setExtendedState(MAXIMIZED_BOTH);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Principal_JInternalFrame() {
		setFont(new Font("Arial", Font.BOLD, 14));
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\FACULDADE\\Eclipse - Senac\\Icones\\icons8-rede-phonelink-24.png"));
		setTitle("Sistema Telefonia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 790, 440);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		//----------- CLIENTES
		JMenu mnClientes = new JMenu("  Clientes     ");
		mnClientes.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnClientes.setIcon(new ImageIcon("D:\\FACULDADE\\Eclipse - Senac\\Icones\\icons8-contatos-50.png"));
		menuBar.add(mnClientes);
		
		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar");
		mntmCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (cadastrarClientes == null || !cadastrarClientes.isVisible()) {
					cadastrarClientes = new TelaCadastroCliente();
					desktopPane.add(cadastrarClientes);
					cadastrarClientes.show();
				}
				
			}
			
			
		});
		mntmCadastrar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mntmCadastrar.setIcon(new ImageIcon("D:\\FACULDADE\\Eclipse - Senac\\Icones\\icons8-usu\u00E1rio-verificado-masculino-26.png"));
		mnClientes.add(mntmCadastrar);
		
		JMenuItem mntmListar = new JMenuItem("Listar");
		mntmListar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK));
		mntmListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaListagemClientes listarClientes = new TelaListagemClientes();
				listarClientes.frmListagemDeClientes.setVisible(true);				

			}
		});
		mntmListar.setIcon(new ImageIcon("D:\\FACULDADE\\Eclipse - Senac\\Icones\\icons8-card\u00E1pio-26.png"));
		mnClientes.add(mntmListar);
		
		JMenuItem mntmExcluir_2 = new JMenuItem("Excluir");
		mntmExcluir_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaExclusaoCliente exlcuirClientes = new TelaExclusaoCliente();
				exlcuirClientes.frmExclusaoCliente.setVisible(true);				

			}
		});
		mntmExcluir_2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
		mntmExcluir_2.setIcon(new ImageIcon("D:\\FACULDADE\\Eclipse - Senac\\Icones\\icons8-remover-usu\u00E1rio-masculino-26.png"));
		mnClientes.add(mntmExcluir_2);
		
		//----------- ENDEREÇOS
		JMenu mnProdutos = new JMenu("  Endereços     ");
		mnProdutos.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnProdutos.setIcon(new ImageIcon("D:\\FACULDADE\\Eclipse - Senac\\adrian-abdesalan-senac-dd-2020-1\\icones\\icons8-endere\u00E7o-50.png"));
		menuBar.add(mnProdutos);
		
		JMenuItem mntmCadastrar_1 = new JMenuItem("Cadastrar");
		mntmCadastrar_1.setIcon(new ImageIcon("D:\\FACULDADE\\Eclipse - Senac\\Icones\\icons8-inserir-p\u00E1gina-24.png"));
		mntmCadastrar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaCadastroEndereco cadastrarClientes = new TelaCadastroEndereco();
				cadastrarClientes.frmCadastroEnderecos.setVisible(true);	
				
			}
		});
		mnProdutos.add(mntmCadastrar_1);
		
		JMenuItem mntmExcluir = new JMenuItem("Excluir");
		mntmExcluir.setIcon(new ImageIcon("D:\\FACULDADE\\Eclipse - Senac\\Icones\\icons8-excluir-24.png"));
		mntmExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaExclusaoEndereco excluirEndereco = new TelaExclusaoEndereco();
				excluirEndereco.frmExclusaoEnderecos.setVisible(true);	
				
			}
		});
		mnProdutos.add(mntmExcluir);
		
		//----------- TELEFONES
		JMenu mnFuncionrios = new JMenu("  Números     ");
		mnFuncionrios.setIcon(new ImageIcon("D:\\FACULDADE\\Eclipse - Senac\\Icones\\icons8-telefone-celular-50.png"));
		mnFuncionrios.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(mnFuncionrios);
		
		JMenuItem mntmCadastar = new JMenuItem("Cadastar");
		mntmCadastar.setIcon(new ImageIcon("D:\\FACULDADE\\Eclipse - Senac\\Icones\\icons8-rede-phonelink-24.png"));
		mntmCadastar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//				TelaCadastroTelefone cadastrarTelefone = new TelaCadastroTelefone();

				if (cadastrarTelefone == null || !cadastrarTelefone.isVisible()) {
					cadastrarTelefone = new TelaCadastroTelefone();
					desktopPane.add(cadastrarTelefone);
					cadastrarTelefone.show();
				}
				
			}
		});
		mnFuncionrios.add(mntmCadastar);
		
		JMenuItem mntmConsultar = new JMenuItem("Consultar");
		mntmConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaListagemTelefones listarTelefones = new TelaListagemTelefones();
				listarTelefones.frmListagemTelefones.setVisible(true);
				
			}
		});
		mntmConsultar.setIcon(new ImageIcon("D:\\FACULDADE\\Eclipse - Senac\\Icones\\icons8-configura\u00E7\u00E3o-de-phonelink-24.png"));
		mnFuncionrios.add(mntmConsultar);
		
		//----------- SOBRE
		JMenu mnSobre = new JMenu("  Sobre");
		mnSobre.setIcon(new ImageIcon("D:\\FACULDADE\\Eclipse - Senac\\Icones\\icons8-sobre-50.png"));
		mnSobre.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(mnSobre);
		
		JMenuItem mntmManual = new JMenuItem("Manual");
		mntmManual.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F10, 0));
		mnSobre.add(mntmManual);
		
		//----------- CORPO
		desktopPane = new JDesktopPane();
		
		desktopPane.setBackground(Color.GRAY);
		desktopPane.setBounds(5, 5, 1000, 800);
		getContentPane().add(desktopPane);
		
		//----------- FOOTER
		JLabel lblDesenvolvidoPorAdrian = new JLabel("Desenvolvido por Adrian Salomon Ferreira Abdesalan");
		lblDesenvolvidoPorAdrian.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblDesenvolvidoPorAdrian.setToolTipText("");
		lblDesenvolvidoPorAdrian.setHorizontalAlignment(SwingConstants.CENTER);
		desktopPane.add(lblDesenvolvidoPorAdrian, BorderLayout.SOUTH);
		

	}

}
