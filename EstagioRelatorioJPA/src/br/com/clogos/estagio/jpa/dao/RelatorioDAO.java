package br.com.clogos.estagio.jpa.dao;

import java.util.List;

import br.com.clogos.estagio.model.Aluno;
import br.com.clogos.estagio.model.Relatorio;

public interface RelatorioDAO {
	Boolean existeRelatorioPreenchido(Aluno aluno);
	List<Relatorio> findRelatoriosAdmin(Relatorio relatorio);
	Boolean updateValidarRelatorio(Long id, String observacao);
}
