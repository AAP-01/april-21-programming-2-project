import java.time.LocalDate;

// Step 4
public class Detective extends SwornOfficer
{
    // Step 6
    private String caseAssigned;

    public Detective()
    {

    }

    public Detective(int employeeID,
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
                         boolean isArmed,
                         String caseAssigned)
    {
        super(employeeID, firstName, lastName, age, hireDate, address, phoneNumber, department, badgeNumber, rank, badgeSerialNumber, isArmed);
        this.caseAssigned = caseAssigned;
    }

    @Override
    public String toString()
    {
        return "Detective{" + super.toString() + "caseAssigned=" + caseAssigned + "}";
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
