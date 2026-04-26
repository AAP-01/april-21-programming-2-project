import java.time.LocalDate;
import java.util.Objects;

// Step 4
public class PatrolOfficer extends SwornOfficer
{
    // Step 6
    private String callsign;
    private String unitCallsign;

    public PatrolOfficer()
    {

    }

    public PatrolOfficer(int employeeID,
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
                         String callsign,
                         String unitCallsign)
    {
        super(employeeID, firstName, lastName, age, hireDate, address, phoneNumber, department, badgeNumber, rank, badgeSerialNumber, isArmed);
        this.callsign = callsign;
        this.unitCallsign = unitCallsign;
    }

    @Override
    public String toString()
    {
        return "PatrolOfficer{" + super.toString() + "callsign=" + callsign + ", unitCallsign=" + unitCallsign + "}";
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
