package strings;

import java.util.HashMap;
import java.util.Map;

public class TinyURL {
  Map<String, String> shortToLongMap;
  private Integer encodedValue;

  public TinyURL() {
    this.shortToLongMap = new HashMap<>();
    this.encodedValue = 0;
  }

  public String encode(String longURL) {
    String encodedString = "http://www.tinyurl.com/" + ++encodedValue;
    this.shortToLongMap.put(encodedString, longURL);
    return encodedString;
  }

  public String decode(String shortURL) {
    if (shortToLongMap.containsKey(shortURL)) {
      return shortToLongMap.get(shortURL);
    }
    return "";
  }
}
