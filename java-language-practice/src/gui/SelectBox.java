package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableModel;

import format.MyInterMain;
import jdbc.DBConn;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.util.List;
import java.util.Vector;
import java.sql.ResultSet;

public class SelectBox extends JInternalFrame {
	
	MyInterMain main;
	
	private JPanel panel;
	private JTextField tfSql;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	
	public SelectBox(MyInterMain main) {
		this();
		this.main = main;
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectBox frame = new SelectBox();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void select() throws Exception {
		/*
		 * 	public void select(){		 
		 * 		1) sql문장 작성		  
		 * 		2) Connection 생성		  
		 * 		3) PreparedStatement 생성		  
		 * 		4) sql 문장 실행		 		
		 *		5) ResultSetMetaData 생성		  
		 * 		6) 각 컬럼을 Vector에 추가(header)
		 * 		7) while(rs.next())에서 한 행의 값들을 모두 Vector에 담아 전체 Vector에 추가
		 * 		8) DefaultTableModel 생성	
		 * 		9) value와 header를 model에 추가
		 * 		10) table에 model 추가	 
		 * 	}
		 * 
		 * */	
		
		Vector<String> header = new Vector();
		Vector list = new Vector();
		try {
			Connection conn = new DBConn().getConn();
			String sql = tfSql.getText();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData meta = rs.getMetaData();
			
			header.add("NO");
			for(int i = 1; i<=meta.getColumnCount(); i++) {
				header.add(meta.getColumnName(i));
			}
			
			int no = 1;
			while(rs.next()) {
				Vector v = new Vector();
				v.add(no);
				for(int i = 1; i<=meta.getColumnCount(); i++) {
					String cn = meta.getColumnName(i);
					v.add(rs.getString(cn));
				}
				list.add(v);	//이중벡터 : DQL을 할 때, 잠시 살펴본 적 있다.
				no++;
			}
			
			DefaultTableModel model = new DefaultTableModel(list, header);
			
			table.setModel(model);
			
		}catch(Exception e1) {
			e1.printStackTrace();
		}
		
	}
	
	public JTable getTable() {
		if (table == null) {			
			table = new JTable();		
		}
		return table;
	}
	
	/**
	 * Create the frame.
	 */
	public SelectBox() {
		super("SQL : DML, DQL", true, true, true, true);
		setVisible(true);
		
		/*
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				main.sb = null;
			}
		});
		*/
		
		setBounds(100, 100, 630, 386);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(getPanel(), BorderLayout.NORTH);
		getContentPane().add(getScrollPane(), BorderLayout.CENTER);

	}

	public JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setPreferredSize(new Dimension(10, 27));
			panel.setLayout(new BorderLayout(0, 0));
			panel.add(getTfSql(), BorderLayout.CENTER);
			panel.add(getBtnNewButton(), BorderLayout.EAST);
			panel.add(getLblNewLabel(), BorderLayout.WEST);
		}
		return panel;
	}
	public JTextField getTfSql() {
		if (tfSql == null) {
			tfSql = new JTextField();
			tfSql.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {	//js랑 비슷하다. release, press, type 등 이름이 같진 않지만 event가 분리되어있다. 키보드...
					if(e.getKeyCode() == KeyEvent.VK_ENTER) {
						try {
							select();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				}
			});
			tfSql.setColumns(10);
		}
		return tfSql;
	}
	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("실행");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						select();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			});
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
	
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("SQL");
		}
		return lblNewLabel;
	}
}
