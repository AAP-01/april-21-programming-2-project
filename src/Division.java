import java.util.ArrayList;

public class Division {

    private String divisionName;
    private PoliceStaff supervisor;
    private ArrayList<PoliceStaff> divisionMembers;

    public Division(String divisionName){
        this.divisionName = divisionName;
        this.divisionMembers = new ArrayList<>();
    }

    public void addDivisionMember(PoliceStaff e){
        divisionMembers.add(e);
    }

    // Getters
    public String getName(){
        return divisionName;
    }
    public PoliceStaff getSupervisor(){
        return supervisor;
    }
    public ArrayList<PoliceStaff> getDivisionMembers(){
        return divisionMembers;
    }

    // Setters
    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }
    public void setSupervisor(PoliceStaff e) throws InvalidSupervisorAssignmentException {
        if(!divisionMembers.contains(e)){
                throw new InvalidSupervisorAssignmentException("Supervisor must be assigned first.");
        }
        this.supervisor = e;
    }

    public void displayDivisionMembers(){
        System.out.println("Division: " + divisionName);

        if(supervisor != null){
            System.out.println("Supervisor: " + supervisor.getRank() + supervisor.getFirstName() + " " + supervisor.getLastName());
        }
        else
        {
            System.out.println("Supervisor: none assigned");
        }

        for(PoliceStaff e : divisionMembers){
            System.out.println(e);
        }
    }
}

//Step 9