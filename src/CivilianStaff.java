import java.time.LocalDate;

public abstract class CivilianStaff extends PoliceStaff {

    protected String jobTitle;
    protected String officeLocation;

    public CivilianStaff() {}

    public CivilianStaff(int employeeID, String firstName, String lastName, int age, LocalDate hireDate, String address, String phoneNumber, String department, String badgeNumber, String rank, String jobTitle, String officeLocation) {
        super(employeeID, firstName, lastName, age, hireDate, address, phoneNumber, department, badgeNumber, rank);
        this.jobTitle = jobTitle;
        this.officeLocation = officeLocation;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Job Title : " + jobTitle);
        System.out.println("Office : " + officeLocation);
    }

    @Override
    public int calculateMonthlySalary() {
        return 3500;
    }

    @Override
    public int calculateWeeklyWorkHours() {
        return 37;
    }

    public String getJobTitle(){
        return jobTitle;
    }
    public void setJobTitle(String jobTitle){
        this.jobTitle = jobTitle;
    }

    public String getOfficeLocation() {return officeLocation;}
    public void setOfficeLocation(String officeLocation) {this.officeLocation = officeLocation;}


    @Override
    public String toString() {
        return "CivilianStaff{" + super.toString() +
                ", jobTitle=" + jobTitle +
                ", officeLocation=" + officeLocation + "}";
    }
}
