package controller.exercicio1;

import java.util.ArrayList;

import model.bo.ClienteBO;
import model.dao.exercicio1.ClienteDAO;
import model.vo.exercicio1.Cliente;

public class ClienteController {

	private ClienteBO bo = new ClienteBO();
	private ClienteDAO dao = new ClienteDAO();

	public ArrayList<Cliente> listarTodosOsClientes() {
		return dao.consultarTodos();
	}

	public String excluirCPF(String textCPF) {
		String mensagem = "";

		if(textCPF.length() == 11) {
			mensagem = bo.excluirCPF(textCPF);
		} else {
			mensagem = "CPF inválido. ";
		}

		return mensagem;
	}
}
