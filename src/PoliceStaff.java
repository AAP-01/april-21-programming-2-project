import java.time.LocalDate;

public abstract class PoliceStaff extends Person implements Payroll, Comparable<PoliceStaff> {

    protected String department;
    protected String badgeNumber;
    protected String rank;
    protected double dailyHours;
    protected int workDays;

    public PoliceStaff(){

    }

    public PoliceStaff(int employeeID, String firstName, String lastName, int age, LocalDate hireDate, String address, String phoneNumber, String department, String badgeNumber, String rank){
        super(employeeID, firstName, lastName, age, hireDate, address, phoneNumber);
        this.department = department;
        this.badgeNumber = badgeNumber;
        this.rank = rank;
    }

    @Override
    public void displayInfo(){
        System.out.println("Employee ID : " + employeeID);
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name : " + lastName);
        System.out.println("Age : " + age);
        System.out.println("Hire Date : " + hireDate);
        System.out.println("Address : " + address);
        System.out.println("Phone : " + phoneNumber);
        System.out.println("Department : " + department);
        System.out.println("Badge Number : " + badgeNumber);
        System.out.println("Rank : " + rank);
    }

    @Override
    public double calculateWeeklyWorkHours(double dailyHours, int workDays)
    {
        return workDays * dailyHours;
    }

    @Override
    public double calculateMonthlySalary()
    {
        return calculateWeeklyWorkHours(dailyHours, workDays) * hourlyRate(rank);
    }

    @Override
    public double calculateAnnualSalary(){
        return calculateMonthlySalary() * 12;
    }

    @Override
    public double calculateOvertimePay(double overtimeHours){
        double hourlyRate = calculateMonthlySalary() / 160.0;
        return hourlyRate * 1.5 * overtimeHours;
    }

    // Getters and setters
    public String getDepartment(){
        return department;
    }
    public void setDepartment(String department){
        this.department = department;
    }

    public String getBadgeNumber(){
        return badgeNumber;
    }
    public void setBadgeNumber(String badgeNumber){
        this.badgeNumber = badgeNumber;
    }

    public String getRank(){
        return rank;
    }
    public void setRank(String rank){
        this.rank = rank;
    }

    public double getDailyHours() {return dailyHours;}
    public void setDailyHours(double dailyHours) {this.dailyHours = dailyHours;}

    public int getWorkDays() {return workDays;}
    public void setWorkDays(int workDays) {this.workDays = workDays;}

    @Override
    public String toString() {
        return "PoliceStaff{" + super.toString() +
                ", department=" + department +
                ", badgeNumber=" + badgeNumber +
                ", rank=" + rank +
                ", dailyHours=" + dailyHours +
                ", workDays=" + workDays + "}";
    }

    @Override
    public int compareTo(PoliceStaff other){
        return Integer.compare(this.employeeID, other.employeeID);
    }
    //step 7


}
