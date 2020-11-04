package control;

import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;

import View.MainWindow;
import model.Book;
import model.Thematic;
import tools.DialogBookStore;
import tools.Validations;

public class ViewControllerEditSearch {
	private ParaUI UI;

	public ViewControllerEditSearch(ParaUI UI) {
		super();
		this.UI = UI;
	}

	public void createBookFromFields(BookStoreController BookStore) {
		BookStore.addBook(getIsbnEdit().getText(), getIsbnEdit().getText(), getTitleEdit().getText(),
				getAuthorEdit().getText(), getEditorialEdit().getText(), Float.valueOf(getPriceEdit().getText()),
				getTextBtnSelected(getFormatgroup()), getTextBtnSelected(getStateGroup()),
				(int) getSpinnerEdit().getValue(), (Thematic) getThematicEdit().getSelectedItem());
	}

	public void fillTable(BookStoreController BookStore) {
		getTable().setModel(BookStore.fillTable());
	}

	public boolean fieldValidations() {
		return Validations.letterValidation(getEditorialEdit().getText())
				&& Validations.letterValidation(getAuthorEdit().getText())
				&& Validations.IsNamberFloat(getPriceEdit().getText()) && getTextBtnSelected(getFormatgroup()) != null
				&& getTextBtnSelected(getStateGroup()) != null && (int) getSpinnerEdit().getValue() > 0;
	}

	public void resetForm() {
		getIsbnEdit().setEnabled(true);
		getIsbnEdit().setText("");
		getAuthorEdit().setText("");
		getEditorialEdit().setText("");
		getPriceEdit().setText("");
		getTitleEdit().setText("");
		getSpinnerEdit().setValue(0);
		getFormatgroup().clearSelection();
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

	public void completeForm(String iSBN, BookStoreController BookStore) {
		Book bookCompleteForm = BookStore.getValue(iSBN);
		getAuthorEdit().setText(bookCompleteForm.getAuthor());
		getEditorialEdit().setText(bookCompleteForm.getEditorial());
		getPriceEdit().setText(String.valueOf(bookCompleteForm.getPrice()));
		getTitleEdit().setText(bookCompleteForm.getTitle());
		getSpinnerEdit().setValue(bookCompleteForm.getUnits());
		getThematicEdit().setSelectedItem(bookCompleteForm.getThematic());
		completeRadioButtonForm(getFormatgroup(), bookCompleteForm.getFormat());
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

	private void changeForm() {
		getIsbnEdit().setEnabled(!getIsbnEdit().isEnabled());
		getAuthorEdit().setEnabled(!getAuthorEdit().isEnabled());
		getEditorialEdit().setEnabled(!getIsbnEdit().isEnabled());
		getPriceEdit().setEnabled(!getPriceEdit().isEnabled());
		getTitleEdit().setEnabled(!getTitleEdit().isEnabled());
		getSpinnerEdit().setEnabled(!getSpinnerEdit().isEnabled());
		getThematicEdit().setEnabled(!getThematicEdit().isEnabled());
		changeStateButtonGroup(getFormatgroup());
		changeStateButtonGroup(getStateGroup());
	}

	private void changeStateButtonGroup(ButtonGroup radiousButtonGroup) {
		for (Enumeration<AbstractButton> buttons = radiousButtonGroup.getElements(); buttons.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();
			button.setEnabled(!button.isEnabled());
		}
	}

	public void actionBtnSerchEdit(BookStoreController BookStore) {
		if (!existBookToSearchEdit(BookStore)) {
			completeForm(getIsbnEdit().getText(), BookStore);
			getMain().getPanelResponsivo().add(getMain().getEdit());
			UI.frame.pack();
		} else {

			DialogBookStore.errorIsbnExist();
			resetForm();
			getMain().getPanelResponsivo().remove(getMain().getEdit());
			UI.frame.pack();

		}

	}

	public void actionBtnEdit(BookStoreController BookStore) {
		changeForm();
		getMain().getPanelResponsivo().remove(getMain().getSearch());
		getMain().getPanelResponsivo().remove(getMain().getEdit());
		getMain().getPanelResponsivo().add(getMain().getSaveEdit());
		UI.frame.pack();
	}

	public void actionBtnEditSave(BookStoreController BookStore) {
		if (fieldValidations()) {
			System.out.println(getIsbnEdit().getText());
			BookStore.deleteBook(getIsbnEdit().getText());
			createBookFromFields(BookStore);
			DialogBookStore.editWin();
			changeForm();
			resetForm();
			getIsbnEdit().setText("");
			getMain().getPanelResponsivo().add(getMain().getSearch());
			getMain().getPanelResponsivo().remove(getMain().getSaveEdit());
			fillTable(BookStore);
			UI.frame.pack();

		} else {
			DialogBookStore.invalidFields();
		}

	}

	public boolean existBookToSearchEdit(BookStoreController BookStore) {
		return BookStore.searchBook(getIsbnEdit().getText()) == null;
	}

	private MainWindow getMain() {
		return UI.main;
	}

	private ButtonGroup getStateGroup() {
		return getMain().getStateSectionSearchEdit().getStateGroup();
	}

	private ButtonGroup getFormatgroup() {
		return getMain().getFormatSectionSearchEdit().getFormatGroup();
	}

	private JSpinner getSpinnerEdit() {
		return getMain().getPanelRegsiterSearchEdit().spinnerUnits();
	}

	private JTextField getTitleEdit() {
		return getMain().getPanelRegsiterSearchEdit().getTextTitle();
	}

	private JTextField getPriceEdit() {
		return getMain().getPanelRegsiterSearchEdit().getTextPrice();
	}

	private JTextField getEditorialEdit() {
		return getMain().getPanelRegsiterSearchEdit().getTextEditorial();
	}

	private JTextField getAuthorEdit() {
		return getMain().getPanelRegsiterSearchEdit().getTextAuthor();
	}

	private JTextField getIsbnEdit() {
		return getMain().getPanelRegsiterSearchEdit().getTextISBN();
	}

	public JButton getBtnSave() {
		return getMain().getSave();
	}

	private JComboBox getThematicEdit() {
		return getMain().getPanelRegsiterSearchEdit().getComboBoxThematic();
	}

	public JTable getTable() {
		return getMain().getTable();
	}

}
