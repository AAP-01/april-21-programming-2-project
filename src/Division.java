import java.util.ArrayList;

public class Division {

    private String name;
    private PoliceStaff supervisor;
    private ArrayList<PoliceStaff> employees;

    public Division(String name){
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public String getName(){
        return name;
    }

    public void addEmployee(PoliceStaff e){
        employees.add(e);
    }

    public void setSupervisor(PoliceStaff e) throws InvalidSupervisorAssignmentException {
        if(!employees.contains(e)){
                throw new InvalidSupervisorAssignmentException("Supervisor must be assigned first.");
        }
        this.supervisor = e;
    }

    public PoliceStaff getSupervisor(){
        return supervisor;
    }

    public ArrayList<PoliceStaff> getEmployees(){
        return employees;
    }

    public void displayEmployees(){
        System.out.println("Division: " + name);

        if(supervisor != null){
            System.out.println("Supervisor: " + supervisor);
        }

        for(PoliceStaff e : employees){
            System.out.println(e);
        }
    }
}

//Step 9