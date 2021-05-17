package br.com.adriel.model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    static public List<Usuario> listUsuario = new ArrayList<Usuario>();

    private String login;
    private String senha;
    private String cargo;
    private static String loginAtual;

    public static List<Usuario> getListUsuario() {
        return listUsuario;
    }

    public static void setListUsuario(List<Usuario> listUsuario) {
        Usuario.listUsuario = listUsuario;
    }

    public static String getLoginAtual() {
        return loginAtual;
    }

    public static void setLoginAtual(String loginAtual) {
        Usuario.loginAtual = loginAtual;
    }

    public Usuario(String login, String senha, String cargo) {
        this.login = login;
        this.senha = senha;
        this.cargo = cargo;
    }

    public Usuario(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void gravar() {
        Usuario.listUsuario.add(this);
    }

    public List<Usuario> getListUsuarios() {
        return listUsuario;
    }

    @Override
    public String toString() {
        return login;
    }

}
