package controlador;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import modelo.Alineacion;
import modelo.Color;
import modelo.Partido;
import modelo.Temporada;
import modelo.Usuario;

public class Controlador {
	
	private static Controlador unicaInstancia;
	private ControladorRemote practicaFinal;

	private Controlador(){
		try {
			practicaFinal=(ControladorRemote) new InitialContext().lookup("java:global/PracticaFinalEJB/ControladorRemoto");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static Controlador getUnicaInstancia(){
		if(unicaInstancia == null){
			unicaInstancia = new Controlador();
		}
		return unicaInstancia;
	}
	
	public Usuario getUsuarioActual(){
		return practicaFinal.getUsuarioActual();
	}
	
	public void setUsuarioActual(Usuario usuario) {
		practicaFinal.setUsuarioActual(usuario);;
	}

	public Usuario registrarUsuario(String usuario, String clave, String mail, String movil){
		return practicaFinal.registrarUsuario(usuario, clave, mail, movil);
		
	}
	
	public boolean login(String usuario, String clave){
		return practicaFinal.login(usuario, clave);
	}
	
	public Usuario obtenerUsuario(String usuario){
		return practicaFinal.obtenerUsuario(usuario);
	}
	
	public Usuario actualizarUsuario(String usuario, String clave, String mail, String movil){
		return practicaFinal.actualizarUsuario(usuario, clave, mail, movil);
	}
	
	public List<Usuario> listarUsuarios(){
		return practicaFinal.listarUsuarios();
	}
	
	public Temporada registroTemporada(String nombre, String lugar, int minimo){
		return practicaFinal.registroTemporada(nombre, lugar, minimo);
	}
	
	public List<Temporada> listarTemporadas(){
		return practicaFinal.listarTemporadas();
	}
	
	public Temporada anadirUsuarioTemporada(String temporada, String usuario){
		return practicaFinal.anadirUsuarioTemporada(temporada, usuario);
	}
	
	public Temporada quitarUsuarioTemporada(String temporada, String usuario){
		return practicaFinal.quitarUsuarioTemporada(temporada, usuario);
	}
	
	public Temporada obtenerTemporada(String temporada){
		return practicaFinal.obtenerTemporada(temporada);
	}
	
	public Partido obtenerPartido(Long partido){
		return practicaFinal.obtenerPartido(partido);
	}
	
	public Partido registrarPartido(Date fecha, String temporada){
		return practicaFinal.registrarPartido(fecha, temporada);
	}
	
	public Partido confirmarAsistencia(Long id, String usuario){
		return practicaFinal.confirmarAsistencia(id, usuario);
	}
	
	public Alineacion registrarAlineacion(Long idPartido, String nombre, Color color, int tanteo){
		return practicaFinal.registrarAlineacion(idPartido, nombre, color, tanteo);
	}
	
	public Alineacion registrarUsuariosAlineacion(String usuario, String alineacion){
		return practicaFinal.registrarUsuariosAlineacion(usuario, alineacion);
	}
	
	
	public List<Partido> obtenerPartidoEntreFechas(Date f1, Date f2){
		return practicaFinal.obtenerPartidoEntreFechas(f1, f2);
	}
	
	public List<Partido> obtenerPartidoTemporada(String temporada){
		return practicaFinal.obtenerPartidoTemporada(temporada);
	}

	public Collection<Partido> listarPartidos() {
		return practicaFinal.listarPartidos();
	}

	public Collection<Alineacion> listarAlineaciones() {
		return practicaFinal.listarAlineaciones();
	}

	public Object verAlineacion(String nombre) {
		return practicaFinal.verAlineacion(nombre);
	}
}
