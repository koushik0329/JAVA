package MultiThreading;

public class MyThread extends Thread{
    public void run(){
        for(int i=10;i>0;i--){
            System.out.println("t1"+i);
            try{
                Thread.sleep(1000);
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        System.out.println("Done t1");
    }
}
