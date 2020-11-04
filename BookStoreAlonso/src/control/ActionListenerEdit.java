package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ActionListenerEdit implements ActionListener {
	private BookStoreController bookStore;
	private ViewControllerEditSearch viewControl;

	public ActionListenerEdit(BookStoreController bookStore, ViewControllerEditSearch viewController) {
		super();
		this.bookStore = bookStore;
		this.viewControl = viewController;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		viewControl.actionBtnEdit(bookStore);
	}
}
