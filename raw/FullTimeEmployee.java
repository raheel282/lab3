package ie.ucd.comp41670.lab3.payroll;

public class FullTimeEmployee extends Employee {
    private final double annualSalary;

    public FullTimeEmployee(int id, String name, double hourlyRate, double annualSalary) {
        super(id, name, hourlyRate);
        this.annualSalary = annualSalary;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    @Override
    public double calculatePay(double hours) {
        return annualSalary / 12.0;
    }

    public String healthInsurance() {
        return "Full health insurance";
    }

    public double pensionContribution() {
        return annualSalary * 0.05;
    }
}
