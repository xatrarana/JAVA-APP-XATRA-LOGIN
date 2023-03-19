import java.io.*;

public class DataFile {
    DataFile(User userData) throws IOException {

        String name = userData.getUsername();
        System.out.println(name);
        String username = userData.getUsername();
        String email = userData.getEmail();
        String phone = userData.getPhone();
        String password = userData.getPassword();
        File file = new File("dataFile/"+name+".txt");
        file.createNewFile();


        FileWriter fileWriter = new FileWriter(file);

        fileWriter.write(userData.getName()+"\n");
        fileWriter.write(userData.getUsername()+"\n");
        fileWriter.write(userData.getEmail()+"\n");
        fileWriter.write(userData.getPhone()+"\n");
        fileWriter.write(userData.getPassword()+"\n");
        fileWriter.close();

        ///searilization
       try{
           FileOutputStream fileOutputStream = new FileOutputStream("dataFile/"+name+".txt");
           ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
           objectOutputStream.writeObject(userData);
           objectOutputStream.flush();
           objectOutputStream.close();
       }catch (Exception e){
           System.out.println(e.getMessage());
       }

    }
}
