package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Book;
import tools.DialogBookStore;

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
			if (viewControl.existBookToSave(bookStore)) {
				viewControl.createBookFromFields(bookStore);
				viewControl.fillTable(bookStore);
				DialogBookStore.SaveBook();
				viewControl.resetForm();
			} else {
				DialogBookStore.errorIsbnExistAlready();
			}
		} else
			DialogBookStore.invalidFields();
	}

}