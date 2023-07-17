

public class Timerr extends Thread {
    private static int CzasWsec = 0;
    private boolean Working = true;
    static int godziny;
    static int minuty;
    static int sekundy;
    static String czasownik = (godziny + ":" + minuty + ":" + CzasWsec);

    public Timerr(){

    }
    public void run() {
        while (Working) {
            Sync();
            sekundy = CzasWsec;
            czasownik = (godziny + ":" + minuty + ":" + CzasWsec);
            if (CzasWsec == 60) {
                CzasWsec = 0;
                minuty++;
            }
            if (minuty == 60) {
                minuty = 0;
                godziny++;
            }
            if (CzasWsec == 86400) {
                CzasWsec = 0;
            }
            try {
                Thread.sleep(1000, 0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public String getCzasownik() {
        return czasownik;
    }

    public static synchronized void Sync() {
        CzasWsec++;
    }

    public void off() {
        Working = false;
    }

    public void timereset(){
        CzasWsec=0;
        minuty=0;
        godziny=0;
    }
}

