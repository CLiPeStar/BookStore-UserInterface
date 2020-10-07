package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import tools.DialogBookStore;

public class ActionListenerAdd implements ActionListener {
	private BookStoreController bookStore;
	private ViewController viewControl;

	public ActionListenerAdd(BookStoreController bookStore, ViewController viewController) {
		super();
		this.bookStore = bookStore;
		this.viewControl = viewController;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int unitsAdd = DialogBookStore.amountToAdd();
		if (unitsAdd > 0)
			bookStore.addUnits(viewControl.getIsbnSelected(bookStore), unitsAdd);
		viewControl.fillTable(bookStore);
	}

}
