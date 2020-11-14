package View;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.GridLayout;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class PanelAddDelete extends JPanel {
	private JLabel labelUnitsTotalDelete;
	private JTextField textFieldIsbnSearch;
	private JSpinner spinnerAdd;
	private JSpinner spinnerDelete;
	private JLabel labelTotalAdd;
	private JButton btnSearchAD;
	private JButton btnSaveChange;
	private JLabel labelTotalDelete;
	private JLabel labelUnitsAdd;
	private JCheckBox CheckBoxDeleteAll;

	/**
	 * Create the panel.
	 */
	public PanelAddDelete() {
		setBackground(new Color(244, 164, 96));
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 222, 173));
		add(panel, BorderLayout.CENTER);

		JLabel lblIsbn = new JLabel("ISBN:");
		lblIsbn.setFont(new Font("Tahoma", Font.PLAIN, 20));

		textFieldIsbnSearch = new JTextField();
		textFieldIsbnSearch.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldIsbnSearch.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 218, 185));
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		JPanel PanelBtn = new JPanel();
		PanelBtn.setBackground(new Color(250, 240, 230));

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1_1.setBackground(new Color(255, 218, 185));

		JLabel lblTotalUnits_1 = new JLabel("Total Units:");
		lblTotalUnits_1.setForeground(Color.GRAY);
		lblTotalUnits_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTotalUnits_1.setBackground(Color.GRAY);

		labelTotalDelete = new JLabel("0");
		labelTotalDelete.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblUnit_1 = new JLabel("Current Units:");
		lblUnit_1.setForeground(Color.GRAY);
		lblUnit_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUnit_1.setBackground(Color.GRAY);

		JLabel lblAdd_1 = new JLabel("Delete:");
		lblAdd_1.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblUnitsToDelete = new JLabel("Units to Delete:");
		lblUnitsToDelete.setForeground(Color.GRAY);
		lblUnitsToDelete.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUnitsToDelete.setBackground(Color.GRAY);

		labelUnitsTotalDelete = new JLabel("0");
		labelUnitsTotalDelete.setFont(new Font("Tahoma", Font.PLAIN, 20));

		spinnerDelete = new JSpinner();
		spinnerDelete.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinnerDelete.setEnabled(false);
		spinnerDelete.setFont(new Font("Tahoma", Font.PLAIN, 20));

		CheckBoxDeleteAll = new JCheckBox("Delete all book");
		CheckBoxDeleteAll.setEnabled(false);
		CheckBoxDeleteAll.setFont(new Font("Tahoma", Font.PLAIN, 17));
		CheckBoxDeleteAll.setBackground(new Color(255, 218, 185));
		GroupLayout gl_panel_1_1 = new GroupLayout(panel_1_1);
		gl_panel_1_1.setHorizontalGroup(gl_panel_1_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1_1.createSequentialGroup().addContainerGap(140, Short.MAX_VALUE)
						.addComponent(labelUnitsTotalDelete).addGap(123))
				.addGroup(gl_panel_1_1.createSequentialGroup().addGap(130)
						.addComponent(spinnerDelete, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE).addContainerGap())
				.addGroup(gl_panel_1_1.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel_1_1.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel_1_1.createSequentialGroup()
										.addComponent(lblTotalUnits_1, GroupLayout.PREFERRED_SIZE, 124,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(labelTotalDelete))
								.addComponent(CheckBoxDeleteAll))
						.addContainerGap(140, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING,
						gl_panel_1_1.createSequentialGroup().addContainerGap()
								.addComponent(lblAdd_1, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(192, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING,
						gl_panel_1_1.createSequentialGroup().addContainerGap().addComponent(lblUnit_1)
								.addContainerGap(140, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING,
						gl_panel_1_1
								.createSequentialGroup().addContainerGap().addComponent(lblUnitsToDelete,
										GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(115, Short.MAX_VALUE)));
		gl_panel_1_1.setVerticalGroup(gl_panel_1_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1_1
				.createSequentialGroup().addContainerGap()
				.addComponent(lblAdd_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_panel_1_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1_1.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
								.addComponent(labelUnitsTotalDelete, GroupLayout.PREFERRED_SIZE, 30,
										GroupLayout.PREFERRED_SIZE)
								.addGap(3))
						.addGroup(gl_panel_1_1.createSequentialGroup().addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(lblUnit_1).addPreferredGap(ComponentPlacement.RELATED)))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(lblUnitsToDelete, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE).addGap(26)
				.addComponent(
						spinnerDelete, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(18)
				.addGroup(gl_panel_1_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1_1.createSequentialGroup()
								.addComponent(lblTotalUnits_1, GroupLayout.PREFERRED_SIZE, 25,
										GroupLayout.PREFERRED_SIZE)
								.addGap(38))
						.addGroup(gl_panel_1_1.createSequentialGroup().addComponent(labelTotalDelete).addGap(18)))
				.addComponent(CheckBoxDeleteAll).addGap(23)));
		panel_1_1.setLayout(gl_panel_1_1);

		JPanel panel_2 = new JPanel();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(PanelBtn, GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup().addComponent(lblIsbn).addGap(18)
								.addComponent(textFieldIsbnSearch, GroupLayout.PREFERRED_SIZE, 285,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(panel_2,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
								.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE).addGap(40)
								.addComponent(panel_1_1, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)))
				.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 25, Short.MAX_VALUE)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblIsbn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(textFieldIsbnSearch, GroupLayout.PREFERRED_SIZE, 24,
												GroupLayout.PREFERRED_SIZE)))
						.addGap(26)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 325, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_1_1, GroupLayout.PREFERRED_SIZE, 325, GroupLayout.PREFERRED_SIZE))
						.addGap(18).addComponent(PanelBtn, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addGap(79)));
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));

		btnSearchAD = new JButton("Search");
		btnSearchAD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(btnSearchAD);
		PanelBtn.setLayout(new GridLayout(1, 0, 0, 0));

		btnSaveChange = new JButton("Save change");
		btnSaveChange.setEnabled(false);
		btnSaveChange.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PanelBtn.add(btnSaveChange);

		JLabel lblAdd = new JLabel("Add:");
		lblAdd.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblUnit = new JLabel("Current Units:");
		lblUnit.setForeground(Color.GRAY);
		lblUnit.setBackground(Color.GRAY);
		lblUnit.setFont(new Font("Tahoma", Font.PLAIN, 20));

		spinnerAdd = new JSpinner();
		spinnerAdd.setEnabled(false);
		spinnerAdd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		spinnerAdd.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));

		labelUnitsAdd = new JLabel("0");
		labelUnitsAdd.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblActualUnits = new JLabel("Units to Add:");
		lblActualUnits.setForeground(Color.GRAY);
		lblActualUnits.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblActualUnits.setBackground(Color.GRAY);

		JLabel lblTotalUnits = new JLabel("Total Units:");
		lblTotalUnits.setForeground(Color.GRAY);
		lblTotalUnits.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTotalUnits.setBackground(Color.GRAY);

		labelTotalAdd = new JLabel("0");
		labelTotalAdd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1
				.createSequentialGroup()
				.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup().addContainerGap().addComponent(lblActualUnits,
								GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup().addContainerGap().addComponent(lblUnit))
						.addGroup(gl_panel_1.createSequentialGroup().addContainerGap().addComponent(lblAdd,
								GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap())
				.addGroup(Alignment.TRAILING,
						gl_panel_1.createSequentialGroup().addContainerGap(140, Short.MAX_VALUE)
								.addComponent(labelUnitsAdd).addGap(123))
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup().addGap(130)
						.addComponent(spinnerAdd, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE).addContainerGap())
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING).addComponent(labelTotalAdd)
								.addComponent(lblTotalUnits, GroupLayout.PREFERRED_SIZE, 124,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap(140, Short.MAX_VALUE)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(lblAdd, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 44, Short.MAX_VALUE).addComponent(lblUnit)
								.addGap(41)
								.addComponent(lblActualUnits, GroupLayout.PREFERRED_SIZE, 25,
										GroupLayout.PREFERRED_SIZE)
								.addGap(11))
						.addGroup(Alignment.TRAILING,
								gl_panel_1.createSequentialGroup()
										.addComponent(labelUnitsAdd, GroupLayout.PREFERRED_SIZE, 30,
												GroupLayout.PREFERRED_SIZE)
										.addGap(39)))
				.addGap(18)
				.addComponent(spinnerAdd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE)
				.addGap(18).addComponent(lblTotalUnits, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(labelTotalAdd).addGap(53)));
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(gl_panel);

	}

	public JLabel getLabelUnitsTotalDelete() {
		return labelUnitsTotalDelete;
	}

	public JTextField getTextFieldIsbnSearch() {
		return textFieldIsbnSearch;
	}

	public JSpinner getSpinnerAdd() {
		return spinnerAdd;
	}

	public JSpinner getSpinnerDelete() {
		return spinnerDelete;
	}

	public JLabel getLabelTotalAdd() {
		return labelTotalAdd;
	}

	public JButton getBtnSearchAD() {
		return btnSearchAD;
	}

	public JButton getBtnSaveChange() {
		return btnSaveChange;
	}

	public JLabel getLabelTotalDelete() {
		return labelTotalDelete;
	}

	public JLabel getLabelUnitsAdd() {
		return labelUnitsAdd;
	}

	public JCheckBox getCheckBoxDeleteAll() {
		return CheckBoxDeleteAll;
	}

}
