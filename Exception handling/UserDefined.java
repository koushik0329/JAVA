//package Exception handling
public class UserDefined{
    public static void main(String args[]){
        int i=5;
        try{
            if(i<10){
                throw new Myexception("error");
            }

        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
class Myexception extends Exception{
    public Myexception(String str){
        super(str);
    }
}