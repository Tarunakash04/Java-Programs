class NameChangingThread extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("Thread " + getName() + " is sleeping for 5 seconds.");
            Thread.sleep(5000); // Sleep for 5 seconds
            setName("NewThreadName"); // Change the thread name
            System.out.println("Thread name changed to " + getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Maina {
    public static void main(String[] args) {
        NameChangingThread thread = new NameChangingThread();
        thread.start();
    }
}
