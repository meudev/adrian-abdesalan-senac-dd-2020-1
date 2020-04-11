package controller.exercicio1;

import java.util.ArrayList;

import model.bo.exercicio1.EnderecoBO;
import model.dao.exercicio1.ClienteDAO;
import model.dao.exercicio1.EnderecoDAO;
import model.vo.exercicio1.Cliente;
import model.vo.exercicio1.Endereco;

public class EnderecoController {

	private static final int TAMANHO_MINIMO_CAMPO_RUA = 3;
	private static final int TAMANHO_MAXIMO_CAMPO_RUA = 255;

	private static final int TAMANHO_MINIMO_CAMPO_CIDADE = 3;
	private static final int TAMANHO_MAXIMO_CAMPO_CIDADE = 255;

	private EnderecoBO bo = new EnderecoBO();
	private EnderecoDAO dao = new EnderecoDAO();

	//LISTAR TODOS ENDEREÇOS
	public ArrayList<Endereco> listarTodosOsEnderecos() {
		return dao.consultarTodos();
	}

	//EXCLUIR ENDEREÇO
	public String excluir(String textoIdSelecionado) {
		String mensagem = "";
		try {
			int idSelecionado = Integer.parseInt(textoIdSelecionado);
			mensagem = bo.excluir(idSelecionado);
		} catch (NumberFormatException ex) {
			mensagem = "Informe um número inteiro";
		}
		return mensagem;
	}

	//SALVAR NOVO ENDEREÇO
	public String salvar(String rua, String bairro, String numero, String cep, String cidade, String estado) {
		String mensagem = "";
		
		cep = cep.replace("-", "");

		//VALIDAR DADOS PREENCHIDOS
		mensagem += validarCampoDeTexto("Rua", rua, TAMANHO_MINIMO_CAMPO_RUA, TAMANHO_MAXIMO_CAMPO_RUA, true);
		mensagem += validarCampoDeTexto("Cidade", cidade, TAMANHO_MINIMO_CAMPO_CIDADE, TAMANHO_MAXIMO_CAMPO_CIDADE,	true);
		mensagem += validarCampoDeTexto("Sigla do estado", estado, 2, 2, true);

		if (mensagem.isEmpty()) {
			Endereco novoEndereco = new Endereco(rua, cep, estado, cidade, bairro, numero);
			mensagem = bo.salvar(novoEndereco);
		}

		return mensagem;
	}

	//VALIDAÇÃO DE CAMPOS
	private String validarCampoDeTexto(String nomeDoCampo, String valor, int tamanhoMinimo, int tamanhoMaximo, boolean obrigatorio) {
		String mensagemValidacao = "";

//		if (obrigatorio && valor != null && !valor.isEmpty() || valor.length() < tamanhoMinimo || valor.length() > tamanhoMaximo) {
//				mensagemValidacao = nomeDoCampo +"  "+ valor + " deve possuir pelo menos " + tamanhoMinimo + " e no máximo "
//						+ tamanhoMaximo + " caracteres \n";
//		}
		
		if (!obrigatorio && valor == null && valor.isEmpty() || valor.length() < tamanhoMinimo || valor.length() > tamanhoMaximo) {
		mensagemValidacao = nomeDoCampo +"  "+ valor + " deve possuir pelo menos " + tamanhoMinimo + " e no máximo "
				+ tamanhoMaximo + " caracteres \n";
		}

		return mensagemValidacao;
	}

}
