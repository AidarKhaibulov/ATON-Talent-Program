import java.util.Iterator;
import java.util.List;

public class Actor extends Thread{
    List<String > dialogues;
    List<Integer > timings;
    Actor(String name, List<String> dialogues,List<Integer> timings){
        super(name);
        this.dialogues=dialogues;
        this.timings=timings;
    }
    @Override
    synchronized public void run(){
        try {
            Iterator it= timings.iterator();
            for(String phrase: dialogues){
                System.out.println(Thread.currentThread().getName()+": "+phrase);
                Thread.sleep((Long) it.next());
            }


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
