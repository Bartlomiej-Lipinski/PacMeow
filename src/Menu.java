import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Menu extends JFrame {
    public Menu() {
        setTitle("PAC_MEOW");
        Color rozowy = new Color(255, 200, 200);
        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon("IKONY/cats-dance.gif"));
        panel.setLayout(new BorderLayout());
        ////////////////////////////////////////////////////////////////////////////////////////////////////
        JButton start = new JButton("Start");
        start.setBackground(rozowy);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(()->new OknoPodanieRozmiaru());
            }
        });
        ////////////////////////////////////////////////////////////////////////////////////////////////////
        JButton scoreboard = new JButton("Score Board");
        scoreboard.setBackground(rozowy);
        scoreboard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(()->new ScoreBoard());
            }
        });

        JButton exit = new JButton("Wyjście");
        exit.setBackground(rozowy);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                System.exit(0);
            }
        });
        /////////////////////////////////////////////////////////////////////////////////////////////////////
        add(label, BorderLayout.NORTH);
        add(start, BorderLayout.CENTER);
        add(scoreboard, BorderLayout.WEST);
        add(exit, BorderLayout.EAST);
        setSize(400, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
    }
}
