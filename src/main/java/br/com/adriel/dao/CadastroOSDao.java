package br.com.adriel.dao;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;

import br.com.adriel.model.CadastroOS;
import br.com.adriel.model.Usuario;

public class CadastroOSDao {
	private static String arquivo = "ordemServico.xml";

	public List<CadastroOS> getList() {
		XStream xs = new XStream();
		File file = new File(this.arquivo);

		if (!file.exists())
			return new ArrayList<CadastroOS>();
		List<CadastroOS> ordemServico = (List<CadastroOS>) xs.fromXML(file);

		return ordemServico;
	}

	public void atualizar(CadastroOS cadastroOS, Usuario tecnico, String data, String hora, String status) {
		List<CadastroOS> cadastroOSs = getList();

		for (CadastroOS cadOs : cadastroOSs) {
			if (cadOs.getDescricao().equals(cadastroOS.getDescricao())
					&& cadOs.getEndereco().equals(cadastroOS.getEndereco())) {
				cadOs.alocarTecnico(tecnico);
				cadOs.atribuirDataHora(data, hora);
				cadOs.atualizarStatus(status);
			}
		}

		XStream xs = new XStream();
		String xml = xs.toXML(cadastroOSs);

		try {
			FileWriter fw = new FileWriter(arquivo);
			fw.write(xml);
			fw.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void gravar(CadastroOS cadastroServico) {
		List<CadastroOS> cadastroServicos = getList();
		if (cadastroServicos == null)
			cadastroServicos = new ArrayList<CadastroOS>();
		cadastroServicos.add(cadastroServico);

		XStream xs = new XStream();
		String xml = xs.toXML(cadastroServicos);

		try {
			FileWriter fw = new FileWriter(arquivo);
			fw.write(xml);
			fw.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public List<CadastroOS> buscarOS(String status, String login) {
		List<CadastroOS> oSs = getList();
		List<CadastroOS> osFiltrada = new ArrayList<CadastroOS>();

		for (CadastroOS o : oSs) {
			if (o.getTecnico() == null)
				continue;
			if (o.getTecnico().getLogin().equals(login) && o.getStatus().equals(status)) {
				osFiltrada.add(o);
			}
		}
		return osFiltrada;

	}

	public List<CadastroOS> buscarOSStatus(String status) {
		List<CadastroOS> oSs = getList();
		List<CadastroOS> osFiltrada = new ArrayList<CadastroOS>();

		for (CadastroOS o : oSs) {
			if (o.getStatus().equals(status)) {
				osFiltrada.add(o);
			}
		}
		return osFiltrada;
	}
}
