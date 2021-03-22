public class SolverTests {
  public static void testIsUnique() {
    System.out.println(Solvers.isUnique("hi") == true);
    System.out.println(Solvers.isUnique("Hello") == false);
    System.out.println(Solvers.isUnique("This is not unique") == false);
  }

  public static void testCheckPermutation() {
    System.out.println(Solvers.checkPermutation("This is", "si sihT") == true);
    System.out.println(Solvers.checkPermutation("This", "shiT") == true);
    System.out.println(Solvers.checkPermutation("NONO", "hi") == false);
  }

  public static void testURLify() {
    System.out.println(Solvers.urlify("This is not URLified").equals("This%20is%20not%20URLified"));
    System.out.println(Solvers.urlify("Nothing").equals("Nothing"));
    System.out.println(Solvers.urlify("") == "");
  }

  public static void testPalindromePermutation() {
    System.out.println("----------- Palindrome Permutation -----------");

    System.out.println(Solvers.palindromePermutation("Tact Coa") == true);
    System.out.println(Solvers.palindromePermutation("Reacearc") == true);
    System.out.println(Solvers.palindromePermutation("Erif Tuckr") == false);
    System.out.println(Solvers.palindromePermutation("Omm") == true);
    System.out.println(Solvers.palindromePermutation("No") == false);
  }

  public static void testOneAway() {
    System.out.println("----------- One Away -----------");
    System.out.println(Solvers.oneAway("Hi", "Hi") == true);
    System.out.println(Solvers.oneAway("Hello", "ello") == true);
    System.out.println(Solvers.oneAway("Hello", "Hi") == false);
    System.out.println(Solvers.oneAway("Excuse", "E") == false);
  }

  public static void testStringCompression() {
    System.out.println("----------- String Compression -----------");
    System.out.println(Solvers.stringCompression("abc") == "abc");
    System.out.println(Solvers.stringCompression("aaaaabbccccc").equals("a5b2c5"));
    System.out.println(Solvers.stringCompression("aaa").equals("a3"));
    System.out.println(Solvers.stringCompression("ew") == "ew");
  }
}
