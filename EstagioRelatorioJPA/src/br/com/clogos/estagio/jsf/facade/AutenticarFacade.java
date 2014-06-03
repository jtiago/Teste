package br.com.clogos.estagio.jsf.facade;

import java.io.IOException;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import br.com.clogos.estagio.jpa.controller.AutenticarController;
import br.com.clogos.estagio.jpa.controller.GenericController;
import br.com.clogos.estagio.model.Aluno;
import br.com.clogos.estagio.model.Perfil;

public class AutenticarFacade implements Serializable {
	private static final long serialVersionUID = 1L;
	private AutenticarController autenticarController;
	private List<Perfil> listaPerfil;
	
	@SuppressWarnings("unchecked")
	public List<Perfil> getListaPerfil() {
		if(listaPerfil == null) {
			GenericController genericController = new GenericController();
			listaPerfil = (List<Perfil>) genericController.findAll(Perfil.class, "nome", "desc");
		}
		return listaPerfil;
	}
	
	public void login(Aluno usuario) {
		usuario.setCpf(usuario.getCpf().replace(".", "").replace("-", ""));
		Aluno alunoLogado = getAutenticarController().validarAutenticacao(usuario);
		
		try {
			if(alunoLogado != null) { 
				HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance()
						.getExternalContext().getRequest();
				request.getSession().setAttribute("usuarioLogado", alunoLogado);
				FacesContext.getCurrentInstance().getExternalContext().redirect((
						new StringBuilder(String.valueOf(request.getContextPath()))).append("/pages/home.jsf").toString());
			} else {
				usuario = null;
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Login ou Senha Invalida.", ""));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("rawtypes")
	public void logout() {
		try {
			HttpServletRequest servletRequest = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
			Enumeration enumeration = servletRequest.getSession().getAttributeNames();
			
			while(enumeration.hasMoreElements()){
				servletRequest.getSession().removeAttribute(enumeration.nextElement().toString());
			}
			servletRequest.getSession().invalidate();
			FacesContext.getCurrentInstance().getExternalContext().redirect(servletRequest.getContextPath()+"/");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public AutenticarController getAutenticarController() {
		return autenticarController == null ? autenticarController = new AutenticarController() : autenticarController;
	}
	

}
