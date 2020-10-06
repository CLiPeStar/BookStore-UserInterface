package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

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
		bookStore.deleteBook(viewControl.getIsbnSelected(bookStore));
		viewControl.fillTable(bookStore);
		if (bookStore.getSize() < 1)
			viewControl.controlStateButtons(viewControl.getBtnSearch());
		;
		JOptionPane.showMessageDialog(null, "Book Deleted");

	}

}
