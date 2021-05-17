package br.com.adriel.dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;

import br.com.adriel.model.Cliente;
import br.com.adriel.model.ClientePF;

public class ClientePFDao {
    private static String arquivo = "clientepf.xml";

    public static List<ClientePF> getLista() {
        XStream xs = new XStream();
        File f = new File(arquivo);

        if (!f.exists()) {
            return new ArrayList<ClientePF>();
        }

        List<ClientePF> clientespf = (List<ClientePF>) xs.fromXML(f);
        return clientespf;
    }

    public List<Cliente> getListaGenerica() {
        XStream xs = new XStream();
        File file = new File(this.arquivo);

        if (!file.exists())
            return new ArrayList<Cliente>();
        List<ClientePF> clientepf = (List<ClientePF>) xs.fromXML(file);

        List<Cliente> clienteGenerico = new ArrayList<Cliente>();
        for (ClientePF c : clientepf) {
            clienteGenerico.add(new Cliente(c.getNome(), c.getTelefone(), c.getEndereco()));
        }

        return clienteGenerico;
    }

    public ClientePF buscarCliente(Cliente cliente) {
        List<ClientePF> clientepf = this.getLista();
        for (ClientePF c : clientepf) {
            if (c.getNome().equals(cliente.getNome()) && c.getEndereco().equals(cliente.getEndereco())
                    && c.getTelefone().equals(cliente.getTelefone())) {
                return c;
            }
        }
        return null;
    }

    public boolean isClientPF(Cliente cliente) {
        File file = new File(this.arquivo);

        List<ClientePF> clientepf = this.getLista();
        for (ClientePF c : clientepf) {
            if (c.getNome().equals(cliente.getNome()) && c.getEndereco().equals(cliente.getEndereco())
                    && c.getTelefone().equals(cliente.getTelefone())) {
                return true;
            }
        }

        return false;
    }

    public void gravar(ClientePF cliEntePf) throws IOException {
        List<ClientePF> clientespf = getLista();

        if (clientespf == null) {
            clientespf = new ArrayList<ClientePF>();
        }
        clientespf.add(cliEntePf);

        XStream xs = new XStream();
        String xml = xs.toXML(clientespf);

        FileWriter fw = new FileWriter(arquivo);
        fw.write(xml);
        fw.close();
    }
}
