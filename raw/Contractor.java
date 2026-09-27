package ie.ucd.comp41670.lab3.payroll;

public class Contractor extends Employee {
    private final double dailyRate;

    public Contractor(int id, String name, double dailyRate) {
        super(id, name, dailyRate);
        this.dailyRate = dailyRate;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public double calculatePay(int daysWorked) {
        return dailyRate * daysWorked;
    }

    @Override
    public double calculatePay(double hours) {
        return dailyRate * (hours / 8.0);
    }
}
