# Lab 3 — Inheritance Review

## Activity 2 — Five-question inheritance review

### 1. Semantic IS-A

**Fail for Contractor.** The raw hierarchy declares `Contractor extends Employee`, even though the domain describes a contractor as an external worker and explicitly distinguishes them from a company employee. The inheritance is therefore being used to force a common payroll structure rather than expressing the domain relationship.

**Pass for FullTimeEmployee and PartTimeEmployee.** Both represent employees with different employment arrangements and naturally fit under `Employee`.

**Pass for Manager → FullTimeEmployee.** A manager in this model is also a full-time employee, so this relationship is semantically defensible.

### 2. Forced overrides

**Fail.** `Contractor` has to override `calculatePay(double hours)` because `Employee` requires that signature, while the contractor's natural input is days worked. The override converts hours into days:

```java
return dailyRate * (hours / 8.0);
```

This is evidence that the inherited contract does not naturally fit the subtype.

### 3. Substitutability

**Fail for Contractor.** `Contractor` adds `calculatePay(int daysWorked)` while inheriting the unrelated `calculatePay(double hours)` contract. A caller treating every `Employee` uniformly therefore cannot use the contractor through the same meaningful pay operation without knowing how the contractor's calculation differs.

### 4. Depth ≤ 3

**Pass.** The deepest raw chain is:

```text
Employee → FullTimeEmployee → Manager
```

which is three levels. The depth is therefore within the stated limit.

### 5. Inheritance-for-reuse

**Fail for Contractor.** The contractor inherits `id`, `name`, and `hourlyRate` from `Employee`, although the contractor is paid using a fixed daily rate. In particular, the raw constructor passes `dailyRate` into the inherited `hourlyRate` field, indicating that inheritance is partly being used to reuse storage and existing methods rather than model a true subtype.

## Findings

### Finding 1 — Broken substitutability

The clearest violation is the contractor's pay contract. `Employee` exposes `calculatePay(double hours)`, while `Contractor` additionally exposes `calculatePay(int daysWorked)` and still overrides the inherited hours-based method. A caller using the parent type therefore receives a contract that does not correspond to the contractor's natural payroll input, violating the intended substitutability described by the lab's review.

### Finding 2 — Inheritance-for-reuse

`Contractor extends Employee` also demonstrates inheritance-for-reuse. The contractor is an external worker with a fixed daily rate, yet it inherits the employee's `hourlyRate` field and employee behaviour. Passing `dailyRate` to `super(..., dailyRate)` makes this mismatch visible: the field is reused even though its meaning has changed.

## Activity 3 — Before / After

### Before

```java
class Employee { double calculatePay(double hours); }
class FullTimeEmployee extends Employee { ... }
class PartTimeEmployee extends Employee { ... }
class Manager extends FullTimeEmployee { ... }
class Contractor extends Employee { double calculatePay(int daysWorked); }
```

### After

```java
interface Payable { double calculatePay(); }

class Employee implements Payable { ... }
class FullTimeEmployee extends Employee { ... }
class PartTimeEmployee extends Employee { ... }
class Manager extends FullTimeEmployee { ... }
class Contractor implements Payable { ... }
```

The common abstraction is changed from an employee-specific hours-based method to a parameterless `Payable` contract. Each object is constructed with the information needed to calculate its own pay, so polymorphic callers do not need to know whether pay is based on salary, hours, bonus, or days.

`Contractor` no longer extends `Employee`, because the domain explicitly describes it as external and because the employee fields do not model its pay correctly. It still implements `Payable`, preserving the useful common payroll operation without claiming an employee IS-A relationship.

`Manager` remains under `FullTimeEmployee` because the raw domain description gives managers a team and bonus while retaining salaried/full-benefit employee characteristics.

## Refactored five-question review

| Question | Result | Reason |
|---|---|---|
| Semantic IS-A | Pass | Employee subtypes model employee relationships; Contractor is no longer an Employee subtype. |
| Forced overrides | Pass | No subtype is forced to implement an unsuitable inherited pay signature. |
| Substitutability | Pass | Every `Payable` supplies the same `calculatePay()` operation. |
| Depth ≤ 3 | Pass | Maximum chain remains `Employee → FullTimeEmployee → Manager`. |
| Inheritance-for-reuse | Pass | Contractor uses an interface rather than inheriting employee state merely for reuse. |
