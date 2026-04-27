import java.util.ArrayList;
import java.util.Scanner;

public class PoliceSystem {

    private static ArrayList<PoliceStaff> employees = new ArrayList<>();

    public static void main(String[] args) {

        // Isn't this step 10 :sob:
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nPOLICE SYSTEM");
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee");
            System.out.println("3. Display All Employees");
            System.out.println("4. Save Data");
            System.out.println("5. Load Data");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    addEmployee(scanner);
                    break;

                case 2:
                    searchEmployee(scanner);
                    break;

                case 3:
                    displayAll();
                    break;

                case 4:
                    saveData();
                    break;

                case 5:
                    loadData();
                    break;

                case 0:
                    System.out.println("Exiting");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        scanner.close();
    }

    private static void addEmployee(Scanner scanner) {

        //Should add some form of protection whenever the user inputs the wrong data type
        System.out.print("Enter Employee ID: ");
        int employeeID = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Address: ");
        String address = scanner.nextLine();

        System.out.print("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Enter Department: ");
        String department = scanner.nextLine();

        System.out.print("Enter Badge Number: ");
        String badgeNumber = scanner.nextLine();

        System.out.print("Enter Rank: ");
        String rank = scanner.nextLine();

        System.out.print("Enter Badge Serial Number: ");
        String badgeSerialNumber = scanner.nextLine();

        System.out.print("Is Armed (true/false): ");
        boolean isArmed = scanner.nextBoolean();
        scanner.nextLine();

        System.out.print("Enter Callsign: ");
        String callsign = scanner.nextLine();

        System.out.print("Enter Unit Callsign: ");
        String unitCallsign = scanner.nextLine();

        PatrolOfficer p = new PatrolOfficer(
                employeeID,
                firstName,
                lastName,
                age,
                java.time.LocalDate.now(),
                address,
                phoneNumber,
                department,
                badgeNumber,
                rank,
                badgeSerialNumber,
                isArmed,
                callsign,
                unitCallsign
        );

        employees.add(p);

        System.out.println("Employee added successfully.");
    }

    private static void searchEmployee(Scanner scanner) {

        System.out.print("Enter ID to search: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (PoliceStaff p : employees) {
            if (p.getEmployeeID() == id) {
                System.out.println("Found:\n" + p);
                return;
            }
        }

        System.out.println("Employee not found.");
    }

    private static void displayAll() {

        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        System.out.println("\nALL EMPLOYEES");

        for (PoliceStaff p : employees) {
            System.out.println(p);
        }
    }

    private static void saveData() {
    }

    private static void loadData() {
    }
}

//STEP 13. REASONING ON NOT USING GUI YET... DID NOT LEARN HOW TO MAKE GUI EVER, USING SCANNER FOR TESTING. WILL IMPLEMENT GUI LATER. GIULIANO DI FULVIO