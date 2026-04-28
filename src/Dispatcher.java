import java.time.LocalDate;

// Step 4
public class Dispatcher extends CivilianStaff
{
    // Step 6
    public Dispatcher()
    {

    }

    public Dispatcher(int employeeID,
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
        return "Dispatchers respond to emergency calls and signal to emergency services what to know and prepare.";
    }

    @Override
    public double hourlyRate(String rank)
    {
        return switch (rank.toLowerCase()) {
            // According to RCMP salaries
            case "trainee" -> 35.00;
            case "call-taker" -> 38.00;
            case "shift supervisor" -> 41.00;
            case "team leader" -> 45.00;
            case "senior manager" -> 55.00;
            default -> {
                System.out.println("Rank invalid");
                yield -1.00;
            }
        };
    }


    @Override
    public String toString()
    {
        return "Dispatcher{" + super.toString() + "}";
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
