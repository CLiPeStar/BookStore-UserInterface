package control;

import java.util.Enumeration;
import java.util.HashMap;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import View.ParaUI;
import model.Book;
import tools.Validations;

public class ViewController {
	private ParaUI UI;

	public ViewController(ParaUI UI) {
		super();
		this.UI = UI;
	}

	public void createBookFromFields(BookStoreController BookStore) {
		BookStore.addBook(getISBN().getText(),
				new Book(getISBN().getText(), getTitle().getText(), getAuthor().getText(), getEditorial().getText(),
						Float.valueOf(getPrice().getText()), getTextBtnSelected(getFormatGroup()),
						getTextBtnSelected(getStateGroup()), (int) getSpinnerUnits().getValue()));
	}

	public void fillTable(BookStoreController BookStore) {
		String columName[] = { "TITLE", "ISBN", "AUTHOR", "EDITORIAL", "FORMAT", "STATE", "PRICE", "UNITS" };
		String[][] tableRow = new String[BookStore.getSize()][columName.length];
		int i = 0;

		for (HashMap.Entry<String, Book> entry : BookStore.getBooKStore().entrySet()) {

			tableRow[i][1] = entry.getKey();
			tableRow[i][0] = entry.getValue().getTitle();
			tableRow[i][2] = entry.getValue().getAuthor();
			tableRow[i][3] = entry.getValue().getEditorial();
			tableRow[i][4] = entry.getValue().getFormat();
			tableRow[i][5] = entry.getValue().getState();
			tableRow[i][6] = String.valueOf(entry.getValue().getPrice());
			tableRow[i][7] = String.valueOf(entry.getValue().getUnits());
			i++;
		}
		DefaultTableModel tablaCompleta = new DefaultTableModel(tableRow, columName);
		UI.getTable().setModel(tablaCompleta);
	}

	public boolean fieldValidations() {
		return Validations.ISBNValidation(getISBN().getText()) && Validations.letterValidation(getEditorial().getText())
				&& Validations.letterValidation(getAuthor().getText())
				&& Validations.IsNamberFloat(getPrice().getText()) && getTextBtnSelected(getFormatGroup()) != null
				&& getTextBtnSelected(getStateGroup()) != null && (int) getSpinnerUnits().getValue() > 0;
	}

	public void emptyForm() {
		getAuthor().setText("");
		getEditorial().setText("");
		getISBN().setText("");
		getPrice().setText("");
		getTitle().setText("");
		getSpinnerUnits().setValue(0);
		getFormatGroup().clearSelection();
		getStateGroup().clearSelection();
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

	public boolean existBook(BookStoreController BookStore) {
		return BookStore.searchBook(getISBN().getText()) == null;
	}

	public String getIsbnSelected(BookStoreController BookStore) {
		int i = 0;
		for (HashMap.Entry<String, Book> entry : BookStore.getBooKStore().entrySet()) {
			if (UI.getTable().getSelectedRow() == i) {
				return entry.getKey();
			}
			i++;
		}
		return null;

	}

	public void controlStateButtons(JButton btn) {
		btn.setEnabled(!btn.isEnabled());
	}

	public int getRowSelectedFromTable() {
		return getTable().getSelectedRow();
	}

	public JTable getTable() {
		return UI.getTable();
	}

	public JButton getBtnSearch() {
		return UI.getBtnSearch();
	}

	public JButton getBtnDelete() {
		return UI.getBtnDelete();
	}

	public JButton getBtnAdd() {
		return UI.getBtnAdd();
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

	private ButtonGroup getStateGroup() {
		return UI.getStateGroup();
	}

	private ButtonGroup getFormatGroup() {
		return UI.getFormatGroup();
	}

	private JSpinner getSpinnerUnits() {
		return UI.getSpinnerUnits();
	}

}
