package main.java.org.example;

import java.time.Instant;

// main.java.org.example.Data represents input received from sensors.
class Data {
    private Instant stamp;
    private String value;

    public Data(Instant stamp, String value) {
        this.stamp = stamp;
        this.value = value;
    }

    public Instant getStamp() {
        return stamp;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "main.java.org.example.Data{" +
                "stamp=" + stamp +
                ", value='" + value + '\'' +
                '}';
    }
}
