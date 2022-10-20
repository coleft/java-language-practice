package format;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import iostream.Data;
import iostream.MemberDao;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class Memberinput extends JInternalFrame {
	MyInterMain main;
	private JLabel lblNewLabel;
	private JTextField tfId;
	private JLabel lblNewLabel_1;
	private JTextField tfIrum;
	private JLabel lblNewLabel_2;
	private JTextField tfAddr;
	private JLabel lblNewLabel_3;
	private JTextField tfPhone;
	private JLabel lblNewLabel_4;
	private JTextField tfPoint;
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
               Memberinput frame = new Memberinput();
               frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   public Memberinput(MyInterMain main) {
	   this();
	   this.main = main;	//닫히면 스스로를 null로 만들기위한 사전작업
   }
   
   /**
    * Create the frame.
    */
   
   public Memberinput() {
      super("회원가입", true, true, true, true);
      addInternalFrameListener(new InternalFrameAdapter() {
      	@Override
      	public void internalFrameClosing(InternalFrameEvent e) {
      		main.mi = null;
      	}
      });
      
      setVisible(true);
      
      setBounds(100, 100, 315, 216);      
      getContentPane().setLayout(null);
      getContentPane().add(getLblNewLabel());
      getContentPane().add(getTfId());
      getContentPane().add(getLblNewLabel_1());
      getContentPane().add(getTfIrum());
      getContentPane().add(getLblNewLabel_2());
      getContentPane().add(getTfAddr());
      getContentPane().add(getLblNewLabel_3());
      getContentPane().add(getTfPhone());
      getContentPane().add(getLblNewLabel_4());
      getContentPane().add(getTfPoint());
      getContentPane().add(getBtnSave());
      getContentPane().add(getBtnModify());
      getContentPane().add(getBtnDelete());
      

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
			tfId.setBounds(81, 7, 116, 18);
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
			tfIrum.setBounds(81, 35, 128, 18);
		}
		return tfIrum;
	}
	public JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("주소");
			lblNewLabel_2.setBounds(12, 66, 57, 15);
		}
		return lblNewLabel_2;
	}
	public JTextField getTfAddr() {
		if (tfAddr == null) {
			tfAddr = new JTextField();
			tfAddr.setColumns(10);
			tfAddr.setBounds(81, 63, 207, 18);
		}
		return tfAddr;
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
			tfPhone.setBounds(81, 91, 133, 18);
		}
		return tfPhone;
	}
	public JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("포인트");
			lblNewLabel_4.setBounds(12, 122, 57, 15);
		}
		return lblNewLabel_4;
	}
	public JTextField getTfPoint() {
		if (tfPoint == null) {
			tfPoint = new JTextField();
			tfPoint.setColumns(10);
			tfPoint.setBounds(81, 119, 98, 18);
		}
		return tfPoint;
	}
	public JButton getBtnSave() {
		if (btnSave == null) {
			btnSave = new JButton("저장");
			btnSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MemberDao dao = new MemberDao();	//control class입니다.
					
					String id = tfId.getText();
					String irum = tfIrum.getText();
					String addr = tfAddr.getText();
					String phone = tfPhone.getText();
					int point = Integer.parseInt(tfPoint.getText());
					
					Data d = new Data(id, irum, addr, phone, point);
					dao.write(d);
					
				}
			});
			btnSave.setBounds(12, 147, 85, 23);
		}
		return btnSave;
	}
	public JButton getBtnModify() {
		if (btnModify == null) {
			btnModify = new JButton("수정");
			btnModify.setBounds(109, 147, 85, 23);
		}
		return btnModify;
	}
	public JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("삭제");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MemberDao dao = new MemberDao();
					String id = ((Memberinput)main.mi).getTfId().getText();
					dao.delete(id);
					
				}
			});
			btnDelete.setBounds(203, 147, 85, 23);
		}
		return btnDelete;
	}
}