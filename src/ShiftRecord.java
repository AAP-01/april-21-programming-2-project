import java.time.LocalDate;

public class ShiftRecord {

    private PoliceStaff employee;
    private LocalDate shiftDate;
    private String shiftType;

    public ShiftRecord(PoliceStaff employee, LocalDate shiftDate, String shiftType){
        this.employee = employee;
        this.shiftDate = shiftDate;
        this.shiftType = shiftType;
    }

    public PoliceStaff getEmployee(){
        return employee;
    }

    public LocalDate getShiftDate(){
        return shiftDate;
    }

    public String getShiftType(){
        return shiftType;
    }

    @Override
    public String toString(){
        return "Shift Record : " + "employee ID: " + employee.getEmployeeID() + ", shift date: " + shiftDate + ", shift type: " + shiftType;
    }

}
