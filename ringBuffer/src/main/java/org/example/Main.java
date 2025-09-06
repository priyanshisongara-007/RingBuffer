package main.java.org.example;

import java.time.Instant;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        RingBuffer rb = new RingBuffer(5);
        char currentChar = 'a' - 1;

        System.out.println("EMPTY TEST:");
        System.out.println(rb.emit());

        System.out.println("FULL TEST:");
        for (int i = 0; i < 10; i++) {
            currentChar++;
            rb.insert(new Data(Instant.now(), Character.toString(currentChar)));
            // Sleep 100 ms to distinguish time stamps (optional)
            Thread.sleep(100);
        }

        List<Data> emittedData = rb.emit();
        for (Data d : emittedData) {
            System.out.println(d);
        }
    }
}