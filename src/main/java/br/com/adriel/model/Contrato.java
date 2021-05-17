package br.com.adriel.model;

import java.util.ArrayList;
import java.util.List;

import br.com.adriel.dao.ContratoDao;

public class Contrato {

    private List<Equipamento> equipamento = new ArrayList<Equipamento>();

    private Integer numeroContrato;
    private Cliente cliente;
    private String data;
    private String duracao;

    private static Integer proxNum = new ContratoDao().getProxNum();

    public Contrato(List<Equipamento> equipamento, Cliente cliente, String data, String duracao) {
        this.equipamento = equipamento;
        this.cliente = cliente;
        this.data = data;
        this.duracao = duracao;
        this.numeroContrato = proxNum;
    }

    public List<Equipamento> getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(List<Equipamento> equipamento) {
        this.equipamento = equipamento;
    }

    public Integer getNumeroContrato() {
        return numeroContrato;
    }

    public void setNumeroContrato(Integer numeroContrato) {
        this.numeroContrato = numeroContrato;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public static Integer getProxNum() {
        return proxNum;
    }

    public static void setProxNum(Integer proxNum) {
        Contrato.proxNum = new ContratoDao().getProxNum();
    }

    @Override
    public String toString() {
        return "Contrato: " + numeroContrato;
    }
}
