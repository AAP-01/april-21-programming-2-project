import java.time.LocalDate;

public abstract class SwornOfficer extends PoliceEmployee{

    protected String badgeSerialNumber;
    protected boolean isArmed;

    public SwornOfficer() {}

    public SwornOfficer(int employeeID, String firstName, String lastName, int age, LocalDate hireDate, String address, String phoneNumber, String department, String badgeNumber, String rank, String badgeSerialNumber, boolean isArmed) {
        super(employeeID, firstName, lastName, age, hireDate, address, phoneNumber, department, badgeNumber, rank);
        this.badgeSerialNumber = badgeSerialNumber;
        this.isArmed = isArmed;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Badge Serial : " + badgeSerialNumber);
        System.out.println("Armed : " + isArmed);
    }

    @Override
    public int calculateMonthlySalary() {
        return 5000;
    }

    @Override
    public int calculateWeeklyWorkHours() {
        return 42;
    }

    public String getBadgeSerialNumber(){
        return badgeSerialNumber;
    }

    public void setBadgeSerialNumber(String badgeSerialNumber){
        this.badgeSerialNumber = badgeSerialNumber;
    }

    public boolean isArmed(){
        return isArmed;
    }

    public void setArmed(boolean armed){
        this.isArmed = armed;
    }

    @Override
    public String toString() {
        return "SwornOfficer{" + super.toString() +
                ", badgeSerialNumber=" + badgeSerialNumber +
                ", isArmed=" + isArmed + "}";
    }
}
