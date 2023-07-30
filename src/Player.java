import java.io.Serializable;

public class Player implements Serializable {
    private String nick;
    private int Points=0;

    private int lifes=9;

    public Player(String nick, int Points) {
        this.nick = nick;
        this.Points = Points;
    }
    public Player() {

    }
    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setPoints(int Points) {
        this.Points = Points;
    }

    public int getPoints() {
        return Points;
    }

    public String getNick() {
        return nick;
    }

    public void dodajPunkt() {
        Points++;
    }

    public int getlifes(){
        return lifes;
    }
    public void minuslife(){
        lifes--;
    }
}
