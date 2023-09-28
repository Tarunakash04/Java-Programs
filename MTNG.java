import java.util.Random;

public class MTNG {

    private static final int SLEEP_TIME = 1000; // 1 second

    private static volatile int randomNumber;

    private static class NumberGeneratorThread extends Thread {

        @Override
        public void run() {
            Random random = new Random();
            while (true) {
                synchronized (this) {
                    randomNumber = random.nextInt(100);
                }

                try {
                    Thread.sleep(SLEEP_TIME);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class EvenNumberThread extends Thread {

        @Override
        public void run() {
            while (true) {
                synchronized (this) {
                    if (randomNumber % 2 == 0) {
                        System.out.println("Square of even number " + randomNumber + " is " + (randomNumber * randomNumber));
                    }
                }
            }
        }
    }

    private static class OddNumberThread extends Thread {

        @Override
        public void run() {
            while (true) {
                synchronized (this) {
                    if (randomNumber % 2 != 0) {
                        System.out.println("Cube of odd number " + randomNumber + " is " + (randomNumber * randomNumber * randomNumber));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        NumberGeneratorThread numberGeneratorThread = new NumberGeneratorThread();
        EvenNumberThread evenNumberThread = new EvenNumberThread();
        OddNumberThread oddNumberThread = new OddNumberThread();

        numberGeneratorThread.start();
        evenNumberThread.start();
        oddNumberThread.start();
    }
}
