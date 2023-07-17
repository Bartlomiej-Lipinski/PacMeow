import PowerUPs.*;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class MyTableCellRenderer extends JLabel implements TableCellRenderer {
    public MyTableCellRenderer(){}
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (value.getClass().equals(Pacmeow.class)) {
            Pacmeow pacmeow = (Pacmeow) value;
            return new JLabel(new ImageIcon(pacmeow.getObrazek().getImage().getScaledInstance(table.getWidth()/table.getColumnCount(),table.getRowHeight(),Image.SCALE_FAST)));
        } else if (value.getClass().equals(Sciana.class)) {
             Sciana sciana = (Sciana) value;
            return new JLabel(new ImageIcon(sciana.getObrazek().getImage().getScaledInstance(table.getWidth()/table.getColumnCount(),table.getRowHeight(),Image.SCALE_FAST)));
        } else if (value.getClass().equals(Snack.class)) {
            Snack snack = (Snack) value;
            return new JLabel(new ImageIcon(snack.getObrazek().getImage().getScaledInstance(table.getWidth()/table.getColumnCount(),table.getRowHeight(),Image.SCALE_FAST)));
        }else if (value.getClass().equals(Pies.class)) {
            Pies pies = (Pies) value;
            return new JLabel(new ImageIcon(pies.getObrazek().getImage().getScaledInstance(table.getWidth()/table.getColumnCount(),table.getRowHeight(),Image.SCALE_FAST)));
        }else if(value.getClass().equals(Empty.class)){
            return null;
        } else if (value.getClass().equals(PowerUP1.class)) {
            PowerUP1 powerUP1 = (PowerUP1) value;
            return new JLabel(new ImageIcon(powerUP1.getObrazek().getImage().getScaledInstance(table.getWidth()/table.getColumnCount(),table.getRowHeight(),Image.SCALE_FAST)));
        }  else if (value.getClass().equals(PowerUP2.class)) {
            PowerUP2 powerUP2 = (PowerUP2) value;
            return new JLabel(new ImageIcon(powerUP2.getObrazek().getImage().getScaledInstance(table.getWidth()/table.getColumnCount(),table.getRowHeight(),Image.SCALE_FAST)));
        } else if (value.getClass().equals(PowerUP3.class)) {
            PowerUP3 powerUP3 = (PowerUP3) value;
            return new JLabel(new ImageIcon(powerUP3.getObrazek().getImage().getScaledInstance(table.getWidth()/table.getColumnCount(),table.getRowHeight(),Image.SCALE_FAST)));
        } else if (value.getClass().equals(PowerUP4.class)) {
            PowerUP4 powerUP4 = (PowerUP4) value;
            return new JLabel(new ImageIcon(powerUP4.getObrazek().getImage().getScaledInstance(table.getWidth()/table.getColumnCount(),table.getRowHeight(),Image.SCALE_FAST)));
        } else if (value.getClass().equals(PowerUP5.class)) {
            PowerUP5 powerUP5 = (PowerUP5) value;
            return new JLabel(new ImageIcon(powerUP5.getObrazek().getImage().getScaledInstance(table.getWidth()/table.getColumnCount(),table.getRowHeight(),Image.SCALE_FAST)));
        }else{
            return null;
        }
    }
}
