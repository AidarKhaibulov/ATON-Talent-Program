import java.util.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        String [] actors={"Chandler","Joey","Monica","Phoebe","Rachel","Ross"};

        HashMap<String, List<String>> dialogues= new HashMap<>();
        dialogues.put(actors[0], Arrays.asList("Hello world!","God bless you guys!"));
        dialogues.put(actors[1],Arrays.asList("Hi!","I decided not to go there Ross"));
        dialogues.put(actors[2],Arrays.asList("Greetings!"));
        dialogues.put(actors[3],Arrays.asList("How are you?"));
        dialogues.put(actors[4],Arrays.asList("What's up?"));
        dialogues.put(actors[5],Arrays.asList("Hi there","Joey when do you go to the cinema?"));

        List<List<Long>> timings = new ArrayList<>();
        timings.add(Arrays.asList(6000L,1000L));
        timings.add(Arrays.asList(10000L,1000L));
        timings.add(Arrays.asList(1000L));
        timings.add(Arrays.asList(1000L));
        timings.add(Arrays.asList(1000L));
        timings.add(Arrays.asList(4000L,3000L));
        Iterator it= timings.iterator();

        for(String actor :actors) {
            Thread.sleep(1000);
            new Actor(actor,dialogues.get(actor), (List<Integer>) it.next()).start();
        }
    }
}