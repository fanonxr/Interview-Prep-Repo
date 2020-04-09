package groupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
  public static void main(String[] args) {
    String[] test1 = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
    List<List<String>> value1 = groupAnagrams(test1);
    System.out.println("Anagrams: " + value1);
  }

  public static List<List<String>> groupAnagrams(String[] strs) {
    // use a hashmap to store the values
    // will hold a list of chars as the key and a list of string (anagrams) as the value
    HashMap<String, List<String>> map = new HashMap<>();
    // loop over the content of the strings
    for (String s: strs) {
      // split the string into individual characters
      char[] charArray = s.toLowerCase().toCharArray();
      // sort that char array
      Arrays.sort(charArray);
      String key = String.valueOf(charArray);

      // check to see if that char array is stored as a key
      if (!map.containsKey(key)) {
        // add it to the map
        map.put(key, new ArrayList<>());
      }
      map.get(key).add(s);

    }
    return new ArrayList<>(map.values());
  }

}
