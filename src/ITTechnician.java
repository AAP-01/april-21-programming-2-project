import java.time.LocalDate;

// Step 4
public class ITTechnician extends CivilianStaff
{
    // Step 6
    public ITTechnician()
    {

    }

    public ITTechnician(int employeeID,
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
        return "IT technicians build and maintain the police department's electronic and digital systems.";
    }

    @Override
    public double hourlyRate(String rank)
    {
        return switch (rank.toLowerCase()) {
            // Canada average
            case "technician i" -> 33.00;
            case "technician ii" -> 40.00;
            case "senior technician" -> 47.00;
            case "lead technician" -> 50.00;
            case "systems supervisor" -> 60.00;
            default -> {
                System.out.println("Rank invalid");
                yield -1.00;
            }
        };
    }

    @Override
    public String toString()
    {
        return "ITTechnician{" + super.toString() + "}";
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

        result = 31 * result + getEmployeeID();
        result = Integer.parseInt(31 * result + getBadgeNumber());

        return result;
    }
    // End of step 6
}