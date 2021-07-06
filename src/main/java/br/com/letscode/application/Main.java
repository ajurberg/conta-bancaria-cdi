package br.com.letscode.application;

import br.com.letscode.domains.Cliente;
import br.com.letscode.domains.Conta;
import br.com.letscode.domains.ContaEnum;
import br.com.letscode.exceptions.PrecondicaoException;
import br.com.letscode.views.ClienteView;
import br.com.letscode.views.ClienteViewImpl;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, PrecondicaoException {
        final WeldContainer container = new Weld().initialize(); // Cria o container
        final Aplicacao aplicacao = container.select(Aplicacao.class).get(); // Cria uma primeira classe dentro do container
        init(aplicacao);
    }

    private static void init(Aplicacao aplicacao) throws PrecondicaoException, IOException {
        int opcao = 0;
        System.out.println("Bem vindo");
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("O que você gostaria de fazer? \n 1- Cadastrar cliente \n 2- Criar conta \n 3- Acessar conta \n 0- Sair \n");
            opcao = sc.nextInt();
            definirOpcao(sc, opcao, aplicacao);
        } while (opcao>0);
    }

    private static void definirOpcao(Scanner sc, int opcao, Aplicacao aplicacao) throws PrecondicaoException, IOException {
        ClienteViewImpl login = new ClienteViewImpl();
        switch (opcao) {
            case 1:
                // Faz o cadastro do cliente
                aplicacao.createCliente(sc);
                aplicacao.getClientes().stream()
                        .map(Cliente::getCaminhoArquivo).forEach(System.out::println);
                break;
            case 2:
                aplicacao.createConta(sc);
                break;
            case 3:
                aplicacao.login(sc);
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Por favor, digite um valor válido.");
        }
    }

    private static void visualizarMenu(Aplicacao aplicacao, Scanner sc) {

    }

}
