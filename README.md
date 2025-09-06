Overview
The main.java.org.example.RingBuffer is a fixed-size circular buffer designed to efficiently store and manage a collection of main.java.org.example.Data objects in a continuous loop. Once the buffer reaches its maximum capacity, new elements overwrite the oldest data, making it ideal for situations where only the most recent data is relevant, such as sensor readings or real-time event logs.

Key Concepts
Fixed Size Buffer: The buffer has a predefined fixed size that determines how many main.java.org.example.Data objects it can hold at a time.

Circular Behavior: Indices wrap around when they reach the end of the buffer, ensuring continuous reuse of the array space.

Overwrite Old main.java.org.example.Data: When the buffer is full, new inserts overwrite the oldest unread data.

Efficient Insert and Emit: Insertions and emissions are performed in constant time, making it well-suited for high-throughput data streams.

Components
main.java.org.example.Data Class:

Represents the items stored in the buffer.

Contains a stamp timestamp (Instant) and value (string).

main.java.org.example.RingBuffer Class:

main.java.org.example.Data array: Internal fixed-length array to store main.java.org.example.Data objects.

Size: Total capacity of the buffer.

lastInsert (int): Index of the last inserted element. Initialized to -1 to track empty state.

nextRead (int): Index of the next element to read during emission.

Core Methods
Constructor: main.java.org.example.RingBuffer(int size)
Initializes the buffer with the specified fixed size:

Allocates internal array of main.java.org.example.Data with the given size.

Sets lastInsert to -1 to indicate no data initially.

Sets nextRead to 0 corresponding to the position to read next.

insert(main.java.org.example.Data input)
Handles adding new data to the buffer:

Advances lastInsert by one (wrapping via modulo if reaching the end).

Saves the input data at that index.

If nextRead is equal to lastInsert, it means the buffer is full and nextRead is advanced, overwriting oldest data.

This circular index movement ensures continuous use of the buffer space without shifting elements.

emit() : List<main.java.org.example.Data>
Returns all unread data since the last emission:

Starts reading from nextRead.

Collects non-null data elements to an output list.

Clears those elements from the buffer (sets to null).

Stops when it reaches the lastInsert (latest inserted element) or when the buffer is empty.

Advances nextRead index as it emits.

If no new data is available, returns an empty list.

Usage and Behavior:
The buffer works efficiently for streaming and cyclic data writing scenarios.

It prevents memory overhead by reusing the same fixed-size array.

Maintains order of insertions during emit operations.

Supports continuous writing without requiring resizing or memory reallocation.