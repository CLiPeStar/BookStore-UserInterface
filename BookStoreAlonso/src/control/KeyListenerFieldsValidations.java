package control;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

public class KeyListenerFieldsValidations implements KeyListener {
	private ViewController viewControl;
	private JTextField field;

	public KeyListenerFieldsValidations(ViewController viewController, JTextField field) {
		super();
		this.field = field;
		this.viewControl = viewController;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		field.setForeground(Color.RED);
		if (viewControl.validateIsbn(field.getText())) {
			field.setForeground(Color.green);
		}

		;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
