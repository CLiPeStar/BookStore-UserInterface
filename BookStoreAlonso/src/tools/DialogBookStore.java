package tools;

import javax.swing.JOptionPane;
import javax.swing.JSpinner;

public class DialogBookStore {

	public static int deleteWarning(String ISBN) {
		return JOptionPane.showOptionDialog(null, "Are you sure you want to delete the book : " + ISBN, "Delete book",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, null, new Object[] { "Yes", "No" },
				"opcion 1");

	}

	public static void errorIsbnExistAlready() {
		JOptionPane.showMessageDialog(null, "This book already exists");

	}

	public static void errorIsbnExist() {
		JOptionPane.showMessageDialog(null, "This book don`t exist");
	}
	
	public static void errorField(String field) {
		JOptionPane.showMessageDialog(null, "Failure in "+field);
		
	}

	public static void win() {
		JOptionPane.showMessageDialog(null, "Action carried out successfully");

	}

	public static void SaveBook() {
		JOptionPane.showMessageDialog(null, "Book saved correctly");

	}

	public static void invalidFields() {
		JOptionPane.showMessageDialog(null, "Invalid fields");

	}

	public static void editWin() {
		JOptionPane.showMessageDialog(null, "Edited correctly");

	}

}
