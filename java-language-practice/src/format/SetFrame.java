package format;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.awt.event.ActionEvent;

public class SetFrame extends JInternalFrame {
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetFrame frame = new SetFrame();
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
	public SetFrame() {
		super("Set을 사용한 로또번호 추출",false,true,false,true);
		setBounds(100, 100, 743, 462);
		setVisible(true);
		getContentPane().setLayout(null);
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getScrollPane());
		getContentPane().add(getBtnNewButton_1());
		

	}
	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("LOTTO 번호 추출 !!");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Set<Integer> set = new HashSet<Integer>();
					for(int i = 0; i<5; i++) {
						set.clear();
						do {
							int n = (int)(Math.random()*45)+1;
							set.add(n);
						}while(set.size()<6);
						
						
						textArea.append(set.toString() +'\n');
					}
					
					textArea.append("\n");
					
					/*
					Set<Integer> lotto = new HashSet<Integer>();
					while(lotto.size()<6) {	//중복 처리 아직 안 함.
						int rn = (int)Math.ceil(Math.random()*46);
						lotto.add(rn);
					}
					Iterator<Integer> iter = lotto.iterator();
					while(iter.hasNext()) {
						Integer s = iter.next();
						textArea.append(String.valueOf(s)+" ");
					}					
					
					textArea.append("\n" + "-".repeat(40) + "\n");
					*/
					
				}
			});
			btnNewButton.setBounds(12, 362, 348, 60);
		}
		return btnNewButton;
	}
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 10, 703, 342);
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
	public JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("전체 삭제");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textArea.setText("");
				}
			});
			btnNewButton_1.setBounds(367, 362, 348, 60);
		}
		return btnNewButton_1;
	}
}
