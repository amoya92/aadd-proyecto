package validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("validadorTanteo")
public class ValidadorTanteo implements Validator{

	@Override
	public void validate(FacesContext contex, UIComponent comp, Object value) throws ValidatorException{
		
		if(((int)value) < 0){
			FacesMessage mensaje = new FacesMessage();
			mensaje.setSummary("Error de tanteo.");
			mensaje.setDetail("Error tanteo: no puede ser inferior a 0.");
			mensaje.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(mensaje);
		}
	}
}
