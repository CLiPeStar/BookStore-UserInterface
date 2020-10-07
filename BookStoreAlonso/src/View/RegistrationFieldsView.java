package View;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSpinner;

public class RegistrationFieldsView extends JPanel {
	private JTextField textISBN;
	private JTextField textTitle;
	private JTextField textAuthor;
	private JTextField textEditorial;
	private JTextField textPrice;
	private JSpinner txtUnits;

	/**
	 * Create the panel.
	 */
	public RegistrationFieldsView() {
		setBackground(new Color(250, 240, 230));
		JLabel lblIsbn = new JLabel("ISBN:");
		lblIsbn.setFont(new Font("Tahoma", Font.PLAIN, 20));

		textISBN = new JTextField();
		textISBN.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textISBN.setColumns(10);

		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));

		textTitle = new JTextField();
		textTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textTitle.setText("");
		textTitle.setColumns(10);

		JLabel lblAuthor = new JLabel("Author:");
		lblAuthor.setFont(new Font("Tahoma", Font.PLAIN, 20));

		textAuthor = new JTextField();
		textAuthor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textAuthor.setColumns(10);

		JLabel lblEditorial = new JLabel("Editorial:");
		lblEditorial.setFont(new Font("Tahoma", Font.PLAIN, 20));

		textEditorial = new JTextField();
		textEditorial.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textEditorial.setColumns(10);

		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 20));

		textPrice = new JTextField();
		textPrice.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textPrice.setColumns(10);

		JLabel lblUnits = new JLabel("Units");
		lblUnits.setFont(new Font("Tahoma", Font.PLAIN, 20));

		txtUnits = new JSpinner();
		txtUnits.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtUnits, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
							.addGap(311))
						.addComponent(textISBN, GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
						.addComponent(lblIsbn)
						.addComponent(lblTitle)
						.addComponent(textTitle, GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
						.addComponent(lblAuthor)
						.addComponent(textAuthor, GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
						.addComponent(lblEditorial)
						.addComponent(textEditorial, GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
						.addComponent(textPrice, GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
						.addComponent(lblPrice)
						.addComponent(lblUnits))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblIsbn)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textISBN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblTitle)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textTitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblAuthor)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textAuthor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblEditorial)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textEditorial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblPrice)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblUnits)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtUnits, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(62, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}

	public JSpinner spinnerUnits() {
		return txtUnits;
	}

	public JTextField getTextISBN() {
		return textISBN;
	}

	public JTextField getTextTitle() {
		return textTitle;
	}

	public JTextField getTextAuthor() {
		return textAuthor;
	}

	public JTextField getTextEditorial() {
		return textEditorial;
	}

	public JTextField getTextPrice() {
		return textPrice;
	}
}
