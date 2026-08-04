package threads;


import java.util.Scanner;

class XPS extends Thread {

    int size;
    int sleep;

    XPS(int n, int s) {
        size = n;
        sleep = s;
    }

    @Override
    public void run() {
        process();
    }

    public void process() {
        for (int i = 0; i < size; i++) {
            System.out.println("Retrieving Data for " + sleep + " ms");
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Sending Data from Thread-0" + i);
        }
    }
}

public class ServerDataTransmission {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int s = sc.nextInt();

        XPS thread = new XPS(n, s);
        thread.start();

        sc.close();
    }
}