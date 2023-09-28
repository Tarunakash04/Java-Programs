class ProcessThread extends Thread {
    public ProcessThread(String name, int priority) {
        super(name);
        setPriority(priority);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(getName() + " - Priority: " + getPriority() + " - Iteration: " + i);
            try {
                Thread.sleep(100); // Simulate some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Maing {
    public static void main(String[] args) {
        ProcessThread process1 = new ProcessThread("Process 1", Thread.MIN_PRIORITY);
        ProcessThread process2 = new ProcessThread("Process 2", Thread.NORM_PRIORITY);
        ProcessThread process3 = new ProcessThread("Process 3", Thread.NORM_PRIORITY);
        ProcessThread process4 = new ProcessThread("Process 4", Thread.MAX_PRIORITY);
        ProcessThread process5 = new ProcessThread("Process 5", Thread.MAX_PRIORITY);

        process1.start();
        process2.start();
        process3.start();
        process4.start();
        process5.start();
    }
}
