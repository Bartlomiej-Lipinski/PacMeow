import javax.swing.*;

public class Pies extends JLabel {
    private int kierunek;
    private ImageIcon obrazek;
    private int X;
    private int Y;
    private ImageIcon[] biegR = new ImageIcon[4];
    private ImageIcon[] biegL = new ImageIcon[4];

    private boolean Working = true;

    public Pies() {
        setAlignmentX(0);
        setAlignmentY(0);
        setVisible(true);
        biegR[0] = new ImageIcon("IKONY/DOG/PIES_RIGHT/PIESRIGHT1.jpg");
        biegR[1] = new ImageIcon("IKONY/DOG/PIES_RIGHT/PIESRIGHT2.jpg");
        biegR[2] = new ImageIcon("IKONY/DOG/PIES_RIGHT/PIESRIGHT3.jpg");
        biegR[3] = new ImageIcon("IKONY/DOG/PIES_RIGHT/PIESRIGHT4.jpg");
        biegL[0] = new ImageIcon("IKONY/DOG/PIES_LEFT/PIESLEFT1.jpg");
        biegL[1] = new ImageIcon("IKONY/DOG/PIES_LEFT/PIESLEFT2.jpg");
        biegL[2] = new ImageIcon("IKONY/DOG/PIES_LEFT/PIESLEFT3.jpg");
        biegL[3] = new ImageIcon("IKONY/DOG/PIES_LEFT/PIESLEFT4.jpg");

        Thread zmianaObrazka = new Thread(() -> {
            try {
                while (true) {
                    switch (kierunek) {
                        case 1 -> {
                            for (int i = 0; i < 4; i++) {
                                obrazek = biegR[i];
                            }
                        }
                        case 2 -> {
                            for (int i = 0; i < 4; i++) {
                                obrazek = biegL[i];
                            }
                        }
                        default -> {
                            for (int i = 0; i < 4; i++) {
                                obrazek = biegR[0];
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
        zmianaObrazka.start();
    }

    public int getTableX() {
        return X;
    }

    public void setTableX(int x) {
        X = x;
    }

    public int getTableY() {
        return Y;
    }

    public void setTableY(int y) {
        Y = y;
    }

    public ImageIcon getObrazek() {
        return obrazek;
    }
    public void setObrazek(ImageIcon obrazek){
        this.obrazek=obrazek;
    }

    public void setKierunek(int kierunek) {
        this.kierunek = kierunek;
    }
    public void off(){
        Working=false;
    }
}
