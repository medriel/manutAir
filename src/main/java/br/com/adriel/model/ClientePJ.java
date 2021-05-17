package br.com.adriel.model;

public class ClientePJ extends Cliente {

    private String razaoSocial;
    private String cnpj;

    public ClientePJ(String nome, String telefone, String endereco, String razaoSocial, String cpnj) {
        super(nome, telefone, endereco);
        this.razaoSocial = razaoSocial;
        this.cnpj = cpnj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "CNPJ: " + cnpj;
    }

}
