package br.com.letscode.views;

import br.com.letscode.domains.Cliente;
import br.com.letscode.exceptions.PrecondicaoException;
import br.com.letscode.services.ClienteService;
import br.com.letscode.factory.ContaFactory;
import jakarta.inject.Inject;

import java.io.IOException;
import java.util.Scanner;

public class ClienteViewImpl implements ClienteView {

    @Inject
    private ClienteService clienteService; // Só tem um tipo de Cliente

    @Inject
    private ContaFactory contaFactory;

    @Override
    public Cliente criarCliente(Scanner sc) throws PrecondicaoException {
        Cliente cliente = new Cliente();
        System.out.println("Informe o nome do cliente: ");
        cliente.setNome(sc.next());
        System.out.println("Informe a sua idade: ");
        cliente.setIdade(sc.nextInt());
        System.out.println("Cadastre a sua senha: ");
        cliente.setSenha(sc.next());
        System.out.printf("Cliente %s criado com sucesso %n", cliente.getNome());
        try {
            return clienteService.criarCliente(cliente); // Delega para o usuárioService para validar a regra de negocio para criar o Usuário. Quem cria é o Dao
        } catch (PrecondicaoException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public Cliente login(Scanner sc) throws IOException {
        Cliente cliente = new Cliente();
        System.out.println("Por favor, digite o seu cpf: ");
        cliente.setCpf(sc.next());
        System.out.println("Por favor, digite a sua senha de quatro dígitos: ");
        cliente.setSenha(sc.next());
        return clienteService.consultarCliente(cliente.getNome(), cliente.getSenha());
    }
}
