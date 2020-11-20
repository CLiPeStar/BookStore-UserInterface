package View;

import java.awt.BorderLayout;
import java.awt.CardLayout;
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

import control.ParaUI;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class UI extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public UI() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 971, 797);
		contentPane = new JPanel();
		setResizable(false);
		contentPane.setBackground(new Color(143,88,0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("BookStore Alonso");
		Image icon = new ImageIcon(getClass().getResource("/assets/logoGalleta.png")).getImage();
		setIconImage(icon);
		contentPane.setLayout(new CardLayout(0, 0));

		JPanel basicPanel = new JPanel();
		basicPanel.setBackground(new Color(244, 164, 96));

		contentPane.add(basicPanel);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(230,156, 35));

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(UI.class.getResource("/assets/galleta.png logo.png")));

		JLabel lblBookstoreAlonso = new JLabel("BookStore Alonso");
		lblBookstoreAlonso.setFont(new Font("Tempus Sans ITC", Font.ITALIC, 40));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup().addGap(232)
								.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addGap(189))
						.addGroup(gl_panel.createSequentialGroup().addGap(307)
								.addComponent(lblBookstoreAlonso, GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
								.addGap(319)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_panel.createSequentialGroup().addContainerGap(70, Short.MAX_VALUE).addComponent(lblBookstoreAlonso)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 571, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		panel.setLayout(gl_panel);
		GroupLayout gl_basicPanel = new GroupLayout(basicPanel);
		gl_basicPanel.setHorizontalGroup(gl_basicPanel.createParallelGroup(Alignment.LEADING).addComponent(panel,
				GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		gl_basicPanel.setVerticalGroup(gl_basicPanel.createParallelGroup(Alignment.LEADING).addComponent(panel,
				GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		basicPanel.setLayout(gl_basicPanel);
//		

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(72,151,219));
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Acctions");
		mnNewMenu.setBackground(new Color(66,166,255));
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 22));
		menuBar.add(mnNewMenu);

		JMenuItem menuBtnSave = new JMenuItem("Save Book");
		menuBtnSave.setBackground(new Color(66,166,255));
		menuBtnSave.setFont(new Font("Segoe UI", Font.BOLD, 22));
		mnNewMenu.add(menuBtnSave);
		menuBtnSave.addActionListener(changePanel("PanelBook"));

		JMenuItem menuBtnSearchEdit = new JMenuItem("Search/Edit Book");
		menuBtnSearchEdit.setBackground(new Color(66,166,255));
		menuBtnSearchEdit.setFont(new Font("Segoe UI", Font.BOLD, 22));
		mnNewMenu.add(menuBtnSearchEdit);
		menuBtnSearchEdit.addActionListener(changePanel("PanelBookSearchEdit"));

		JMenuItem menuBtnDeleteBook = new JMenuItem("Add/Delete Book");
		menuBtnDeleteBook.setBackground(new Color(66,166,255));
		menuBtnDeleteBook.setFont(new Font("Segoe UI", Font.BOLD, 22));
		mnNewMenu.add(menuBtnDeleteBook);
		menuBtnDeleteBook.addActionListener(changePanel("PanelBookChange"));

		JMenuItem menuBtnLibrary = new JMenuItem("Library");
		menuBtnLibrary.setBackground(new Color(66,166,255));
		menuBtnLibrary.setFont(new Font("Segoe UI", Font.BOLD, 22));
		mnNewMenu.add(menuBtnLibrary);
		menuBtnLibrary.addActionListener(changePanel("PanelTable"));

		JMenuItem menuBtnExit = new JMenuItem("EXIT");
		menuBtnExit.setBackground(new Color(66,166,255));
		menuBtnExit.setFont(new Font("Segoe UI", Font.BOLD, 22));
		mnNewMenu.add(menuBtnExit);
		menuBtnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		MainWindow main = new MainWindow();
		contentPane.add(main.getViewTable(), "PanelTable");
		contentPane.add(main.getViewSave(), "PanelBook");
		contentPane.add(main.getViewSearchEdit(), "PanelBookSearchEdit");
		contentPane.add(main.getViewChange(), "PanelBookChange");
		main.presentar(new ParaUI(this));
	}

	private void asociarPanel(String string) {
		((CardLayout) contentPane.getLayout()).show(contentPane, string);
	}

	private ActionListener changePanel(String namePanel) {

		ActionListener changePanel = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				asociarPanel(namePanel);
				setResizable(true);

			}
		};

		return changePanel;

	}

}
