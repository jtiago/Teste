package br.com.clogos.estagio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.clogos.estagio.jpa.dao.ObjectModel;

@Entity
@Table(name="PERFIL")
public class Perfil implements ObjectModel {
	private static final long serialVersionUID = -1232891701475637425L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idperfil")
	private Long id;
	@Column(name="nomeperfil", length=25)
	private String nome;
	
	@Column(length=1)
	private Boolean cadastroAluno;
	@Column(length=1)
	private Boolean cadastroCampo;
	@Column(length=1)
	private Boolean cadastroSupervisor;
	@Column(length=1)
	private Boolean cadastroTurma;
	@Column(length=1)
	private Boolean liberarRelatorio;
	@Column(length=1)
	private Boolean relatorioAluno;
	@Column(length=1)
	private Boolean relatorioAdmin;
	@Column(length=1)
	private Boolean revisaoRelatorio;
	
//	update perfil set cadastroAluno = 1, cadastroCampo = 1, cadastroSupervisor = 1, cadastroTurma = 1, liberarrelatorio = 1, relatorioAdmin = 1,
//			relatorioAluno = 0, revisaoRelatorio = 0 where idperfil = 1;
	
//	update perfil set cadastroAluno = 0, cadastroCampo = 0, cadastroSupervisor = 0, cadastroTurma = 0, liberarrelatorio = 0, relatorioAdmin = 0,
//			relatorioAluno = 1, revisaoRelatorio = 1 where idperfil = 2;
	
//	insert into usuario (cpfusuario,nomeusuario,senhausuario,fkperfil)
//	values ('22222222222', 'Arruda', 'MjI=', 1)

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

	public Boolean getCadastroAluno() {
		return cadastroAluno;
	}

	public void setCadastroAluno(Boolean cadastroAluno) {
		this.cadastroAluno = cadastroAluno;
	}

	public Boolean getCadastroCampo() {
		return cadastroCampo;
	}

	public void setCadastroCampo(Boolean cadastroCampo) {
		this.cadastroCampo = cadastroCampo;
	}

	public Boolean getCadastroSupervisor() {
		return cadastroSupervisor;
	}

	public void setCadastroSupervisor(Boolean cadastroSupervisor) {
		this.cadastroSupervisor = cadastroSupervisor;
	}

	public Boolean getCadastroTurma() {
		return cadastroTurma;
	}

	public void setCadastroTurma(Boolean cadastroTurma) {
		this.cadastroTurma = cadastroTurma;
	}

	public Boolean getLiberarRelatorio() {
		return liberarRelatorio;
	}

	public void setLiberarRelatorio(Boolean liberarRelatorio) {
		this.liberarRelatorio = liberarRelatorio;
	}

	public Boolean getRelatorioAluno() {
		return relatorioAluno;
	}

	public void setRelatorioAluno(Boolean relatorioAluno) {
		this.relatorioAluno = relatorioAluno;
	}

	public Boolean getRelatorioAdmin() {
		return relatorioAdmin;
	}

	public void setRelatorioAdmin(Boolean relatorioAdmin) {
		this.relatorioAdmin = relatorioAdmin;
	}

	public Boolean getRevisaoRelatorio() {
		return revisaoRelatorio;
	}

	public void setRevisaoRelatorio(Boolean revisaoRelatorio) {
		this.revisaoRelatorio = revisaoRelatorio;
	}
}
