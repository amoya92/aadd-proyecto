package beans;

import javax.faces.bean.ManagedBean;

import controlador.Controlador;

@ManagedBean(name="beanLogin")
public class BeanLogin {

	private String nombre;
	
	private String password;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String submit(){
		if(Controlador.getUnicaInstancia().login(nombre, password)){
			return "bienvenido";
		}
		else{
			System.out.println("FALLO LOGIN");
			return null;
		}
	}
}
