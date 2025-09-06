package main.java.org.example;

import java.util.ArrayList;
import java.util.List;


// main.java.org.example.RingBuffer is a circular buffer for storing main.java.org.example.Data objects.
class RingBuffer {
    private Data[] data;
    // total size of buffer
    private int size;
    // last element that was written to in buffer
    private int lastInsert;
    // next element to read during emit
    private int nextRead;

    // Constructor
    public RingBuffer(int size) {
        this.size = size;
        this.data = new Data[size];
        // initialize to -1 so that we can discern when no insert has occurred
        this.lastInsert = -1;
        this.nextRead = 0;
    }

    // Insert adds a new main.java.org.example.Data to the main.java.org.example.RingBuffer.
    // If the buffer is full, the oldest data is overwritten.
    public void insert(Data input) {
        lastInsert = (lastInsert + 1) % size;
        data[lastInsert] = input;

        if (nextRead == lastInsert) {
            nextRead = (nextRead + 1) % size;
        }
    }

    // Emit returns all data in main.java.org.example.RingBuffer since the last call to Emit.
    // If no data has been written since the last call to Emit,
    // an empty list is returned.
    public List<Data> emit() {
        List<Data> output = new ArrayList<>();

        while (true) {
            if (data[nextRead] != null) {
                output.add(data[nextRead]);
                data[nextRead] = null;
            }

            if (nextRead == lastInsert || lastInsert == -1) {
                break;
            }

            nextRead = (nextRead + 1) % size;
        }

        return output;
    }
}

