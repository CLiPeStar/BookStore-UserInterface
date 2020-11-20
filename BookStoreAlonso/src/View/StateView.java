package View;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.SwingConstants;

public class StateView extends JPanel {
	private ButtonGroup stateGroup = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public StateView() {
		setBackground(new Color(72,151,219));
		setForeground(new Color(72,151,219));
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 255, 255), new Color(0, 0, 0)), "State", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(new GridLayout(2, 1, 0, 0));

		JRadioButton rdbtnReissue = new JRadioButton("Reissue");
		rdbtnReissue.setBackground(new Color(72,151,219));
		rdbtnReissue.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnReissue.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(rdbtnReissue);

		JRadioButton rdbtnNovelty = new JRadioButton("Novelty");
		rdbtnNovelty.setBackground(new Color(72,151,219));
		rdbtnNovelty.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnNovelty.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(rdbtnNovelty);
		stateGroup.add(rdbtnNovelty);
		stateGroup.add(rdbtnReissue);

	}

	public ButtonGroup getStateGroup() {
		return stateGroup;
	}

}
