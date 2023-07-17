import PowerUPs.*;

import javax.swing.*;

public class PiesKontroler extends Thread {
    private final JTable plan;
    private final Pacmeow kot;
    private final Sciana sciana;
    private final Snack snack;
    private final Player player;
    private final JFrame gra;
    private final Pies pies;
    private final Timerr timerr;
    private final Refresher refresher;
    private final Empty empty;
    private final InfoBelt infoBelt;
    private final PowerUP1 powerUP1;
    private final PowerUP2 powerUP2;
    private final PowerUP3 powerUP3;
    private final PowerUP4 powerUP4;
    private final PowerUP5 powerUP5;
    private boolean Working = true;

    private int speed;

    public PiesKontroler(JTable plan, Pacmeow kot, Sciana sciana, Snack snack, Player player,
                         JFrame gra, Pies pies, Timerr timerr, Refresher refresher, Empty empty,
                         InfoBelt infoBelt, PowerUP1 powerUP1, PowerUP2 powerUP2, PowerUP3 powerUP3,
                         PowerUP4 powerUP4, PowerUP5 powerUP5) {
        this.plan = plan;
        this.kot = kot;
        this.sciana = sciana;
        this.snack = snack;
        this.player = player;
        this.gra = gra;
        this.pies = pies;
        this.timerr = timerr;
        this.refresher = refresher;
        this.empty = empty;
        this.infoBelt = infoBelt;
        this.powerUP1 = powerUP1;
        this.powerUP2 = powerUP2;
        this.powerUP3 = powerUP3;
        this.powerUP4 = powerUP4;
        this.powerUP5 = powerUP5;
        speed=200;
    }
    @Override
    public void run() {
        while (Working) {
            int kierunek = (int) ((Math.random() * 4) + 1);
            int x = pies.getTableX();
            int y = pies.getTableY();
            switch (kierunek) {
                case 1 -> {
                    if (plan.getValueAt(x + 1, y) == sciana) {

                    } else if (plan.getValueAt(x + 1, y) == kot) {
                       kolizjaKot();
                    } else if (plan.getValueAt(x+1, y) == empty) {
                        int los = (int) ((Math.random()*10)+1);
                        if (los==1){
                            int los1 = (int) ((Math.random()*5)+1);
                            switch (los1){
                                case 1->{plan.setValueAt(pies, x+1, y);
                                    plan.setValueAt(powerUP1, x, y);
                                    pies.setTableX(x + 1);
                                    pies.setKierunek(2);}
                                case 2->{plan.setValueAt(pies, x+1, y);
                                    plan.setValueAt(powerUP2, x, y);
                                    pies.setTableX(x + 1);
                                    pies.setKierunek(2);}
                                case 3->{plan.setValueAt(pies, x+1, y);
                                    plan.setValueAt(powerUP3, x, y);
                                    pies.setTableX(x + 1);
                                    pies.setKierunek(2);}
                                case 4->{plan.setValueAt(pies, x+1, y);
                                    plan.setValueAt(powerUP4, x, y);
                                    pies.setTableX(x + 1);
                                    pies.setKierunek(2);}
                                case 5->{plan.setValueAt(pies, x+1, y);
                                    plan.setValueAt(powerUP5, x, y);
                                    pies.setTableX(x + 1);
                                    pies.setKierunek(2);}
                            }
                        }else {
                            Object a = plan.getValueAt(x + 1, y);
                            plan.setValueAt(pies, x + 1, y);
                            plan.setValueAt(a, x, y);
                            pies.setTableX(x + 1);
                        }
                    }else {
                        Object a = plan.getValueAt(x + 1, y);
                        plan.setValueAt(pies, x + 1, y);
                        plan.setValueAt(a, x, y);
                        pies.setTableX(x + 1);
                    }
                }
                case 2 -> {
                    if (plan.getValueAt(x - 1, y) == sciana) {

                    } else if (plan.getValueAt(x - 1, y) == kot) {
                        kolizjaKot();
                    }else if (plan.getValueAt(x-1, y) == empty) {
                        int los = (int) ((Math.random()*10)+1);
                        if (los==1){
                            int los1 = (int) ((Math.random()*5)+1);
                            switch (los1){
                                case 1->{plan.setValueAt(pies, x-1, y );
                                    plan.setValueAt(powerUP1, x, y);
                                    pies.setTableX(x - 1);
                                    pies.setKierunek(2);}
                                case 2->{plan.setValueAt(pies, x-1, y );
                                    plan.setValueAt(powerUP2, x, y);
                                    pies.setTableX(x - 1);
                                    pies.setKierunek(2);}
                                case 3->{plan.setValueAt(pies, x-1, y );
                                    plan.setValueAt(powerUP3, x, y);
                                    pies.setTableX(x - 1);
                                    pies.setKierunek(2);}
                                case 4->{plan.setValueAt(pies, x-1, y );
                                    plan.setValueAt(powerUP4, x, y);
                                    pies.setTableX(x - 1);
                                    pies.setKierunek(2);}
                                case 5->{plan.setValueAt(pies, x-1, y );;
                                    plan.setValueAt(powerUP5, x, y);
                                    pies.setTableX(x - 1);
                                    pies.setKierunek(2);}
                            }
                        }else {
                            Object a = plan.getValueAt(x - 1, y);
                            plan.setValueAt(pies, x - 1, y);
                            plan.setValueAt(a, x, y);
                            pies.setTableX(x - 1);
                        }
                    } else {
                        Object a = plan.getValueAt(x - 1, y);
                        plan.setValueAt(pies, x - 1, y);
                        plan.setValueAt(a, x, y);
                        pies.setTableX(x - 1);
                    }
                }
                case 3 -> {
                    if (plan.getValueAt(x, y + 1) == sciana) {

                    } else if (plan.getValueAt(x, y + 1) == kot) {
                        kolizjaKot();
                    }else if (plan.getValueAt(x, y + 1) == empty) {
                        int los = (int) ((Math.random()*10)+1);
                        if (los==1){
                            int los1 = (int) ((Math.random()*5)+1);
                            switch (los1){
                                case 1->{plan.setValueAt(pies, x, y + 1);
                                    plan.setValueAt(powerUP1, x, y);
                                    pies.setTableY(y + 1);
                                    pies.setKierunek(2);}
                                case 2->{plan.setValueAt(pies, x, y + 1);
                                    plan.setValueAt(powerUP2, x, y);
                                    pies.setTableY(y + 1);
                                    pies.setKierunek(2);}
                                case 3->{plan.setValueAt(pies, x, y + 1);
                                    plan.setValueAt(powerUP3, x, y);
                                    pies.setTableY(y + 1);
                                    pies.setKierunek(2);}
                                case 4->{plan.setValueAt(pies, x, y + 1);
                                    plan.setValueAt(powerUP4, x, y);
                                    pies.setTableY(y + 1);
                                    pies.setKierunek(2);}
                                case 5->{plan.setValueAt(pies, x, y + 1);
                                    plan.setValueAt(powerUP5, x, y);
                                    pies.setTableY(y + 1);
                                    pies.setKierunek(2);}
                            }
                        }else {
                            Object a = plan.getValueAt(x, y + 1);
                            plan.setValueAt(pies, x, y + 1);
                            plan.setValueAt(a, x, y);
                            pies.setTableY(y + 1);
                            pies.setKierunek(1);
                        }
                    } else {
                        Object a = plan.getValueAt(x, y + 1);
                        plan.setValueAt(pies, x, y + 1);
                        plan.setValueAt(a, x, y);
                        pies.setTableY(y + 1);
                        pies.setKierunek(1);
                    }
                }
                case 4 -> {
                    if (plan.getValueAt(x, y - 1) == sciana) {

                    } else if (plan.getValueAt(x, y - 1) == kot) {
                        kolizjaKot();
                    }else if (plan.getValueAt(x, y - 1) == empty) {
                        int los = (int) ((Math.random()*10)+1);
                        if (los==1){
                             int los1 = (int) ((Math.random()*5)+1);
                             switch (los1){
                                 case 1->{plan.setValueAt(pies, x, y - 1);
                                     plan.setValueAt(powerUP1, x, y);
                                     pies.setTableY(y - 1);
                                     pies.setKierunek(2);}
                                 case 2->{plan.setValueAt(pies, x, y - 1);
                                     plan.setValueAt(powerUP2, x, y);
                                     pies.setTableY(y - 1);
                                     pies.setKierunek(2);}
                                 case 3->{plan.setValueAt(pies, x, y - 1);
                                     plan.setValueAt(powerUP3, x, y);
                                     pies.setTableY(y - 1);
                                     pies.setKierunek(2);}
                                 case 4->{plan.setValueAt(pies, x, y - 1);
                                     plan.setValueAt(powerUP4, x, y);
                                     pies.setTableY(y - 1);
                                     pies.setKierunek(2);}
                                 case 5->{plan.setValueAt(pies, x, y - 1);
                                     plan.setValueAt(powerUP5, x, y);
                                     pies.setTableY(y - 1);
                                     pies.setKierunek(2);}
                             }
                        }else {
                            Object a = plan.getValueAt(x, y - 1);
                            plan.setValueAt(pies, x, y - 1);
                            plan.setValueAt(a, x, y);
                            pies.setTableY(y - 1);
                            pies.setKierunek(2);
                        }
                    } else {
                        Object a = plan.getValueAt(x, y - 1);
                        plan.setValueAt(pies, x, y - 1);
                        plan.setValueAt(a, x, y);
                        pies.setTableY(y - 1);
                        pies.setKierunek(2);
                    }
                }
            }
            try {
                Thread.sleep(speed, 0);
            } catch (InterruptedException e) {
                e.getCause();
            }
        }
    }

    private void kolizjaKot() {
        if (player.getlifes()==0) {
            SwingUtilities.invokeLater(() -> new KoniecGry(player));
            proceduraWylaczenia();
            off();
        }else {
            player.minuslife();
            plan.setValueAt(empty,kot.getTableX(),kot.getTableY());
            plan.setValueAt(kot, 2, 2);
            kot.setTableY(2);
            kot.setTableX(2);
        }
    }

    public void off(){
        Working=false;
    }
    public void proceduraWylaczenia(){
        gra.dispose();
        timerr.off();
        refresher.off();
        pies.off();
        kot.off();
        infoBelt.off();
    }
    public void setSpeed(int speedupdate){
        speed=speedupdate;
    }
}

