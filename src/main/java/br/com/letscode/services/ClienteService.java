package br.com.letscode.services;

import br.com.letscode.domains.Cliente;
import br.com.letscode.exceptions.PrecondicaoException;

public interface ClienteService {

    // A interface precisa ter uma assinatura de cadastro do cliente
    Cliente criarCliente(Cliente cliente) throws PrecondicaoException;
    void consultarCliente(String nome);

}
