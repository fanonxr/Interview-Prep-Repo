package countElements;

import java.util.HashSet;

public class CountElements {
  public static void main(String[] args) {
    int[] test1 = new int[]{1, 2, 3};
    int[] test2 = new int[]{1, 1, 3, 3, 5, 5, 7, 7};
    int[] test3 = new int[]{1, 3, 2, 3, 5, 0};
    int[] test4 = new int[]{1, 1, 2, 2};
    int value1 = countElements(test1);
    int value2 = countElements(test2);
    int value3 = countElements(test3);
    int value4 = countElements(test4);
    System.out.println("Value 1 = " + value1);
    System.out.println("Value 2 = " + value2);
    System.out.println("Value 3 = " + value3);
    System.out.println("Value 4 = " + value4);
  }

  public static int countElements(int[] arr) {
    // create a hashset that will store the tracked nums
    HashSet<Integer> set = new HashSet<Integer>();
    // loop over the array and add it to the hashset
    for (int n: arr) {
      set.add(n);
    }
    // count the elements
    int counter = 0;
    for (int n: arr) {
      if (set.contains(n + 1)) {
        counter++;
      }
    }
    return counter;
  }
}
