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

  public static Boolean palindromePermutation(String s) {
    // Initialize charDictionary
    HashMap <Character, Integer> charDictionary = new HashMap <Character, Integer>();
    // Initalize string (replace all the spaces and apostrophes and make it all lowercase)
    String cleanString = s.replaceAll(" ", "").replaceAll("'","").toLowerCase();
    // Initialize targetCount
    int targetCount = 0;
    // For each character in the string
    for (int i = 0; i < cleanString.length(); i += 1) {
      // If the character is not in the charDictionary
      if (!charDictionary.containsKey(cleanString.charAt(i))) {
        // Add it
        charDictionary.put(cleanString.charAt(i), 1);
        // Else
      } else {
        // Increment it
        int charCount = charDictionary.get(cleanString.charAt(i));
        charCount += 1;
        charDictionary.put(cleanString.charAt(i), charCount);
      }
    }
    // If the string is an even length
    if (cleanString.length() % 2 == 0) {
      // Iterate through the charDictionary
      for (Character c : charDictionary.keySet()) {
        // If the targetCount is 0 and the entry value is greater than 1
        if (targetCount == 0 & charDictionary.get(c) > 1) {
          // Set the target count to the first entry's value
          targetCount = charDictionary.get(c);
          // Else
        } else {
            // If the entry value does not equal the target count
            if (charDictionary.get(c) != targetCount) {
              // return false
              return false;
            }
        }
      }
      // If the string is an odd length
    } else {
      // Initialize foundSingleChar as false
      Character singleChar = null;
      // Iterate through the charDictionary
      for(Character c : charDictionary.keySet()) {
        // If the targetCount is 0
        if (targetCount == 0) {
          // If the entry value is greater than 1
          if (charDictionary.get(c) > 1) {
            // Set the target count to the entry's value
            targetCount = charDictionary.get(c);
            // Else if foundSingleChar is false and entryValue is 1
          } else if (charDictionary.get(c) == 1) {
            // Set foundSingleChar to true
            singleChar = c;
          } else {
            return false;
          }
          // Else
        } else {
          // If targetCount does not equal the entry value
          if (targetCount != charDictionary.get(c)) {
            // System.out.println(charDictionary.get(c));
            // System.out.println(c);
            // System.out.println(targetCount);
            if (singleChar == null && charDictionary.get(c) == 1) {
              singleChar = c;
            } else if (!singleChar.equals(c)) {
              return false;
            }
          }
        }
      }
    }
    return true;
  }



}