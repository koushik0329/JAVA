package MultiThreading;

public class Main {
    public static void main(String args[]) throws Exception{

        // Create a subclass of Thread
        MyThread t1 = new MyThread();

        //implement Runnable interface and pass instance as an argument to Thread()
        Runnable r1 = new MyRunnable();
        Thread t2 = new Thread(r1);


        // To make a user thread as Daemon Thread
        // t1.setDaemon(true);
        // t2.setDaemon(true);
        t1.start();
//        t2.join();//calling thread (ex.main) waits until the specified thread dies or for x milliseconds
        t2.start();
    }
}
