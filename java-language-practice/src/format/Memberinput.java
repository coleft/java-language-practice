package format;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class Memberinput extends JInternalFrame {

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

   /**
    * Create the frame.
    */
   public Memberinput() {
      super("회원가입", true, true, true, true);
      setBounds(100, 100, 450, 300);
      setVisible(true);

   }

}