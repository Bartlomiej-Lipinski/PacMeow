import PowerUPs.*;
import javax.swing.*;
import java.awt.*;

public class Core extends JFrame {
    public Core(int sizex, int sizey) {
        setTitle("PAC-MEOW");
        setBackground(new Color(255, 200, 200));
//        DEKLARACJA KLAS POTRZEBNYCH DO GRY
        Plansza plansza = new Plansza(sizex, sizey);
        JTable plan = new JTable();
        Timerr t = new Timerr();
        Pacmeow kot = new Pacmeow();
        Pies pies = new Pies();
        Snack snack = new Snack();
        Sciana sciana = new Sciana();
        Empty empty = new Empty();
        Player player = new Player();
        InfoBelt infoBelt = new InfoBelt(t,player);
        PowerUP1 powerUP1 = new PowerUP1();
        PowerUP2 powerUP2 = new PowerUP2();
        PowerUP3 powerUP3 = new PowerUP3();
        PowerUP4 powerUP4 = new PowerUP4();
        PowerUP5 powerUP5 = new PowerUP5();
        plan.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        plan.setModel(plansza);
//        TABLE MODEL DLA WSZYSTKICH
        for (int i = 0; i < plan.getColumnCount(); i++) {
            plan.getColumnModel().getColumn(i).setCellRenderer(new MyTableCellRenderer());
        }
        plan.setBackground(Color.WHITE);
        plan.setShowGrid(false);
        setLayout(new BorderLayout());
        setSize(plan.getRowCount() * 20, plan.getColumnCount() * 20);
        setVisible(true);
        setLocationRelativeTo(null);
        add(plan, BorderLayout.CENTER);
        add(infoBelt, BorderLayout.NORTH);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        plan.setColumnSelectionAllowed(false);
        generujPlansze(plan, kot, pies, sciana,snack);
        plan.setGridColor(Color.pink);
//        PORUSZANIE SIĘ I ANTYKOLIZJA PSA
        Refresher refresher = new Refresher(plan);
        refresher.start();
        t.start();
        PiesKontroler piesKontroler = new PiesKontroler(plan,kot,sciana,snack,player,this,pies,t,refresher,empty,infoBelt,powerUP1,powerUP2,powerUP3,powerUP4,powerUP5);
        piesKontroler.start();
        Resizer resizer = new Resizer(this,plan);
        this.addComponentListener(resizer);
//        PORUSZANIE SIĘ KOTAM I ANTY-KOLIZJA ZE ŚCIANĄ
        plan.addKeyListener(new PacmeowKontroler(plan,kot,player,sciana,snack,empty,t,piesKontroler,refresher,
                this,pies,infoBelt,powerUP1,powerUP2,powerUP3,powerUP4,powerUP5));
    }
    private void generujPlansze(JTable table, Pacmeow pacmeow, Pies pies, Sciana sciana, Snack snack) {
        boolean toggle = true;
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.setValueAt(sciana, 0, i);
            table.setValueAt(sciana, table.getRowCount() - 1, i);
        }
        for (int i = 0; i < table.getRowCount() - 1; i++) {
            table.setValueAt(sciana, i, 0);
            table.setValueAt(sciana, i, table.getColumnCount() - 1);
        }
        for (int row = 1; row < table.getRowCount() - 1; row++) {
            for (int col = 1; col < table.getColumnCount() - 1; col++) {
                if (row%2==0){
                    toggle=false;
                }else {
                    toggle=true;
                }

                if (toggle){
                    table.setValueAt(snack,row,col);
                    snack.dodajSnacka();
                }else {
                    int szansa = (int) ((Math.random() * 100) + 1);
                    if (szansa <=75) {
                        table.setValueAt(sciana, row, col);
                    } else {
                        table.setValueAt(snack, row, col);
                        snack.dodajSnacka();
                    }
                }
            }
        }
        snack.usunSnacka();
        snack.usunSnacka();
        table.setValueAt(pies, table.getRowCount() - 2, table.getColumnCount() - 2);
        pies.setTableX(table.getRowCount() - 2);
        pies.setTableY(table.getColumnCount() - 2);
        table.setValueAt(pacmeow, 2, 2);
        pacmeow.setTableY(2);
        pacmeow.setTableX(2);
    }
}