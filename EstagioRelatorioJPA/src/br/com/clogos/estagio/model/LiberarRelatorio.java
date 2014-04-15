package br.com.clogos.estagio.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.clogos.estagio.enums.ModuloEnum;

@Entity
@Table(name = "LIBERARRELATORIO")
public class LiberarRelatorio implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idliberar")
	private Long id;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fkturma",  referencedColumnName = "idaluno")
	private Aluno turma;
	
	@Enumerated(EnumType.STRING)
	private ModuloEnum modulo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Aluno getTurma() {
		return turma;
	}

	public void setTurma(Aluno turma) {
		this.turma = turma;
	}

	public ModuloEnum getModulo() {
		return modulo;
	}

	public void setModulo(ModuloEnum modulo) {
		this.modulo = modulo;
	}
}
