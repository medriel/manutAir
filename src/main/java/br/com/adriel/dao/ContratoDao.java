package br.com.adriel.dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;

import br.com.adriel.model.Contrato;
import br.com.adriel.model.Equipamento;

public class ContratoDao {
    private static String arquivo = "contrato.xml";

    public static List<Contrato> getLista() {
        XStream xs = new XStream();
        File f = new File(arquivo);

        if (!f.exists()) {
            return new ArrayList<Contrato>();
        }

        List<Contrato> contratos = (List<Contrato>) xs.fromXML(f);
        return contratos;
    }

    public void gravar(Contrato conTrato) throws IOException {
        List<Contrato> contratos = getLista();

        if (contratos == null) {
            contratos = new ArrayList<Contrato>();
        }
        contratos.add(conTrato);

        XStream xs = new XStream();
        String xml = xs.toXML(contratos);

        FileWriter fw = new FileWriter(arquivo);
        fw.write(xml);
        fw.close();

        Contrato.setProxNum(contratos.size() + 1);
    }

    public void atualizar(Contrato conTrato, List<Equipamento> equipamento) {
        List<Contrato> contrato = getLista();

        for (Contrato c : contrato) {
            if (c.getProxNum().equals(conTrato.getProxNum())) {
                c.setEquipamento(equipamento);
            }
        }

        XStream xs = new XStream();
        String xml = xs.toXML(contrato);

        try {
            FileWriter fw = new FileWriter(arquivo);
            fw.write(xml);
            fw.close();

            Contrato.setProxNum(contrato.size() + 1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public int getProxNum() {
        return this.getLista().size();
    }
}
