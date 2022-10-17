package thread;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ThreadFrame extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JButton btnThread;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThreadFrame frame = new ThreadFrame();
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
	public ThreadFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 595, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnNewButton());
		contentPane.add(getScrollPane());
		contentPane.add(getBtnThread());
	}
	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("RUN");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//1~99,999,999의 수를 1씩 증가시켜 더하는 로직
					long sum = 0L;
					for(double i = 0; i<999999999; i=i+0.5) {						
						sum += (long)i;						
					}
					textArea.setText("sum = " + sum);
				}
			});
			btnNewButton.setBounds(12, 10, 271, 37);
		}
		return btnNewButton;
	}
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 55, 555, 272);
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
	public JButton getBtnThread() {
		if (btnThread == null) {
			btnThread = new JButton("THREAD");
			btnThread.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Thread t = new Thread(new Runnable(){	/* Runnable에는 run메소드를 꼭 추가하도록 설계돼있다. */	/* 여기서 추상메서드를 재정의하지 않으면 객체가 만들어지지 않는다. 절차를 따름. */
						@Override
						public void run() {
							long sum = 0L;
							for(double i = 0; i<999999999; i=i+0.5) {
								sum += (long)i;
							}
							textArea.setText("sum = " + sum);							
						}						
					}); 
					t.start();
				}
			});
			btnThread.setBounds(295, 10, 272, 37);
		}
		return btnThread;
	}
}
