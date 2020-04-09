package singleNumber;

import java.util.HashMap;

public class SingleNumberSolution {
  public static void main(String[] args) {
    SingleNumberSolution singleNumberSolution = new SingleNumberSolution();
    int[] testSet1 = new int[]{2, 2, 1};
    int[] testSet2 = new int[]{4, 1, 2, 1, 2};


    int test1 = singleNumberSolution.singleNumber(testSet1);
    int test2 = singleNumberSolution.singleNumber(testSet2);
    System.out.println("Test 1 = " + test1);
    System.out.println("Test 2 = " + test2);
  }

  public int singleNumber(int[] nums) {
    // create a map to store the nums and the amount of times they show up
    HashMap<Integer, Integer> map = new HashMap<>();
    // loop over the array of nums
    for (int num : nums) {
      // check to see if the num is in the map or not
      if (!map.containsKey(num)) {
        // add it to the map
        map.put(num, 1);
      } else {
        // it is already in the map
        int keyValue = map.get(num);
        map.replace(num, keyValue, keyValue + 1);
      }
    }

    // loop over the map until the value of a key is 1

    return 0;
  }
}
