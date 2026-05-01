import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShiftManager {
    public static final String DAY_SHIFT = "Day";
    public static final String NIGHT_SHIFT = "Night";
    public static final String ROTATION_SHIFT = "Rotation";

    private List<ShiftRecord> shiftSchedule;
    private Map<PoliceStaff, List<String>> shiftPreferences;

    public ShiftManager() {
        this.shiftSchedule = new ArrayList<>();
        this.shiftPreferences = new HashMap<>();
    }

    public void addShiftPreference(PoliceStaff employee, String preference) {
        shiftPreferences.putIfAbsent(employee, new ArrayList<>());

        if (!shiftPreferences.get(employee).contains(preference)){
            shiftPreferences.get(employee).add(preference);
        }
    }

    public List<String> getPreferences(PoliceStaff employee) {
        return shiftPreferences.getOrDefault(employee, new ArrayList<>());
    }

    public void assignShift(PoliceStaff employee, LocalDate date, String shiftType) throws ShiftConflictException {
        for (ShiftRecord record : shiftSchedule) {
            if (record.getEmployee().equals(employee) && record.getShiftDate().equals(date)) {
                throw new ShiftConflictException("ERROR: Employee ID " + employee.getEmployeeID() + " is already scheduled for a shift on " + date);
            }
        }

        ShiftRecord newRecord = new ShiftRecord(employee, date, shiftType);
        shiftSchedule.add(newRecord);
        System.out.println("Shift assigned successfully: " + newRecord);
    }

    public double calculateShiftBonus(PoliceStaff employee, LocalDate startDate, LocalDate endDate) {
        double bonus = 0.0;

        for (ShiftRecord record : shiftSchedule) {
            if (record.getEmployee().equals(employee) && !record.getShiftDate().isBefore(startDate) && !record.getShiftDate().isAfter(endDate)) {
                if (record.getShiftType().equals(NIGHT_SHIFT)) {
                    bonus += 30.00;
                } else if (record.getShiftType().equals(ROTATION_SHIFT)) {
                    bonus += 12.50;
                }
            }
        }
        return bonus;
    }

    public int calculateRiskLevel(PoliceStaff employee, LocalDate startDate, LocalDate endDate) {
        int riskLevel = 1;

        for (ShiftRecord record : shiftSchedule) {
            if (record.getEmployee().equals(employee) && !record.getShiftDate().isBefore(startDate) && !record.getShiftDate().isAfter(endDate)) {
                if (record.getShiftType().equals(NIGHT_SHIFT)) {
                    riskLevel += 5;
                } else if (record.getShiftType().equals(ROTATION_SHIFT)) {
                    riskLevel += 3;
                }
            }
        }
        return riskLevel;
    }

    public void displaySchedule() {
        System.out.println("Current Shift Schedule");
        for (ShiftRecord record : shiftSchedule) {
            System.out.println(record);
        }
    }
}