package br.com.adriel.model;

public class CadastroOS {
	private Contrato contrato;
	private String endereco;
	private Equipamento equipamento;
	private String descricao;
	private Usuario tecnico;
	private String data;
	private String hora;
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getData() {
		return data;
	}

	public String getHora() {
		return hora;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public CadastroOS(Contrato contrato, String endereco, Equipamento equipamento, String descricao) {
		this.contrato = contrato;
		this.endereco = endereco;
		this.equipamento = equipamento;
		this.descricao = descricao;
		this.tecnico = null;
	}

	public void alocarTecnico(Usuario tecnico) {
		this.tecnico = tecnico;
	}

	public void atribuirDataHora(String data, String hora) {
		this.data = data;
		this.hora = hora;
	}

	public void atualizarStatus(String status) {
		this.status = status;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Usuario getTecnico() {
		return tecnico;
	}

	public void setTecnico(Usuario tecnico) {
		this.tecnico = tecnico;
	}

	@Override
	public String toString() {
		return "OS do Contrato: " + contrato + " Equipamento-" + equipamento + "Tecnico -" + tecnico + "->" + status;
	}
}
