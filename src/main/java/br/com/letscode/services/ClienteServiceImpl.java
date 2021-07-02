package br.com.letscode.services;

import br.com.letscode.Dao.ClienteDao;
import br.com.letscode.domains.Cliente;
import br.com.letscode.exceptions.PrecondicaoException;
import jakarta.inject.Inject;

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
    public void consultarCliente(String nome) {
        // TODO implementar busca
    }
}
