package br.com.letscode.views;

import br.com.letscode.domains.Cliente;
import br.com.letscode.exceptions.PrecondicaoException;

import java.io.IOException;
import java.util.Scanner;

public interface ClienteView {

    Cliente criarCliente(Scanner sc) throws PrecondicaoException;

    Cliente login(Scanner sc) throws IOException;

}
