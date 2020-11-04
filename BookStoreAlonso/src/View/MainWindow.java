package View;

import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import control.ParaUI;
import model.IparaUI;
import model.Iview;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class MainWindow extends JPanel implements Iview {
	private jPanelBook panelBook = new jPanelBook();
	private jPanelTable panelTable = new jPanelTable();
	private PanelAddDelete panelChange = new PanelAddDelete();
	private PanelSearchEdit searchEditPanel = new PanelSearchEdit();
	private JButton save = new JButton("Save");
	private JButton saveEdit = new JButton("Save");
	private JButton edit = new JButton("Edit");
	private JButton search = new JButton("Search");

	/**
	 * Create the panel.
	 */
	public MainWindow() {
	}

	public JPanel getPanelExport() {
		setBackground(new Color(246, 142, 69));
		setLayout(new BorderLayout(0, 0));

		JPanel PanelExport = new JPanel();
		PanelExport.setBackground(new Color(244, 164, 96));
		add(PanelExport, BorderLayout.CENTER);
		PanelExport.setLayout(new BorderLayout(0, 0));

		JPanel headPanel = new JPanel();
		headPanel.setBackground(new Color(255, 123, 120));
		PanelExport.add(headPanel, BorderLayout.NORTH);
		headPanel.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(244, 164, 96));
		headPanel.add(panel);

		JLabel lblTitle = new JLabel("BookStore");
		lblTitle.setFont(new Font("News701 BT", Font.ITALIC, 30));
		panel.add(lblTitle);
		return PanelExport;
	}

	@Override
	public void presentar(IparaUI paraUI) {
		paraUI.accept(this);
	}

	public JPanel getViewSave() {
		JPanel panelSave = getPanelExport();
		panelBook.getPanelButtonDinamic().add(save);
		panelSave.add(panelBook, BorderLayout.CENTER);

		return panelSave;
	}

	public JPanel getViewTable() {
		JPanel panelTableExport = getPanelExport();
		panelTableExport.add(panelTable, BorderLayout.CENTER);
		return panelTableExport;
	}

	public JPanel getViewSearchEdit() {
		JPanel panelExport = getPanelExport();
		panelExport.add(searchEditPanel, BorderLayout.CENTER);
		return panelExport;
	}

	public JPanel getViewChange() {
		JPanel panelChangeE = getPanelExport();
		getPanelResponsivo().add(search);
		
		panelChangeE.add(panelChange, BorderLayout.CENTER);
		return panelChangeE;
	}
	

	public JSpinner getSpinnerUnits() {
		return this.panelBook.getSpinnerUnits();
	}

	public JTextField getTextISBNRegister() {
		return this.panelBook.getTextISBN();
	}

	public JComboBox getComboBoxThematic() {
		return this.panelBook.getComboBoxThematic();
	}

	public JTextField getTextISBNSearchAD() {
		return this.panelChange.getTextFieldIsbnSearch();
	}

	public JTextField getTextTitle() {
		return this.panelBook.getTextTitle();
	}

	public JTextField getTextAuthor() {
		return this.panelBook.getTextAuthor();
	}

	public JTextField getTextEditorial() {
		return this.panelBook.getTextEditorial();
	}

	public JTextField getTextPrice() {
		return this.panelBook.getTextPrice();
	}

	public ButtonGroup getFormatGroup() {
		return this.panelBook.getFormatGroup();
	}

	public ButtonGroup getStateGroup() {
		return this.panelBook.getStateGroup();
	}

	public JTable getTable() {
		return panelTable.getTable();
	}

	public JButton getSave() {
		return save;
	}

	public JButton getSearchAD() {
		return this.panelChange.getBtnSearchAD();
	}

	public JLabel getLabelUnitsAdd() {
		return panelChange.getLabelUnitsAdd();
	}

	public JSpinner getSpinnerAdd() {
		return panelChange.getSpinnerAdd();
	}

	public JSpinner getSpinnerDelete() {
		return panelChange.getSpinnerDelete();
	}

	public JLabel getLabelTotalAdd() {
		return panelChange.getLabelTotalAdd();
	}

	public JLabel getLabelUnitsTotalDelete() {
		return panelChange.getLabelUnitsTotalDelete();
	}

	public JLabel getLabelTotalDelete() {
		return panelChange.getLabelTotalDelete();
	}

	public JButton getBtnSaveChange() {
		return this.panelChange.getBtnSaveChange();
	}

	public RegistrationFieldsView getPanelRegsiterSearchEdit() {
		return searchEditPanel.getPanelRegsiterSearchEdit();
	}

	public FormatsView getFormatSectionSearchEdit() {
		return searchEditPanel.getFormatSectionSearchEdit();
	}

	public StateView getStateSectionSearchEdit() {
		return searchEditPanel.getStateSectionSearchEdit();
	}

	public JButton getSaveEdit() {
		return saveEdit;
	}

	public JButton getEdit() {
		return edit;
	}

	public JButton getSearch() {
		return search;
	}

	public JPanel getPanelResponsivo() {
		return this.searchEditPanel.getPanelResponsivo();
	}

}
