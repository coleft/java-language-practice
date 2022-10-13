package format;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SimpleDatePanel extends JPanel {
	private JLabel lblNewLabel;
	private JTextField format;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	/**
	 * Create the panel.
	 */
	public SimpleDatePanel() {
		setLayout(null);
		add(getLblNewLabel());
		add(getFormat());
		add(getBtnNewButton());
		add(getScrollPane());

	}

	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("포맷");
			lblNewLabel.setBounds(12, 10, 57, 15);
		}
		return lblNewLabel;
	}
	public JTextField getFormat() {
		if (format == null) {
			format = new JTextField();
			format.setText("");
			format.setBounds(81, 7, 357, 21);
			format.setColumns(10);
		}
		return format;
	}
	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("실행");
			btnNewButton.addActionListener(new ActionListener() {	//추가된 코드
				public void actionPerformed(ActionEvent e) {					
					
					SimpleDateFormat sdf = new SimpleDateFormat(format.getText());
					String r = sdf.format(new Date());
					textArea.append("format : " + format.getText() + "\n");
					textArea.append("result : " + r + "\n");
				}
			});
			btnNewButton.setBounds(81, 38, 357, 23);
		}
		return btnNewButton;
	}
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 71, 426, 219);
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
