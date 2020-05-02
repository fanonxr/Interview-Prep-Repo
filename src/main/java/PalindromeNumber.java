public class PalindromeNumber {
  public static void main(String[] args) {
    System.out.println(isPalidrome(121));
  }

  public static boolean isPalidrome(int x) {
    // check to see if the number is negative
    if (x < 0) {
      return false;
    }

    // convert the integer to a string
    String numConverted = x + "";
    // split that string
    String[] separatedNums = numConverted.split("");

    // create two pointers starting at the beginning and end of the array
    int lp = 0;
    int rp = separatedNums.length;

    while (lp < rp) {
      // check to see if the left and right values are the same
      if (Integer.parseInt(separatedNums[lp]) !=  Integer.parseInt(separatedNums[rp - 1])) {
        return false;
      }

      // increment the left pointer
      lp++;

      // decrement the right pointer
      rp--;
    }

    return true;
  }

  public static boolean isPalindromeString(String s) {
    int i = 0, j = s.length() - 1;
    while (i < j) {
      while (i < j && isAlphaNumeric(s.charAt(i))) {
        i++;
      }
      while (i < j && isAlphaNumeric(s.charAt(j))) {
        j--;
      }
      // compare to see if they equal or not
      if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
        return false;
      }
      i++;
      j--;
    }

    return true;
  }

  private static boolean isAlphaNumeric(char c) {
    return !Character.isLetter(c) && !Character.isDigit(c);
  }
}
