package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableModel;

import format.MyInterMain;
import jdbc.MemberDto;
import jdbc.MemberVo;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MemberSearchDB extends JInternalFrame {
	
	MyInterMain main;
	MemberInputDB midb;
	
	private JPanel panel;
	private JTextField findStr;
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
					MemberSearchDB frame = new MemberSearchDB();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MemberSearchDB(MyInterMain main) {
		this();	//패러미터 없는 생성자 실행
		this.main = main;	// 이거 없으면 아래 창닫기 실행 안 된다. main 값이 초기화되지 않아서
	}
	
	/**
	 * Create the frame.
	 */
	public MemberSearchDB() {
		
		super("회원조회DB", true, true, true, true);
		setVisible(true);
		
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				main.msdb = null;
			}
		});
		
		setBounds(100, 100, 702, 459);
		getContentPane().add(getPanel(), BorderLayout.NORTH);
		getContentPane().add(getScrollPane(), BorderLayout.CENTER);

	}

	public void select() {
		// 검색어 가져와 MemberDto.select 호출
		String f = findStr.getText();
		MemberDto dto = new MemberDto();
		
		Vector<Vector> list = dto.select(f);		
		
		// DefaultTableModel에 있는 모든 데이터를 삭제
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		
		// DefaultTableModel에 리턴 받은 Vector 데이터를 추가
		for(Vector v : list) {
			model.addRow(v);
		}
		
		// model을 테이블에 설정 => 할 필요 없습니다. 
		
	}	
	
	public JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setPreferredSize(new Dimension(10, 34));
			panel.setLayout(new BorderLayout(0, 0));
			panel.add(getFindStr(), BorderLayout.CENTER);
			panel.add(getBtnNewButton(), BorderLayout.EAST);
		}
		return panel;
	}
	public JTextField getFindStr() {
		if (findStr == null) {
			findStr = new JTextField();
			findStr.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					
					if(e.getKeyCode() == KeyEvent.VK_ENTER) {
						select();
					}
					
				}
			});
			findStr.setColumns(10);
		}
		return findStr;
	}
	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("검색");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					select();
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
	public JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int row = table.getSelectedRow();					
					if(main.midb==null) {
						main.midb = new MemberInputDB(main);
						main.getDesktopPane().add(main.midb);
						main.getDesktopPane().updateUI();
						main.midb.toFront();
					}
					String id = (String)table.getValueAt(row, 0);
					String name = (String)table.getValueAt(row, 1);
					String gender = (String)table.getValueAt(row, 2);
					String phone = (String)table.getValueAt(row, 3);
					String madate = (String)table.getValueAt(row, 4);
					
					((MemberInputDB) main.midb).getTfId().setText(id.toString());
					((MemberInputDB) main.midb).getTfIrum().setText(name.toString());
					//((MemberInputDB) main.midb).getTfGender().setText(id.toString());
					((MemberInputDB) main.midb).getTfPhone().setText(phone.toString());
					//((MemberInputDB) main.midb).getTfMdate().setText(id.toString());
				}
			});
			String[] header = {"아이디","성명","성별","연락처","등록일"};
			DefaultTableModel model = new DefaultTableModel(null, header); //데이터는 없고 헤더만 있음
			table.setModel(model);
		}
		return table;
	}
}
