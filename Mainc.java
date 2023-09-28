class UserThread extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("User Thread is starting...");
            Thread.sleep(1000); // Sleep for 1 second
            System.out.println("User Thread has finished.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Mainc {
    public static void main(String[] args) {
        UserThread userThread = new UserThread();

        Thread mainThread = Thread.currentThread();

        userThread.start();

        try {
            System.out.println("Main Thread is starting...");
            Thread.sleep(1000); // Sleep for 1 second
            System.out.println("Main Thread has finished.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
