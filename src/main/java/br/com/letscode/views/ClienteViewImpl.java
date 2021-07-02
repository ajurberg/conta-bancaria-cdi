package br.com.letscode.views;

import br.com.letscode.domains.Cliente;
import br.com.letscode.exceptions.PrecondicaoException;
import br.com.letscode.services.ClienteService;
import br.com.letscode.factory.ContaFactory;
import jakarta.inject.Inject;

import java.util.Scanner;

public class ClienteViewImpl implements ClienteView {

    @Inject
    private ClienteService clienteService; // Só tem um tipo de Cliente

    @Inject
    private ContaFactory contaFactory;

    @Override
    public Cliente create(Scanner sc) {
        Cliente cliente = new Cliente();
        System.out.println("Informe o nome do cliente: ");
        cliente.setNome(sc.next());
        System.out.printf("Cliente %s criado com sucesso %n", cliente.getNome());
        try {
            return clienteService.criarCliente(cliente); // Delega para o usuárioService para validar a regra de negocio para criar o Usuário. Quem cria é o Dao
        } catch (PrecondicaoException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

}
