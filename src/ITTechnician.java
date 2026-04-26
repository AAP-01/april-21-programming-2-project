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

        result = 31 * result + employeeID;
        result = Integer.parseInt(31 * result + badgeNumber);

        return result;
    }
    // End of step 6
}