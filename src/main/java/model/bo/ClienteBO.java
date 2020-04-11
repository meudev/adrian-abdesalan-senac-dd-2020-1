package model.bo;

import model.dao.exercicio1.ClienteDAO;
import model.vo.exercicio1.Cliente;

public class ClienteBO {

	private ClienteDAO dao = new ClienteDAO();
	/**
	 * Tenta salvar um cliente novo, validando o CPF
	 * @param cliente o Cliente a ser salvo no banco
	 * @return
	 */
	public String salvar(Cliente cliente) {
		String mensagem = "";
		
		if(dao.cpfJaUtilizado(cliente.getCpf())) {
			mensagem = "CPF informado (" + cliente.getCpf() + ") já foi utilizado";
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
	
	public String excluir(int cpfSelecionado) {
		String mensagem = "";

		if (dao.excluirCPF(cpfSelecionado)) {
			mensagem = "Excluído com sucesso";
		} else {
			mensagem = "Erro ao excluir";
		}

		return mensagem;
	}

}
