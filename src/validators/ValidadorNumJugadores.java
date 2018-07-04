package validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("validadorMinJugadores")
public class ValidadorNumJugadores implements Validator{

	@Override
	public void validate(FacesContext contex, UIComponent comp, Object value) throws ValidatorException{
		
		if(((int)value) < 2){
			FacesMessage mensaje = new FacesMessage();
			mensaje.setSummary("Error de número de jugadores.");
			mensaje.setDetail("Error de número de jugadores: debe haber al menos 2.");
			mensaje.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(mensaje);
		}
	}
}
