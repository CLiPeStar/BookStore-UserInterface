package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerSearchEdit implements ActionListener {

	private BookStoreController bookStore;
	private ViewControllerEditSearch viewControl;

	public ActionListenerSearchEdit(BookStoreController bookStore, ViewControllerEditSearch viewController) {
		super();
		this.bookStore = bookStore;
		this.viewControl = viewController;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		viewControl.actionBtnSerchEdit(bookStore);

	}
}
