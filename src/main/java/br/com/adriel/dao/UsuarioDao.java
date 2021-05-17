package br.com.adriel.dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;

import br.com.adriel.model.Usuario;

public class UsuarioDao {
    private static String arquivo = "usuario.xml";

    public static List<Usuario> getLista() {
        XStream xs = new XStream();
        File f = new File(arquivo);

        if (!f.exists()) {
            return new ArrayList<Usuario>();
        }

        List<Usuario> usuarios = (List<Usuario>) xs.fromXML(f);
        return usuarios;
    }

    public void gravar(Usuario usuArio) throws IOException {
        List<Usuario> usuarios = getLista();

        if (usuarios == null) {
            usuarios = new ArrayList<Usuario>();
        }
        usuarios.add(usuArio);

        XStream xs = new XStream();
        String xml = xs.toXML(usuarios);

        FileWriter fw = new FileWriter(arquivo);
        fw.write(xml);
        fw.close();
    }

    public static Usuario autenticar(String login, String senha) {
        List<Usuario> usuarios = getLista();

        for (Usuario u : usuarios) {
            if (u.getLogin().equals(login) && u.getSenha().equals(senha)) {
                return u;
            }
        }
        return null;
    }

    public static List<Usuario> buscarTecnico() {
        List<Usuario> usuarios = getLista();
        List<Usuario> tecnicos = new ArrayList<Usuario>();

        for (Usuario tec : usuarios) {
            if (tec.getCargo().equals("Tecnico")) {
                tecnicos.add(tec);
            }
        }
        return tecnicos;
    }
}
