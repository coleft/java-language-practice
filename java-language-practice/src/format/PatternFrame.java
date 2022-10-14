package format;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class PatternFrame extends JInternalFrame {
	private JLabel lblNewLabel;
	private JTextField emailPattern;
	private JLabel lblNewLabel_1;
	private JTextField emailValue;
	private JSeparator separator;
	private JButton btnNewButton;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_1_1;
	private JTextField phonePattern;
	private JTextField phoneValue;
	private JButton btnNewButton_1;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatternFrame frame = new PatternFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PatternFrame() {
		super("이메일", true, true, true, true);
		setBounds(100, 100, 759, 467);
	    //setBounds(100, 100, 654, 344);
	    setVisible(true);		
		
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getEmailPattern());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getEmailValue());
		getContentPane().add(getSeparator());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getLblNewLabel_2());
		getContentPane().add(getLblNewLabel_1_1());
		getContentPane().add(getPhonePattern());
		getContentPane().add(getPhoneValue());
		getContentPane().add(getBtnNewButton_1());
		getContentPane().add(getScrollPane());

	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("이메일 패턴");
			lblNewLabel.setBounds(12, 10, 89, 15);
		}
		return lblNewLabel;
	}
	public JTextField getEmailPattern() {
		if (emailPattern == null) {
			emailPattern = new JTextField();
			emailPattern.setText("\\w+@\\w+\\.\\w+(\\.\\w+)?");
			emailPattern.setBounds(113, 7, 474, 21);
			emailPattern.setColumns(10);
		}
		return emailPattern;
	}
	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("이메일 입력");
			lblNewLabel_1.setBounds(12, 38, 89, 15);
		}
		return lblNewLabel_1;
	}
	public JTextField getEmailValue() {
		if (emailValue == null) {
			emailValue = new JTextField();
			emailValue.setColumns(10);
			emailValue.setBounds(113, 35, 474, 21);
		}
		return emailValue;
	}
	public JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(12, 63, 719, 5);
		}
		return separator;
	}
	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("New button");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String ep = emailPattern.getText();
					String v = emailValue.getText();
					boolean b = Pattern.matches(ep, v);
					textArea.append("이메일 패턴 : " + ep);
					textArea.append("\n이메일입력 : " + v);
					textArea.append("\n체크 결과 : " + b);
					textArea.append("-".repeat(40) + "\n");
					
				}
			});
			btnNewButton.setBounds(599, 6, 132, 49);
		}
		return btnNewButton;
	}
	public JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("연락처 패턴");
			lblNewLabel_2.setBounds(12, 80, 89, 15);
		}
		return lblNewLabel_2;
	}
	public JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("연락처 입력");
			lblNewLabel_1_1.setBounds(12, 108, 89, 15);
		}
		return lblNewLabel_1_1;
	}
	public JTextField getPhonePattern() {
		if (phonePattern == null) {
			phonePattern = new JTextField();
			phonePattern.setText("\\d{2,3}-\\d{3,4}-\\d{4}");
			phonePattern.setColumns(10);
			phonePattern.setBounds(113, 77, 474, 21);
		}
		return phonePattern;
	}
	public JTextField getPhoneValue() {
		if (phoneValue == null) {
			phoneValue = new JTextField();
			phoneValue.setColumns(10);
			phoneValue.setBounds(113, 105, 474, 21);
		}
		return phoneValue;
	}
	public JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("New button");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String pp = phonePattern.getText();
					String pv = phoneValue.getText();
					boolean b = Pattern.matches(pp, pv);
					textArea.append("연락처 패턴 : " + pp);
					textArea.append("\n연락처 입력 : " + pv);
					textArea.append("\n체크 결과 : " + b);
					textArea.append("-".repeat(40) + "\n");
					
				}
			});
			btnNewButton_1.setBounds(599, 76, 132, 49);
		}
		return btnNewButton_1;
	}
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 145, 719, 282);
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
