package model.bo.exercicio1;

import model.dao.exercicio1.ClienteDAO;
import model.vo.exercicio1.Cliente;

public class ClienteBO {

	private ClienteDAO dao = new ClienteDAO();

	public String salvar(Cliente cliente) {
		String mensagem = "";
		
		if(dao.cpfJaUtilizado(cliente.getCpf())) {
			mensagem = "CPF informado (" + cliente.getCpf() + ") j� foi utilizado";
		}else {
			cliente = dao.salvar(cliente);
			
			if(cliente.getId() > 0) {
				mensagem = "Cliente salvo com sucesso";
			}else {
				mensagem = "Erro ao salvar cliente";
			}
		}
		
		return mensagem;
	}
	
	public String excluirCPF(String cpfSelecionado) {
		String mensagem = "";

		if (dao.temClienteTemTelefone(cpfSelecionado)) {
			mensagem = "Cliente informado n�o pode ser exclu��do, pois existe telefone registrado em seu nome.";
		} else {
			if (dao.excluirCPF(cpfSelecionado)) {
				mensagem = "Exclu��do com sucesso";
			} else {
				mensagem = "Erro ao excluir";
			}
		}

		return mensagem;
	}

}
