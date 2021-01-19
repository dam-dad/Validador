package dad.javafx.validador;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;

public class IntegerField extends TextField {

	private IntegerProperty number = new SimpleIntegerProperty();
	
	public IntegerField() {
		this(0);
	}

	public IntegerField(Integer number) {
		super();
		
		textProperty().bindBidirectional(this.number, new StringConverter<Number>() {
			@Override
			public Number fromString(String string) {
				if (string == null || string.isEmpty()) return null;
				try {
					return Integer.parseInt(string);
				} catch (NumberFormatException e) {
					return null;
				}
			}
			@Override
			public String toString(Number object) {
				if (object == null) return null;
				return "" + object;
			}
		});
	}

	public final IntegerProperty numberProperty() {
		return this.number;
	}

	public final int getNumber() {
		return this.numberProperty().get();
	}

	public final void setNumber(final int number) {
		this.numberProperty().set(number);
	}

}
