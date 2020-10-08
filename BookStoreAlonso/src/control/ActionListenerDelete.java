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
		String ISBN = viewControl.getIsbnRequired(bookStore);
		if (ISBN != null) {
			
		int selection = DialogBookStore.optionToDelete();
		switch (selection) {
		case 0:
			selection = DialogBookStore.amountToDelete();
			selection = bookStore.checkUnits(ISBN, selection);
			if (selection > 0)
				bookStore.eraseDrives(ISBN, selection);

			break;
		case 1:
			selection = DialogBookStore.deleteWarning(ISBN);

			if (selection == JOptionPane.OK_OPTION) {
				bookStore.deleteBook(ISBN);
				if (bookStore.getSize() < 1)
					viewControl.controlStateButtons(viewControl.getBtnSearch());
				viewControl.controlStateButtons(viewControl.getBtnDelete());
				viewControl.controlStateButtons(viewControl.getBtnAdd());
				JOptionPane.showMessageDialog(null, "Book Deleted");

			}
			break;

		default:
		}

		viewControl.fillTable(bookStore);
		}

	}

}
