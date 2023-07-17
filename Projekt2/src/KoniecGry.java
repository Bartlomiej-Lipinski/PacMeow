import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class KoniecGry extends JFrame {
    private Player graczHolder;

    public KoniecGry(Player graczHolder) {
        this.graczHolder = graczHolder;
        JTextArea text = new JTextArea("PODAJ SWÓJ Nick");
        text.setBackground(new Color(255, 200, 200));
        text.setEditable(false);
        JTextArea podanieNicku = new JTextArea();
        JButton potwierdz = new JButton("Potwierdź");
        potwierdz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nick = podanieNicku.getText();
                graczHolder.setNick(nick);
                Players.read();
                Players.addPlayer(graczHolder);
                Players.save();
                dispose();
            }
        });
        setSize(100, 100);
        setVisible(true);
        setResizable(false);
        setLayout(new BorderLayout());
        add(text, BorderLayout.NORTH);
        add(podanieNicku, BorderLayout.CENTER);
        add(potwierdz, BorderLayout.SOUTH);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        addKeyListener(new SkrotKontroler(this));
    }
}
