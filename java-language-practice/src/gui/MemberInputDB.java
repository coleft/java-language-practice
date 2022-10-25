package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import format.MyInterMain;
import jdbc.MemberDto;
import jdbc.MemberVo;

public class MemberInputDB extends JInternalFrame {
	
	//라디오 버튼을 그룹화
	ButtonGroup bg = new ButtonGroup();
	
	MyInterMain main;
	
	private JLabel lblNewLabel;
	private JTextField tfId;
	private JLabel lblNewLabel_1;
	private JTextField tfIrum;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField tfPhone;
	private JLabel lblNewLabel_4;
	private JTextField tfPicture;
	private JButton btnSave;
	private JButton btnModify;
	private JButton btnDelete;
	private JRadioButton btnGenderM;
	private JRadioButton btnGenderF;
	private JButton btnNewButton_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberInputDB frame = new MemberInputDB();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MemberInputDB(MyInterMain main) {
		this();
		this.main = main;
	}
	
	/**
	 * Create the frame.
	 */
	public MemberInputDB() {
		
		super("회원가입DB", false,true,false,true);
		setVisible(true);
		
		addInternalFrameListener(new InternalFrameAdapter() {	//internalFrame > Closing
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				main.midb = null;	
			}
		});
		
		setBounds(100, 100, 454, 249);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getTfId());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getTfIrum());
		getContentPane().add(getLblNewLabel_2());
		getContentPane().add(getLblNewLabel_3());
		getContentPane().add(getTfPhone());
		getContentPane().add(getLblNewLabel_4());
		getContentPane().add(getTfPicture());
		getContentPane().add(getBtnSave());
		getContentPane().add(getBtnModify());
		getContentPane().add(getBtnDelete());
		getContentPane().add(getBtnGenderM());
		getContentPane().add(getBtnGenderF());
		getContentPane().add(getBtnNewButton_3());

		bg.add(getBtnGenderM());
		bg.add(getBtnGenderF());
		
	}
	
	public void loadData(MemberVo vo) {
		tfId.setText(vo.getId());
		tfIrum.setText(vo.getIrum());
		tfPhone.setText(vo.getPhone());
		tfPicture.setText(vo.getPicture());
		
		if(vo.getGender().equals("m")) {
			btnGenderM.setSelected(true);
		}else {
			btnGenderF.setSelected(true);
		}
	}
	
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("아이디");
			lblNewLabel.setBounds(12, 10, 57, 15);
		}
		return lblNewLabel;
	}
	public JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setBounds(81, 7, 132, 21);
			tfId.setColumns(10);
		}
		return tfId;
	}
	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("성명");
			lblNewLabel_1.setBounds(12, 38, 57, 15);
		}
		return lblNewLabel_1;
	}
	public JTextField getTfIrum() {
		if (tfIrum == null) {
			tfIrum = new JTextField();
			tfIrum.setColumns(10);
			tfIrum.setBounds(81, 35, 159, 21);
		}
		return tfIrum;
	}
	public JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("성별");
			lblNewLabel_2.setBounds(12, 66, 57, 15);
		}
		return lblNewLabel_2;
	}
	public JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("연락처");
			lblNewLabel_3.setBounds(12, 94, 57, 15);
		}
		return lblNewLabel_3;
	}
	public JTextField getTfPhone() {
		if (tfPhone == null) {
			tfPhone = new JTextField();
			tfPhone.setColumns(10);
			tfPhone.setBounds(81, 91, 195, 21);
		}
		return tfPhone;
	}
	public JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("증명사진");
			lblNewLabel_4.setBounds(12, 125, 57, 15);
		}
		return lblNewLabel_4;
	}
	public JTextField getTfPicture() {
		if (tfPicture == null) {
			tfPicture = new JTextField();
			tfPicture.setColumns(10);
			tfPicture.setBounds(81, 122, 239, 21);
		}
		return tfPicture;
	}
	public JButton getBtnSave() {
		if (btnSave == null) {
			btnSave = new JButton("저장");
			btnSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String id = tfId.getText();
					String irum = tfIrum.getText();
					String gender = btnGenderM.isSelected() ? "m" : "f";
					String phone = tfPhone.getText();					
					String picture = tfPicture.getText();					
					
					MemberVo vo = new MemberVo(id, irum, gender, phone, picture);
					MemberDto dto = new MemberDto();
					int cnt = dto.insert(vo);
					
					if(cnt>0) {
						System.out.println("정상처리됨");						
					}else {
						System.out.println("저장 중 오류 발생"); //나중에 optionPane에 뜨게 해주자.
					}
					
				}
			});
			btnSave.setBounds(81, 153, 106, 36);
		}
		return btnSave;
	}
	public JButton getBtnModify() {
		if (btnModify == null) {
			btnModify = new JButton("수정");
			btnModify.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String id = tfId.getText();
					String irum = tfIrum.getText();
					String gender = btnGenderM.isSelected() ? "m" : "f";
					String phone = tfPhone.getText();					
					String picture = tfPicture.getText();
					
					MemberVo vo = new MemberVo(id,irum,gender,phone,picture);
					MemberDto dto = new MemberDto();
					int cnt = dto.update(vo);	//control키 누르고 update 누르면 해당 위치로 바로 이동 가능합니다.
					if(cnt>0) {
						//성공
					}else {
						//오류
					}
				}
			});
			btnModify.setBounds(199, 153, 106, 36);
		}
		return btnModify;
	}
	public JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("삭제");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String id = tfId.getText();
					MemberDto dto = new MemberDto();
					int cnt = dto.delete(id);
					if(cnt>0) {
						tfId.setText("");
						tfIrum.setText("");
						tfPhone.setText("");
						tfPicture.setText("");						
					}else {
						// 오류 처리
					}					
				}
			});
			btnDelete.setBounds(317, 153, 106, 36);
		}
		return btnDelete;
	}
	public JRadioButton getBtnGenderM() {
		if (btnGenderM == null) {
			btnGenderM = new JRadioButton("늑대");
			btnGenderM.setBounds(81, 62, 63, 23);
		}
		return btnGenderM;
	}
	public JRadioButton getBtnGenderF() {
		if (btnGenderF == null) {
			btnGenderF = new JRadioButton("여우");
			btnGenderF.setBounds(148, 62, 57, 23);
		}
		return btnGenderF;
	}
	public JButton getBtnNewButton_3() {
		if (btnNewButton_3 == null) {
			btnNewButton_3 = new JButton("이미지선택");
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JFileChooser fc = new JFileChooser();
					int flag = fc.showOpenDialog(MemberInputDB.this);
					if(flag == JFileChooser.APPROVE_OPTION) {
						String fn = fc.getSelectedFile().getPath();
						tfPicture.setText(fn);
					}
				}
			});
			btnNewButton_3.setBounds(326, 122, 97, 21);
		}
		return btnNewButton_3;
	}
}
