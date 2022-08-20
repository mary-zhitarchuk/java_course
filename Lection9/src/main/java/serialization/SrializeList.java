package serialization;

import java.io.*;

public class SrializeList {
    public static void serialize(String fileName, Object o) {
         try(FileOutputStream fileOutputStream = new FileOutputStream(fileName);
             ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream))
         {
             outputStream.writeObject(o);
         }catch(IOException e){
             System.out.println(e.getMessage());
        }
    }

    public static Object deserialize(String fileName){
        try(FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream inputStream = new ObjectInputStream(fileInputStream)){
            return inputStream.readObject();
        }catch(IOException| ClassNotFoundException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
