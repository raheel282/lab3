package ie.ucd.comp41670.lab3.refactored;

public class PartTimeEmployee extends Employee {
    private final double hourlyRate;
    private final double hoursWorked;

    public PartTimeEmployee(int id, String name, double hourlyRate, double hoursWorked) {
        super(id, name);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    @Override
    public double calculatePay() {
        return hourlyRate * hoursWorked;
    }
}
