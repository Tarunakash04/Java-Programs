import java.util.concurrent.Semaphore;

class Printer {
    private Semaphore semaphore = new Semaphore(1);

    public void print(String job, int order) {
        try {
            semaphore.acquire();
            System.out.println("Printing Job " + job + " (Order " + order + ")");
            Thread.sleep(1000); // Simulate printing time
            System.out.println("Job " + job + " (Order " + order + ") completed");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}

class PrintJob implements Runnable {
    private Printer printer;
    private String job;
    private int order;

    public PrintJob(Printer printer, String job, int order) {
        this.printer = printer;
        this.job = job;
        this.order = order;
    }

    @Override
    public void run() {
        printer.print(job, order);
    }
}

public class Maind {
    public static void main(String[] args) {
        Printer printer = new Printer();

        Thread job1 = new Thread(new PrintJob(printer, "A", 1));
        Thread job2 = new Thread(new PrintJob(printer, "B", 2));
        Thread job3 = new Thread(new PrintJob(printer, "C", 3));

        job1.start();
        job2.start();
        job3.start();

        try {
            job1.join();
            job2.join();
            job3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
