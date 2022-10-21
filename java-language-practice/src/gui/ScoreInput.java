package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import format.MyInterMain;
import iostream.ScoreDao;
import iostream.ScoreVo;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class ScoreInput extends JInternalFrame {
	MyInterMain main;
	private JLabel lblNewLabel;
	private JTextField tfSerial;
	private JLabel lblId;
	private JTextField tfId;
	private JLabel lblNewLabel_2;
	private JTextField tfMdate;
	private JLabel lblNewLabel_3;
	private JTextField tfSubject;
	private JLabel lblNewLabel_4;
	private JTextField tfScore;
	private JButton btnSave;
	private JButton btnModify;
	private JButton btnDelete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScoreInput frame = new ScoreInput();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ScoreInput(MyInterMain main) {
		this();
		this.main = main;
	}	
	
	/**
	 * Create the frame.
	 */
	public ScoreInput() {
		super("성적입력", false, true, true, true);
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				main.si = null;
			}
		});
		
		
		
		setVisible(true);
		setBounds(100, 100, 365, 233);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getTfSerial());
		getContentPane().add(getLblId());
		getContentPane().add(getTfId());
		getContentPane().add(getLblNewLabel_2());
		getContentPane().add(getTfMdate());
		getContentPane().add(getLblNewLabel_3());
		getContentPane().add(getTfSubject());
		getContentPane().add(getLblNewLabel_4());
		getContentPane().add(getTfScore());
		getContentPane().add(getBtnSave());
		getContentPane().add(getBtnModify());
		getContentPane().add(getBtnDelete());

	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Serial");
			lblNewLabel.setBounds(12, 10, 57, 15);
		}
		return lblNewLabel;
	}
	public JTextField getTfSerial() {
		if (tfSerial == null) {
			tfSerial = new JTextField();
			tfSerial.setBounds(81, 7, 96, 18);
			tfSerial.setColumns(10);
		}
		return tfSerial;
	}
	public JLabel getLblId() {
		if (lblId == null) {
			lblId = new JLabel("ID");
			lblId.setBounds(12, 38, 57, 15);
		}
		return lblId;
	}
	public JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setColumns(10);
			tfId.setBounds(81, 35, 139, 18);
		}
		return tfId;
	}
	public JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("시험일자");
			lblNewLabel_2.setBounds(12, 66, 57, 15);
		}
		return lblNewLabel_2;
	}
	public JTextField getTfMdate() {
		if (tfMdate == null) {
			tfMdate = new JTextField();
			tfMdate.setColumns(10);
			tfMdate.setBounds(81, 63, 195, 18);
		}
		return tfMdate;
	}
	public JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("과목");
			lblNewLabel_3.setBounds(12, 94, 57, 15);
		}
		return lblNewLabel_3;
	}
	public JTextField getTfSubject() {
		if (tfSubject == null) {
			tfSubject = new JTextField();
			tfSubject.setColumns(10);
			tfSubject.setBounds(81, 91, 246, 18);
		}
		return tfSubject;
	}
	public JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("성적");
			lblNewLabel_4.setBounds(12, 122, 57, 15);
		}
		return lblNewLabel_4;
	}
	public JTextField getTfScore() {
		if (tfScore == null) {
			tfScore = new JTextField();
			tfScore.setColumns(10);
			tfScore.setBounds(81, 119, 139, 18);
		}
		return tfScore;
	}
	public JButton getBtnSave() {
		if (btnSave == null) {
			btnSave = new JButton("저장");
			btnSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int serial = Integer.parseInt(tfSerial.getText());
					String id = tfId.getText();
					String mDate = tfMdate.getText();
					String subject = tfSubject.getText();
					int score = Integer.parseInt(tfScore.getText());
					
					ScoreVo vo = new ScoreVo(serial,id, mDate, subject, score);
					ScoreDao dao = new ScoreDao();
					dao.write(vo);//여기까지 UI단까지는 할 일이 다 끝난 것이다.
				}
			});
			btnSave.setBounds(12, 147, 97, 32);
		}
		return btnSave;
	}
	public JButton getBtnModify() {
		if (btnModify == null) {
			btnModify = new JButton("수정");
			btnModify.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					//수정된 정보를 가져와 ScoreVo 객체 생성
					int serial = Integer.parseInt(getTfSerial().getText());
					String id = getTfId().getText();
					String mDate = getTfMdate().getText();
					String subject = getTfSubject().getText();
					int score = Integer.parseInt(getTfScore().getText());
					ScoreVo vo = new ScoreVo(serial, id, mDate, subject, score);
					
					//ScoreDao.modify(vo) 호출
					ScoreDao dao = new ScoreDao();
					dao.modify(vo);
					
					
				}
			});
			btnModify.setBounds(121, 147, 97, 32);
		}
		return btnModify;
	}
	public JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("삭제");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ScoreDao dao = new ScoreDao();
					Integer serial = Integer.parseInt(((ScoreInput)main.si).getTfId().getText());
										
					dao.delete(serial);
					
				}
			});
			btnDelete.setBounds(230, 147, 97, 32);
		}
		return btnDelete;
	}
}
