// Step 1
import java.time.LocalDate;

public abstract class Person {

    protected int employeeID;
    protected String firstName;
    protected String lastName;
    protected int age;
    protected LocalDate hireDate;
    protected String address;
    protected String phoneNumber;

    public Person(){

    }

    public Person(int employeeID, String firstName, String lastName, int age, LocalDate hireDate, String address, String phoneNumber){
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.hireDate = hireDate;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public abstract void displayInfo();

    // Step 2
    abstract public int calculateMonthlySalary();

    abstract public int calculateWeeklyWorkHours();
    // End of step 2

    // Getters and setters
    public int getEmployeeID(){
        return employeeID;
    }
    public void setEmployeeID(int employeeID){
        this.employeeID = employeeID;
    }

    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }

    public LocalDate getHireDate(){
        return hireDate;
    }
    public void setHireDate(LocalDate hireDate){
        this.hireDate = hireDate;
    }

    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address = address;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    // This is supposed to be part of step 6 (John)
    @Override
    public String toString(){
        return "Person{" + "employeeID = " + employeeID + ", firstName = " + firstName + ", lastName = " + lastName + ", age = " + age + ", hireDate = " + hireDate + ", address = " + address + ", phoneNumber = " + phoneNumber + " }";
    }
    // End of step 1
}
