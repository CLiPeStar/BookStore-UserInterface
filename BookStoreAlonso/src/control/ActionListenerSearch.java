package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import tools.DialogBookStore;

public class ActionListenerSearch implements ActionListener {
	private BookStoreController bookStore;
	private ViewController viewControl;

	public ActionListenerSearch(BookStoreController bookStore, ViewController viewControl) {
		super();
		this.bookStore = bookStore;
		this.viewControl = viewControl;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String ISBN = viewControl.getIsbnRequired(bookStore);
		if (ISBN != null) {
			
		JOptionPane.showMessageDialog(null, bookStore.searchBook(ISBN).toString());
		}

	}

}
