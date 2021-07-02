package br.com.letscode.domains;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Conta {

    private int numeroConta;
    private String senha;
    private Cliente cliente;
    private String caminhoArquivo;
    private BigDecimal saldo = BigDecimal.valueOf(0);

}
