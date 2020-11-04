
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import tools.DialogBookStore;

public class ActionListenerSearch implements ActionListener {
	private BookStoreController bookStore;
	private ViewController viewControl;

	public ActionListenerSearch(BookStoreController bookStore, ViewController viewController) {
		super();
		this.bookStore = bookStore;
		this.viewControl = viewController;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!viewControl.existBookToSearchChange(bookStore)) {
			viewControl.activatePanels(bookStore);
		}else {
			
			viewControl.desactivatePanels();
			DialogBookStore.errorIsbnExist();
		}
	}

}