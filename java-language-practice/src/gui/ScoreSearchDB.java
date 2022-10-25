package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableModel;

import format.MyInterMain;
import jdbc.MemberDto;
import jdbc.ScoreDto;
import jdbc.ScoreVo;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ScoreSearchDB extends JInternalFrame {
	
	MyInterMain main;
	
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
					ScoreSearchDB frame = new ScoreSearchDB();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ScoreSearchDB(MyInterMain main) {
		this();
		this.main = main;
	}
	
	/**
	 * Create the frame.
	 */
	public ScoreSearchDB() {
		
		super("성적조회DB", true,true,true,true);
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				main.ssdb = null;
			}
		});
		setVisible(true);
		
		setBounds(100, 100, 608, 558);
		getContentPane().add(getPanel(), BorderLayout.NORTH);
		getContentPane().add(getScrollPane(), BorderLayout.CENTER);

	}
	
	public void select() {	//table에 나오게 할 거야
		String f = findStr.getText();
		ScoreDto dto = new ScoreDto();
		
		Vector<Vector> list = dto.select(f);
		
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.setRowCount(0);
		
		for(Vector v : list) {
			model.addRow(v);
		}
	}

	public JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setPreferredSize(new Dimension(10, 35));
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
					if(e.getKeyCode()==KeyEvent.VK_ENTER) {
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
					String serial = (String)table.getValueAt(row, 0);
					ScoreDto dto = new ScoreDto();
					ScoreVo vo = dto.selectOne(serial);
					
					if(main.sidb==null) {
						main.sidb = new ScoreInputDB(main);
						main.getDesktopPane().add(main.sidb);
					}
					((ScoreInputDB) main.sidb).loadData(vo);
					main.sidb.toFront();
				}
			});
			String[] header = {"시리얼","아이디","시험일자","과목명","성적"};
			DefaultTableModel model = new DefaultTableModel(null, header);
			table.setModel(model);
		}
		return table;
	}
}
