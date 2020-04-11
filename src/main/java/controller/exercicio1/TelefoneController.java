package controller.exercicio1;

import model.bo.exercicio1.TelefoneBO;
import model.vo.exercicio1.Cliente;
import model.vo.exercicio1.Telefone;

public class TelefoneController {
	
	private static final int TAMANHO_MINIMO_CAMPO_NUMERO = 8;
	private static final int TAMANHO_MAXIMO_CAMPO_NUMERO = 9;

	private TelefoneBO bo = new TelefoneBO();

	/**
	 * Salva um novo telefone, validando os valores informados
	 * 
	 * @param novoTelefone o telefone a ser salvo;
	 * @return uma mensagem informando uma das opções a seguir:
	 * 
	 *         (1) à campos para ajustar
	 * 
	 *         (2) salvo com sucesso
	 * 
	 *         (3) erro ao salvar
	 */
	public String salvar(Telefone novoTelefone) {
		String mensagemValidacao = validarCampos(novoTelefone);

		if (mensagemValidacao.isEmpty()) {
			mensagemValidacao = bo.salvar(novoTelefone);
		}
		return mensagemValidacao;
	}

	private String validarCampos(Telefone novoTelefone) {
		String mensagem = "";

		if (novoTelefone == null) {
			mensagem = "Telefone não foi criado";
		} else {
			if (novoTelefone.getDdd().trim().length() != 2) {
				mensagem += "Informe o DDD com 2 dígitos \n";
			}

			try {
				Integer.parseInt(novoTelefone.getDdd());
			} catch (NumberFormatException ex) {
				mensagem += "O DDD deve ser um NÚMERO";
			}
		}

		// TODO fazer mais validações
		// Numero

		// Codigo pais
		return mensagem;
	}

	
	//SALVAR NO TELEFONE
	public String salvar(String ddd, String numero, Cliente cliente) {
		String mensagem = "";
		
		mensagem += validarCampoNumerico("DDD", ddd, 2, 2, true);
		mensagem += validarCampoNumerico("Número", numero, TAMANHO_MINIMO_CAMPO_NUMERO, TAMANHO_MAXIMO_CAMPO_NUMERO, true);
				
		if (mensagem.isEmpty()) {
			boolean movel = false;
			boolean ativo = false;
			String codigoPais = "55";
			int id = 0;
			
			if(numero.length() == 9) {
				movel = true;
			}
			if(cliente != null) {
				ativo = true;
			}
			
			Telefone novoTelefone = new Telefone(id, cliente, codigoPais, ddd, numero, movel, ativo);
			mensagem = bo.salvar(novoTelefone);
		}
		
		return mensagem;
	}
	
	//VALIDAR DADOS DIGITADOS
	private String validarCampoNumerico(String nomeDoCampo, String valor, int tamanhoMinimo, int tamanhoMaximo, boolean obrigatorio) {
		String mensagemValidacao = "";

		if (obrigatorio && valor != null && !valor.isEmpty() || valor.length() < tamanhoMinimo || valor.length() > tamanhoMaximo) {
				mensagemValidacao = nomeDoCampo +"  "+ valor + " deve possuir pelo menos " + tamanhoMinimo + " e no máximo "
						+ tamanhoMaximo + " caracteres \n";
			}

		return mensagemValidacao;
	}

}
