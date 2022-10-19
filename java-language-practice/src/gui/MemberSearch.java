package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import iostream.Data;
import iostream.MemberDao;

public class MemberSearch extends JInternalFrame {
   private JPanel panel;
   private JTextField textField;
   private JButton btnNewButton;
   private JScrollPane scrollPane;
   private JTable table;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               MemberSearch frame = new MemberSearch();
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
   public MemberSearch() {
	  super("회원조회", true,true,true,true);
      //setTitle("회원조회");
	  setVisible(true);
      setBounds(100, 100, 550, 470);
      getContentPane().setLayout(new BorderLayout(0, 0));
      getContentPane().add(getPanel(), BorderLayout.NORTH);
      getContentPane().add(getScrollPane(), BorderLayout.CENTER);
   }

   public JPanel getPanel() {
      if (panel == null) {
         panel = new JPanel();
         panel.setPreferredSize(new Dimension(10, 35));
         panel.setLayout(new BorderLayout(0, 0));
         panel.add(getTextField(), BorderLayout.CENTER);
         panel.add(getBtnNewButton(), BorderLayout.EAST);
      }
      return panel;
   }
   public JTextField getTextField() {
      if (textField == null) {
         textField = new JTextField();
         textField.setColumns(10);
      }
      return textField;
   }
   public JButton getBtnNewButton() {
      if (btnNewButton == null) {
         btnNewButton = new JButton("검색");
      }
      return btnNewButton;
   }
   public JScrollPane getScrollPane() {
      if (scrollPane == null) {
         scrollPane = new JScrollPane();
         scrollPane.setViewportView(getTable());
      }
      return scrollPane;
   }
   public JTable getTable() {
      if (table == null) { //table의 요소가 null이면 만들고 리턴
    	 MemberDao dao = new MemberDao();
    	 List<Data> list = dao.read();
    	 
    	 //List ->Vector<Vector>
    	 Vector<Vector> vector = new Vector<Vector>();
    	 for(Data d : list) {
    		 vector.add(d.getVector());
    	 }
    	 
         DefaultTableModel model = new DefaultTableModel();
         Vector<String> header = new Vector<String>();
         header.add("아이디");
         header.add("성명");
         header.add("주소");
         header.add("연락처");
         header.add("포인트");
         model.setDataVector(vector, header);
         
         table = new JTable(model);
      }
      return table;
   }
}