package View;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import control.ActionListenerAdd;
import control.ActionListenerDelete;
import control.ActionListenerSave;
import control.ActionListenerSearch;
import control.BookStoreController;
import control.KeyListenerFieldsValidations;
import control.ViewController;

public class ParaUI extends UI {

	public ParaUI() {
		super();
		addListeners();
	}

	private void addListeners() {
		BookStoreController bookStore = new BookStoreController();
		ViewController viewController = new ViewController(this);
		ActionListenerBtnSave(bookStore, viewController);
		ActionListenerBtnSearch(bookStore, viewController);
		ActionListenerBtnDelete(bookStore, viewController);
		ActionListenerBtnAdd(bookStore, viewController);

	}

	private void ActionListenerBtnSave(BookStoreController bookStore, ViewController viewController) {
		getBtnSave().addActionListener(new ActionListenerSave(bookStore, viewController));
	}

	private void ActionListenerBtnSearch(BookStoreController bookStore, ViewController viewController) {
		getBtnSearch().addActionListener(new ActionListenerSearch(bookStore, viewController));
	}

	private void ActionListenerBtnDelete(BookStoreController bookStore, ViewController viewController) {
		getBtnDelete().addActionListener(new ActionListenerDelete(bookStore, viewController));
	}

	private void ActionListenerBtnAdd(BookStoreController bookStore, ViewController viewController) {
		getBtnAdd().addActionListener(new ActionListenerAdd(bookStore, viewController));
	}

}
