package control;

import java.util.Enumeration;
import java.util.HashMap;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
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

	public void createBookFromFields(BookStoreController controllerBookStore) {
		controllerBookStore.addBook(getISBN().getText(),
				new Book(getISBN().getText(), getTitle().getText(), getAuthor().getText(), getEditorial().getText(),
						Float.valueOf(getPrice().getText()), getTextBtnSelected(getFormatGroup()),
						getTextBtnSelected(getStateGroup())));
	}

	public void fillTable(BookStoreController controllerBookStore) {
		String nombresColumnas[] = { "TITULO", "ISBN", "AUTOR", "PRECIO" };
		String[][] filasTabla = new String[controllerBookStore.getSize()][4];
		int i = 0;

		for (HashMap.Entry<String, Book> entry : controllerBookStore.getHasMapBookStore().entrySet()) {

			filasTabla[i][1] = entry.getKey();
			filasTabla[i][0] = entry.getValue().getTitle();
			filasTabla[i][2] = entry.getValue().getAuthor();
			filasTabla[i][3] = String.valueOf(entry.getValue().getPrice());
			i++;
		}
		DefaultTableModel tablaCompleta = new DefaultTableModel(filasTabla, nombresColumnas);
		UI.getTable().setModel(tablaCompleta);
	}

	public boolean fieldValidations() {
		return Validations.ISBNValidation(getISBN().getText()) && Validations.letterValidation(getEditorial().getText())
				&& Validations.letterValidation(getAuthor().getText())
				&& Validations.IsNamberFloat(getPrice().getText()) && getTextBtnSelected(getFormatGroup()) != null
				&& getTextBtnSelected(getStateGroup()) != null;
	}

	public void emptyForm() {
		getAuthor().setText("");
		getEditorial().setText("");
		getISBN().setText("");
		getPrice().setText("");
		getTitle().setText("");
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

	public boolean existBook(BookStoreController controllerBookStore) {
		return controllerBookStore.searchBook(getISBN().getText()) == null;
	}

	public void controlStateButtons() {
		UI.getBtnDelete().setEnabled(!UI.getBtnDelete().isEnabled());
		UI.getBtnSearch().setEnabled(!UI.getBtnSearch().isEnabled());

	}

	public String getIsbnSelected(BookStoreController controllerBookStore) {
		int i = 0;
		for (HashMap.Entry<String, Book> entry : controllerBookStore.getHasMapBookStore().entrySet()) {
			if (UI.getTable().getSelectedRow() == i) {
				return entry.getKey();
			}
			i++;
		}
		return null;

	}
	public int getRowSelectedFromTable() {
		
		return UI.getTable().getSelectedRow();
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

}
