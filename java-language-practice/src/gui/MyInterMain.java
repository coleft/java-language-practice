package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JDesktopPane;

public class MyInterMain extends JFrame {

   private JPanel contentPane;
   private JDesktopPane desktopPane;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               MyInterMain frame = new MyInterMain();
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
   public MyInterMain() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 667, 549);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

      setContentPane(contentPane);
      contentPane.setLayout(new BorderLayout(0, 0));
      contentPane.add(getDesktopPane(), BorderLayout.CENTER);
      
      desktopPane.add(new Memberinput());
      desktopPane.updateUI();
   }

   public JDesktopPane getDesktopPane() {
      if (desktopPane == null) {
         desktopPane = new JDesktopPane();
      }
      return desktopPane;
   }
}