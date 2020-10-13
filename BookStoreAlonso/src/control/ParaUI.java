package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;

import View.UI;

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
		KeyListenerFieldsValidations(viewController, getTextISBN());
		ChangeListenerTabbedPanel(viewController);
		ActionListenerBtnEdit(bookStore, viewController);

	}

	private void ActionListenerBtnEdit(BookStoreController bookStore, ViewController viewController) {
		getBtnEdit().addActionListener(new ActionListenerEdit(bookStore, viewController));
	}

	private void ChangeListenerTabbedPanel(ViewController viewController) {
		getTabbedPanels().addChangeListener(new ChangeListenerTabbedPanel(viewController));
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

	private void KeyListenerFieldsValidations(ViewController viewController, JTextField textISBN) {
		getTextISBN().addKeyListener(new KeyListenerFieldsValidations(viewController, textISBN));

	}

}
