import java.util.ArrayList;

public class Division {

    private String divisionName;
    private PoliceStaff supervisor;
    private ArrayList<PoliceStaff> divisionMembers;
    private String courseRequirement;
    private String certificationRequirement;

    public Division(String divisionName, PoliceStaff supervisor, String courseRequirement, String certificationRequirement){
        this.divisionName = divisionName;
        this.supervisor = supervisor;
        this.courseRequirement = courseRequirement;
        this.certificationRequirement = certificationRequirement;
        this.divisionMembers = new ArrayList<>();
    }

    // Checks if the employee's training makes them eligible to join the division
    public void addDivisionMember(PoliceStaff e)
    {
        for (TrainingRecord trainingRecord : e.getTrainingRecordList())
        {
            if (trainingRecord.getTrainingCourse().equalsIgnoreCase(courseRequirement) && trainingRecord.isCertified())
            {
                if (!divisionMembers.contains(e))
                {
                    divisionMembers.add(e);
                    return; // Ends the loop as soon as one record matches
                }
            }
        }
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

    // Getters
    public String getDivisionName(){
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
}
//Step 9