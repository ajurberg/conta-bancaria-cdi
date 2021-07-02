package br.com.letscode.views;

import br.com.letscode.domains.Conta;
import br.com.letscode.domains.ContaEnum;
import br.com.letscode.factory.ContaFactory;
import br.com.letscode.services.ContaService;
import jakarta.inject.Inject;

import java.util.Scanner;

public class ContaViewImpl implements ContaView {

    @Inject
    private ContaFactory contaFactory;

    @Override
    public Conta create(Scanner sc) {
        int opcao = 0;
        do {
            System.out.println("Tipo de conta: \n 1- Conta corrente \n 2- Conta Poupança \n 3- Conta Especial \n");
            opcao = sc.nextInt();
            definirOpcao(sc, opcao);
        } while (opcao > 0);
        return null;
    }

    private Conta definirOpcao(Scanner sc, int opcao) {
        Conta conta = new Conta();
        ContaEnum contaEnum = null;
        switch (opcao) {
            case 1:
                contaEnum = ContaEnum.CORRENTE;
                break;
            case 2:
                contaEnum = ContaEnum.POUPANCA;
                break;
            case 3:
                contaEnum = ContaEnum.ESPECIAL;
                break;
        }
        ContaService contaService = contaFactory.createConta(contaEnum);
        return contaService.criarConta(conta);
    }


}
