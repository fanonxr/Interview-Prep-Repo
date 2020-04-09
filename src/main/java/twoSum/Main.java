package twoSum;

import java.util.HashMap;
import java.util.Map;

public class Main {
  public static void main(String[] args) {
    int[] testArray = {2, 7, 11, 15};
    int target = 9;

    int[] solution = twoSum(testArray, target);
    System.out.println("solution = [" + solution[0] + ", " + solution[1] + "]");
  }

  public static int[] bruteForceTwoSum(int[] nums, int target) {
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[j] == target - nums[i]) {
          return new int[]{i, j};
        }
      }
    }
    return new int[]{0, 0};
  }

  public static int[] twoPassSolution(int[] nums, int target) {
    // create a hashmap to store the results as we pass through them
    Map<Integer, Integer> map = new HashMap<>();
    // add the data to the hashmap
    for (int i = 0; i < nums.length - 1; i++) {
      // key = the number in the hashmap
      // value = index of where that number is in the array
      map.put(nums[i], i);
    }

    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i]; // get the complement of what it will be

      // check to see if the hash map contains the compliment and if it does not equal the current index
      if (map.containsKey(complement) && map.get(complement) != i) {
        return new int[]{i, map.get(complement)};
      }
    }
    return new int[]{};
  }

  public static int[] twoSum(int[] nums, int target) {
    // check to see if the list is empty or null
    if (nums == null || nums.length == 0) return new int[0];

    // create a map to store the numbers
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    // get the total length of the list to traverse

    int len = nums.length;
    // prepare an array of the two indices to be returned
    int[] result = new int[2];

    for (int i = 0; i < len; i++) {
      if (map.get(target - nums[i]) != null) {
        result[0] = map.get(target - nums[i]);
        result[1] = i;
        return result;
      } else map.put(nums[i], i);
    }
    return new int[0];
  }
}
