package model.bo.exercicio1;

import java.util.ArrayList;

import model.dao.exercicio1.ClienteDAO;
import model.vo.exercicio1.Cliente;

public class ClienteBO {

	private ClienteDAO dao;

	public ArrayList<Cliente> pesquisarTodos() {
		return dao.consultarTodos();
	}
	
	public String excluir(String cpfSelecionado) {
		String mensagem = "";

		if (dao.temClienteTemTelefone(cpfSelecionado)) {
			mensagem = "Cliente informado não pode ser excluí­do, pois existe telefone registrado em seu nome.";
		} else {
			if (dao.excluirCPF(cpfSelecionado)) {
				mensagem = "Excluí­do com sucesso";
			} else {
				mensagem = "Erro ao excluir";
			}
		}

		return mensagem;
	}

	// TODO criar os métodos para chamar os métodos PÚBLICOS no ClienteDAO
}
