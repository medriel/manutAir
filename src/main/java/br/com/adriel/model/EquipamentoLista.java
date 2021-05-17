package br.com.adriel.model;

import java.util.ArrayList;
import java.util.List;

public class EquipamentoLista {

    private static List<Equipamento> equipamento = new ArrayList<Equipamento>();

    public List<Equipamento> getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(List<Equipamento> equipamento) {
        this.equipamento = equipamento;
    }

    public void adicionarEquipamento(Equipamento equipamento) {
        this.equipamento.add(equipamento);
    }

    public void removerEquipamento(Equipamento equipamento) {
        this.equipamento.remove(equipamento);
    }

    public void reiniciarLista() {
        this.equipamento = new ArrayList<Equipamento>();
    }
}
