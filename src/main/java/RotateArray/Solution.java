package RotateArray;

import java.util.Arrays;

public class Solution {
  public static void main(String[] args) {
    //
    int[] test = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
    rotate(test, 3);
  }

  public static void rotate(int[] nums, int k) {
    // get the midpoint of the array
    int midpoint = (nums.length / 2);
    int[] arr = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      arr[i] = nums[i];
    }

    // loop over the contents of the array
    for (int i = 0; i < nums.length - 1; i++) {
      if (i <= midpoint) {
        arr[i + k] = nums[i];
      }

      if (i >= midpoint) {
        arr[i + (-k)] = nums[i];
      }
    }

    System.out.println(Arrays.toString(arr));
  }
}
