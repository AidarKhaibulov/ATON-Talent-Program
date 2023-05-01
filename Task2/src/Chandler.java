public class Chandler extends Thread{
    Chandler(){
        super("Chandler");
    }

    public void run(){

        System.out.printf("%s: Hey.\n", Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("%s: And this from the cry-for-help department. Are you wearing makeup?\n", Thread.currentThread().getName());
    }
}
