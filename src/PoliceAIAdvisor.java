public class PoliceAIAdvisor
{
    // Phase 2
    public String recommentDivision(PoliceStaff employee, String studentID)
    {
        int lastDigit = studentID.charAt(studentID.length() - 1);   //Still in String form

        if (Character.isDigit(lastDigit));
        {
            lastDigit = Character.getNumericValue(studentID.charAt(studentID.length() - 1));    // Now in int form

            if (lastDigit >= 0 && lastDigit <= 3)
            {
                // Determine based on years of service
            }
            else if (lastDigit >= 4 && lastDigit <= 6)
            {
                // Determine based on training
            }
            else if (lastDigit >= 7 && lastDigit <= 9)
            {
                // Determine based on workload tolerance or job position
            }
        }
    }
}
