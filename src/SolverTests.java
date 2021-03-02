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
}
