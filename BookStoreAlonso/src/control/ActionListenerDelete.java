package control;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import tools.DialogBookStore;

public class ActionListenerDelete implements ActionListener {
	private BookStoreController bookStore;
	private ViewController viewControl;

	public ActionListenerDelete(BookStoreController bookStore, ViewController viewController) {
		super();
		this.bookStore = bookStore;
		this.viewControl = viewController;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int selection = DialogBookStore.optionToDelete();
		switch (selection) {
		case 0:
			selection = DialogBookStore.amountToDelete();
			selection = bookStore.checkUnits(viewControl.getIsbnSelected(bookStore),selection);
			if (selection > 0)
				bookStore.eraseDrives(viewControl.getIsbnSelected(bookStore), selection);

			break;
		case 1:
			selection = DialogBookStore.deleteWarning(viewControl.getIsbnSelected(bookStore));

			if (selection == JOptionPane.OK_OPTION) {
				bookStore.deleteBook(viewControl.getIsbnSelected(bookStore));
				if (bookStore.getSize() < 1)
					viewControl.controlStateButtons(viewControl.getBtnSearch());
				JOptionPane.showMessageDialog(null, "Book Deleted");

			}
			break;

		default:
		}

		viewControl.fillTable(bookStore);

	}

}
