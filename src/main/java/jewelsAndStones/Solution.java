package jewelsAndStones;

import java.util.HashSet;

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();
    String j = "aAbx";
    String s = "aaBbXx";
    int ans = solution.numJewelsInStones(j, s);
    System.out.println(ans);
  }

  public int numJewelsInStones(String J, String S) {
    // use a hashset to store all the jewels
    HashSet<Character> set = new HashSet<>();
    // add the jewels to the set
    for (Character c: J.toCharArray()) {
      set.add(c);
    }
    // count how many are in the set
    int counter = 0;
    for (Character c: S.toCharArray()) {
      if (set.contains(c)) counter++;
    }

    return counter;
  }
}
