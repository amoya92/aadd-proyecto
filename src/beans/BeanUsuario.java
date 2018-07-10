package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import controlador.Controlador;

@ManagedBean(name="beanUsuario")
@SessionScoped
public class BeanUsuario {
	
	private String valorBoton;

	public String comprobarLogin() {
		if(Controlador.getUnicaInstancia().getUsuarioActual() == null) {
			return "login";
		} else {
			Controlador.getUnicaInstancia().setUsuarioActual(null);
			return "index";
		}
	}
	
	public String getValorBoton() {
		if(Controlador.getUnicaInstancia().getUsuarioActual() == null) {
			return "Login";
		} else {
			return "Hola, " + Controlador.getUnicaInstancia().getUsuarioActual().getUsuario() + " | Logout";
		}
	}
}
