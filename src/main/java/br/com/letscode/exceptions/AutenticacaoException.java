package br.com.letscode.exceptions;

public class AutenticacaoException extends RuntimeException {
    public AutenticacaoException() { super("Erro de autenticação."); }
}
