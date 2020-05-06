package Fibonacci;

public class Fibonacci {
  // method to execute fibonacci without memoization
  public int fib(int n) {
    if (n == 0) return 0;
    if (n == 1) return 1;
    return fib(n - 1) + fib(n - 2);
  }

  // executing fibonacci with memoization
  public int fibDriver(int n) {
    int[] cache = new int[n];
    return fib(n, cache);
  }

  public int fib(int n, int[] cache) {
    if (n == 0) return 0;
    if (n == 1) return 1;
    // we are storing the fib result in cache to so we don't have to recompute every recursive call
    if (cache[n] == 0) cache[n] = fib(n - 1) + fib(n - 2);
    return cache[n];
  }
}
