import javax.swing.*;

public class Snack extends JLabel {
    private int X;
    private int Y;
    private int iloscSnackowNaPlanszy;
    private ImageIcon obrazek;
    public Snack() {
        obrazek = new ImageIcon("IKONY/snack.png");
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
    public void dodajSnacka(){
        iloscSnackowNaPlanszy++;
    }
    public void usunSnacka(){
        iloscSnackowNaPlanszy--;
    }
    public int getIloscSnackowNaPlanszy(){
        return iloscSnackowNaPlanszy;
    }
}
