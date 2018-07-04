package beans;

import java.util.Collection;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import controlador.Controlador;
import modelo.Partido;

@ManagedBean(name = "BeanListarPartidos")
@SessionScoped
public class BeanListarPartidos {
	
	private Collection<Partido> partidos;

	public Collection<Partido> getPartidos() {
		partidos = Controlador.getUnicaInstancia().listarPartidos();
		return partidos;
	}

	public void setPartidos(Collection<Partido> partidos) {
		this.partidos = partidos;
	}
	
	

}
