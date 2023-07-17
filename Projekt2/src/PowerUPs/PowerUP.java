package PowerUPs;

import javax.swing.*;

abstract public class PowerUP extends JLabel {
    private int X;
    private int Y;
    private ImageIcon obrazek;
    public PowerUP() {
        obrazek = new ImageIcon("IKONY/PowerUP'y/catBowl.jpg");
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
    public void setObrazek(ImageIcon icon){
        obrazek=icon;
    }
}
