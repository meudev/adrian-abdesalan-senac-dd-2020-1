package controller.exercicio1;

import java.util.ArrayList;


import model.bo.exercicio1.ClienteBO;
import model.dao.exercicio1.ClienteDAO;
import model.vo.exercicio1.Cliente;
import model.vo.exercicio1.Endereco;

public class ClienteController {

	private static final int TAMANHO_MINIMO_CAMPO_NOME = 2;
	private static final int TAMANHO_MAXIMO_CAMPO_NOME = 255;

	private static final int TAMANHO_MINIMO_CAMPO_SOBRENOME = 2;
	private static final int TAMANHO_MAXIMO_CAMPO_SOBRENOME= 255;
	
	private ClienteBO bo = new ClienteBO();
	private ClienteDAO dao = new ClienteDAO();

	
	//LISTAR TODOS CLIENTES
	public ArrayList<Cliente> listarTodosOsClientes() {
		return dao.consultarTodos();
	}

	//EXCLUIR CLIENTE VIA CPF
	public String excluirCPF(String textCPF) {
		String mensagem = "";
		
		textCPF = removerFormatacaoCPF(textCPF);
		
		if(textCPF.length() == 11) {
			mensagem = bo.excluirCPF(textCPF);
		} else {
			mensagem = "CPF inválido. "+ textCPF;
		}

		return mensagem;
	}
	
	//SALVAR NOVO CLIENTE
	public String salvar(String nome, String sobrenome, String cpf, Endereco endereco) {
		String mensagem = "";
		
		cpf = removerFormatacaoCPF(cpf);

		mensagem += validarCampoDeTexto("Nome", nome, TAMANHO_MINIMO_CAMPO_NOME, TAMANHO_MAXIMO_CAMPO_NOME, true);
		mensagem += validarCampoDeTexto("Sobrenome", sobrenome, TAMANHO_MINIMO_CAMPO_SOBRENOME, TAMANHO_MAXIMO_CAMPO_SOBRENOME, true);
		mensagem += validarCampoDeTexto("CPF", cpf, 11, 11, true);
		
		if(endereco != null) {
			mensagem += "Selecione um endereço";
		} else {
		
			if (mensagem.isEmpty()) {
				Cliente novoCliente = new Cliente(nome, sobrenome, cpf, null, null);
				mensagem = bo.salvar(novoCliente);
			}
		}


		return mensagem;
	}

	//VALIDAÇÃO DE CAMPOS
	private String validarCampoDeTexto(String nomeDoCampo, String valor, int tamanhoMinimo, int tamanhoMaximo, boolean obrigatorio) {
		String mensagemValidacao = "";

		if (obrigatorio && valor != null && !valor.isEmpty() || valor.length() < tamanhoMinimo || valor.length() > tamanhoMaximo) {
				mensagemValidacao = nomeDoCampo +"  "+ valor + " deve possuir pelo menos " + tamanhoMinimo + " e no máximo "
						+ tamanhoMaximo + " caracteres \n";
			}

		return mensagemValidacao;
	}
	
	//RETIRA A FORMATAÇÃO DO CPF
	private String removerFormatacaoCPF(String cpfFormatado) {
		
		cpfFormatado = cpfFormatado.replace(".", "");
		cpfFormatado = cpfFormatado.replace("-", "");
		
		return cpfFormatado;
	}
}
