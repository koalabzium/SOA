package pl.agh.kis.soa;

import pl.agh.kis.soa.ejb3.server.impl.Payment;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


@FacesValidator("PaymentValidator")
public class PaymanetValidator implements Validator {

    @EJB
    Payment payment;

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {



    }
}
