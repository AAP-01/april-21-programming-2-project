import java.time.LocalDate;

// Step 4
public class Clerk extends CivilianStaff
{
    // Step 6
    public Clerk()
    {

    }

    public Clerk(int employeeID,
                      String firstName,
                      String lastName,
                      int age,
                      LocalDate hireDate,
                      String address,
                      String phoneNumber,
                      String department,
                      String badgeNumber,
                      String rank,
                      String badgeSerialNumber,
                      String jobTitle,
                      String officeLocation)
    {
        super(employeeID, firstName, lastName, age, hireDate, address, phoneNumber, department, badgeNumber, rank, jobTitle, officeLocation);
    }

    @Override
    public String displayRoleDescription()
    {
        return "Clerks, namely records clerks, store and organize records of all actions and expenses of the police department.";
    }

    @Override
    public double hourlyRate(String rank)
    {
        return switch (rank.toLowerCase()) {
            // Canada average
            case "clerk i" -> 16.00;
            case "clerk ii" -> 23.00;
            case "specialist" -> 30.00;
            case "supervisor" -> 32.00;
            case "manager" -> 33.00;
            default -> {
                System.out.println("Rank invalid");
                yield -1.00;
            }
        };
    }

    @Override
    public String toString()
    {
        return "Clerk{" + super.toString() + "}";
    }

    @Override
    public boolean equals(Object o)
    {
        return super.equals(o);
    }

    @Override
    public int hashCode()
    {
        int result = 17;

        result = 31 * result + employeeID;
        result = Integer.parseInt(31 * result + badgeNumber);

        return result;
    }
    // End of step 6
}
