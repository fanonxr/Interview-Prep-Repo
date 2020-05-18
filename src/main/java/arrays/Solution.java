package arrays;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  public static void main(String[] args) {

  }

  public static int findMinInRotatedArray(int[] nums) {
    // check for edge cases
    if (nums.length <= 0) {
      return -1;
    }
    if (nums.length == 1) {
      return nums[0];
    }
    // execute binary search in order to find the elements
    int start = 0;
    int end = nums.length - 1;

    while (start < end) {
      // calculate the midpoint
      int mid = start + (end - start) / 2;
      // search for the mid
      if (mid > 0 && nums[mid] < nums[mid - 1]) {
        return nums[mid];
        // check if the value at the midpoint is greater than the value at the end
      } else if (nums[start] <= nums[mid] && nums[mid] > nums[end]) {
        // search higher half
        start = mid + 1;
      } else {
        // else search the lower half
        end = mid - 1;
      }
    }
    return nums[start];
  }

  public int subArraySum(int[] nums, int k) {
    // use a hashmap to store if we have seen that sum
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1); // we have seen 0 once
    // keep track of the sum
    int sum = 0;
    // how many sub arrays will calculate up to
    int result = 0;
    for (int num : nums) {
      // add the current num to our sum
      sum += num;
      // check if the map contains
      if (map.containsKey(sum - k)) {
        result += map.get(sum - k);
      }
      map.put(sum, map.getOrDefault(sum, 0) + 1);
    }
    return result;
  }

}
