package control;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

public class KeyListenerFieldsValidations implements KeyListener {
	private ViewController viewControl;

	public KeyListenerFieldsValidations(ViewController viewController) {
		super();
		this.viewControl = viewController;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
//		viewControl.setForeground(Color.RED);
//		if (viewControl.validateIsbn(fieldValidation.getText())) {
//			fieldValidation.setForeground(Color.black);
//		}

		;
	}

}
