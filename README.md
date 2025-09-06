<img width="1817" height="319" alt="image" src="https://github.com/user-attachments/assets/69629afb-784d-4745-b065-e0ee22325dee" />

**Overview**
RingBuffer is a fixed-size circular buffer designed to efficiently store and manage a collection of main.java.org.example.Data objects in a continuous loop. Once the buffer reaches its maximum capacity, new elements overwrite the oldest data, making it ideal for situations where only the most recent data is relevant, such as sensor readings or real-time event logs.

**Key Concepts**
Fixed Size Buffer: The buffer has a predefined fixed size that determines how many main.java.org.example.Data objects it can hold at a time.

Circular Behavior: Indices wrap around when they reach the end of the buffer, ensuring continuous reuse of the array space.

Overwrite Old main.java.org.example.Data: When the buffer is full, new inserts overwrite the oldest unread data.

Efficient Insert and Emit: Insertions and emissions are performed in constant time, making it well-suited for high-throughput data streams.

**Components**
main.java.org.example.Data Class:

Represents the items stored in the buffer.

Contains a stamp timestamp (Instant) and value (string).

main.java.org.example.RingBuffer Class:

main.java.org.example.Data array: Internal fixed-length array to store main.java.org.example.Data objects.

Size: Total capacity of the buffer.

lastInsert (int): Index of the last inserted element. Initialized to -1 to track empty state.

nextRead (int): Index of the next element to read during emission.


**Usage and Behavior:**
The buffer works efficiently for streaming and cyclic data writing scenarios.

It prevents memory overhead by reusing the same fixed-size array.

Maintains order of insertions during emit operations.

Supports continuous writing without requiring resizing or memory reallocation.
