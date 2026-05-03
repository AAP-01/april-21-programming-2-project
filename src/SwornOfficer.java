import java.time.LocalDate;

public abstract class SwornOfficer extends PoliceStaff {

    private String badgeSerialNumber;
    private boolean armed;

    public SwornOfficer() {}

    public SwornOfficer(int employeeID, String firstName, String lastName, int age, LocalDate hireDate, String address, String phoneNumber, String department, String badgeNumber, String rank, String badgeSerialNumber, boolean armed) {
        super(employeeID, firstName, lastName, age, hireDate, address, phoneNumber, department, badgeNumber, rank);
        this.badgeSerialNumber = badgeSerialNumber;
        this.armed = armed;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Badge Serial : " + badgeSerialNumber);
        System.out.println("Armed : " + armed);
    }

    public String getBadgeSerialNumber(){
        return badgeSerialNumber;
    }
    public void setBadgeSerialNumber(String badgeSerialNumber){
        this.badgeSerialNumber = badgeSerialNumber;
    }

    public boolean getIsArmed(){
        return armed;
    }
    public void setArmed(boolean armed){
        this.armed = armed;
    }

    @Override
    public String toString() {
        return "SwornOfficer{" + super.toString() +
                ", badgeSerialNumber=" + badgeSerialNumber +
                ", armed=" + armed + "}";
    }
}
