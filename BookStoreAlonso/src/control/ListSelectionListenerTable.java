package control;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListSelectionListenerTable implements ListSelectionListener {
	private ViewController viewControl;

	public ListSelectionListenerTable(ViewController viewControl) {
		super();
		this.viewControl = viewControl;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (getTable().getSelectedRowCount() > 0) {
			getBtnDelete().setEnabled(true);
		} else {
			getBtnDelete().setEnabled(false);
		}
	}

	private JButton getBtnDelete() {
		return viewControl.getBtnDelete();
	}

	private JTable getTable() {
		return viewControl.getTable();
	}
}