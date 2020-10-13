package control;

import java.util.Enumeration;
import java.util.HashMap;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import View.jPanelBook;
import View.jPanelTable;
import model.Book;
import model.EditionStatus;
import tools.DialogBookStore;
import tools.Validations;

public class ViewController {
	private ParaUI UI;
	private EditionStatus status = EditionStatus.UNEDITED;

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

	public void resetForm() {
		getISBN().setEnabled(true);
		getAuthor().setText("");
		getEditorial().setText("");
		getISBN().setText("");
		getPrice().setText("");
		getTitle().setText("");
		getSpinnerUnits().setValue(0);
		getFormatGroup().clearSelection();
		getStateGroup().clearSelection();
		status = EditionStatus.UNEDITED;
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

	public void completeForm(String iSBN, BookStoreController BookStore) {
		Book bookCompleteForm = BookStore.getValue(iSBN);
		getISBN().setEnabled(false);
		getAuthor().setText(bookCompleteForm.getAuthor());
		getEditorial().setText(bookCompleteForm.getEditorial());
		getISBN().setText(bookCompleteForm.getIsbn());
		getPrice().setText(String.valueOf(bookCompleteForm.getPrice()));
		getTitle().setText(bookCompleteForm.getTitle());
		getSpinnerUnits().setValue(bookCompleteForm.getUnits());
		completeRadioButtonForm(getFormatGroup(), bookCompleteForm.getFormat());
		completeRadioButtonForm(getStateGroup(), bookCompleteForm.getState());
	}

	private void completeRadioButtonForm(ButtonGroup radiousButtonGroup, String nameRadio) {
		for (Enumeration<AbstractButton> buttons = radiousButtonGroup.getElements(); buttons.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();
			if (button.getText() == nameRadio) {
				button.setSelected(true);
			}
		}
	}

	public void controlStateButtons(JButton btn) {
		btn.setEnabled(!btn.isEnabled());
	}

	public int getRowSelectedFromTable() {
		return getTable().getSelectedRow();
	}

	public String getIsbnRequired(BookStoreController bookStore) {
		if (getRowSelectedFromTable() >= 0) {
			return getIsbnSelected(bookStore);
		}
		try {
			String bookSearch = DialogBookStore.inputISBN();
			if (bookStore.searchBook(bookSearch) == null && !bookSearch.isEmpty()) {
				DialogBookStore.errorIsbnExist();
			}
			if (bookStore.searchBook(bookSearch) != null) {
				return bookSearch;
			}
		} catch (Exception e) {
		}
		return null;
	}

	public EditionStatus getStatus() {
		return status;
	}

	public void setStatus(EditionStatus status) {
		this.status = status;
	}

	public JTabbedPane getTabbedPanel() {
		return UI.getTabbedPanels();
	}

	public jPanelBook getPanelBook() {
		return UI.getPanelBook();
	}

	public jPanelTable getPanelTable() {
		return UI.getPanelTable();
	}

	public JTable getTable() {
		return UI.getTable();
	}

	public JButton getBtnEdit() {
		return UI.getBtnEdit();
	}

	public JButton getBtnSearch() {
		return UI.getBtnSearch();
	}

	public JButton getBtnSave() {
		return UI.getBtnSave();
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

	public boolean validateIsbn(String text) {
		return Validations.ISBNValidation(text);
	}

	public void deleteBook(BookStoreController bookStore) {
		bookStore.deleteBook(getISBN().getText());

	}

}
