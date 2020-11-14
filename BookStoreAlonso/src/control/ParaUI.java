package control;

import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import View.MainWindow;
import model.IparaUI;
import model.Iview;

public class ParaUI implements IparaUI {
	protected MainWindow main;
	protected JFrame frame;

	public ParaUI(JFrame frame) {
		super();
		this.frame = frame;
	}

	public void accept(Iview view) {
		this.main = (MainWindow) view;
		addListeners(main);

	}

	private void addListeners(MainWindow view) {
		BookStoreController bookStore = new BookStoreController();
		ViewController viewController = new ViewController(this);
		ViewControllerEditSearch viewControllerEditSearch = new ViewControllerEditSearch(this);

		ActionListenerBtnSave(bookStore, viewController);
		ActionListenerBtnSearchChange(bookStore, viewController);
		KeyListenerFieldsValidations(viewController, main.getTextISBNRegister());
		KeyListenerFieldsValidations(viewController, main.getTextISBNSearchAD());
		KeyListenerFieldsValidations(viewController, main.getPanelRegsiterSearchEdit().getTextISBN());
		ChangeListenerSpinner(bookStore, viewController, main.getSpinnerAdd());
		ChangeListenerSpinner(bookStore, viewController, main.getSpinnerDelete());
		ActionListenerBtnSaveChange(bookStore, viewController);

		ActionListenerBtnSearchEdit(bookStore, viewControllerEditSearch);
		ActionListenerBtnEdit(bookStore, viewControllerEditSearch);
		ActionListenerBtnSave(bookStore, viewControllerEditSearch);

		main.getTable().setModel(bookStore.fillTable());
	}

	private void ActionListenerBtnSave(BookStoreController bookStore, ViewController viewController) {
		main.getSave().addActionListener(new ActionListenerSave(bookStore, viewController));
	}

	private void ActionListenerBtnSaveChange(BookStoreController bookStore, ViewController viewController) {
		main.getBtnSaveChange().addActionListener(new ActionListenerSaveChange(bookStore, viewController));
	}

	private void ActionListenerBtnSearchChange(BookStoreController bookStore, ViewController viewController) {
		main.getSearchAD().addActionListener(new ActionListenerSearch(bookStore, viewController));
	}

	private void KeyListenerFieldsValidations(ViewController viewController, JTextField textISBN) {
		textISBN.addKeyListener(new KeyListenerFieldsValidations(viewController, textISBN));

	}

	private void ChangeListenerSpinner(BookStoreController bookStore, ViewController viewController, JSpinner spinner) {
		spinner.addChangeListener(new ChangeListenerSpinner(bookStore, viewController));

	}

	private void ActionListenerBtnSearchEdit(BookStoreController bookStore, ViewControllerEditSearch viewController) {
		main.getSearch().addActionListener(new ActionListenerSearchEdit(bookStore, viewController));
	}

	private void ActionListenerBtnEdit(BookStoreController bookStore,
			ViewControllerEditSearch viewControllerEditSearch) {
		main.getEdit().addActionListener(new ActionListenerEdit(bookStore, viewControllerEditSearch));
	}

	private void ActionListenerBtnSave(BookStoreController bookStore,
			ViewControllerEditSearch viewControllerEditSearch) {
		main.getSaveEdit().addActionListener(new ActionListenerSaveEdit(bookStore, viewControllerEditSearch));
	}

}
