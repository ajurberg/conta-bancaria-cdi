package br.com.letscode.Dao;

import br.com.letscode.domains.Cliente;
import br.com.letscode.exceptions.PrecondicaoException;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClienteFileDaoImpl implements ClienteDao {

    List<Cliente> clientes = new ArrayList<>();

    @Override
    public Cliente create(Cliente cliente) throws PrecondicaoException {
        cliente.setCaminhoArquivo("Caminho do usuario");
        return cliente;
    }

    @Override
    public void escreverArquivo(Cliente cliente) {
        clientes.add(cliente);
        try {
            var myWriter = new FileWriter("clientes.csv");
            myWriter.write(String.valueOf(clientes));
            myWriter.close();
        } catch (IOException e) {
            System.out.println("Operação não realizada");
            e.printStackTrace();
        }
    }

    @Override
    public List<Cliente> lerArquivo(String nome) throws IOException {
        return clientes;
    }
}
