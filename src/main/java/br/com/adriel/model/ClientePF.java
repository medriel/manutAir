package br.com.adriel.model;

public class ClientePF extends Cliente {

    private String cpf;

    public ClientePF(String nome, String telefone, String endereco, String cpf) {
        super(nome, telefone, endereco);
        this.cpf = cpf;

    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "CPF: " + cpf;
    }
}
