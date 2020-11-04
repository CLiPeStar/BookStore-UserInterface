package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import tools.DialogBookStore;

public class ActionListenerSaveEdit implements ActionListener {
	private BookStoreController bookStore;
	private ViewControllerEditSearch viewControl;

	public ActionListenerSaveEdit(BookStoreController bookStore, ViewControllerEditSearch viewController) {
		super();
		this.bookStore = bookStore;
		this.viewControl = viewController;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		viewControl.actionBtnEditSave(bookStore);
	}

}
