package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import java.util.Date;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import modelo.Partido;
import modelo.Temporada;
import modelo.Usuario;
import controlador.Controlador;

@ManagedBean(name = "beanVerPartido")
@SessionScoped
public class BeanVerTemporada {

	@ManagedProperty(value = "#{param.id}")
	private String id;
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	

	public String getNombre(){
		return Controlador.getUnicaInstancia().obtenerTemporada(this.id).getNombre();
	}
	
	public String getLugar(){
		return Controlador.getUnicaInstancia().obtenerTemporada(this.id).getLugar();
	}
	
	public int getMinimo(){
		return Controlador.getUnicaInstancia().obtenerTemporada(this.id).getMinimo();
	}
	
	public Collection<Usuario> getUsuarios(){
		return Controlador.getUnicaInstancia().obtenerTemporada(this.id).getUsuarios();
	}
	
	public Collection<Partido> getPartidos(){
		return Controlador.getUnicaInstancia().obtenerTemporada(this.id).getPartidos();
	}

	
}
