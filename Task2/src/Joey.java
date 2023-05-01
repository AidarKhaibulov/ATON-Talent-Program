public class Joey extends Thread{
    Joey(){
        super("Joey");
    }

    public void run(){
        System.out.printf("%s: Hey,hey.\n", Thread.currentThread().getName());

    }
}
