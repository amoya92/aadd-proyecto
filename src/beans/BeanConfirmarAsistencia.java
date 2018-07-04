package beans;

import java.util.Collection;
import java.util.LinkedList;

import controlador.Controlador;
import modelo.Partido;
import modelo.Temporada;

public class BeanConfirmarAsistencia {

	private Collection<Partido> partidos;

	private Long[] checked;


	public Collection<Partido> getPartidos() {
		this.partidos = new LinkedList<Partido>();
		for (Temporada temporada : Controlador.getUnicaInstancia().getUsuarioActual().getTemporadas()) {
			partidos.addAll(temporada.getPartidos());
		}
		return partidos;
	}

	public void setPartidos(Collection<Partido> partidos) {
		this.partidos = partidos;
	}

	public Long[] getChecked() {
		return checked;
	}

	public void setChecked(Long[] checked) {
		this.checked = checked;
	}

	public String submit() {

		for (Partido partido : partidos) {
			for (int i = 0; i < this.checked.length; i++) {
				if (checked[i] == partido.getId())
					Controlador.getUnicaInstancia().confirmarAsistencia(checked[i], Controlador.getUnicaInstancia().getUsuarioActual().getUsuario());
			}

		}
		return "confirmacionaceptada";

	}
}
