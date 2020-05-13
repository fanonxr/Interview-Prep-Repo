package rotate2DMatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();
    int[][] matrix1 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    int[][] matrix2 = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
    int[] A = new int[]{-3, -1, 1, 0, 2, 10, -2, 8};
    System.out.println(solution.threeSum(A));

    // solution.rotate(matrix1);
  }

  public int[][] rotate(int[][] matrix) {
    int size = matrix.length - 1;
    for (int layer = 0; layer < (matrix.length / 2); layer++) {
      for (int i = layer; i < size - layer; i++) {
        int top = matrix[layer][i];
        int right = matrix[i][size - layer];
        int bottom = matrix[size - layer][size - i];
        int left = matrix[size - i][layer];

        // rotating 90 degrees by swapping elements
        matrix[layer][i] = left;
        matrix[i][size - layer] = top;
        matrix[size - layer][size - i] = right;
        matrix[size - i][layer] = bottom;

      }
    }
    return matrix;
  }

  public List<List<Integer>> threeSum(int[] A) {
    // 1. sort the array so we can use two pointers
    Arrays.sort(A);
    // 2. create hashset to store duplicates
    Set<List<Integer>> uniqueTriplets = new HashSet<List<Integer>>();
    // 3. get the pointer to stop at the correct index
    int secondToLastIndex = A.length - 2;
    // 4. loop over and execute 2 sum
    for (int i = 0; i < secondToLastIndex; i++) {
      findTwoSum(i, A, uniqueTriplets);
    }
    return new ArrayList<>(uniqueTriplets);

  }

  public void findTwoSum(int rootIndex, int[] A, Set<List<Integer>> set) {
    int left = rootIndex + 1;
    int right = A.length - 1;
    // sum all 3 numbers
    while (left < right) {
      int totalSum = A[left] + A[right] + A[rootIndex];
      // check to equate for 0
      if (totalSum == 0) {
        set.add(Arrays.asList(A[rootIndex], A[left], A[right]));
        left++;
        right--;
      } else if (totalSum < 0) left++;
      else right--;
    }
  }

}
