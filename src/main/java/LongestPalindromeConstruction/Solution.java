package LongestPalindromeConstruction;

import java.util.HashSet;
import java.util.Set;

public class Solution {
  public static void main(String[] args) {

  }

  public static int longestPalindrome(String s) {
    // we will get the total amount of matching characters
    int matching = 0;
    Set<Character> unMatchedCharacters = new HashSet<>();

    for (char c: s.toCharArray()) {
      if (unMatchedCharacters.contains(c)) {
        unMatchedCharacters.remove(c);
        matching++;
      } else {
        unMatchedCharacters.add(c);
      }
    }

    int longestPalindromeLength = matching * 2;
    if (!unMatchedCharacters.isEmpty()) {
      longestPalindromeLength++;
    }

    return longestPalindromeLength;
  }
}
