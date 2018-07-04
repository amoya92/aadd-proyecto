package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.util.Collection;

import modelo.Color;
import modelo.Partido;
import controlador.Controlador;

@ManagedBean(name = "beanCrearAlineacion")
@SessionScoped
public class BeanCrearAlineacion {

	private String nombre;

	private int tanteo;

	private Color color;
	
	private Long partidoId;
	
	private Collection<Partido> partidos;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTanteo() {
		return tanteo;
	}

	public void setTanteo(int tanteo) {
		this.tanteo = tanteo;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Long getPartidoId() {
		return partidoId;
	}

	public void setPartidoId(Long partidoId) {
		this.partidoId = partidoId;
	}

	public Collection<Partido> getPartidos() {
		partidos = Controlador.getUnicaInstancia().listarPartidos();
		return partidos;
	}

	public void setPartidos(Collection<Partido> partidos) {
		this.partidos = partidos;
	}
	
	public String submit() {
		System.out.println("Nombre" + nombre + " Color = " + color + "Partido = " + partidoId);
		Controlador.getUnicaInstancia().registrarAlineacion(partidoId, nombre, color, tanteo);
		return "listaalineacion";
	}
	
	
}
