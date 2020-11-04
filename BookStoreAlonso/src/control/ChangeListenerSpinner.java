package control;

import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ChangeListenerSpinner implements ChangeListener{
	private BookStoreController bookStore;
	private ViewController viewControl;

	public ChangeListenerSpinner(BookStoreController bookStore, ViewController viewController) {
		super();
		this.bookStore = bookStore;
		this.viewControl = viewController;
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		viewControl.changeUnitsTotal(bookStore);
		
	}

}
