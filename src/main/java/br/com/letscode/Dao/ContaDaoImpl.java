package br.com.letscode.Dao;

import br.com.letscode.domains.Conta;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContaDaoImpl implements ContaDao {

    List<Conta> contas = new ArrayList<>();

    @Override
    public void atualizarArquivo(Conta conta) {
        contas.add(conta);
        try {
            var myWriter = new FileWriter("contas.csv");
            myWriter.write(String.valueOf(contas));
            myWriter.close();
        } catch (IOException e) {
            System.out.println("Operação não realizada");
            e.printStackTrace();
        }
    }

}
