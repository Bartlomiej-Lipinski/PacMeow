import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SkrotKontroler implements KeyListener {

    private final JFrame frame;

    public SkrotKontroler(JFrame frame){
        this.frame = frame;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_Q && e.isControlDown() && e.isShiftDown()) {
            System.out.println("skórt do wyjścia");
            frame.dispose();
            JButton akcept = new JButton("OK");
            JOptionPane.showMessageDialog(akcept,"zamknęto okno skrótem WYNIK NIEZAPISANY");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
