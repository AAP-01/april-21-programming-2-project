import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class CertificationAlertManager
{
    private List<TrainingRecord> soonToExpire = new ArrayList<>();
    private List<TrainingRecord> expired = new ArrayList<>();

    public void checkEmployee(PoliceStaff employee)
    {
        soonToExpire.clear();
        expired.clear();

        for (TrainingRecord trainingRecord : employee.getTrainingRecordList())
        {
            if (trainingRecord.isCertified() && trainingRecord.getEndDate() != null) {

                long daysUntilExpiration = ChronoUnit.DAYS.between(LocalDate.now(), trainingRecord.getCertificationExpiry());

                if (daysUntilExpiration <= 30 && daysUntilExpiration > 0)
                {
                    soonToExpire.add(trainingRecord);
                } else if (daysUntilExpiration == 0) {
                    expired.add(trainingRecord);
                }
            }
        }
    }

    public List<TrainingRecord> getSoonToExpire() {return soonToExpire;}
    public List<TrainingRecord> getExpired() {return expired;}
}
