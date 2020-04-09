package MoveZeros;

import java.util.Arrays;

public class MoveZeroes {
  public static void main(String[] args) {
    int[] test1 = {0, 1, 0, 3, 12};
    moveZeroes(test1);
  }

  public static void moveZeroes(int[] nums) {
    int i = 0, j = 0, length = nums.length;
    while (true) {
      // find i that nums[i] = 0
      while (i < length && nums[i] != 0)
        ++i;
      // no zero in the array
      if (i == length)
        break;
      // find j that nums[j] != 0
      // all numbers in the array are 0
      while (j < length && nums[j] == 0)
        ++j;
      if (j == length)
        break;
      // find!
      // 0 is after non-0, continue searching with j=i+1
      if (j < i) {
        j = i + 1;
      } else {
        nums[i++] = nums[j];
        nums[j++] = 0;
      }
    }

    System.out.println("Array is converted to: " + Arrays.toString(nums));
  }
}
