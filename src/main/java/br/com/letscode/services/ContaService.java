package br.com.letscode.services;

import br.com.letscode.domains.Conta;
import br.com.letscode.exceptions.SaldoInsuficienteException;

import java.math.BigDecimal;

public interface ContaService {

    Conta criarConta(Conta conta); // A interface precisa ter uma assinatura de cadastro da conta
    BigDecimal depositar(BigDecimal valor) throws SaldoInsuficienteException;
    BigDecimal sacar(BigDecimal valor) throws SaldoInsuficienteException;
    BigDecimal transferir(BigDecimal valor, Conta recebedora);
    String consultarSaldo();

}
