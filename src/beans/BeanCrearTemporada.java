package beans;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import controlador.Controlador;
import modelo.Usuario;

@ManagedBean(name="beanTemporada")
@SessionScoped
public class BeanCrearTemporada {

	private String nombre;
	private String lugar;
	private int minimo;

	public BeanCrearTemporada() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public int getMinimo() {
		return minimo;
	}

	public void setMinimo(int minimo) {
		this.minimo = minimo;
	}


	public String submit() {
		if (Controlador.getUnicaInstancia().obtenerTemporada(nombre) != null){
			FacesContext.getCurrentInstance().addMessage("nombre", new FacesMessage("Nombre ya utilizado."));
			return "temporadafallo";
		}
		else {
			Controlador.getUnicaInstancia().registroTemporada(nombre, lugar, minimo);
			return "listatemporada";
		}
	}
	
}
