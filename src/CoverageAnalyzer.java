import java.util.ArrayList;
import java.util.HashMap;

public class CoverageAnalyzer {

    private ArrayList<PoliceStaff> staffList;

    public CoverageAnalyzer(ArrayList<PoliceStaff> staffList) {
        this.staffList = staffList;
    }

    public HashMap<String, Integer> analyzeCoverage() {
        HashMap<String, Integer> coverage = new HashMap<>();

        for (PoliceStaff staff : staffList) {
            String department = staff.getDepartment();

            if (!coverage.containsKey(department)) {
                coverage.put(department, 1);
            } else {
                coverage.put(department, coverage.get(department) + 1);
            }
        }

        return coverage;
    }

    public void printCoverageReport() {
        HashMap<String, Integer> coverage = analyzeCoverage();

        if (coverage.isEmpty()) {
            System.out.println("No staff available.");
            return;
        }

        System.out.println("Patrol Coverage Report");

        for (String department : coverage.keySet()) {
            System.out.println(department + ": " + coverage.get(department) + " officers assigned");
        }
    }
}