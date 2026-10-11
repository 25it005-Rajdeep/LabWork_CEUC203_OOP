import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Pr10ThreadPoolRunner {
    public static void main(String[] s) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 10; i++) {
            executor.submit(new Pr10Task(i));
        }

        executor.shutdown();
    }
}
