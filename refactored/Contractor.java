package ie.ucd.comp41670.lab3.refactored;

public class Contractor implements Payable {
    private final int id;
    private final String name;
    private final double dailyRate;
    private final int daysWorked;

    public Contractor(int id, String name, double dailyRate, int daysWorked) {
        this.id = id;
        this.name = name;
        this.dailyRate = dailyRate;
        this.daysWorked = daysWorked;
    }

    @Override
    public double calculatePay() {
        return dailyRate * daysWorked;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getDailyRate() { return dailyRate; }
    public int getDaysWorked() { return daysWorked; }
}
