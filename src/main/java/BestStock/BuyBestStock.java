package BestStock;

public class BuyBestStock {
  public static void main(String[] args) {
    int[] testNums = new int[]{7, 1, 5, 3, 6, 4};
    maxProfit(testNums);

  }

  public static int maxProfit(int[] nums) {
    int maxProfit = 0;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > nums[i - 1]) {
        maxProfit += nums[i] - nums[i - 1];
      }
    }
    System.out.println("Max profit: " + maxProfit);
    return maxProfit;
  }
}
