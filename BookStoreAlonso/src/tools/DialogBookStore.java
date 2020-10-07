package tools;

import javax.swing.JOptionPane;
import javax.swing.JSpinner;

public class DialogBookStore {
	public static int optionToDelete() {
		return JOptionPane.showOptionDialog(null, "Select option", "Option selector", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Erase drives", "Delete Book" }, null);
	}

	public static int deleteWarning(String ISBN) {
		return JOptionPane.showOptionDialog(null, "Are you surre that whant delete book : " + ISBN, "Delete book",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, null, new Object[] { "Yes", "No" },
				"opcion 1");

	}
	public static int amountToDelete() {
		JSpinner spinner = new JSpinner();
		JOptionPane.showOptionDialog(null, spinner, "How many units do you want to delete?",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
		return (int) spinner.getValue();

	}
	public static int amountToAdd() {
		JSpinner spinner = new JSpinner();
		JOptionPane.showOptionDialog(null, spinner, "How many units do you want to add?",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
		return (int) spinner.getValue();
		
	}
}
