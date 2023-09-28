class ThreadA extends Thread {
    private String k;
    private int dc; // Variable to store the digit count

    public ThreadA(String k) {
        this.k = k;
    }

    public int getDigitCount() {
        return dc;
    }

    @Override
    public void run() {
        dc = countDigits(k);
        System.out.println("ThreadA:" + dc);
    }

    private int countDigits(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                count++;
            }
        }
        return count;
    }
}

class ThreadB extends Thread {
    private String k;
    private int cc; // Variable to store the character count

    public ThreadB(String k) {
        this.k = k;
    }

    public int getCharacterCount() {
        return cc;
    }

    @Override
    public void run() {
        cc = countAlphabeticCharacters(k);
        System.out.println("ThreadB:" + cc);
    }

    private int countAlphabeticCharacters(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                count++;
            }
        }
        return count;
    }
}

public class Maine {
    public static void main(String[] args) {
        String k = "Hello123World456";

        ThreadA threadA = new ThreadA(k);
        ThreadB threadB = new ThreadB(k);

        threadA.start();
        threadB.start();

        try {
            threadA.join();
            threadB.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int dc = threadA.getDigitCount();
        int cc = threadB.getCharacterCount();

        System.out.println("Total Digits Count: " + dc);
        System.out.println("Total Alphabetic Characters Count: " + cc);
    }
}
