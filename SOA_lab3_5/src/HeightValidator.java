import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


@FacesValidator("HeightValidator")
public class HeightValidator implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object value) throws ValidatorException {
        Object genderObj = uiComponent.getAttributes().get("gender");

        int height = (int) value;
        if (genderObj == null && (height < 150 || height > 185))
        {
            FacesMessage msg =
                    new FacesMessage("Musisz podać wzrost od 150 do 200 cm.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }

        if (genderObj == null) return;

        String gender = genderObj.toString();
        if (gender.equals("m") && (height < 165 || height > 200))
        {
            FacesMessage msg =
                    new FacesMessage("Musisz podać wzrost od 165 do 200 cm.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }

        if (gender.equals("f") && (height < 150 || height > 185))
        {
            FacesMessage msg =
                    new FacesMessage("Musisz podać wzrost od 150 do 185 cm.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
        if (gender.equals("o") && (height < 150 || height > 185))
        {
            FacesMessage msg =
                    new FacesMessage("Musisz podać wzrost od 150 do 200 cm.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
}