import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private  String email;
    private  String phone;
    private String password;
    private String username;
 User(){

 }
    User(String name,String username, String email, String phone, String password){
        this.name = name;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;

    }
    public String getName(){
        return this.name;
    }

    public  String getEmail(){
        return this.email;
    }
    public  String getPhone(){
        return this.phone;
    }
    public  String getPassword(){
        return this.password;
    }

    public String getUsername(){
        return this.username;
    }

}
