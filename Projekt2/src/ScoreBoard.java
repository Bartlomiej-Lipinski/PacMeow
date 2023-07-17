import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

public class ScoreBoard extends JFrame {
    Vector<Integer> punkty = new Vector<>();
    Vector<String> nicki = new Vector<>();

    ArrayList<Player> scoreboard;

    public ScoreBoard() {
        Color rozowy = new Color(255, 200, 200);
        setTitle("TABLICA WYNIKÓW");
        setLayout(new GridLayout(1, 2));
        JList Nazwa = new JList<>(punkty);
        Nazwa.setBackground(rozowy);
        JList wynik = new JList<>(nicki);
        wynik.setBackground(rozowy);
        File file = new File("D:\\STUDIA\\Projekt2\\Projekt2\\tablawynikow.txt");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            scoreboard = (ArrayList<Player>) objectInputStream.readObject();
        } catch (Exception e) {
            e.getCause();
        }
        sort();
        for (int i = 0;i<scoreboard.size();i++){
               Player gracz = scoreboard.get(i);
               nicki.add(gracz.getNick());
               punkty.add(gracz.getPoints());
            }
        add(Nazwa);
        add(wynik);
        JScrollPane jScrollPane = new JScrollPane(Nazwa);
        this.getContentPane().add(jScrollPane);
        JScrollPane jScrollPane1 = new JScrollPane(wynik);
        this.getContentPane().add(jScrollPane1);
        setSize(400, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().addKeyListener(new SkrotKontroler(this));
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void sort(){
        Collections.sort(scoreboard, new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                return o2.getPoints()- o1.getPoints();
            }
        });
    }

}
