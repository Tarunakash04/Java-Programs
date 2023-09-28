class NameChangingThread extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 5; i >= 1; i--) {
                System.out.println("Thread " + getName() + " is sleeping for " + i + " seconds.");
                Thread.sleep(6000); // Sleep for 6 seconds
                setName("Thread" + i); // Change the thread name
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Mainb {
    public static void main(String[] args) {
        NameChangingThread thread = new NameChangingThread();
        thread.start();
    }
}
