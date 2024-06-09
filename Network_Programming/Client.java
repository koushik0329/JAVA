package Network_Programming;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String args[]){
        try{
            String address=args[0];
            int port=Integer.parseInt(args[1]);
            Socket s=new Socket(address,port);
            OutputStream os=s.getOutputStream();
            InputStream is=s.getInputStream();
            byte[] b1=new byte[100];
            byte[] b2=new byte[100];
            while(true){
                System.out.println("To server:");
                System.in.read(b1);
                os.write(b1);
                is.read(b2);
                String s1=new String(b2);
                String s2=s1.trim();
                System.out.println("from server"+s2);
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
