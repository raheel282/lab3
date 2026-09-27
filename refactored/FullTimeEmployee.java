package ie.ucd.comp41670.lab3.refactored;

public class FullTimeEmployee extends Employee {
    private final double annualSalary;

    public FullTimeEmployee(int id, String name, double annualSalary) {
        super(id, name);
        this.annualSalary = annualSalary;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    @Override
    public double calculatePay() {
        return annualSalary / 12.0;
    }

    public String healthInsurance() {
        return "Full health insurance";
    }

    public double pensionContribution() {
        return annualSalary * 0.05;
    }
}
