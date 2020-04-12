package LastStoneWeight;

import java.util.PriorityQueue;

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] test1 = new int[]{2, 7, 4, 1, 8, 1};
    int ans = solution.lastStoneWeight(test1);
    System.out.println("Answer is " + ans);
  }

  public int lastStoneWeight(int[] stones) {
    // create a heap to store the stone values
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
    for (int stone: stones) {
      // add the inverse of the stone weight to make sure it becomes a maxheap
      maxHeap.add(-stone);
    }

    // handle smashing the stones together
    while (maxHeap.size() > 1) {
      int stoneOne = -maxHeap.remove();
      int stoneTwo = -maxHeap.remove();
      // smash together and add back into heap
      if (stoneOne != stoneTwo) {
        maxHeap.add(-(stoneOne - stoneTwo));
      }
    }

    return maxHeap.isEmpty() ? 0 : -maxHeap.remove();
  }
}
