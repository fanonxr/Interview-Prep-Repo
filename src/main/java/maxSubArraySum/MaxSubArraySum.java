package maxSubArraySum;

public class MaxSubArraySum {
  public static void main(String[] args) {
    int[] numArrayTest = new int[] {-3, 1, -8, 4, -1, 2, 1, -5, 5};
    int test1 = maxSubArraySum(numArrayTest);
    System.out.println(test1);
  }

  public static int maxSubArraySum(int[] nums) {
    int maxSoFar = nums[0], maxEndingHere = nums[0];
    for (int i = 1; i < nums.length; ++i) {
      maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
      maxSoFar = Math.max(maxSoFar, maxEndingHere);
    }
    return maxSoFar;
  }
}
