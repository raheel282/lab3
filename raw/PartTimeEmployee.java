package ie.ucd.comp41670.lab3.payroll;

public class PartTimeEmployee extends Employee {

    public PartTimeEmployee(int id, String name, double hourlyRate) {
        super(id, name, hourlyRate);
    }

    @Override
    public double calculatePay(double hours) {
        return getHourlyRate() * hours;
    }
}
