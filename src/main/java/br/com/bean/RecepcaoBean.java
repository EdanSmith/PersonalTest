package br.com.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class RecepcaoBean {

	public String redirecionar(String viewName) {
		return (viewName + "?faces-redirect=true");
	}
}
