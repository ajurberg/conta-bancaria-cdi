package br.com.letscode.services;

import br.com.letscode.Dao.ClienteDao;
import br.com.letscode.domains.Cliente;
import br.com.letscode.exceptions.NoClientException;
import br.com.letscode.exceptions.PrecondicaoException;
import jakarta.inject.Inject;

import java.io.IOException;

public class ClienteServiceImpl implements ClienteService {

    @Inject
    private ClienteDao clienteDAO;

    @Override
    public Cliente criarCliente(Cliente cliente) throws PrecondicaoException {
        if (cliente.getIdade() > 18) {
            return clienteDAO.create(cliente);
        }
        throw new PrecondicaoException("Usuário com precondições não satisfeitas");
    }

    @Override
    public Cliente consultarCliente(String nome, String senha) throws IOException {
        for (Cliente cliente : clienteDAO.lerArquivo(nome)) {
            if (cliente.getNome().equals(nome) && cliente.getSenha().equals(senha)) {
                return cliente;
            } else {
                throw new NoClientException("Cliente não encontrado");
            }
        }
        return null;
    }

    @Override
    public void escreverArquivo(Cliente cliente) throws IOException {
        clienteDAO.escreverArquivo(cliente);
    }
}
