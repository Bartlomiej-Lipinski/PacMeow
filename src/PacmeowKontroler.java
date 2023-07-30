import PowerUPs.*;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PacmeowKontroler implements KeyListener {
    private final JTable plan;
    private final Pacmeow kot;
    private final Player player;
    private final Sciana sciana;
    private final Snack snack;
    private final Empty empty;
    private final Timerr timerr;
    private final PiesKontroler piesKontroler;
    private final Refresher refresher;
    private final JFrame gra;
    private final Pies pies;
    private final InfoBelt infoBelt;
    private final PowerUP1 powerUP1;
    private final PowerUP2 powerUP2;
    private final PowerUP3 powerUP3;
    private final PowerUP4 powerUP4;
    private final PowerUP5 powerUP5;

    public PacmeowKontroler(JTable plan, Pacmeow kot, Player player, Sciana sciana, Snack snack,
                            Empty empty, Timerr timerr, PiesKontroler piesKontroler, Refresher refresher,
                            JFrame gra, Pies pies, InfoBelt infoBelt, PowerUP1 powerUP1, PowerUP2 powerUP2, PowerUP3 powerUP3, PowerUP4 powerUP4 , PowerUP5 powerUP5){
        this.plan = plan;
        this.kot = kot;
        this.player = player;
        this.sciana = sciana;
        this.snack = snack;
        this.empty = empty;
        this.timerr = timerr;
        this.piesKontroler = piesKontroler;
        this.refresher = refresher;
        this.gra = gra;
        this.pies = pies;
        this.infoBelt = infoBelt;
        this.powerUP1 = powerUP1;
        this.powerUP2 = powerUP2;
        this.powerUP3 = powerUP3;
        this.powerUP4 = powerUP4;
        this.powerUP5 = powerUP5;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == 'w') {
            int x = kot.getTableX();
            int y = kot.getTableY();
            if (plan.getValueAt(x - 1, y) == sciana) {

            } else if (plan.getValueAt(x-1,y)==snack) {
                plan.setValueAt(kot,x-1, y);
                plan.setValueAt(empty, x, y);
                kot.setTableY(y);
                kot.setTableX(x-1);
                player.dodajPunkt();
                snack.usunSnacka();
                if (snack.getIloscSnackowNaPlanszy()==0){
                    SwingUtilities.invokeLater(()->new KoniecGry(player));
                    proceduraWylaczenia();
                }
            }else if (plan.getValueAt(x-1,y)==powerUP1) {
                piesKontroler.setSpeed(2000);
                plan.setValueAt(kot, x - 1, y);
                plan.setValueAt(empty, x, y);
                kot.setTableY(y);
                kot.setTableX(x - 1);
            }else if (plan.getValueAt(x-1,y)==powerUP2) {
                plan.setValueAt(empty,pies.getTableX(),pies.getTableY());
                plan.setValueAt(pies,plan.getRowCount() - 2, plan.getColumnCount() - 2);
                pies.setTableY(plan.getColumnCount()-2);
                pies.setTableX(plan.getRowCount()-2);
                plan.setValueAt(kot, x - 1, y);
                plan.setValueAt(empty, x, y);
                kot.setTableY(y);
                kot.setTableX(x - 1);
            }else if (plan.getValueAt(x-1,y)==powerUP3) {
                piesKontroler.setSpeed(6000);
                plan.setValueAt(kot, x - 1, y);
                plan.setValueAt(empty, x, y);
                kot.setTableY(y);
                kot.setTableX(x - 1);
            }else if (plan.getValueAt(x-1,y)==powerUP4) {
                piesKontroler.setSpeed(100);
                plan.setValueAt(kot, x - 1, y);
                plan.setValueAt(empty, x, y);
                kot.setTableY(y);
                kot.setTableX(x - 1);
            }else if (plan.getValueAt(x-1,y)==powerUP5) {
                piesKontroler.setSpeed(50);
                plan.setValueAt(kot, x - 1, y);
                plan.setValueAt(empty, x, y);
                kot.setTableY(y);
                kot.setTableX(x - 1);
            } else {
                plan.setValueAt(kot, x - 1, y);
                plan.setValueAt(empty, x, y);
                kot.setTableY(y);
                kot.setTableX(x - 1);
            }
        }
        else if (e.getKeyChar() == 's') {
            int x = kot.getTableX();
            int y = kot.getTableY();
            if (plan.getValueAt(x + 1, y) == sciana) {

            } else if (plan.getValueAt(x+1,y)==snack) {
                plan.setValueAt(kot, x+1, y);
                plan.setValueAt(empty, x, y);
                kot.setTableY(y);
                kot.setTableX(x+1);
                player.dodajPunkt();
                snack.usunSnacka();
                if (snack.getIloscSnackowNaPlanszy()==0){
                    SwingUtilities.invokeLater(()->new KoniecGry(player));
                   proceduraWylaczenia();
                }
            } else if (plan.getValueAt(x+1,y)==pies) {
                kolizjaPies();
            }else if (plan.getValueAt(x+1,y)==powerUP1) {
                piesKontroler.setSpeed(2000);
                plan.setValueAt(kot, x + 1, y);
                plan.setValueAt(empty, x, y);
                kot.setTableY(y);
                kot.setTableX(x + 1);
            }else if (plan.getValueAt(x+1,y)==powerUP2) {
                plan.setValueAt(empty,pies.getTableX(),pies.getTableY());
                plan.setValueAt(pies,plan.getRowCount() - 2, plan.getColumnCount() - 2);
                pies.setTableY(plan.getColumnCount()-2);
                pies.setTableX(plan.getRowCount()-2);
                plan.setValueAt(kot, x + 1, y);
                plan.setValueAt(empty, x, y);
                kot.setTableY(y);
                kot.setTableX(x + 1);
            }else if (plan.getValueAt(x+1,y)==powerUP3) {
                piesKontroler.setSpeed(6000);
                plan.setValueAt(kot, x + 1, y);
                plan.setValueAt(empty, x, y);
                kot.setTableY(y);
                kot.setTableX(x + 1);
            }else if (plan.getValueAt(x+1,y)==powerUP4) {
                piesKontroler.setSpeed(100);
                plan.setValueAt(kot, x + 1, y);
                plan.setValueAt(empty, x, y);
                kot.setTableY(y);
                kot.setTableX(x + 1);
            }else if (plan.getValueAt(x+1,y)==powerUP5) {
                piesKontroler.setSpeed(50);
                plan.setValueAt(kot, x + 1, y);
                plan.setValueAt(empty, x, y);
                kot.setTableY(y);
                kot.setTableX(x + 1);
            }else {
                plan.setValueAt(kot, x + 1, y);
                plan.setValueAt(empty, x, y);
                kot.setTableY(y);
                kot.setTableX(x + 1);
            }
        }
        else if (e.getKeyChar() == 'd') {
            kot.setKierunek(1);
            int x = kot.getTableX();
            int y = kot.getTableY();
            if (plan.getValueAt(x, y + 1) == sciana) {

            } else if (plan.getValueAt(x,y+1)==snack) {
                plan.setValueAt(kot, x, y+1);
                plan.setValueAt(empty, x, y);
                kot.setTableY(y+1);
                kot.setTableX(x);
                player.dodajPunkt();
                snack.usunSnacka();
                if (snack.getIloscSnackowNaPlanszy()==0){
                    SwingUtilities.invokeLater(()->new KoniecGry(player));
                    proceduraWylaczenia();
                }
            } else if (plan.getValueAt(x,y+1)==pies) {
                kolizjaPies();
            }else if (plan.getValueAt(x,y+1)==powerUP1) {
                piesKontroler.setSpeed(2000);
                plan.setValueAt(kot, x, y+1);
                plan.setValueAt(empty, x, y);
                kot.setTableY(y+1);
                kot.setTableX(x);
            }else if (plan.getValueAt(x,y+1)==powerUP2) {
                plan.setValueAt(empty,pies.getTableX(),pies.getTableY());
                plan.setValueAt(pies,plan.getRowCount() - 2, plan.getColumnCount() - 2);
                pies.setTableY(plan.getColumnCount()-2);
                pies.setTableX(plan.getRowCount()-2);
                plan.setValueAt(kot, x, y + 1);
                plan.setValueAt(empty, x, y);
                kot.setTableY(y + 1);
                kot.setTableX(x);
            }else if (plan.getValueAt(x,y+1)==powerUP3) {
                piesKontroler.setSpeed(6000);
                plan.setValueAt(kot, x, y + 1);
                plan.setValueAt(empty, x, y);
                kot.setTableY(y + 1);
                kot.setTableX(x);
            }else if (plan.getValueAt(x,y+1)==powerUP4) {
                piesKontroler.setSpeed(100);
                plan.setValueAt(kot, x, y + 1);
                plan.setValueAt(empty, x, y);
                kot.setTableY(y + 1);
                kot.setTableX(x);
            }else if (plan.getValueAt(x,y+1)==powerUP5) {
                piesKontroler.setSpeed(50);
                plan.setValueAt(kot, x, y + 1);
                plan.setValueAt(empty, x, y);
                kot.setTableY(y + 1);
                kot.setTableX(x);
            } else {
                plan.setValueAt(kot, x, y + 1);
                plan.setValueAt(empty, x, y);
                kot.setTableY(y + 1);
                kot.setTableX(x);
            }
        }
        else if (e.getKeyChar() == 'a') {
            kot.setKierunek(2);
            int x = kot.getTableX();
            int y = kot.getTableY();
            if (plan.getValueAt(x, y - 1) == sciana) {

            } else if (plan.getValueAt(x, y - 1) == snack) {
                plan.setValueAt(kot, x, y - 1);
                plan.setValueAt(empty, x, y);
                kot.setTableY(y - 1);
                kot.setTableX(x);
                player.dodajPunkt();
                snack.usunSnacka();
                if (snack.getIloscSnackowNaPlanszy()==0){
                    SwingUtilities.invokeLater(()->new KoniecGry(player));
                    proceduraWylaczenia();
                }
            } else if (plan.getValueAt(x,y-1)==pies) {
                kolizjaPies();
            } else if (plan.getValueAt(x,y-1)==powerUP1) {
                piesKontroler.setSpeed(2000);
                plan.setValueAt(kot, x, y-1);
                plan.setValueAt(empty, x, y);
                kot.setTableY(y-1);
                kot.setTableX(x);
            }else if (plan.getValueAt(x,y-1)==powerUP2) {
                plan.setValueAt(empty,pies.getTableX(),pies.getTableY());
                plan.setValueAt(pies,plan.getRowCount() - 2, plan.getColumnCount() - 2);
                pies.setTableY(plan.getColumnCount()-2);
                pies.setTableX(plan.getRowCount()-2);
                plan.setValueAt(kot, x, y - 1);
                plan.setValueAt(empty, x, y);
                kot.setTableY(y - 1);
                kot.setTableX(x);
            }else if (plan.getValueAt(x,y-1)==powerUP3) {
                piesKontroler.setSpeed(6000);
                plan.setValueAt(kot, x, y-1);
                plan.setValueAt(empty, x, y);
                kot.setTableY(y-1);
                kot.setTableX(x);
            }else if (plan.getValueAt(x,y-1)==powerUP4) {
                piesKontroler.setSpeed(100);
                plan.setValueAt(kot, x, y-1);
                plan.setValueAt(empty, x, y);
                kot.setTableY(y-1);
                kot.setTableX(x);
            }else if (plan.getValueAt(x,y-1)==powerUP5) {
                piesKontroler.setSpeed(50);
                plan.setValueAt(kot, x, y-1);
                plan.setValueAt(empty, x, y);
                kot.setTableY(y-1);
                kot.setTableX(x);
            }else {
                plan.setValueAt(kot, x, y - 1);
                plan.setValueAt(empty, x, y);
                kot.setTableY(y - 1);
                kot.setTableX(x);
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_Q && e.isControlDown() && e.isShiftDown()) {
            proceduraWylaczenia();
            JButton akcept = new JButton("OK");
            JOptionPane.showMessageDialog(akcept,"zamknęto okno skrótem WYNIK NIEZAPISANY");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    public void proceduraWylaczenia(){
        gra.dispose();
        timerr.off();
        timerr.timereset();
        piesKontroler.off();
        refresher.off();
        pies.off();
        kot.off();
        infoBelt.off();
    }
    private void kolizjaPies() {
        if (player.getlifes()==0) {
            SwingUtilities.invokeLater(() -> new KoniecGry(player));
            proceduraWylaczenia();
        }else {
            player.minuslife();
            plan.setValueAt(empty,kot.getTableX(),kot.getTableY());
            plan.setValueAt(kot, 2, 2);
            kot.setTableY(2);
            kot.setTableX(2);
        }
    }
}
