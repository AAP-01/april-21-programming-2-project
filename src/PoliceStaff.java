import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class PoliceStaff extends Person implements Payroll, Comparable<PoliceStaff> {

    private String department;
    private String badgeNumber;
    private String rank;
    private double dailyHours;
    private int workDays;
    private List<TrainingRecord> trainingRecordList;

    public PoliceStaff(){

    }

    public PoliceStaff(int employeeID, String firstName, String lastName, int age, LocalDate hireDate, String address, String phoneNumber, String department, String badgeNumber, String rank){
        super(employeeID, firstName, lastName, age, hireDate, address, phoneNumber);
        this.department = department;
        this.badgeNumber = badgeNumber;
        this.rank = rank;

        this.trainingRecordList = new ArrayList<>();
    }

    @Override
    public void displayInfo(){
        System.out.println("Employee ID : " + getEmployeeID());
        System.out.println("First Name: " + getFirstName());
        System.out.println("Last Name : " + getLastName());
        System.out.println("Age : " + getAge());
        System.out.println("Hire Date : " + getHireDate());
        System.out.println("Address : " + getAddress());
        System.out.println("Phone : " + getPhoneNumber());
        System.out.println("Department : " + getDepartment());
        System.out.println("Badge Number : " + getBadgeNumber());
        System.out.println("Rank : " + getRank());
    }

    // Methods from Payroll interface class
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

    // Adds training records to the employee
    public void addRecord(TrainingRecord trainingRecord)
    {
        trainingRecordList.add(trainingRecord);
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

    // For phase 2 module 2
    abstract public String getJobType();

    public List<TrainingRecord> getTrainingRecordList() {return trainingRecordList;}

    @Override
    public String toString() {
        return "PoliceStaff{" +
                "department='" + department +
                ", badgeNumber='" + badgeNumber +
                ", rank='" + rank +
                ", dailyHours=" + dailyHours +
                ", workDays=" + workDays +
                ", trainingRecordList=" + trainingRecordList +
                '}';
    }

    // Comparable
    @Override
    public int compareTo(PoliceStaff other){
        return Integer.compare(this.getEmployeeID(), other.getEmployeeID());
    }
    //step 7


}
