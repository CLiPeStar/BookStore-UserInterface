package View;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.SwingConstants;

public class FormatsView extends JPanel {
	private ButtonGroup formatGroup = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public FormatsView() {
		setBackground(new Color(250, 240, 230));
		setForeground(new Color(250, 240, 230));
		setFont(new Font("Tahoma", Font.PLAIN, 20));
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(0, 0, 0)),
				"Format", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(new GridLayout(1, 0, 0, 0));

		JRadioButton rdbtnBoard = new JRadioButton("Board");
		rdbtnBoard.setBackground(new Color(250, 240, 230));
		rdbtnBoard.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnBoard.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(rdbtnBoard);

		JRadioButton rdbtnRustic = new JRadioButton("Rustic");
		rdbtnRustic.setBackground(new Color(250, 240, 230));
		rdbtnRustic.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnRustic.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(rdbtnRustic);

		JRadioButton rdbtnStapled = new JRadioButton("Stapled");
		rdbtnStapled.setBackground(new Color(250, 240, 230));
		rdbtnStapled.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnStapled.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(rdbtnStapled);

		JRadioButton rdbtnSpiral = new JRadioButton("Spiral");
		rdbtnSpiral.setBackground(new Color(250, 240, 230));
		rdbtnSpiral.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnSpiral.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(rdbtnSpiral);

		formatGroup.add(rdbtnBoard);
		formatGroup.add(rdbtnRustic);
		formatGroup.add(rdbtnStapled);
		formatGroup.add(rdbtnSpiral);

	}

	public ButtonGroup getFormatGroup() {
		return formatGroup;
	}

}
