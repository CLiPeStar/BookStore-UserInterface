package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class UI extends JFrame {

	private JPanel contentPane;
	private KeyPadActions keyPadFooter;
	private jPanelBook panelBook;
	private jPanelTable panelTable;
	private JPanel panel;
	private JLabel lblTitle;
	private JTabbedPane tabbedPanels;

	/**
	 * Create the frame.
	 */
	public UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 971, 778);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(246, 142, 69));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("BookStore Alonso");
		Image icon = new ImageIcon(getClass().getResource("/assets/logoGalleta.png")).getImage();
		setIconImage(icon);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel headPanel = new JPanel();
		headPanel.setBackground(new Color(255, 245, 238));
		contentPane.add(headPanel, BorderLayout.NORTH);
		headPanel.setLayout(new GridLayout(1, 0, 0, 0));

		panel = new JPanel();
		panel.setBackground(new Color(255, 222, 173));
		headPanel.add(panel);

		lblTitle = new JLabel("BookStore");
		lblTitle.setFont(new Font("News701 BT", Font.ITALIC, 30));
		panel.add(lblTitle);

		tabbedPanels = new JTabbedPane(JTabbedPane.TOP);

		tabbedPanels.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(tabbedPanels, BorderLayout.CENTER);

		panelBook = new jPanelBook();
		tabbedPanels.addTab("Book", null, panelBook, null);
		panelTable = new jPanelTable();
		tabbedPanels.addTab("Shelving", null, panelTable, null);

		JPanel panelFooter = new JPanel();
		panelFooter.setLayout(new GridLayout(0, 1, 0, 0));
		keyPadFooter = new KeyPadActions();
		panelFooter.add(keyPadFooter);
		contentPane.add(panelFooter, BorderLayout.SOUTH);

		
		getBtnExit().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}

	public JTabbedPane getTabbedPanels() {
		return tabbedPanels;
	}

	public JButton getBtnEdit() {
		return keyPadFooter.getBtnEdit();
	}

	public jPanelBook getPanelBook() {
		return panelBook;
	}

	public jPanelTable getPanelTable() {
		return panelTable;
	}

	public JSpinner getSpinnerUnits() {
		return panelBook.getSpinnerUnits();
	}

	public JButton getBtnAdd() {
		return keyPadFooter.getBtnAdd();
	}

	public JButton getBtnSave() {
		return keyPadFooter.getBtnSave();
	}

	public JButton getBtnDelete() {
		return keyPadFooter.getBtnDelete();
	}

	public JButton getBtnExit() {
		return keyPadFooter.getBtnExit();
	}

	public JButton getBtnSearch() {
		return keyPadFooter.getBtnSearch();
	}

	public JTextField getTextISBN() {
		return panelBook.getTextISBN();
	}

	public JTextField getTextTitle() {
		return panelBook.getTextTitle();
	}

	public JTextField getTextAuthor() {
		return panelBook.getTextAuthor();
	}

	public JTextField getTextEditorial() {
		return panelBook.getTextEditorial();
	}

	public JTextField getTextPrice() {
		return panelBook.getTextPrice();
	}

	public ButtonGroup getFormatGroup() {
		return panelBook.getFormatGroup();
	}

	public ButtonGroup getStateGroup() {
		return panelBook.getStateGroup();
	}

	public JTable getTable() {
		return panelTable.getTable();
	}

}
