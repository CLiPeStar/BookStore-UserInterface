package tools;

import java.util.regex.Pattern;

public class Validations {
	public static boolean letterValidation(String name) {
		return Pattern.matches("[a-zA-Z\\s]+", name);
	}

	public static boolean ISBNValidation(String name) {
		return Pattern.matches("\\d{13}", name);

	}

	public static boolean IsNamberFloat(String name) {
		try {
			Float.parseFloat(name);
			char charAt = name.charAt(name.length() - 1);
			if (charAt == 'f' || charAt == 'd')
				return false;
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
