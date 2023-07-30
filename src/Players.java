import java.io.*;
import java.util.ArrayList;

public class Players implements Serializable {
    private static ArrayList<Player> gracze = new ArrayList<>();

    public static void addPlayer(Player gracz){
        gracze.add(gracz);
    }
    public static void save(){
        try {
            File file = new File("tablawynikow.txt");
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(gracze);
            objectOutputStream.flush();
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    public static void read(){
        File file = new File("tablawynikow.txt");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            gracze = (ArrayList<Player>) objectInputStream.readObject();
        } catch (Exception e) {
            e.getCause();
        }
    }
}