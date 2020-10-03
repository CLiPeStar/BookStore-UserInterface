package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ActionListenerSearch implements ActionListener {
	private BookStoreController bookStore;

	public ActionListenerSearch(BookStoreController bookStore) {
		super();
		this.bookStore = bookStore;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			String bookSearch = JOptionPane.showInputDialog("ISBN Book");
			if (bookStore.searchBook(bookSearch) == null && !bookSearch.isEmpty()) {
				JOptionPane.showMessageDialog(null, "This book don`t exist");
			}
			JOptionPane.showMessageDialog(null, bookStore.searchBook(bookSearch).toString());
		} catch (Exception e2) {

		}

	}

}
