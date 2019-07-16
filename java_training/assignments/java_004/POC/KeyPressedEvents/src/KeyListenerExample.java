import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
public class KeyListenerExample {
  public static void main(String [] args) {
 
    JFrame.setDefaultLookAndFeelDecorated(true);
    JFrame frame = new JFrame("KeyListener Example");
    frame.setSize(300,150);
 
    final JLabel label = new JLabel();
    frame.add(label);
 
    frame.addKeyListener(new KeyListener() {
        public void keyTyped(KeyEvent ke) { 
          label.setText("Key Typed: " + ke.getKeyChar());
        }
        public void keyPressed(KeyEvent ke) {}
        public void keyReleased(KeyEvent ke) {}
    });
 
    frame.setVisible(true);			
  }
}
 