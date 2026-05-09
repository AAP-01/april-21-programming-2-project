import java.util.ArrayList;
import java.util.List;

public class Division {

    private String divisionName;
    private PoliceStaff supervisor;
    private ArrayList<PoliceStaff> divisionMembers;
    private String courseRequirement;
    private static List<Division> divisions = new ArrayList<>();

    // For phase 2 module
    private int yearsOfExperienceRequired;
    private String trainingRequired;
    private String divisionType;    // Corresponds to the job types of PatrolOfficer, Investigator, Dispatcher, Clerk, and ITTechnician

    public Division(String divisionName, PoliceStaff supervisor, String courseRequirement, int yearsOfExperienceRequired, String trainingRequired, String divisionType){
        this.divisionName = divisionName;
        this.supervisor = supervisor;
        this.courseRequirement = courseRequirement;
        this.divisionMembers = new ArrayList<>();
        this.yearsOfExperienceRequired = yearsOfExperienceRequired;
        this.trainingRequired = trainingRequired;
        this.divisionType = divisionType;
        divisions.add(this);
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
    public int getYearsOfExperienceRequired() {return yearsOfExperienceRequired;}
    public String getTrainingRequired() {return trainingRequired;}
    public String getDivisionType() {return divisionType;}
    public static List<Division> getDivisions() {return divisions;}

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
    public void setYearsOfExperienceRequired(int yearsOfExperienceRequired) {this.yearsOfExperienceRequired = yearsOfExperienceRequired;}
    public void setTrainingRequired(String trainingRequired) {this.trainingRequired = trainingRequired;}
    public void setDivisionMembers(ArrayList<PoliceStaff> divisionMembers) {this.divisionMembers = divisionMembers;}
}
//Step 9