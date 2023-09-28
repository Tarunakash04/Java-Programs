class SleepThread extends Thread {
    private long sleepTimeNs;

    public SleepThread(long sleepTimeNs) {
        this.sleepTimeNs = sleepTimeNs;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(sleepTimeNs / 1000000, (int)(sleepTimeNs % 1000000));
            System.out.println("Slept for " + sleepTimeNs + " nanoseconds.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Mainf {
    public static void main(String[] args) {
        long[] sleepTimesNs = { 10L, 20L, 50L, 70L, 100L };

        for (long sleepTimeNs : sleepTimesNs) {
            SleepThread sleepThread = new SleepThread(sleepTimeNs);
            sleepThread.start();
        }
    }
}
