package validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("validadorMovil")
public class ValidadorMovil implements Validator{

	@Override
	public void validate(FacesContext contex, UIComponent comp, Object value) throws ValidatorException{
		
		if(((String)value).length() != 9){
			FacesMessage mensaje = new FacesMessage();
			mensaje.setSummary("Error de movil.");
			mensaje.setDetail("Error de movil: debe tener 9 dígitos.");
			mensaje.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(mensaje);
		}
	}
}
