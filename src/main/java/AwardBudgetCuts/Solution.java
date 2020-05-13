package AwardBudgetCuts;

import java.util.Arrays;

public class Solution {
  static double findGrantsCap(double[] grantsArray, double newBudget) {
    if (grantsArray == null || newBudget <= 0) return 0;

    int length = grantsArray.length;
    double prefixSum = 0;

    Arrays.sort(grantsArray);

    for (int index = 0; index < length; index++) {
      double current = grantsArray[index];
      double available = newBudget - prefixSum;
      int numbersLeft = length - index;

      if (current * numbersLeft > available) return available / numbersLeft;

      prefixSum += current;
    }

    return grantsArray[length - 1];


  }
}
