package format;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class DecimalPanel extends JPanel {
	private JTextField pattern;
	private JTextField number;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	/**
	 * Create the panel.
	 */
	public DecimalPanel() {
		setLayout(null);
		add(getPattern());
		add(getNumber());
		add(getLblNewLabel());
		add(getLblNewLabel_1());
		add(getBtnNewButton());
		add(getScrollPane());

	}

	public JTextField getPattern() {
		if (pattern == null) {
			pattern = new JTextField();
			pattern.setBounds(81, 5, 357, 21);
			pattern.setColumns(10);
		}
		return pattern;
	}
	public JTextField getNumber() {
		if (number == null) {
			number = new JTextField();
			number.setColumns(10);
			number.setBounds(81, 36, 357, 21);
		}
		return number;
	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("패턴");
			lblNewLabel.setBounds(12, 8, 57, 15);
		}
		return lblNewLabel;
	}
	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("숫자");
			lblNewLabel_1.setBounds(12, 39, 57, 15);
		}
		return lblNewLabel_1;
	}
	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("실행");
			
			btnNewButton.addActionListener(new ActionListener() {				
				public void actionPerformed(ActionEvent e) {
					
					   double d = Double.parseDouble(number.getText());
					   String p = pattern.getText();
					   DecimalFormat df = new DecimalFormat(p);
					   String r = df.format(d);
					   textArea.append("pattern : " + p + "\n");
					   textArea.append("number : " + d + "\n");
					   textArea.append("result : " + r + "\n");						
					
				}
			});
			btnNewButton.setBounds(81, 67, 357, 23);
		}
		return btnNewButton;
	}
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 100, 426, 190);
			scrollPane.setViewportView(getTextArea());
		}
		return scrollPane;
	}
	public JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}
}
