import javax.swing.*;
public class Refresher extends Thread{
    private final JTable plan;
    private boolean Working = true;
    public Refresher(JTable plan)
    {
        this.plan = plan;
    }
    @Override
    public void run() {
        while(Working){
            plan.repaint();
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.getCause();
            }
        }
    }
    public void off(){
        Working=false;
    }
}
