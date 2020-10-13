package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.EditionStatus;

public class ActionListenerEdit implements ActionListener {
	private BookStoreController bookStore;
	private ViewController viewControl;

	public ActionListenerEdit(BookStoreController bookStore, ViewController viewController) {
		super();
		this.bookStore = bookStore;
		this.viewControl = viewController;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String ISBN = viewControl.getIsbnRequired(bookStore);
		if (ISBN != null) {
			viewControl.setStatus(EditionStatus.EDITING);
			viewControl.getTabbedPanel().setSelectedIndex(0);
			viewControl.completeForm(ISBN, bookStore);
		}
	}

}
