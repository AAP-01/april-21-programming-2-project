import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PoliceAIAdvisor
{
    // Phase 2
    public String recommendDivision(PoliceStaff employee, String studentID)
    {
        List<Division> eligibleDivisions = new ArrayList<>();

        if (studentID == null || studentID.isEmpty() || !Character.isDigit(studentID.charAt(studentID.length() - 1)))
            return "Invalid student ID";

        int lastDigit = studentID.charAt(studentID.length() - 1);   //Still in String form

        if (Character.isDigit(lastDigit))
        {
            lastDigit = Character.getNumericValue(studentID.charAt(studentID.length() - 1));    // Now in int form

            if (lastDigit >= 0 && lastDigit <= 3)
            {
                // Determine based on years of service
                int experience = Period.between(employee.getHireDate(), LocalDate.now()).getYears();

                for (Division division : Division.getDivisions())
                {
                    if (experience >= division.getYearsOfExperienceRequired())
                    {
                        eligibleDivisions.add(division);
                    }
                }

                return "Eligible divisions: " + eligibleDivisions.stream()
                                                .map(Division::getDivisionName)
                                                .collect(Collectors.joining(", ")) +
                                                ". The employee has the required years of experience for these divisions";
            }
            else if (lastDigit >= 4 && lastDigit <= 6)
            {
                // Determine based on training
                for (TrainingRecord trainingRecord : employee.getTrainingRecordList())
                {
                    for (Division division : Division.getDivisions())
                    {
                        if (trainingRecord.getTrainingCourse().equalsIgnoreCase(division.getDivisionName()) &&
                                trainingRecord.getTrainingProgress().equalsIgnoreCase("Completed") &&
                                trainingRecord.isCertified())
                        {
                            eligibleDivisions.add(division);
                        }
                    }
                }

                return "Eligible divisions: " + eligibleDivisions.stream()
                                                .map(Division::getDivisionName)
                                                .collect(Collectors.joining(", ")) +
                                                ". The employee has the sufficient training for these divisions";
            }
            else if (lastDigit >= 7 && lastDigit <= 9)
            {
                // Determine based on workload tolerance or job position
                for (Division division : Division.getDivisions())
                {
                    if (division.getDivisionType().equalsIgnoreCase(employee.getJobType()))
                    {
                        eligibleDivisions.add(division);
                    }
                }

                return "Eligible divisions: " + eligibleDivisions.stream()
                                                .map(Division::getDivisionName)
                                                .collect(Collectors.joining(", ")) +
                                                ". The employee's current position makes them suitable for these divisions";
            }
        }

        return employee.getFirstName() + " " + employee.getLastName() + " isn't eligible for any division based on the given conditions";
    }
}
