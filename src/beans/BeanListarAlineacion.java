package beans;

import java.util.Collection;
import java.util.LinkedList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import controlador.Controlador;
import modelo.Alineacion;
import modelo.Temporada;

@ManagedBean(name = "BeanListarAlineacion")
@SessionScoped
public class BeanListarAlineacion {

	private Collection<Alineacion> alineaciones;

	public Collection<Alineacion> getAlineaciones() {
		alineaciones = Controlador.getUnicaInstancia().listarAlineaciones();
		return alineaciones;
	}

	public void setAlineaciones(Collection<Alineacion> alineaciones) {
		this.alineaciones = alineaciones;
	}
	
	
}
