import javax.swing.*;

public class Pacmeow extends JLabel{
    private int kierunek; // 1-góra 2-dół 3-lewo 4-prawo 5-idle
    private ImageIcon obrazek;
    private ImageIcon[] animacjaRunningL = new ImageIcon[4];
    private ImageIcon[] animacjaRunnnigR =new ImageIcon[4];
    private int X;
    private int Y;
    private boolean Working=true;

    public Pacmeow() {
        animacjaRunningL[0] = new ImageIcon("IKONY/run_left/Cat Sprite Sheet1.png");
        animacjaRunningL[1] = new ImageIcon("IKONY/run_left/Cat Sprite Sheet2.png");
        animacjaRunningL[2] = new ImageIcon("IKONY/run_left/Cat Sprite Sheet3.png");
        animacjaRunningL[3] = new ImageIcon("IKONY/run_left/Cat Sprite Sheet4.png");
        animacjaRunnnigR[0] = new ImageIcon("IKONY/run_right/Cat Sprite Sheet.png");
        animacjaRunnnigR[1] = new ImageIcon("IKONY/run_right/Cat Sprite Sheet2.png");
        animacjaRunnnigR[2] = new ImageIcon("IKONY/run_right/Cat Sprite Sheet3.png");
        animacjaRunnnigR[3] = new ImageIcon("IKONY/run_right/Cat Sprite Sheet4.png");
        setVisible(true);
        Thread animacja = new Thread(()->{
            try {
                while (true) {
                    switch (kierunek) {
                        case 1 -> {
                            for (int i = 0; i < 4; i++) {
                                obrazek = animacjaRunnnigR[i];
                            }
                        }
                        case 2 -> {
                            for (int i = 0; i < 4; i++) {
                                obrazek = animacjaRunningL[i];
                            }
                        }
                        default -> {
                            for (int i = 0; i < 4; i++) {
                                obrazek = animacjaRunnnigR[i];
                            }
                        }
                    }
                    if (!Working){
                        throw new InterruptedException();
                    }
                }
            }catch (InterruptedException e){
                return;
            }
        });
        animacja.start();
    }
    public void setTableX(int X){
        this.X=X;
    }
    public int getTableX(){
        return X;
    }
    public void setTableY(int Y){
        this.Y=Y;
    }
    public int getTableY(){
        return Y;
    }
    public ImageIcon getObrazek() {
        return obrazek;
    }
    public void setKierunek(int kierunek) {
        this.kierunek = kierunek;
    }
    public void off(){
        Working=false;
    }
}
