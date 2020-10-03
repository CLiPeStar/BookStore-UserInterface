package control;

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
		ActionListenerBtnSearch(bookStore);
		ActionListenerBtnDelete(bookStore, viewController);

	}

	private void ActionListenerBtnSave(BookStoreController bookStore, ViewController viewController) {
		getBtnSave().addActionListener(new ActionListenerSave(bookStore, viewController));
	}

	private void ActionListenerBtnSearch(BookStoreController bookStore) {
		getBtnSearch().addActionListener(new ActionListenerSearch(bookStore));
	}

	private void ActionListenerBtnDelete(BookStoreController bookStore, ViewController viewController) {
		getBtnDelete().addActionListener(new ActionListenerDelete(bookStore, viewController));
	}

}
