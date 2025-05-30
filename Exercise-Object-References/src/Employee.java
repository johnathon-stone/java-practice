//  Part 4. Using Static Members
//   4.1.1 Create a class with 'String name and static int totalEmployees(initialize to 0).
public class Employee {
    String name;
    static int totalEmployees = 0;

//   4.1.2 Create a constructor that increments 'totalEmployees' each time a new 'Employee' is created.
    public Employee(String name) {
        this.name = name;
        totalEmployees++;
    }

//   *! Not instructed per the documentation to do this step but it is required for the program to function properly. !*
    public static int getTotalEmployees() {
        return totalEmployees;
    }
}
