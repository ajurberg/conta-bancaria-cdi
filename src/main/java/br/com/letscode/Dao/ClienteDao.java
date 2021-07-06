package br.com.letscode.Dao;

import br.com.letscode.domains.Cliente;
import br.com.letscode.exceptions.PrecondicaoException;

import java.io.IOException;
import java.util.List;

public interface ClienteDao {

    Cliente create(Cliente cliente) throws PrecondicaoException;
    void escreverArquivo(Cliente cliente);
    List<Cliente> lerArquivo(String nome) throws IOException;

}
