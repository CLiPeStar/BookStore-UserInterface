package control;

import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.Book;
import tools.Validations;

public class ViewController {
	private ParaUI UI;

	public ViewController(ParaUI UI) {
		super();
		this.UI = UI;
	}

	public void createBookFromFields(BookStoreController controllerBookStore) {
		controllerBookStore.addBook(new Book(getISBN().getText(), getTitle().getText(), getAuthor().getText(),
				getEditorial().getText(), Float.valueOf(getPrice().getText()), getTextBtnSelected(UI.getFormatGroup()),
				getTextBtnSelected(UI.getStateGroup())));
	}

	public void fillTable(BookStoreController controllerBookStore) {
		String rowName[] = { "ISBN", "Title", "Editorial", "Author", "Price", "Format", "State" };
		String[][] rowTable = new String[controllerBookStore.getSize()][rowName.length];
		for (int i = 0; i < controllerBookStore.getSize(); i++) {
			rowTable[i][0] = controllerBookStore.getBook(i).getIsbn();
			rowTable[i][1] = controllerBookStore.getBook(i).getTitle();
			rowTable[i][2] = controllerBookStore.getBook(i).getEditorial();
			rowTable[i][3] = controllerBookStore.getBook(i).getAuthor();
			rowTable[i][4] = String.valueOf(controllerBookStore.getBook(i).getPrice());
			rowTable[i][5] = controllerBookStore.getBook(i).getFormat();
			rowTable[i][6] = controllerBookStore.getBook(i).getState();
		}
		DefaultTableModel tableComplete = new DefaultTableModel(rowTable, rowName);
		getTable().setModel(tableComplete);
	}


	public boolean fieldValidations() {
		return Validations.ISBNValidation(getISBN().getText()) && Validations.letterValidation(getEditorial().getText())
				&& Validations.letterValidation(getAuthor().getText())
				&& Validations.IsNamberFloat(getPrice().getText()) && getTextBtnSelected(UI.getFormatGroup()) != null
				&& getTextBtnSelected(UI.getStateGroup()) != null;
	}

	public void emptyForm() {
		getAuthor().setText("");
		getEditorial().setText("");
		getISBN().setText("");
		getPrice().setText("");
		getTitle().setText("");
		UI.getFormatGroup().clearSelection();
		UI.getStateGroup().clearSelection();
	}

	public String getTextBtnSelected(ButtonGroup radiousButtonGroup) {
		for (Enumeration<AbstractButton> buttons = radiousButtonGroup.getElements(); buttons.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();
			if (button.isSelected()) {
				return button.getText();
			}
		}
		return null;
	}

	public boolean existBook(BookStoreController controllerBookStore) {
		return controllerBookStore.searchBook(getISBN().getText()) == null;
	}

	public void controlStateButtons(JButton btn) {
		btn.setEnabled(!btn.isEnabled());

	}

	public JButton getBtnSearch() {
		return UI.getBtnSearch();
	}

	public JButton getBtnDelete() {
		return UI.getBtnDelete();
	}

	private JTextField getPrice() {
		return UI.getTextPrice();
	}

	private JTextField getTitle() {
		return UI.getTextTitle();
	}

	private JTextField getAuthor() {
		return UI.getTextAuthor();
	}

	private JTextField getEditorial() {
		return UI.getTextEditorial();
	}

	private JTextField getISBN() {
		return UI.getTextISBN();
	}

	public int getRowSelectedFromTable() {

		return getTable().getSelectedRow();
	}

	public JTable getTable() {
		return UI.getTable();
	}
}
