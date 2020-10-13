package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Book;
import model.EditionStatus;

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
			if (viewControl.existBook(bookStore) || viewControl.getStatus() == EditionStatus.EDITING) {
				if (bookStore.getSize() <= 0) {
					viewControl.controlStateButtons(viewControl.getBtnSearch());
					viewControl.controlStateButtons(viewControl.getBtnAdd());
					viewControl.controlStateButtons(viewControl.getBtnDelete());
					viewControl.controlStateButtons(viewControl.getBtnEdit());
				}
				if (viewControl.getStatus() == EditionStatus.EDITING)
					viewControl.deleteBook(bookStore);
				viewControl.createBookFromFields(bookStore);
				viewControl.fillTable(bookStore);
				if (viewControl.getStatus() == EditionStatus.EDITING) {
					
					JOptionPane.showMessageDialog(null, "Book modified correctly");
				} else {
					JOptionPane.showMessageDialog(null, "Book add correctly");

				}
				viewControl.resetForm();
			} else {
				JOptionPane.showMessageDialog(null, "This ISBN already exist");
			}
		} else
			JOptionPane.showMessageDialog(null, "Invalid fields");
	}

}
