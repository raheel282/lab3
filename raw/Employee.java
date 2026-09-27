package ie.ucd.comp41670.lab3.payroll;

import java.util.Objects;

public class Employee {
    private final int id;
    private final String name;
    private final double hourlyRate;

    public Employee(int id, String name, double hourlyRate) {
        this.id = id;
        this.name = name;
        this.hourlyRate = hourlyRate;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getHourlyRate() { return hourlyRate; }

    public double calculatePay(double hours) {
        return hourlyRate * hours;
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', hourlyRate=" + hourlyRate + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
