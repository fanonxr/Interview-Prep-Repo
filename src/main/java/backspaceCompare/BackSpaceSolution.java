package backspaceCompare;

import java.util.Stack;

public class BackSpaceSolution {

  public static void main(String[] args) {
    BackSpaceSolution backSpaceSolution = new BackSpaceSolution();

    String test1_1 = "ab#cd";
    String test1_2 = "afg##cd";
    System.out.println(backSpaceSolution.backspaceCompare(test1_1, test1_2));


    String test2_1 = "a##c";
    String test2_2 = "#a#c";
    System.out.println(backSpaceSolution.backspaceCompare(test2_1, test2_2));

    // Testing with leetcode's solution
    System.out.println();
  }


  public boolean backspaceCompare(String s, String t) {
    return createStr(s).compareTo(createStr(t)) == 0;
  }

  /*
  * Method to build the string separately using a stack
  * O(N) time complexity since we have to go through the full duration of the string
  * O(N) space complexity since we are creating a stack that has the potential to be the full size of the string
  * */
  public String createStr(String s) {
    // use a stack to build up the string without the "#"
    Stack<Character> builtStr = new Stack<>();
    // loop over the string
    for (char c: s.toCharArray()) {
      // add the char to the stack if its not #
      if (c != '#') {
        builtStr.push(c);
      } else if (!builtStr.isEmpty()) {
        // pop the c off it the element is #
        builtStr.pop();
      }
    }
    // return the string version
    return String.valueOf(builtStr);
  }

  /**
   * using two pointers to compare
   * Time complexity is O(N) due to the lengths of T and S
   * Space complexity is O(1) since we are comparing in place
   * */
  public boolean backspaceCompareWithTwoPointers(String s, String t) {
    int sPointer = s.length() - 1;
    int tPointer = t.length() - 1;
    int skipS = 0, skipT = 0;

    while (sPointer >= 0 || tPointer >= 0) { // while there maybe chars in both strings
      // find the position of the next possible character to build from #
      while (sPointer >= 0) {
        if (s.charAt(sPointer) == '#') {
          // move to the next string
          skipS++;
          // decrement the pointer
          sPointer--;
        } else if (skipS > 0) { // check to see if its not the hash value
          skipS--; // move to next string
          sPointer--; // decrment pointer
        } else {
          break;
        }
      }
      // find the position for next char in string t
      while (tPointer >= 0) {
        if (t.charAt(tPointer) == '#') {
          skipT++;
          tPointer--;
        } else if (skipT > 0) {
          skipT--;
          tPointer--;
        } else {
          break;
        }
      }
      // compare the characters within string s and string t
      if (sPointer >= 0 && tPointer >= 0 && s.charAt(sPointer) != t.charAt(tPointer)) {
        return false;
      }

      if ((sPointer >= 0) != (tPointer >= 0)) {
        return false;
      }

      sPointer--; tPointer--;
    }

    return true;
  }
}
