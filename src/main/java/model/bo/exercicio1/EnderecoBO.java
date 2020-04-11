package model.bo.exercicio1;

import java.util.ArrayList;

import model.dao.exercicio1.ClienteDAO;
import model.dao.exercicio1.EnderecoDAO;
import model.vo.exercicio1.Cliente;
import model.vo.exercicio1.Endereco;

public class EnderecoBO {

	private EnderecoDAO dao = new EnderecoDAO();
	
	//EXCLUIR ENDERE�O
	public String excluir(int idSelecionado) {
		String mensagem = "";

		ClienteDAO clienteDAO = new ClienteDAO();
		if (clienteDAO.temClienteMorandoNoEndereco(idSelecionado)) {
			mensagem = "Endere�o informado n�o pode ser exclu�do, pois existe cliente morando nele.";
		} else {
			if (dao.excluir(idSelecionado)) {
				mensagem = "Exclu�do com sucesso";
			} else {
				mensagem = "Erro ao excluir";
			}
		}

		return mensagem;
	}

	//SALVAR NO ENDERE�O
	public String salvar(Endereco novoEndereco) {
		String mensagem = "";

		novoEndereco = dao.salvar(novoEndereco);

		if (novoEndereco.getId() > 0) {
			mensagem = "Salvo com sucesso";
		} else {
			mensagem = "Erro ao salvar";
		}

		return mensagem;
	}

}