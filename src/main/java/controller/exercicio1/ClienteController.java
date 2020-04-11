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

	public String excluir(String textCPF) {
		String mensagem = "";
		try {
			int cpfSelecionado = Integer.parseInt(textCPF);
			mensagem = bo.excluir(cpfSelecionado);
		} catch (NumberFormatException ex) {
			mensagem = "Informe apenas números. ";
		}
		return mensagem;
	}
}
