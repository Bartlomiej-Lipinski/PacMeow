import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class OknoPodanieRozmiaru extends JFrame {

    int rozmiargry;

    public OknoPodanieRozmiaru() {
        JTextField rozmiar = new JTextField("PODAJ ROZMIAR OKNA");
        rozmiar.setEditable(false);
        rozmiar.setBackground(new Color(255, 200, 200));
        JTextField dane1 = new JTextField();
        dane1.setSize(100, 50);
        JTextField dane2 = new JTextField();
        dane2.setSize(100, 50);
        JButton akcept = new JButton("OK");
        akcept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int rozmiargry1 = Integer.parseInt(dane1.getText());
                    int rozmiargry2 = Integer.parseInt(dane2.getText());
                    if (rozmiargry1 < 10 || rozmiargry1 > 100 || rozmiargry2 < 10 || rozmiargry2 > 100) {
                        JOptionPane.showMessageDialog(akcept, "podano błędne dane");
                    } else {
                        SwingUtilities.invokeLater(() -> new Core(rozmiargry1, rozmiargry2));
                    }
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(akcept, "podano błędne dane");
                }
                dispose();
            }
        });
        akcept.setBackground(new Color(255, 200, 200));
        setLayout(new BorderLayout());
        JPanel p = new JPanel();
        p.setBackground(new Color(255, 200, 200));
        p.setLayout(new GridLayout(1, 4));
        JTextField zmiennax = new JTextField("X");
        zmiennax.setEditable(false);
        zmiennax.setBackground(new Color(255, 200, 200));
        JTextField zmiennay = new JTextField("Y");
        zmiennay.setEditable(false);
        zmiennay.setBackground(new Color(255, 200, 200));
        addKeyListener(new SkrotKontroler(this));
        p.add(zmiennax);
        p.add(dane1);
        p.add(zmiennay);
        p.add(dane2);
        setSize(100, 100);
        setBackground(Color.pink);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        add(rozmiar, BorderLayout.NORTH);
        add(p, BorderLayout.CENTER);
        add(akcept, BorderLayout.SOUTH);
        pack();
    }

    public int getRozmiargry() {
        return rozmiargry;
    }
}
