package View;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Color;

public class jPanelTable extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public jPanelTable() {
		setBackground(new Color(250, 240, 230));
		setLayout(new GridLayout(1, 0, 0, 0));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);

		table = new JTable() {

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		scrollPane.setViewportView(table);
	}

	public JTable getTable() {
		return table;
	}

}