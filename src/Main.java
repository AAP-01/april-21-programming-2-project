void main() {

    // Is this useless? PoliceSystem has its own ArrayList and has a function unlike this one
    // Run the program in PoliceSystemGUI to see the GUI
    // Demo of employees

    // Creating employees
    List<PoliceStaff> employees = new ArrayList<>();

    PatrolOfficer patrol1 = new PatrolOfficer(
            101, "James", "Carter", 32,
            LocalDate.of(2015, 3, 12),
            "123 Maple St", "555-1234",
            "Patrol Division", "PD-221", "Constable",
            "BSN-9981", true,
            "Car-12", "Unit-4A"
    );
    patrol1.getTrainingRecordList().add(
            new TrainingRecord(
                    "Defensive Tactics", "Completed", 40,
                    LocalDate.of(2024, 1, 10),
                    LocalDate.of(2024, 1, 20),
                    true,
                    LocalDate.of(2026, 1, 20)
            )
    );

    PatrolOfficer patrol2 = new PatrolOfficer(
            102, "Maria", "Lopez", 29,
            LocalDate.of(2018, 7, 22),
            "456 Oak Ave", "555-5678",
            "Traffic Enforcement", "PD-334", "Sergeant",
            "BSN-8821", true,
            "Bike-07", "Unit-2B"
    );
    patrol2.getTrainingRecordList().add(
            new TrainingRecord(
                    "Traffic Stop Safety", "Completed", 24,
                    LocalDate.of(2024, 3, 1),
                    LocalDate.of(2024, 3, 8),
                    true,
                    LocalDate.of(2026, 3, 8)
            )
    );

    PatrolOfficer patrol3 = new PatrolOfficer(
            103, "Derek", "Hughes", 27,
            LocalDate.of(2021, 5, 10),
            "88 Willow Rd", "555-7781",
            "Patrol Division", "PD-402", "Constable",
            "BSN-9033", true,
            "Car-21", "Unit-3C"
    );
    patrol3.getTrainingRecordList().add(
            new TrainingRecord(
                    "Use of Force Continuum", "Completed", 20,
                    LocalDate.of(2023, 9, 10),
                    LocalDate.of(2023, 9, 15),
                    true,
                    LocalDate.of(2025, 9, 15)
            )
    );

    Detective detective1 = new Detective(
            201, "Ava", "Nguyen", 38,
            LocalDate.of(2012, 9, 14),
            "321 Birch Blvd", "555-3456",
            "Major Crimes", "PD-145", "Detective Sergeant",
            "BSN-6645", true,
            "Case #2026-22"
    );
    detective1.getTrainingRecordList().add(
            new TrainingRecord(
                    "Advanced Interview & Interrogation", "Completed", 30,
                    LocalDate.of(2024, 2, 5),
                    LocalDate.of(2024, 2, 15),
                    true,
                    LocalDate.of(2027, 2, 15)
            )
    );

    Detective detective2 = new Detective(
            202, "Ethan", "Reeves", 41,
            LocalDate.of(2010, 1, 5),
            "789 Pine Rd", "555-9012",
            "Investigations", "PD-112", "Detective",
            "BSN-7712", true,
            "Case #2026-14"
    );
    detective2.getTrainingRecordList().add(
            new TrainingRecord(
                    "Crime Scene Processing", "Completed", 36,
                    LocalDate.of(2023, 6, 1),
                    LocalDate.of(2023, 6, 12),
                    true,
                    LocalDate.of(2026, 6, 12)
            )
    );

    Detective detective3 = new Detective(
            203, "Lily", "Sanders", 35,
            LocalDate.of(2016, 4, 18),
            "55 Cedar Ln", "555-6677",
            "Cyber Crimes", "PD-199", "Detective",
            "BSN-5521", true,
            "Case #2026-33"
    );
    detective3.getTrainingRecordList().add(
            new TrainingRecord(
                    "Cybercrime Investigation", "Completed", 40,
                    LocalDate.of(2024, 8, 1),
                    LocalDate.of(2024, 8, 20),
                    true,
                    LocalDate.of(2027, 8, 20)
            )
    );

    Dispatcher dispatcher1 = new Dispatcher(
            301, "Liam", "Turner", 27,
            LocalDate.of(2020, 6, 10),
            "12 River St", "555-7788",
            "Communications", "CIV-201", "Call-taker",
            "N/A", "Emergency Dispatcher", "Comm Center A"
    );
    dispatcher1.getTrainingRecordList().add(
            new TrainingRecord(
                    "Emergency Communications Protocols", "Completed", 25,
                    LocalDate.of(2024, 1, 5),
                    LocalDate.of(2024, 1, 12),
                    true,
                    LocalDate.of(2026, 1, 12)
            )
    );

    Dispatcher dispatcher2 = new Dispatcher(
            302, "Sophie", "Martin", 34,
            LocalDate.of(2016, 11, 3),
            "98 Hillcrest Dr", "555-8899",
            "Communications", "CIV-305", "Call-taker",
            "N/A", "Radio Operator", "Comm Center B"
    );
    dispatcher2.getTrainingRecordList().add(
            new TrainingRecord(
                    "Emergency Medical Dispatch (EMD)", "Completed", 30,
                    LocalDate.of(2023, 6, 20),
                    LocalDate.of(2023, 6, 30),
                    true,
                    LocalDate.of(2025, 6, 30)
            )
    );

    Clerk clerk1 = new Clerk(
            401, "Benjamin", "Clark", 45,
            LocalDate.of(2008, 8, 29),
            "44 Elm St", "555-9900",
            "Records", "CIV-150", "Specialist",
            "N/A", "Records Clerk", "Admin Building"
    );
    clerk1.getTrainingRecordList().add(
            new TrainingRecord(
                    "Records Management Systems", "Completed", 16,
                    LocalDate.of(2024, 2, 1),
                    LocalDate.of(2024, 2, 5),
                    true,
                    LocalDate.of(2026, 2, 5)
            )
    );

    ITTechnician itTech1 = new ITTechnician(
            501, "Noah", "Bennett", 30,
            LocalDate.of(2019, 4, 18),
            "55 Tech Way", "555-2233",
            "IT Services", "CIV-410", "Technician II",
            "N/A", "Systems Technician", "IT Office"
    );
    itTech1.getTrainingRecordList().add(
            new TrainingRecord(
                    "Police Network Security", "Completed", 40,
                    LocalDate.of(2024, 3, 1),
                    LocalDate.of(2024, 3, 20),
                    true,
                    LocalDate.of(2027, 3, 20)
            )
    );

    employees.add(patrol1);
    employees.add(patrol2);
    employees.add(patrol3);
    employees.add(detective1);
    employees.add(detective2);
    employees.add(detective3);
    employees.add(dispatcher1);
    employees.add(dispatcher2);
    employees.add(clerk1);
    employees.add(itTech1);

    for (PoliceStaff employee : employees)
    {
        System.out.println("Employee ID: " + employee.getEmployeeID());
        System.out.println(employee.getRank() + " " + employee.getFirstName() + " " + employee.getLastName());
        System.out.println("-----");
    }

    // Sorting
    Collections.sort(employees);
    for (PoliceStaff employee : employees)
    {
        System.out.println(employee);
    }

    System.out.println("================Sort by last name=================");
    Collections.sort(employees, new SortByLastName());
    for (PoliceStaff employee : employees)
    {
        System.out.println(employee.getFirstName() + " " + employee.getLastName());
    }

    System.out.println("================Sort by age=================");
    Collections.sort(employees, new SortByAge());
    for (PoliceStaff employee : employees)
    {
        System.out.println(employee.getFirstName() + " " + employee.getLastName() + ", aged " + employee.getAge());
    }
}
