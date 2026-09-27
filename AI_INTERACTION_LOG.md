# AI Interaction Log

### 1. Employee (base class)

- **Prompt:** `// Employee base class for a payroll system. Fields: id (int), name (String), hourlyRate (double). Methods: constructor, getters, calculatePay(double hours), toString, equals.`
- **Output:** Generated `Employee` with `id`, `name`, `hourlyRate` and `calculatePay(double hours)`.
- **Issues:** Base class establishes an hours-based contract that may not fit every payroll type.
- **Decision:** Modified
- **Fix:** Kept the raw version for review; changed the abstraction in the refactored package.
- **Learned:** A base method should represent behaviour shared meaningfully by all subtypes.

---

### 2. FullTimeEmployee

- **Prompt:** `// FullTimeEmployee extends Employee — annual salary, calculatePay ignores hours and returns monthly salary, benefit methods healthInsurance() and pensionContribution().`
- **Output:** Generated salaried subclass with monthly pay and benefits.
- **Issues:** The inherited `hourlyRate` remains conceptually questionable for salaried staff.
- **Decision:** Modified
- **Fix:** Removed hourly-rate dependence from the refactored full-time class.
- **Learned:** Reusing inherited state can hide a domain mismatch.

---

### 3. PartTimeEmployee

- **Prompt:** `// PartTimeEmployee extends Employee — calculatePay(double hours) = hourlyRate * hours, no benefits.`
- **Output:** Generated hourly-pay subclass.
- **Issues:** The relationship is semantically reasonable, but the input-specific pay method still conflicts with other types.
- **Decision:** Modified
- **Fix:** Moved pay calculation behind a parameterless `Payable` interface.
- **Learned:** A common polymorphic operation can encapsulate different input data in object state.

---

### 4. Manager

- **Prompt:** `// Manager extends FullTimeEmployee — bonus and team size, pay includes bonus.`
- **Output:** Generated manager subclass with bonus added to monthly salary.
- **Issues:** Depth is acceptable, but the hierarchy should not grow further without semantic justification.
- **Decision:** Accepted with modification
- **Fix:** Kept the three-level chain and simplified the pay contract.
- **Learned:** Limited hierarchy depth is useful when each level adds a genuine IS-A relationship.

---

### 5. Contractor

- **Prompt:** `// Contractor — external worker, fixed daily rate, not a company employee, calculatePay(int daysWorked) = dailyRate * daysWorked.`
- **Output:** Generated `Contractor extends Employee` with `calculatePay(int daysWorked)`; also added an overridden `calculatePay(double hours)` to satisfy `Employee`'s inherited contract.
- **Issues:** Contractor is external; inherited employee fields and `calculatePay(double)` create a substitutability problem — a caller holding an `Employee` reference gets an hours-to-days conversion the domain never asked for.
- **Decision:** Rejected
- **Fix:** `Contractor` now implements `Payable` directly.
- **Learned:** Interfaces can separate a shared capability from an employment taxonomy.

---