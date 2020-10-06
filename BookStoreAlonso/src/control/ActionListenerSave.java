package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Book;

public class ActionListenerSave implements ActionListener {
	private BookStoreController bookStore;
	private ViewController viewControl;

	public ActionListenerSave(BookStoreController bookStore, ViewController viewController) {
		super();
		this.bookStore = bookStore;
		this.viewControl = viewController;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (viewControl.fieldValidations()) {
			if (viewControl.existBook(bookStore)) {
				viewControl.createBookFromFields(bookStore);
				viewControl.fillTable(bookStore);
				viewControl.emptyForm();
				if (bookStore.getSize() <= 1)
					viewControl.controlStateButtons(viewControl.getBtnSearch());;
				JOptionPane.showMessageDialog(null, "Book add correctly");
			} else {
				JOptionPane.showMessageDialog(null, "This ISBN already exist");
			}
		} else
			JOptionPane.showMessageDialog(null, "Invalid fields");
	}

}
