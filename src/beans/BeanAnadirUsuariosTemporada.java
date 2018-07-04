package beans;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import controlador.Controlador;
import modelo.Temporada;
import modelo.Usuario;

@ManagedBean(name="beanAnadirUsuariosTemporada")
@SessionScoped
public class BeanAnadirUsuariosTemporada {

	private String nombre;
	
	private Collection<Temporada> temporadas;
	
	private Collection<Usuario> usuarios;
	private String[] checked;

	public BeanAnadirUsuariosTemporada() {
		this.usuarios = new LinkedList<Usuario>();
	}
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Collection<Usuario> getUsuarios() {
		this.usuarios = new LinkedList<Usuario>();
		this.usuarios.addAll(Controlador.getUnicaInstancia().listarUsuarios());
		return this.usuarios;
		/*List<Usuario> todosUsuarios = Controlador.getUnicaInstancia().listarUsuarios();
		for (Usuario usuario : todosUsuarios) {
			usuarios.add(usuario);
		}
		return usuarios;*/
	}
	
	

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public Collection<Temporada> getTemporadas(){
		this.temporadas = Controlador.getUnicaInstancia().listarTemporadas();
		return this.temporadas;
	}
	
	public void setTemporadas(Collection<Temporada> temporadas) {
		this.temporadas = temporadas;
	}


	public String submit() {
		String cadena = "";
		for(int i = 0; i < checked.length; i++) {
			 cadena += checked[i] + " ";
		}
		System.out.println("Nombre = " + this.nombre + "Usuarios = " + cadena);
		if(this.nombre != null && this.nombre != "") {
			Temporada temporada = Controlador.getUnicaInstancia().obtenerTemporada(nombre);
			if (temporada == null){
				//FacesContext.getCurrentInstance().addMessage("nombre", new FacesMessage("Nombre ya utilizado."));
				return "temporadafallo";
			}
			else {
				for(int i = 0; i<this.checked.length; i++){
					Controlador.getUnicaInstancia().anadirUsuarioTemporada(nombre, checked[i]);
				}
				return "listatemporada";
			}
		}
		return "temporadafallo";
	}
	
	public String[] getChecked() {
		return checked;
	}

	public void setChecked(String[] checked) {
		this.checked = checked;
	}
	
}
