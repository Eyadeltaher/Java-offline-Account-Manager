package eyad;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileHandle {
    @SuppressWarnings("unchecked")
    public static ArrayList<Account> loadData(){
        File file = new File(Account.getFILENAME());
        if (file.exists() && file.length() > 0) {
            try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(Account.getFILENAME()))) {
                return (ArrayList<Account>) inputStream.readObject();
            } catch (Exception e) {
                System.out.println("Error in class FileHandle (loadData method): "+e.getMessage());
            }
        }
        return new ArrayList<>();
    }

    public static void savaData(ArrayList<Account> list) {
        try (ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(Account.getFILENAME()))) {
            objOut.writeObject(list);
            objOut.flush();
        } catch (Exception e) {
            System.out.println("Error in class FileHandle (saveData method): "+e.getMessage());
        }
    }
}
