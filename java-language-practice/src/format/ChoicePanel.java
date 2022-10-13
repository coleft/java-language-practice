package format;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.text.ChoiceFormat;
import java.awt.event.ActionEvent;

public class ChoicePanel extends JPanel {
	private JLabel lblNewLabel;
	private JTextField limit;
	private JLabel lblNewLabel_1;
	private JTextField grade;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1_1;
	private JTextField score;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	/**
	 * Create the panel.
	 */
	public ChoicePanel() {
		setLayout(null);
		add(getLblNewLabel());
		add(getLimit());
		add(getLblNewLabel_1());
		add(getGrade());
		add(getBtnNewButton());
		add(getLblNewLabel_1_1());
		add(getScore());
		add(getScrollPane_1());

	}

	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("limit");
			lblNewLabel.setBounds(12, 10, 57, 15);
		}
		return lblNewLabel;
	}
	public JTextField getLimit() {
		if (limit == null) {
			limit = new JTextField();
			limit.setBounds(81, 7, 357, 18);
			limit.setColumns(10);
		}
		return limit;
	}
	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("grade");
			lblNewLabel_1.setBounds(12, 38, 57, 15);
		}
		return lblNewLabel_1;
	}
	public JTextField getGrade() {
		if (grade == null) {
			grade = new JTextField();
			grade.setColumns(10);
			grade.setBounds(81, 35, 357, 18);
		}
		return grade;
	}
	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("실행");
			btnNewButton.addActionListener(new ActionListener() {
				
				/*
				public void actionPerformed(ActionEvent e) {
					
					int[] score = {634,5,45,65,8,7,846,3,13,86,9,7957,4,653};
					String[] temp = limit.getText().split(",");
					String[] g = grade.getText().split(",");
					double[] d = new double[temp.length];
					for(int i = 0; i<d.length; i++) {
						d[i] = Double.parseDouble(temp[i]);
					}
					ChoiceFormat cf = new ChoiceFormat(d,g);
					for(int i = 0; i<score.length; i++) {
						textArea.append(score[i] + " = " + cf.format(score[i]) + "\n");
					}
					
				}
				*/
				
				public void actionPerformed(ActionEvent e) {
					
					
					String[] temp = limit.getText().split(",");
					
					String[] g = grade.getText().split(",");
					double[] d = new double[temp.length];
					
					String[] tempScore = score.getText().split(",");
					int[] s = new int[tempScore.length];
					
					for(int i = 0; i<tempScore.length; i++) {
						s[i] = Integer.parseInt(tempScore[i]);
					}
					
					for(int i = 0; i<d.length; i++) {
						d[i] = Double.parseDouble(temp[i]);
					}
					
					ChoiceFormat cf = new ChoiceFormat(d,g);
					for(int i = 0; i<s.length; i++) {
						textArea.append(s[i] + " = " + cf.format(s[i]) + "\n");
						textArea.append("\n");
					}
					
				}
				
			});
			btnNewButton.setBounds(81, 91, 357, 23);
		}
		return btnNewButton;
	}
	public JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("score");
			lblNewLabel_1_1.setBounds(12, 66, 57, 15);
		}
		return lblNewLabel_1_1;
	}
	public JTextField getScore() {
		if (score == null) {
			score = new JTextField();
			score.setColumns(10);
			score.setBounds(81, 63, 357, 18);
		}
		return score;
	}
	public JScrollPane getScrollPane_1() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 124, 426, 166);
			scrollPane.setViewportView(getTextArea_1());
		}
		return scrollPane;
	}
	public JTextArea getTextArea_1() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}
}
