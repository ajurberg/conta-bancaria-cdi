package br.com.letscode.application;

import br.com.letscode.domains.Cliente;
import br.com.letscode.domains.Conta;
import br.com.letscode.exceptions.PrecondicaoException;
import br.com.letscode.views.ClienteView;
import br.com.letscode.views.ContaView;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aplicacao {

    private List<Cliente> clientes;

    @Inject
    private ClienteView clienteView;

    @Inject
    private ContaView contaView;

    @PostConstruct
    public void iniciar() {
        System.out.println("Iniciando a aplicação");
        clientes = new ArrayList<>();
    }

    public void createCliente(Scanner sc) throws PrecondicaoException {
        getClientes().add(clienteView.criarCliente(sc));
    }

    public Conta createConta(Scanner sc) {
        return contaView.create(sc);
    }

    public List<Cliente> getClientes() { return clientes; }

    public ContaView getContaView() {
        return contaView;
    }

    public ClienteView getClienteView() {
        return clienteView;
    }

    public Cliente getUsuario(Scanner sc) throws IOException {
        return clienteView.login(sc);
    }

    public Cliente login(Scanner sc) throws IOException {
        return clienteView.login(sc);
    }

}
