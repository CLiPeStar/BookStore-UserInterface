package tools;

import java.util.regex.Pattern;

public class Validations {
	public static boolean letterValidation(String name, String fieldName) {
		boolean valido = true;
		if (!Pattern.matches("[a-zA-Z\\s]+", name)) {
			DialogBookStore.errorField(fieldName);
			valido = false;
		}
		return valido;
	}

	public static boolean ISBNValidation(String name) {
		return Pattern.matches("\\d{13}", name);

	}

	public static boolean IsNamberFloat(String name, String fieldName) {
		try {
			Float.parseFloat(name);
			char charAt = name.charAt(name.length() - 1);
			if (charAt == 'f' || charAt == 'd') {
				DialogBookStore.errorField(fieldName);
				return false;

			}
		} catch (Exception e) {
			DialogBookStore.errorField(fieldName);
			return false;
		}
		return true;
	}
}
