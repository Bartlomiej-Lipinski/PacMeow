import javax.swing.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class Resizer implements ComponentListener {
    private final JFrame core;
    private final JTable table;

    public Resizer(JFrame core, JTable table){
        this.core = core;
        this.table = table;
    }
    @Override
    public void componentResized(ComponentEvent e) {
        table.setRowHeight(core.getHeight()/table.getRowCount()-4);
    }

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }
}
