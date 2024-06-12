package Synchronization;

class Bank{
    float balance=5000.00f;
    synchronized void withdraw(float amount){
        try{
            System.out.println("withdraw started");
            if(balance<amount){
                System.out.println("less balance , waiting for deposit");
                wait();
            }
            balance=balance-amount;
            System.out.println("withdraw commpleted");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    synchronized void deposit(float amount){
        System.out.println("deposit started");
        balance=balance+amount;
        System.out.println("deposit completed");
        notify();
    }
}

class Customer1 extends Thread{
    Bank b;
    Customer1(Bank b){
        this.b=b;
    }
    public void run(){
        b.withdraw(6000.00f);
    }
}
class Customer2 extends Thread{
    Bank b;
    Customer2(Bank b){
        this.b=b;
    }
    public void run(){
        b.deposit(5000.00f);
    }
}

public class Demo {
    public static void main(String args[]){
        Bank b=new Bank();
        Customer1 c1=new Customer1(b);
        c1.start();
        Customer2 c2=new Customer2(b);
        c2.start();
//        c2.start();
    }
}
