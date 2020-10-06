package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import java.awt.GridBagLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.Color;

public class KeyPadActions extends JPanel {
	private JButton btnSave;
	private JButton btnDelete;
	private JButton btnExit;
	private JButton btnSearch;

	/**
	 * Create the panel.
	 */
	public KeyPadActions() {
		setBackground(new Color(255, 222, 173));
		setFont(new Font("Tahoma", Font.PLAIN, 20));

		btnSave = new JButton("Save");
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 20));

		btnSearch = new JButton("Search");
		btnSearch.setEnabled(false);
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 20));

		btnDelete = new JButton("Delete");
		btnDelete.setEnabled(false);
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 20));

		btnExit = new JButton("Exit");

		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addComponent(btnSave, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE).addGap(10)
						.addComponent(btnSearch, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE).addGap(10)
						.addComponent(btnDelete, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE).addGap(10)
						.addComponent(btnExit, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(btnSave, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
				.addComponent(btnSearch, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
				.addComponent(btnDelete, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
				.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE));
		setLayout(groupLayout);
	}

	public JButton getBtnSave() {
		return btnSave;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public JButton getBtnExit() {
		return btnExit;
	}

	public JButton getBtnSearch() {
		return btnSearch;
	}

}
