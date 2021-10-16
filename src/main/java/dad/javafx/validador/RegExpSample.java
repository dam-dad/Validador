package dad.javafx.validador;

import java.util.regex.Pattern;

public class RegExpSample {

	public static void main(String[] args) {

		System.out.println(Pattern.matches("\\w+@[a-zA-Z]+\\.[a-zA-Z0-9]+", "peric09@gmail.es"));
		
	}

}
