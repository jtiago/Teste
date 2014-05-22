package br.com.clogos.estagio.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.clogos.estagio.jpa.dao.ObjectModel;

@Entity
@Table(name="SUPERVISOR")
public class Supervisor implements ObjectModel {
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idsupervisor")
	private Long id;
	
	@Column(name="nomesupervisor", length=100, nullable=false)
	private String nome;
	
	@OneToMany(mappedBy = "supervisor")
	private List<CampoEstagio> campoEstagio;
	
	@OneToMany(mappedBy = "supervisor")
	private List<Relatorio> relatorios;
	
	@OneToOne(cascade=CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JoinColumn(name="fkimagem", referencedColumnName="idimagem")
	private ImagemAssinatura imagem;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<CampoEstagio> getCampoEstagio() {
		return campoEstagio;
	}

	public void setCampoEstagio(List<CampoEstagio> campoEstagio) {
		this.campoEstagio = campoEstagio;
	}

	public ImagemAssinatura getImagem() {
		return imagem;
	}

	public void setImagem(ImagemAssinatura imagem) {
		this.imagem = imagem;
	}

	public List<Relatorio> getRelatorios() {
		return relatorios;
	}

	public void setRelatorios(List<Relatorio> relatorios) {
		this.relatorios = relatorios;
	}
	
	
}
