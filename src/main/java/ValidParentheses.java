import java.util.Stack;

public class ValidParentheses {
  public static void main(String[] args) {
    String fruit = "strawberries".substring(2, 5);
    System.out.println(fruit);
  }

  public static boolean isValid(String s) {
    String opening = "({[";
    String closing = ")}]";

    // stack that will hold the contents
    Stack<Character> buffer = new Stack<>();

    // loop over the passed in string
    for (char c: s.toCharArray()) {
      // check to see if it is an opening value
      if (opening.indexOf(c) != -1) {
        buffer.push(c);
      } else if (closing.indexOf(c) != -1) {
        if (buffer.isEmpty()){
          return false;
        }
        // check to see if the pairs match one another
        if (closing.indexOf(c) != opening.indexOf(buffer.pop())) {
          return false;
        }
      }
    }
    // if its empty then return true else returns false
    return buffer.isEmpty();

  }
}
