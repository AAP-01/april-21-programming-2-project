import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Phase 2 category C (John)
public class TrainingRecord
{
    private final String trainingCourse;
    private String trainingProgress;
    private final int trainingUnits;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean certified;
    private LocalDate certificationExpiry;
    private List<String> specializedSkills;

    // Each PoliceStaff object will have its own training record(s). Might do it via a new method in PoliceStaff adding and handling them under the employee. I don't think I'll need a TrainingManager for this
    public TrainingRecord(String trainingCourse, String trainingProgress, int trainingUnits, LocalDate startDate, LocalDate endDate, boolean certified, LocalDate certificationExpiry)
    {
        this.trainingCourse = trainingCourse;
        this.trainingProgress = trainingProgress;
        this.trainingUnits = trainingUnits;
        this.startDate = startDate;
        this.endDate = endDate;
        this.certified = certified;
        this.certificationExpiry = certificationExpiry;
        this.specializedSkills = new ArrayList<>();
    }

    // Getters
    public String getTrainingCourse() {return trainingCourse;}
    public String getTrainingProgress() {return trainingProgress;}
    public int getTrainingUnits() {return trainingUnits;}
    public LocalDate getStartDate() {return startDate;}
    public LocalDate getEndDate() {return endDate;}
    public boolean isCertified() {return certified;}
    public LocalDate getCertificationExpiry() {return certificationExpiry;}
    public List<String> getSpecializedSkills() {return specializedSkills;}

    // Setters
    public void setTrainingProgress(String trainingProgress) {this.trainingProgress = trainingProgress;}
    public void setStartDate(LocalDate startDate) {this.startDate = startDate;}
    public void setEndDate(LocalDate endDate) {this.endDate = endDate;}
    public void setCertified(boolean certified) {this.certified = certified;}
    public void setCertificationExpiry(LocalDate certificationExpiry) {this.certificationExpiry = certificationExpiry;}

    @Override
    public String toString() {
        return "TrainingRecord{" +
                "trainingCourse='" + trainingCourse +
                ", trainingProgress='" + trainingProgress +
                ", trainingUnits=" + trainingUnits +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", certified=" + certified +
                ", certificationExpiry=" + certificationExpiry +
                ", specializedSkills=" + specializedSkills +
                '}';
    }
}
