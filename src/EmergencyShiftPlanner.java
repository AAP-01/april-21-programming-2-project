import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EmergencyShiftPlanner {

    private ArrayList<PoliceStaff> staffList;

    private static final double MAX_OVERTIME_HOURS = 20.0;

    public EmergencyShiftPlanner(ArrayList<PoliceStaff> staffList) {
        this.staffList = staffList;
    }

    public void reassignStaff(String fromDepartment, String toDepartment, int numberNeeded) {
        int reassigned = 0;

        for (PoliceStaff staff : staffList) {
            if (reassigned >= numberNeeded) {
                break;
            }

            if (staff.getDepartment().equalsIgnoreCase(fromDepartment) && getOvertimeHours(staff) < MAX_OVERTIME_HOURS){

                staff.setDepartment(toDepartment);
                reassigned++;

                System.out.println(staff.getFirstName() + " " + staff.getLastName() + " reassigned from " + fromDepartment + " to " + toDepartment);
            }
        }

        if (reassigned < numberNeeded) {
            System.out.println("Only " + reassigned + " staff were available for reassignment.");
        }
    }

    public ArrayList<PoliceStaff> getOverworkedStaff() {
        ArrayList<PoliceStaff> overworked = new ArrayList<>();

        for (PoliceStaff staff : staffList) {
            if (getOvertimeHours(staff) > MAX_OVERTIME_HOURS) {
                overworked.add(staff);
            }
        }

        return overworked;
    }

    public HashMap<String, Integer> detectStaffShortages(int minimumRequired) {
        HashMap<String, Integer> departmentCounts = new HashMap<>();
        HashMap<String, Integer> shortages = new HashMap<>();

        for (PoliceStaff staff : staffList) {
            String department = staff.getDepartment();

            if (!departmentCounts.containsKey(department)) {
                departmentCounts.put(department, 1);
            } else {
                departmentCounts.put(department, departmentCounts.get(department) + 1);
            }
        }

        for (String department : departmentCounts.keySet()) {
            int count = departmentCounts.get(department);

            if (count < minimumRequired) {
                shortages.put(department, count);
            }
        }

        return shortages;
    }

    private double getOvertimeHours(PoliceStaff staff) {
        double weeklyHours = staff.calculateWeeklyWorkHours(staff.getDailyHours(),staff.getWorkDays());

        if (weeklyHours > 40) {
            return weeklyHours - 40;
        }

        return 0;
    }

    public void printOverworkedStaff() {
        ArrayList<PoliceStaff> overworked = getOverworkedStaff();

        if (overworked.isEmpty()) {
            System.out.println("No overworked staff found.");
            return;
        }

        System.out.println("Overworked Staff");

        for (PoliceStaff staff : overworked) {
            System.out.println(staff.getFirstName() + " " + staff.getLastName() + " | Department: " + staff.getDepartment() + " | Overtime Hours: " + getOvertimeHours(staff));
        }
    }

    public void printStaffShortages(int minimumRequired) {
        Map<String, Integer> shortages = detectStaffShortages(minimumRequired);

        if (shortages.isEmpty()) {
            System.out.println("No staffing shortages detected.");
            return;
        }

        System.out.println("Staffing shortages");

        for (String department : shortages.keySet()) {
            System.out.println( department + " has only " +  shortages.get(department) + " staff members.");
        }
    }
}