import javax.swing.*;
import javax.swing.table.AbstractTableModel;
public class Plansza extends AbstractTableModel {
    int X;
    int Y;
    JLabel[][] plansza;
    Plansza(int X, int Y){
        this.X=X;
        this.Y=Y;
        plansza = new JLabel[X][Y];
    }

    @Override
    public int getRowCount() {
        return X;
    }

    @Override
    public int getColumnCount() {
        return Y;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return plansza[rowIndex][columnIndex];
    }

    public void setValueAt(Object value,int row,int col){
        plansza[row][col] = (JLabel) value;
        fireTableCellUpdated(row,col);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

}
