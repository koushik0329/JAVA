package MultiThreading;

public class MyRunnable implements Runnable{
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println("t2"+i);
            try{
                Thread.sleep(1000);
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        System.out.println("Done t2");
    }
}
