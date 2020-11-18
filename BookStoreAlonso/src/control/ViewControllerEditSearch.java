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
import View.RegistrationFieldsView;
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
				getTextBtnSelected(getFormatgroup(),"Format"), getTextBtnSelected(getStateGroup(),"State"),
				(int) getSpinnerEdit().getValue(), (Thematic) getThematicEdit().getSelectedItem());
	}

	public void fillTable(BookStoreController BookStore) {
		getTable().setModel(BookStore.fillTable());
	}

	public boolean fieldValidations() {
		return Validations.letterValidation(getEditorialEdit().getText(), "Editorial")
				&& Validations.letterValidation(getAuthorEdit().getText(), "Author")
				&& Validations.IsNamberFloat(getPriceEdit().getText(), "Price")
				&& getTextBtnSelected(getFormatgroup(),"Format") != null && getTextBtnSelected(getStateGroup(),"State") != null
				&& (int) getSpinnerEdit().getValue() > 0;
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

	public String getTextBtnSelected(ButtonGroup radiousButtonGroup,String name) {
		for (Enumeration<AbstractButton> buttons = radiousButtonGroup.getElements(); buttons.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();
			if (button.isSelected()) {
				return button.getText();
			}
		}
		DialogBookStore.errorField(name);
		return null;
	}

	public void completeForm(String iSBN, BookStoreController BookStore) {
		Book bookCompleteForm = BookStore.searchBook(iSBN);
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
			if (button.getText().equals(nameRadio)) {
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
			UI.frame.repaint();
		} else {

			DialogBookStore.errorIsbnExist();
			resetForm();
			getMain().getPanelResponsivo().remove(getMain().getEdit());
			UI.frame.pack();
			UI.frame.repaint();

		}

	}

	public void actionBtnEdit(BookStoreController BookStore) {
		changeForm();
		getMain().changeBtnForEdit();
		
		UI.frame.pack();
		UI.frame.repaint();
	}

	public void actionBtnEditSave(BookStoreController BookStore) {
		if (fieldValidations()) {
			BookStore.deleteBook(getIsbnEdit().getText());
			createBookFromFields(BookStore);
			DialogBookStore.editWin();
			changeForm();
			resetForm();
			getIsbnEdit().setText("");
			getMain().changeBtnForEditSave();
			fillTable(BookStore);
			UI.frame.pack();
			UI.frame.repaint();
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
		return getFormatSectionSearchEdit().spinnerUnits();
	}

	private JTextField getTitleEdit() {
		return getFormatSectionSearchEdit().getTextTitle();
	}

	private JTextField getPriceEdit() {
		return getFormatSectionSearchEdit().getTextPrice();
	}

	private JTextField getEditorialEdit() {
		return getFormatSectionSearchEdit().getTextEditorial();
	}

	private JTextField getAuthorEdit() {
		return getFormatSectionSearchEdit().getTextAuthor();
	}

	private JTextField getIsbnEdit() {
		return getFormatSectionSearchEdit().getTextISBN();
	}

	public JButton getBtnSave() {
		return getMain().getSave();
	}

	private JComboBox getThematicEdit() {
		return getFormatSectionSearchEdit().getComboBoxThematic();
	}

	private RegistrationFieldsView getFormatSectionSearchEdit() {
		return getMain().getPanelRegsiterSearchEdit();
	}

	private JTable getTable() {
		return getMain().getTable();
	}

}
