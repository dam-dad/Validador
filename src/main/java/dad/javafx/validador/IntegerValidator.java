package dad.javafx.validador;

import org.controlsfx.validation.Severity;
import org.controlsfx.validation.ValidationResult;
import org.controlsfx.validation.Validator;

import javafx.scene.control.Control;

public class IntegerValidator implements Validator<String> {

	@Override
	public ValidationResult apply(Control control, String value) {
   		boolean condition = false;
		try {
			Integer.parseInt(value);
		} catch (NumberFormatException e) {
			condition = true;
		}
        return ValidationResult.fromMessageIf(control, "Debe introducir un número", Severity.ERROR, condition);
	}
	
}
