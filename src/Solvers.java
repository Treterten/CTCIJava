import java.util.HashSet;
import java.util.HashMap;

public class Solvers {

  public static boolean isUnique(String s) {
    HashSet<Character> characters = new HashSet<Character>();
    for (int i = 0; i < s.length(); i += 1) {
        if (characters.contains(s.charAt(i))) {
            return false;
        }
        characters.add(s.charAt(i));
    }
    return true;
  }

  public static boolean checkPermutation(String s1, String s2) {
    HashMap<Character, Integer> s1c = new HashMap<Character, Integer>();
    HashMap<Character, Integer> s2c = new HashMap<Character, Integer>();

    if (s1.length() != s2.length()) {
      return false;
    }

    for (int i = 0; i < s1.length(); i += 1) {
      Character currentS1Char = s1.charAt(i);
      Character currentS2Char = s2.charAt(i);
      if (s1c.containsKey(currentS1Char)) {
        int currentCharacterCount = s1c.get(currentS1Char);
        currentCharacterCount += 1;
        s1c.put(currentS1Char, currentCharacterCount);
      } else {
        s1c.put(currentS1Char, 1);
      }
      if (s2c.containsKey(currentS2Char)) {
        int currentCharacterCount = s2c.get(currentS2Char);
        currentCharacterCount += 1;
        s2c.put(currentS2Char, currentCharacterCount);
      } else {
        s2c.put(currentS2Char, 1);
      }
    }

    for (Character k : s1c.keySet()) {
      if (!s1c.get(k).equals(s2c.get(k))) {
        return false;
      }
    }

    return true;
  }

  public static String urlify(String s) {
    String solution = "";
    for(int i = 0; i < s.length(); i+=1) {
      if ( s.charAt(i) != ' ') {
        solution += s.charAt(i);
      } else {
        solution += "%20";
      }
    }
    return solution;
  }

}