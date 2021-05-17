package br.com.adriel.model;

public class Equipamento {

    private String marca;
    private String modelo;
    private String sn;

    public Equipamento(String marca, String modelo, String sn) {
        this.marca = marca;
        this.modelo = modelo;
        this.sn = sn;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    @Override
    public String toString() {
        return "Modelo:" + modelo;
    }
}
