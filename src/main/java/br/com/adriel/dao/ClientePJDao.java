package br.com.adriel.dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;

import br.com.adriel.model.Cliente;
import br.com.adriel.model.ClientePJ;

public class ClientePJDao {

    private static String arquivo = "clientepj.xml";

    public static List<ClientePJ> getLista() {
        XStream xs = new XStream();
        File f = new File(arquivo);

        if (!f.exists()) {
            return new ArrayList<ClientePJ>();
        }

        List<ClientePJ> clientespj = (List<ClientePJ>) xs.fromXML(f);
        return clientespj;
    }

    public List<Cliente> getListaGenerica() {
        XStream xs = new XStream();
        File file = new File(this.arquivo);

        if (!file.exists())
            return new ArrayList<Cliente>();
        List<ClientePJ> clientepj = (List<ClientePJ>) xs.fromXML(file);

        List<Cliente> clienteGenerico = new ArrayList<Cliente>();
        for (ClientePJ c : clientepj) {
            clienteGenerico.add(new Cliente(c.getNome(), c.getTelefone(), c.getEndereco()));
        }

        return clienteGenerico;
    }

    public ClientePJ buscarCliente(Cliente cliente) {
        List<ClientePJ> clientepj = this.getLista();
        for (ClientePJ c : clientepj) {
            if (c.getNome().equals(cliente.getNome()) && c.getEndereco().equals(cliente.getEndereco())
                    && c.getTelefone().equals(cliente.getTelefone())) {
                return c;
            }
        }
        return null;
    }

    public void gravar(ClientePJ cliEntePj) throws IOException {
        List<ClientePJ> clientespj = getLista();

        if (clientespj == null) {
            clientespj = new ArrayList<ClientePJ>();
        }
        clientespj.add(cliEntePj);

        XStream xs = new XStream();
        String xml = xs.toXML(clientespj);

        FileWriter fw = new FileWriter(arquivo);
        fw.write(xml);
        fw.close();
    }
}
