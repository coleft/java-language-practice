package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import format.MyInterMain;
import iostream.ScoreDao;
import iostream.ScoreVo;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ScoreSearch extends JInternalFrame {
	private JPanel panel;
	private JTextField findStr;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JTable table;
	MyInterMain main;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScoreSearch frame = new ScoreSearch();
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
	
	public ScoreSearch(MyInterMain main) {
		this();
		this.main = main;
	}
	
	public ScoreSearch() {
		super("์ฑ์ ์กฐํ",true, true, true, true);
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				main.ss = null;
			}
		});
		setVisible(true);
		
		
		
		setBounds(100, 100, 556, 392);
		getContentPane().add(getPanel(), BorderLayout.NORTH);
		getContentPane().add(getScrollPane(), BorderLayout.CENTER);

	}

	public JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setPreferredSize(new Dimension(10, 40));
			panel.setLayout(new BorderLayout(0, 0));
			panel.add(getFindStr(), BorderLayout.CENTER);
			panel.add(getBtnNewButton(), BorderLayout.EAST);
		}
		return panel;
	}
	public JTextField getFindStr() {
		if (findStr == null) {
			findStr = new JTextField();
			findStr.setColumns(10);
		}
		return findStr;
	}
	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("๊ฒ์");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String find = findStr.getText().trim();//๊ณ ๊ธ์ง ํ๋ก๊ทธ๋จ์ ๋ง๋ค๋ฉด ๋์ด์ฐ๊ธฐ ๊ฐ์ํ๋ค.
					ScoreDao dao = new ScoreDao();
					List<ScoreVo> list = dao.read();
					DefaultTableModel model = 
							(DefaultTableModel)table.getModel();
					model.setRowCount(0);//๊ธฐ์กด์ ํ์ด๋ธ์ด ๊ฐ๊ณ  ์๋ ๋ฐ์ดํฐ ๋ชจ๋ ์ฌ๋ผ์ง๋ค.
					for(ScoreVo vo : list) {
						if(vo.getId().contains(find)||
						   vo.getSubject().contains(find)) {
							model.addRow(vo.getVector());
						}
					}
					table.updateUI();
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
			DefaultTableModel model = new DefaultTableModel();
			String[] header = {"์๋ฒ","์์ด๋","์ํ์ผ์","๊ณผ๋ชฉ","์ ์"};
			model.setDataVector(null, header);
			
			table = new JTable(model);
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int row = table.getSelectedRow();
					if(main.si == null) {
						main.si = new ScoreInput(main);
						main.getDesktopPane().add(main.si);
						main.getDesktopPane().updateUI();
						main.si.toFront();
					}
					Integer serial = (Integer)table.getValueAt(row, 0);
					String id = (String)table.getValueAt(row, 1);
					String mDate = (String)table.getValueAt(row, 2);
					String subject = (String)table.getValueAt(row, 3);
					int score = (Integer)table.getValueAt(row, 4);
					
					main.si.getTfSerial().setText(serial.toString());
					main.si.getTfId().setText(id);
					main.si.getTfMdate().setText(mDate);
					main.si.getTfSubject().setText(subject);
					main.si.getTfScore().setText(score+"");
				}
			});
		}
		return table;
	}
}
