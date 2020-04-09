package happnumber;

import java.util.HashSet;

public class HappyNumber {
  public static void main(String[] args) {
    boolean test1 = isHappy(19);
    boolean test2 = isHappy(2);
    System.out.println(test1);
    System.out.println(test2);
  }
  public static HashSet<Integer> occured = new HashSet<>();
  public static boolean isHappy(int n) {

    if (occured.contains(n)) return false;
    if (n == 1) return true;
    // add n to the hash set
    occured.add(n);
    int counter = 0;
    // move through each digit by dividing by 10
    while (n != 0) {
      counter += Math.pow(n % 10, 2); // it by sq
      n /= 10;
    }

    return isHappy(counter);
  }
}
