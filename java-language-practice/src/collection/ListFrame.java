package collection;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListFrame extends JInternalFrame {
   List<Data> list = new ArrayList<Data>();
   int index;
   
   private JLabel lblNewLabel;
   private JTextField id;
   private JLabel lblNewLabel_1;
   private JTextField irum;
   private JLabel lblNewLabel_2;
   private JTextField age;
   private JSeparator separator;
   private JButton btnNewButton;
   private JButton btnNewButton_1;
   private JButton btnNewButton_1_1;
   private JButton btnNewButton_1_2;
   private JButton btnNewButton_2;
   private JScrollPane scrollPane;
   private JTextArea textArea;
   private JLabel lblNewLabel_3;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               ListFrame frame = new ListFrame();
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
   public ListFrame() {
      super("List", true, true, true, true);
      
      setVisible(true);
      setBounds(100, 100, 656, 607);
      getContentPane().setLayout(null);
      getContentPane().add(getLblNewLabel());
      getContentPane().add(getId());
      getContentPane().add(getLblNewLabel_1());
      getContentPane().add(getIrum());
      getContentPane().add(getLblNewLabel_2());
      getContentPane().add(getAge());
      getContentPane().add(getSeparator());
      getContentPane().add(getBtnNewButton());
      getContentPane().add(getBtnNewButton_1());
      getContentPane().add(getBtnNewButton_1_1());
      getContentPane().add(getBtnNewButton_1_2());
      getContentPane().add(getBtnNewButton_2());
      getContentPane().add(getScrollPane());
      getContentPane().add(getLblNewLabel_3());

   }

   public JLabel getLblNewLabel() {
      if (lblNewLabel == null) {
         lblNewLabel = new JLabel("아이디");
         lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 14));
         lblNewLabel.setBounds(12, 10, 50, 15);
      }
      return lblNewLabel;
   }
   public JTextField getId() {
      if (id == null) {
         id = new JTextField();
         id.setBounds(74, 10, 177, 21);
         id.setColumns(10);
      }
      return id;
   }
   public JLabel getLblNewLabel_1() {
      if (lblNewLabel_1 == null) {
         lblNewLabel_1 = new JLabel("성명");
         lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 14));
         lblNewLabel_1.setBounds(12, 41, 50, 15);
      }
      return lblNewLabel_1;
   }
   public JTextField getIrum() {
      if (irum == null) {
         irum = new JTextField();
         irum.setColumns(10);
         irum.setBounds(74, 41, 177, 21);
      }
      return irum;
   }
   public JLabel getLblNewLabel_2() {
      if (lblNewLabel_2 == null) {
         lblNewLabel_2 = new JLabel("나이");
         lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 14));
         lblNewLabel_2.setBounds(12, 72, 50, 15);
      }
      return lblNewLabel_2;
   }
   public JTextField getAge() {
      if (age == null) {
         age = new JTextField();
         age.setColumns(10);
         age.setBounds(74, 72, 177, 21);
      }
      return age;
   }
   public JSeparator getSeparator() {
      if (separator == null) {
         separator = new JSeparator();
         separator.setBounds(12, 107, 342, 2);
      }
      return separator;
   }
   public JButton getBtnNewButton() {
      if (btnNewButton == null) {
         btnNewButton = new JButton("조회");
         btnNewButton.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		String mId = id.getText();
         		Data temp = new Data(mId, null, 0);
         		index = list.indexOf(temp);
         		if(index >= 0) {
         			Data d = list.get(index);
         			irum.setText(d.getIrum());
         			age.setText(d.getAge()+"");
         		}else {
         			JOptionPane.showMessageDialog(ListFrame.this, "찾는 데이터가 없네요~");
         			irum.setText("");
         			age.setText("");
         		}
         	}
         });
         btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 14));
         btnNewButton.setBounds(263, 7, 91, 21);
      }
      return btnNewButton;
   }
   public JButton getBtnNewButton_1() {
      if (btnNewButton_1 == null) {
         btnNewButton_1 = new JButton("저장");
         
         btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               String mId = id.getText();
               String mIrum = irum.getText();
               int mAge = Integer.parseInt( age.getText() ); //getText하면 int형이라 오류(missmatch)가 뜸. 그래서 Integer.parseInt를 써줌.
               Data data = new Data(mId, mIrum, mAge);
               list.add(data);
               
               id.requestFocus();
               id.selectAll();
            }
         });
         
         btnNewButton_1.setFont(new Font("맑은 고딕", Font.BOLD, 14));
         btnNewButton_1.setBounds(160, 119, 91, 21);
      }
      return btnNewButton_1;
   }
   public JButton getBtnNewButton_1_1() {
      if (btnNewButton_1_1 == null) {
         btnNewButton_1_1 = new JButton("수정");
         btnNewButton_1_1.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		
         		if(index >= 0 ) {
         			String mId = id.getText();
         			String mIrum = irum.getText();
         			int mAge = Integer.parseInt(age.getText());
         			Data d = new Data(mId, mIrum, mAge);
         			list.set(index, d);
         		}else {
         			JOptionPane.showMessageDialog(ListFrame.this, "수정할 자료를 먼저 검색해 주세요.");
         		}         		
         	}
         });
         btnNewButton_1_1.setFont(new Font("맑은 고딕", Font.BOLD, 14));
         btnNewButton_1_1.setBounds(263, 119, 91, 21);
      }
      return btnNewButton_1_1;
   }
   public JButton getBtnNewButton_1_2() {
      if (btnNewButton_1_2 == null) {
         btnNewButton_1_2 = new JButton("삭제");
         btnNewButton_1_2.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {         		
         		if(index >= 0) {
         			list.remove(index);
         			id.setText("");
         			irum.setText("");
         			age.setText("");
         			textArea.setText("");
         			id.requestFocus();
         		}else {
         			JOptionPane.showMessageDialog(ListFrame.this, "삭제할 데이터를 검색해 주세요.");
         		}         		
         	}
         });
         btnNewButton_1_2.setFont(new Font("맑은 고딕", Font.BOLD, 14));
         btnNewButton_1_2.setBounds(263, 150, 91, 21);
      }
      return btnNewButton_1_2;
   }
   public JButton getBtnNewButton_2() {
      if (btnNewButton_2 == null) {
         btnNewButton_2 = new JButton("전체출력");
         
         btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	textArea.setText("");
            	for(Data d : list) {
            		textArea.append(d.toString());
            	}
            }
         });
         
         btnNewButton_2.setFont(new Font("맑은 고딕", Font.BOLD, 14));
         btnNewButton_2.setBounds(533, 7, 91, 21);
      }
      return btnNewButton_2;
   }
   public JScrollPane getScrollPane() {
      if (scrollPane == null) {
         scrollPane = new JScrollPane();
         scrollPane.setBounds(366, 41, 258, 488);
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
	public JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("New label");
			lblNewLabel_3.setBounds(12, 567, 628, -21);
		}
		return lblNewLabel_3;
	}
}