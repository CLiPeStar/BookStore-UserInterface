package control;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.EditionStatus;

public class ChangeListenerTabbedPanel implements ChangeListener {
	private ViewController viewControl;

	public ChangeListenerTabbedPanel(ViewController viewControl) {
		super();
		this.viewControl = viewControl;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		if (getTabbedPanel().getSelectedIndex() == 0) {
			getBtnSave().setEnabled(true);
			viewControl.getTable().clearSelection();
		} else {
			viewControl.setStatus(EditionStatus.UNEDITED);
			getBtnSave().setEnabled(false);
			viewControl.resetForm();
		}

	}

	private JTabbedPane getTabbedPanel() {
		return viewControl.getTabbedPanel();
	}

	private JButton getBtnSave() {
		return viewControl.getBtnSave();
	}

}
