package Queues;

import java.util.Arrays;
import java.util.Collections;
import java.util.NoSuchElementException;

public class CustomCircularQueue {
  private int head = 0;
  private int tail = 0;
  private int size = 0;
  private static int SCALE_FACTER = 2;
  private int[] queue;

  // constructor where you will pass in the total amount the array will contain
  public CustomCircularQueue(int capacity) {
    this.queue = new int[capacity];
  }
  // enqueue is add the value to the front of queue (first in, first out)
  public void enqueue(int x) {
    // check the size to see if you can enqueue
    if (size == queue.length) {
      resize();
    }
    // insert the item to the end of the queue
    queue[tail] = x;

    // adjust the tail
    tail = (tail + 1) % queue.length;
    size++;
  }

  // removing an element from the queue
  public int dequeue() {
    // check if there are elements to deque
    if (size == 0) {
      throw new NoSuchElementException("Queue is empty");
    }

    int dequeuedValue = queue[head];
    head = (head + 1) % queue.length;
    size--;

    return dequeuedValue;
  }

  private void resize() {
    // do a circular shift on all items -head positions
    // putting the head item at index 0 and the rest of the list in position
    Collections.rotate(Arrays.asList(queue), -head);

    head = 0;
    tail = size;

    // resize based on the scaling factor,
    queue = Arrays.copyOf(queue, size * SCALE_FACTER);

  }
}
