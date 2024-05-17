import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Throws{
    public static void main(String args[]) throws Exception{
        int i,j=1,k=0;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        i=0;
        System.out.println("enter a number");
        j=Integer.parseInt(br.readLine());
        k=i+j;
        System.out.println("o/p is "+k);
    }
}