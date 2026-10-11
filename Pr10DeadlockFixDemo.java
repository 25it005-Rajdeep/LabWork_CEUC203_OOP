public class Pr10DeadlockFixDemo {


    public static void main(String[] args) {
        Object Game = new Object();
        Object Movie = new Object();
        Thread me = new Thread(() -> {
            synchronized (Game) {
                System.out.println("Me: Locked Game. Waiting for Launch...");
                try { Thread.sleep(100); } catch (InterruptedException e) {}

                synchronized (Movie) {
                    System.out.println("Me: opened movie! starting ...");
                }
            }
        }, "Me");

        Thread you = new Thread(() -> {
            synchronized (Game) {
                System.out.println("You: Locked Game. Waiting for Launch...");
                try { Thread.sleep(100); } catch (InterruptedException e) {}

                synchronized (Movie) {
                    System.out.println("You: opened movie! starting ...");
                }
            }

        }, "You");

        me.start();
        you.start();
    }
}
