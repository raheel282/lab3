package ie.ucd.comp41670.lab3.refactored;

import java.util.List;

public class PayrollTest {
    public static void main(String[] args) {
        List<Payable> payroll = List.of(
                new FullTimeEmployee(1, "Alice", 60000),
                new PartTimeEmployee(2, "Bob", 20, 80),
                new Manager(3, "Carol", 72000, 6, 1000),
                new Contractor(4, "Dave", 300, 10)
        );

        for (Payable payable : payroll) {
            System.out.println("Pay: " + payable.calculatePay());
        }
    }
}
