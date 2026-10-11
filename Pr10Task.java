import java.util.*;

public class Pr10Task implements Runnable {
    int taskID;

    Pr10Task(int id){
        taskID = id;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println("Task " + taskID + " is running by " + threadName);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Task " + taskID + " is finished by " + threadName);
    }
}
