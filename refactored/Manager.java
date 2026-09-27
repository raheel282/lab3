package ie.ucd.comp41670.lab3.refactored;

public class Manager extends FullTimeEmployee {
    private final int teamSize;
    private final double bonus;

    public Manager(int id, String name, double annualSalary, int teamSize, double bonus) {
        super(id, name, annualSalary);
        this.teamSize = teamSize;
        this.bonus = bonus;
    }

    @Override
    public double calculatePay() {
        return super.calculatePay() + bonus;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public double getBonus() {
        return bonus;
    }
}
