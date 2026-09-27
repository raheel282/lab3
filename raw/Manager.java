package ie.ucd.comp41670.lab3.payroll;

public class Manager extends FullTimeEmployee {
    private final int teamSize;
    private final double bonus;

    public Manager(int id, String name, double hourlyRate, double annualSalary,
                   int teamSize, double bonus) {
        super(id, name, hourlyRate, annualSalary);
        this.teamSize = teamSize;
        this.bonus = bonus;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public double getBonus() {
        return bonus;
    }

    @Override
    public double calculatePay(double hours) {
        return super.calculatePay(hours) + bonus;
    }
}
