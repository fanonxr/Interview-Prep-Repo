package minStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {
  Deque<Deque<Integer>> delegate = new ArrayDeque<>();

  public void push(int x) {
    if (delegate.isEmpty() || x < getMin()) {
      delegate.addLast(new ArrayDeque<>());
    }
    delegate.getLast().addLast(x);
  }

  public void pop() {
    delegate.getLast().removeLast();
    if (delegate.getLast().isEmpty()) {
      delegate.removeLast();
    }
  }

  public int top() {
    return delegate.getLast().getLast();
  }

  public int getMin() {
    return delegate.getLast().getFirst();
  }
}
