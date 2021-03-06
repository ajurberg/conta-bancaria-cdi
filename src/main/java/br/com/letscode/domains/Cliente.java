package br.com.letscode.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    private String nome;
    private Integer idade;
    private String cpf;
    private String senha;
    private String caminhoArquivo;

}
