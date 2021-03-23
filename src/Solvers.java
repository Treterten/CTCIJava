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

  public static Boolean oneAway(String s1, String s2) {
    // Initialize grid size (based on which string is larger)
    int gridSize = Math.max(s1.length(), s2.length());
    // Initialize grid
    Integer[][] grid = new Integer[gridSize][gridSize];
    // If s1 is greater
    if (s1.length() > s2.length()) {
      // while s2 is shorter than s1
      while (s2.length() < s1.length()) {
        // add a space in front of s2
        s2 = ' ' + s2;
      }
    // else if s2 is greater
    } else if (s2.length() > s1.length()) {
      // while s1 is shorter than s2
      while (s1.length() < s2.length()) {
        // add a space in front of s2
        s1 = ' ' + s1;
      }
    }
    // for every row in the grid
    // System.out.println("New Grid: ");
    for (int i = 0; i < grid.length; i += 1) {
      // for every space in the grid
      for (int j = 0; j < grid[0].length; j += 1) {
        // IF i -1 and j-1 are greater than or equal to 0
        if (i - 1 > 0 & j - 1 > 0) {
          // Set the number at the current square equal the number at j-1 and i-1
          grid[i][j] = grid[i - 1][j - 1];
          // else
        } else {
            grid[i][j] = 0;
        }
      // If the string at i for s1 is the same as the string at j for s2
        if (s1.charAt(i) != s2.charAt(j)) {
          // Increment the number at the current square
          grid[i][j] += 1;
        }
        // System.out.print(grid[i][j].toString() + ' ');
      }
      // System.out.println();
    }
    // If the number at the bottom right of the grid is greater than or equal to 1
    if (grid[gridSize - 1][gridSize - 1] <= 1) {
      // return true
      // System.out.println(grid[grid.length - 1][grid.length - 1]);
      return true;
    }

    return false;
  }

  public static String stringCompression(String s) {
    // Initialize the letter counter
    Integer letterCounter = 0;
    // Initialize the result string
    String result = "";
    // Initialize the current character
    Character currentCharacter = ' ';
    // For every character in the string
    for (int i = 0; i < s.length(); i += 1) {
      // If the character is the same as the character before and the character is not the first one
      if (i > 0) {
        if (s.charAt(i) != s.charAt(i - 1)) {
          result += currentCharacter + letterCounter.toString();
          letterCounter = 1;
          currentCharacter = s.charAt(i);
        } else {
          letterCounter++;
        }
      } else {
        currentCharacter = s.charAt(i);
        letterCounter = 1;
      }
    }
    result += currentCharacter + letterCounter.toString();
    if (s.length() < result.length()) {
      // return the result string
      System.out.println(s);
      return s;
    }
    return result;
  }

  public static char[][] rotateMatrix(char[][] matrix) {
    char[][] result = new char[matrix.length][matrix.length];
    // For each row in the matrix
    for (int i = 0; i < matrix.length; i += 1) {
      // Set the target row to the matrix length - 1
      int targetRow = matrix.length - 1;
      // For each column in the matrix
      for (int j = 0; j < matrix.length; j += 1) {
        // Set the element at [target row][row] to be the current element
        result[targetRow][i] = matrix[i][j];
        // Decrement the target row
        targetRow -= 1;
      }
    }
    return result;
  }

  public static int[][] zeroMatrix(int[][] matrix) {
    // Initialize row hash map
    HashMap<Integer, Boolean> rows = new HashMap<Integer, Boolean>();
    // Initialize column hash map
    HashMap<Integer, Boolean> columns = new HashMap<Integer, Boolean>();
    // Iterate through the matrix (i = row index, j = column index)
    for (int i = 0; i < matrix.length; i += 1) {
      for (int j = 0; j < matrix[i].length; j += 1) {
        // If the element is 0
        if (matrix[i][j] == 0) {
          // In the row hash map, set i to true
          rows.put(i, true);
          // In the column hash map, set j to true
          columns.put(j, true);
        }
      }

    }
    // Iterate through the Rows
    for (int i = 0; i < matrix.length; i += 1) {
      // If the row is in the hash map
      if (rows.containsKey(i)) {
        // iterate through the elements in the row
        for (int j = 0; j < matrix[i].length; j += 1) {
          // Set each element to 0
          matrix[i][j] = 0;
        }
      }
    }
    // Iterate through the columns
    for (int j = 0; j < matrix[0].length; j += 1) {
      // If the column is in the hash map
      if (columns.containsKey(j)) {
        // iterate through the elements in the column
        for (int i = 0; i < matrix.length; i += 1) {
          // Set each element to 0
          matrix[i][j] = 0;
        }
      }
    }
    return matrix;
  }
}