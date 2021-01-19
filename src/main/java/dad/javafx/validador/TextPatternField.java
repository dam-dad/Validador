package dad.javafx.validador;

import java.util.regex.Pattern;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.TextField;

public class TextPatternField extends TextField {

	private Pattern pattern;
	private StringProperty regex = new SimpleStringProperty("");
	
	public TextPatternField() {
		super();
		regex.addListener((o, ov, nv) -> {
			pattern = Pattern.compile(nv);
			System.out.println("pattern=" + nv);
		});
		regex.set("^.*$");
	}

	@Override
	public void replaceText(int start, int end, String text) {
		String newText = getText().substring(0, start) + text + getText().substring(end);
		if (pattern.matcher(newText).matches()) {
			super.replaceText(start, end, text);
		}
	}

	@Override
	public void replaceSelection(String text) {
		int start = getSelection().getStart();
		int end = getSelection().getEnd();
		String newText = getText().substring(0, start) + text + getText().substring(end);
		if (pattern.matcher(newText).matches()) {
			super.replaceSelection(text);
		}
	}

	public final StringProperty regexProperty() {
		return this.regex;
	}

	public final String getRegex() {
		return this.regexProperty().get();
	}

	public final void setRegex(final String regex) {
		this.regexProperty().set(regex);
	}

}
