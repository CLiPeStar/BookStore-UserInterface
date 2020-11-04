package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerSaveChange implements ActionListener {
	private BookStoreController bookStore;
	private ViewController viewControl;

	public ActionListenerSaveChange(BookStoreController bookStore, ViewController viewController) {
		super();
		this.bookStore = bookStore;
		this.viewControl = viewController;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		viewControl.actionSaveChange(bookStore);

	}

}
