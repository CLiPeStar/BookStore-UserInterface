package View;

import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.util.Enumeration;
import java.awt.GridLayout;

public class PanelSearchEdit extends JPanel {
	private RegistrationFieldsView register = new RegistrationFieldsView();
	private FormatsView formatSection = new FormatsView();
	private StateView stateSection = new StateView();
	private JPanel PanelResponsivo;

	/**
	 * Create the panel.
	 */
	public PanelSearchEdit() {
		setLayout(new BorderLayout(0, 0));

		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(new Color(244, 164, 96));
		add(mainPanel, BorderLayout.CENTER);

		JPanel panelRegister = new JPanel();
		panelRegister.setLayout(new BorderLayout(0, 0));
		register.getTextTitle().setEnabled(false);
		register.getTextAuthor().setEnabled(false);
		register.getTextEditorial().setEnabled(false);
		register.getTextPrice().setEnabled(false);
		register.getTxtUnits().setEnabled(false);
		register.getComboBoxThematic().setEnabled(false);
		panelRegister.add(register);

		JPanel panelState = new JPanel();
		panelState.setLayout(new BorderLayout(0, 0));
		panelState.add(stateSection);

		JPanel panelFormat = new JPanel();
		panelFormat.setBackground(new Color(255, 218, 185));
		panelFormat.setLayout(new BorderLayout(0, 0));
		panelFormat.add(formatSection);

		PanelResponsivo = new JPanel();
		PanelResponsivo.setBackground(new Color(244, 164, 96));
		GroupLayout gl_mainPanel = new GroupLayout(mainPanel);
		gl_mainPanel.setHorizontalGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_mainPanel.createSequentialGroup().addContainerGap()
						.addGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(panelFormat, GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
								.addGroup(gl_mainPanel.createSequentialGroup()
										.addComponent(panelRegister, GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(panelState, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE))
								.addComponent(PanelResponsivo, GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE))
						.addContainerGap()));
		gl_mainPanel.setVerticalGroup(gl_mainPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_mainPanel.createSequentialGroup().addContainerGap()
						.addGroup(gl_mainPanel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(panelState, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panelRegister, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 441,
										Short.MAX_VALUE))
						.addGap(18)
						.addComponent(panelFormat, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(PanelResponsivo, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(46, Short.MAX_VALUE)));
		PanelResponsivo.setLayout(new GridLayout(1, 0, 0, 0));
		mainPanel.setLayout(gl_mainPanel);

		changeStateButtonGroup(formatSection.getFormatGroup());
		changeStateButtonGroup(stateSection.getStateGroup());
	}

	private void changeStateButtonGroup(ButtonGroup radiousButtonGroup) {
		for (Enumeration<AbstractButton> buttons = radiousButtonGroup.getElements(); buttons.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();
			button.setEnabled(false);
		}
	}

	public RegistrationFieldsView getPanelRegsiterSearchEdit() {
		return register;
	}

	public FormatsView getFormatSectionSearchEdit() {
		return formatSection;
	}

	public StateView getStateSectionSearchEdit() {
		return stateSection;
	}

	public JPanel getPanelResponsivo() {

		return PanelResponsivo;
	}

}