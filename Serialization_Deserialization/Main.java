package Serialization_Deserialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String args[]) throws IOException {
        User user=new User();
        user.name="Bro";
        user.password="ok";
//        user.sayHello();
        FileOutputStream fileout=new FileOutputStream("C:\\Users\\Admin\\OneDrive\\Desktop\\JAVAC\\IDE\\src\\Serialization_Deserialization\\UserInfo.ser");
        ObjectOutputStream out=new ObjectOutputStream(fileout);
        out.writeObject(user);
        out.close();
        fileout.close();

        System.out.println("object info saved");

    }
}
