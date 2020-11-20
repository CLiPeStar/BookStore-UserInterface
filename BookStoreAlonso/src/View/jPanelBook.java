package View;

import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class jPanelBook extends JPanel {
	private RegistrationFieldsView registerFieldsPanel;
	private FormatsView formats;
	private StateView state;
	private JPanel panelButtonDinamic;



	/**
	 * Create the panel.
	 */
	public jPanelBook() {
		setBackground(new Color(33,91,143));

		JPanel panelFields = new JPanel();
		registerFieldsPanel = new RegistrationFieldsView();
		panelFields.add(registerFieldsPanel);

		JPanel panelLogo = new JPanel();
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(33,91,143));
		panelLogo.add(lblNewLabel);
		panelLogo.setBackground(new Color(33,91,143));
		lblNewLabel.setIcon(new ImageIcon(jPanelBook.class.getResource("/assets/icono.png")));

		JPanel panelState = new JPanel();
		panelState.setBackground(new Color(33,91,143));
		state = new StateView();
		panelState.add(state);

		JPanel panelFormat = new JPanel();
		formats = new FormatsView();
		panelFormat.add(formats);
		
		panelButtonDinamic = new JPanel();

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panelButtonDinamic, GroupLayout.DEFAULT_SIZE, 954, Short.MAX_VALUE)
							.addGap(2))
						.addComponent(panelFormat, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 956, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panelFields, GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panelLogo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panelState, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panelState, GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
						.addComponent(panelLogo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panelFields, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelFormat, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panelButtonDinamic, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(47))
		);
		panelButtonDinamic.setLayout(new GridLayout(1, 0, 0, 0));
		panelFormat.setLayout(new GridLayout(1, 0, 0, 0));
		panelState.setLayout(new GridLayout(1, 0, 0, 0));
		panelLogo.setLayout(new GridLayout(1, 0, 0, 0));

		panelFields.setLayout(new GridLayout(1, 0, 0, 0));
		setLayout(groupLayout);

	}

	public JSpinner getSpinnerUnits() {
		return registerFieldsPanel.spinnerUnits();
	}

	public JTextField getTextISBN() {
		return registerFieldsPanel.getTextISBN();
	}

	public JTextField getTextTitle() {
		return registerFieldsPanel.getTextTitle();
	}

	public JTextField getTextAuthor() {
		return registerFieldsPanel.getTextAuthor();
	}

	public JTextField getTextEditorial() {
		return registerFieldsPanel.getTextEditorial();
	}

	public JTextField getTextPrice() {
		return registerFieldsPanel.getTextPrice();
	}

	public ButtonGroup getFormatGroup() {
		return formats.getFormatGroup();
	}

	public ButtonGroup getStateGroup() {
		return state.getStateGroup();
	}
	public FormatsView getFormats() {
		return formats;
	}

	public StateView getState() {
		return state;
	}
	public JPanel getPanelButtonDinamic() {
		return panelButtonDinamic;
	}
	public JComboBox getComboBoxThematic() {
		return registerFieldsPanel.getComboBoxThematic();
	}
	
}
