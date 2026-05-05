import java.time.LocalDate;
import java.util.Objects;

// Step 4
public class PatrolOfficer extends SwornOfficer {
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
                         boolean armed,
                         String callsign,
                         String unitCallsign)
    {
        super(employeeID, firstName, lastName, age, hireDate, address, phoneNumber, department, badgeNumber, rank, badgeSerialNumber, armed);
        this.callsign = callsign;
        this.unitCallsign = unitCallsign;
    }

    @Override
    public String displayRoleDescription()
    {
        return "Patrol officers maintain public order, safety, and enforces laws within an assigned area.";
    }

    @Override
    public double hourlyRate(String rank)
    {
        return switch (rank.toLowerCase()) {
            // According to RCMP salaries
            case "constable" -> 45.00;
            case "corporal" -> 59.00;
            case "sergeant" -> 64.00;
            case "staff sergeant" -> 70.00;
            case "sergeant major" -> 72.00;
            default -> {
                System.out.println("Rank invalid");
                yield -1.00;
            }
        };
    }

    // Getters
    public String getCallsign() {return callsign;}
    public String getUnitCallsign() {return unitCallsign;}

    @Override
    public String getJobType() {return "Field";}

    // Setters
    public void setCallsign(String callsign) {this.callsign = callsign;}
    public void setUnitCallsign(String unitCallsign) {this.unitCallsign = unitCallsign;}

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

        result = 31 * result + getEmployeeID();
        result = Integer.parseInt(31 * result + getBadgeNumber());

        return result;
    }
    // End of step 6
}
