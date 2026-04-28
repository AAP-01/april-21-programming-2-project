public interface Payroll
{
    public double hourlyRate(String rank);
    public double calculateWeeklyWorkHours(double totalHours, int days);
    public double calculateMonthlySalary();
    public double calculateAnnualSalary();
    public double calculateOvertimePay(double overtimeHours);
}
