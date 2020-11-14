package control;

import java.util.Enumeration;
import java.util.HashMap;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import View.MainWindow;
import model.Book;
import model.Thematic;
import tools.DialogBookStore;
import tools.Validations;

public class ViewController {
	private ParaUI UI;

	public ViewController(ParaUI UI) {
		super();
		this.UI = UI;
	}

	public void createBookFromFields(BookStoreController BookStore) {
		BookStore.addBook(getISBNSave().getText(), getISBNSave().getText(), getTitle().getText(), getAuthor().getText(),
				getEditorial().getText(), Float.valueOf(getPrice().getText()), getTextBtnSelected(getFormatGroup(),"Format"),
				getTextBtnSelected(getStateGroup(),"State"), (int) getSpinnerUnits().getValue(),
				(Thematic) getMain().getComboBoxThematic().getSelectedItem());
	}

	public void fillTable(BookStoreController BookStore) {
		getTable().setModel(BookStore.fillTable());
	}

	public boolean fieldValidations() {
		return Validations.ISBNValidation(getISBNSave().getText())
				&& Validations.letterValidation(getEditorial().getText(), "Editorial")
				&& Validations.letterValidation(getAuthor().getText(), "Author")
				&& Validations.IsNamberFloat(getPrice().getText(), "Price")
				&& getTextBtnSelected(getFormatGroup(),"Format") != null && getTextBtnSelected(getStateGroup(),"State") != null
				&& (int) getSpinnerUnits().getValue() > 0;
	}

	public void resetForm() {
		getISBNSave().setEnabled(true);
		getAuthor().setText("");
		getEditorial().setText("");
		getISBNSave().setText("");
		getPrice().setText("");
		getTitle().setText("");
		getSpinnerUnits().setValue(0);
		getFormatGroup().clearSelection();
		getStateGroup().clearSelection();
	}

	public String getTextBtnSelected(ButtonGroup radiousButtonGroup,String field) {
		for (Enumeration<AbstractButton> buttons = radiousButtonGroup.getElements(); buttons.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();
			if (button.isSelected()) {
				return button.getText();
			}
		}
		DialogBookStore.errorField(field);
		return null;
	}

	public boolean existBookToSave(BookStoreController BookStore) {
		return BookStore.searchBook(getISBNSave().getText()) == null;
	}

	public void desactivatePanels() {
		getMain().getLabelUnitsTotalDelete().setText("0");
		getMain().getLabelUnitsAdd().setText("0");
		getMain().getSpinnerAdd().setEnabled(false);
		getMain().getSpinnerAdd().setValue(0);
		getMain().getSpinnerDelete().setEnabled(false);
		getMain().getSpinnerDelete().setValue(0);
		getMain().getLabelTotalAdd().setText("0");
		getMain().getLabelTotalDelete().setText("0");
		getMain().getBtnSaveChange().setEnabled(false);
		getISBNSearch().setText("");
		getMain().getCheckBoxDeleteAll().setEnabled(false);
		getMain().getCheckBoxDeleteAll().setSelected(false);
	}

	public void actionSaveChange(BookStoreController BookStore) {
		int add = (int) getMain().getSpinnerAdd().getValue();
		int delete = (int) getMain().getSpinnerDelete().getValue();
		BookStore.addUnits(getISBNSearch().getText(), add);
		BookStore.eraseDrives(getISBNSearch().getText(), delete);
		if (getMain().getCheckBoxDeleteAll().isSelected()) {
			int select = DialogBookStore.deleteWarning(getISBNSearch().getText());
			if (select == 0)
				BookStore.deleteBook(getISBNSearch().getText());
		}
		fillTable(BookStore);
		DialogBookStore.win();
		desactivatePanels();
	}

	public void activatePanels(BookStoreController bookStore) {
		int units = bookStore.getBookUnits(getISBNSearch().getText());
		getMain().getLabelUnitsTotalDelete().setText(String.valueOf(units));
		getMain().getLabelUnitsAdd().setText(String.valueOf(units));
		getMain().getSpinnerAdd().setEnabled(true);
		getMain().getSpinnerDelete().setEnabled(true);
		getMain().getLabelTotalAdd().setText(String.valueOf(units));
		getMain().getLabelTotalDelete().setText(String.valueOf(units));
		getMain().getBtnSaveChange().setEnabled(true);
		getMain().getCheckBoxDeleteAll().setEnabled(true);

	}

	public void changeUnitsTotal(BookStoreController bookStore) {
		int units = bookStore.getBookUnits(getISBNSearch().getText());
		int add = (int) getMain().getSpinnerAdd().getValue();
		int delete = (int) getMain().getSpinnerDelete().getValue();
		getMain().getLabelTotalAdd().setText(String.valueOf((units + add) - delete));
		getMain().getLabelTotalDelete().setText(String.valueOf((units + add) - delete));

	}

	public boolean existBookToSearchChange(BookStoreController BookStore) {
		return BookStore.searchBook(getISBNSearch().getText()) == null;
	}

	public void controlStateButtons(JButton btn) {
		btn.setEnabled(!btn.isEnabled());
	}

	private JTextField getISBNSearch() {
		return getMain().getTextISBNSearchAD();
	}

	private JTable getTable() {
		return getMain().getTable();
	}

	private JTextField getPrice() {
		return getMain().getTextPrice();
	}

	private MainWindow getMain() {
		return UI.main;
	}

	private JTextField getTitle() {
		return getMain().getTextTitle();
	}

	private JTextField getAuthor() {
		return getMain().getTextAuthor();
	}

	private JTextField getEditorial() {
		return getMain().getTextEditorial();
	}

	private JTextField getISBNSave() {
		return getMain().getTextISBNRegister();
	}

	private ButtonGroup getStateGroup() {
		return getMain().getStateGroup();
	}

	private ButtonGroup getFormatGroup() {
		return getMain().getFormatGroup();
	}

	private JSpinner getSpinnerUnits() {
		return getMain().getSpinnerUnits();
	}

	public boolean validateIsbn(String text) {
		return Validations.ISBNValidation(text);
	}

}
