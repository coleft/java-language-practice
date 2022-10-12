package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;

public class FrameLayout extends JFrame {

	private JPanel contentPane;	//메인 셀로판지
	private JPanel panel;
	private JPanel panel_1;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {	//스레드를 돌려준다. 다중처리를 하겠다!!
			public void run() {
				try {
					FrameLayout frame = new FrameLayout();
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
	public FrameLayout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 565, 321);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(255, 0, 128), 20, true));
		
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanel(), BorderLayout.NORTH);
		contentPane.add(getPanel_1(), BorderLayout.WEST);
	}
	public JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setPreferredSize(new Dimension(10, 35));
			panel.add(getBtnNewButton());
		}
		return panel;
	}
	public JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setPreferredSize(new Dimension(95, 10));
			panel_1.add(getBtnNewButton_1());
		}
		return panel_1;
	}
	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("New button");
		}
		return btnNewButton;
	}
	public JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("New button");
		}
		return btnNewButton_1;
	}
}
