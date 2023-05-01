public class Phoebe extends Thread{
    Phoebe(){
        super("Phoebe");
    }

    public void run(){
        System.out.printf("%s: Hey.\n", Thread.currentThread().getName());

    }
}
