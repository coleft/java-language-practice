package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import format.MyInterMain;
import jdbc.MemberVo;
import jdbc.ScoreDto;
import jdbc.ScoreVo;

import javax.swing.JButton;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ScoreInputDB extends JInternalFrame {
	
	MyInterMain main;
	ScoreSearchDB ssdb;
	
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
					ScoreInputDB frame = new ScoreInputDB();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ScoreInputDB(MyInterMain main) {
		this();
		this.main = main;	//객체가 있어야 해 !!
	}
	
	/**
	 * Create the frame.
	 */
	public ScoreInputDB() {
		
		super("성적입력DB", false, true, false, true);
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				main.sidb = null;
			}
		});
		setVisible(true);
		
		
		
		setBounds(100, 100, 450, 300);
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
	
	public void loadData(ScoreVo vo) {
		tfSerial.setText(vo.getSerial());
		tfId.setText(vo.getId());
		tfMdate.setText(vo.getMdate());
		tfSubject.setText(vo.getSubject());
		tfScore.setText(vo.getScore());		
	}
	
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Serial");
			lblNewLabel.setBounds(12, 10, 73, 27);
		}
		return lblNewLabel;
	}
	public JTextField getTfSerial() {
		if (tfSerial == null) {
			tfSerial = new JTextField();
			tfSerial.setBounds(97, 10, 164, 27);
			tfSerial.setColumns(10);
		}
		return tfSerial;
	}
	public JLabel getLblId() {
		if (lblId == null) {
			lblId = new JLabel("ID");
			lblId.setBounds(12, 47, 73, 27);
		}
		return lblId;
	}
	public JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setColumns(10);
			tfId.setBounds(97, 47, 192, 27);
		}
		return tfId;
	}
	public JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("시험일자");
			lblNewLabel_2.setBounds(12, 84, 73, 27);
		}
		return lblNewLabel_2;
	}
	public JTextField getTfMdate() {
		if (tfMdate == null) {
			tfMdate = new JTextField();
			tfMdate.setColumns(10);
			tfMdate.setBounds(97, 84, 325, 27);
		}
		return tfMdate;
	}
	public JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("과목");
			lblNewLabel_3.setBounds(12, 121, 73, 27);
		}
		return lblNewLabel_3;
	}
	public JTextField getTfSubject() {
		if (tfSubject == null) {
			tfSubject = new JTextField();
			tfSubject.setColumns(10);
			tfSubject.setBounds(97, 121, 286, 27);
		}
		return tfSubject;
	}
	public JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("성적");
			lblNewLabel_4.setBounds(12, 158, 73, 27);
		}
		return lblNewLabel_4;
	}
	public JTextField getTfScore() {
		if (tfScore == null) {
			tfScore = new JTextField();
			tfScore.setColumns(10);
			tfScore.setBounds(97, 158, 212, 27);
		}
		return tfScore;
	}
	public JButton getBtnSave() {
		if (btnSave == null) {
			btnSave = new JButton("저장");
			btnSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String serial = tfSerial.getText();
					String id = tfId.getText();
					String mdate = tfMdate.getText();
					String subject = tfSubject.getText();
					String score = tfScore.getText();
					
					ScoreVo vo = new ScoreVo(serial, id, mdate, subject, score);
					ScoreDto dto = new ScoreDto();
					int cnt = dto.insert(vo);
					
					if(cnt>0) {
						System.out.println("정상처리됨");
					}else {
						System.out.println("저장 중 오류 발생");
					}
				}
			});
			btnSave.setBounds(12, 195, 113, 65);
		}
		return btnSave;
	}
	public JButton getBtnModify() {
		if (btnModify == null) {
			btnModify = new JButton("수정");
			btnModify.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String serial = tfSerial.getText();
					String id = tfId.getText();
					String mdate = tfMdate.getText();
					String subject = tfSubject.getText();
					String score = tfScore.getText();
					
					ScoreVo vo = new ScoreVo(serial, id, mdate, subject, score);
					ScoreDto dto = new ScoreDto();
					int cnt = dto.update(vo);
					if(cnt>0) {
						//성공
					}else {
						//오류
					}
				}
			});
			btnModify.setBounds(162, 195, 113, 65);
		}
		return btnModify;
	}
	public JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("삭제");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String serial = tfSerial.getText();
					ScoreDto dto = new ScoreDto();
					int cnt = dto.delete(serial);
					if(cnt>0) {
						tfSerial.setText("");
						tfId.setText("");
						tfMdate.setText("");
						tfSubject.setText("");
						tfScore.setText("");
					}else {
						//오류처리
					}
				}
			});
			btnDelete.setBounds(309, 195, 113, 65);
		}
		return btnDelete;
	}
}
