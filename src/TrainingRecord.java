import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Phase 2 category C (John)
public class TrainingRecord
{
    private final String trainingCourse;    // The name of the course
    private String trainingProgress;    // Progress of the course. Either "Completed", "Ongoing", or "Withdrawn"
    private final int trainingUnits;    // The number of units to do in the course
    private LocalDate startDate;    // The start of the course
    private LocalDate endDate;  // The end of the course. Depends on trainingProgress being "Completed"
    private boolean certified;  // If the employee is certified. Depends on trainingProgress being "Completed"
    private LocalDate certificationExpiry;  // The expiration date of the certificate. Depends on certified being true
    private List<String> specializedSkills; // Special skills that the course may provide. Some divisions may require them

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
    public void setEndDate(LocalDate endDate)
    {
        if (isCertified())
        {
            this.endDate = endDate;
        }
        else
        {
            this.endDate = null;
        }
    }
    public void setCertified(){this.certified = trainingProgress.equalsIgnoreCase("Completed");}
    public void setCertificationExpiry(LocalDate certificationExpiry)
    {
        if (isCertified())
        {
            this.certificationExpiry = certificationExpiry;
        }
        else
        {
            this.certificationExpiry = null;
        }
    }

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
