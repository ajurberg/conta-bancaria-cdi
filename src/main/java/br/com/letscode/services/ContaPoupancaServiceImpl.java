package br.com.letscode.services;

import br.com.letscode.domains.Conta;
import br.com.letscode.domains.ContaEnum;
import br.com.letscode.exceptions.NoClientException;
import br.com.letscode.exceptions.SaldoInsuficienteException;
import br.com.letscode.views.TipoConta;
import jakarta.inject.Inject;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

@TipoConta(value = ContaEnum.POUPANCA)
public class ContaPoupancaServiceImpl implements ContaService {

    public static final double TAXA_POUPANCA = 0.0007; // 0.07%

    @Inject
    private Conta conta;

    @Override
    public Conta criarConta(Conta conta) {
        conta.setCaminhoArquivo("[Teste] Conta especial"); // Dao
        if (null == conta.getCliente()) {
            throw new NoClientException("Cliente inexistente");
        }
        conta.setSaldo(new BigDecimal(100));
        System.out.println("Conta poupança criada. \n Você tem um saldo de R$" + conta.getSaldo() + ".\n");
        return conta;
    }

    @Override
    public BigDecimal depositar(BigDecimal valor) throws SaldoInsuficienteException {
        conta.setSaldo(conta.getSaldo().add(getValorTaxadoPoupanca(valor)));
        return conta.getSaldo();
    }

    @Override
    public BigDecimal sacar(BigDecimal valor) throws SaldoInsuficienteException {
        if (conta.getSaldo().compareTo(valor) > 0) {
            conta.setSaldo(conta.getSaldo().subtract(getValorTaxadoPoupanca(valor)));
            return conta.getSaldo();
        }
        throw new SaldoInsuficienteException();
    }

    @Override
    public BigDecimal transferir(BigDecimal valor, Conta recebedora) {
        if (conta.getSaldo().compareTo(valor) > 0) {
            recebedora.setSaldo(recebedora.getSaldo().add(getValorTaxadoPoupanca(valor)));
            return conta.getSaldo().subtract(valor);
        }
        throw new SaldoInsuficienteException();
    }

    @Override
    public String consultarSaldo() {
        return NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR")).format(conta.getSaldo());
    }

    private BigDecimal getValorTaxadoPoupanca(BigDecimal valor) {
        return valor.subtract(valor.multiply(BigDecimal.valueOf(TAXA_POUPANCA)));
    }
}
