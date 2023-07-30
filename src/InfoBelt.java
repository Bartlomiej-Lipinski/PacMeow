import javax.swing.*;
import java.awt.*;

public class InfoBelt extends JPanel {

    private boolean Working=true;
    public InfoBelt(Timerr timerr,Player player){
        setLayout(new GridLayout(1,3));
        JTextArea punkty = new JTextArea();
        JTextArea lifes = new JTextArea();
        JTextArea timer = new JTextArea();
        punkty.setEditable(false);
        punkty.setText(String.valueOf(player.getPoints()));
        punkty.setBackground(new Color(255,200,200));
        lifes.setEditable(false);
        lifes.setText(String.valueOf(player.getlifes()));
        lifes.setBackground(new Color(255,200,200));
        timer.setEditable(false);
        timer.setText(timerr.getCzasownik());
        timer.setBackground(new Color(255,200,200));
        add(timer);
        add(punkty);
        add(lifes);
        setVisible(true);
        Thread updater = new Thread(()->{
                while (Working) {
                    punkty.setText(String.valueOf(player.getPoints()));
                    lifes.setText(String.valueOf(player.getlifes()));
                    timer.setText(timerr.getCzasownik());
                }
        });
        updater.start();
    }
    public void off(){
        Working=false;
    }
}
