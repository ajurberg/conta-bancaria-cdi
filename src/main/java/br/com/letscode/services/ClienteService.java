package br.com.letscode.services;

import br.com.letscode.domains.Cliente;
import br.com.letscode.exceptions.PrecondicaoException;

import java.io.IOException;

public interface ClienteService {

    // A interface precisa ter uma assinatura de cadastro do cliente
    Cliente criarCliente(Cliente cliente) throws PrecondicaoException;
    Cliente consultarCliente(String nome, String senha) throws IOException;
    void escreverArquivo(Cliente cliente) throws IOException;

}
