package dad.javafx.validador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.controlsfx.validation.Severity;
import org.controlsfx.validation.ValidationResult;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.util.converter.NumberStringConverter;

public class Controller implements Initializable {
	
	private IntegerProperty numero1 = new SimpleIntegerProperty();
	private IntegerProperty numero3 = new SimpleIntegerProperty();
	
	@FXML
	private VBox view;
	
	@FXML
	private TextField numero1Text, numero2Text;

	@FXML
	private IntegerField numero3Text;

	@FXML
	private Button pulsameButton;

	public Controller() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/View.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		numero1Text.textProperty().bindBidirectional(numero1, new NumberStringConverter());
		numero3Text.numberProperty().bindBidirectional(numero3);
		
		Validator<String> oneCharValidator =  (control, value) -> ValidationResult.fromMessageIf(control, "El campo debe contenerun sólo caracter", Severity.ERROR, value.length() != 1);

		ValidationSupport support = new ValidationSupport();
	    support.registerValidator(numero1Text, true, new IntegerValidator());
	    support.registerValidator(numero2Text, false, oneCharValidator);
	    support.invalidProperty().addListener((o, ov, nv) -> System.out.println(nv ? "is invalid" : "is valid"));
	    
	    pulsameButton.disableProperty().bind(support.invalidProperty());
	    
	    numero1.addListener((o, ov, nv) -> System.out.println("ov=" + ov + "/nv=" + nv));
	    numero3.addListener((o, ov, nv) -> System.out.println("ov=" + ov + "/nv=" + nv));
	    
	}
	
	public VBox getView() {
		return view;
	}

}
