import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Final {
    public static void main(String args[]){
        int i,j=1,k=0;
//        BufferedReader br=new BufferedReader((new InputStreamReader(System.in)));
        InputStreamReader in=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(in);
        i=8;
        try{
            j=Integer.parseInt(br.readLine());
            k=i/j;
        }
        catch(IOException e){
            System.out.println(e);
        }
        catch (ArithmeticException e){
            System.out.println(e);

        }
        catch (Exception e){
            System.out.println(e);
        }
//        System.out.println(k);
        finally {
            System.out.println("Done");
        }
    }
}