# COMP41670 Lab 3

This directory contains the Lab 3 implementation for critically analysing an AI-generated inheritance hierarchy.

## Structure

- `raw/` — example raw hierarchy to be audited.
- `review.md` — five-question review and before/after justification.
- `refactored/` — redesigned hierarchy and polymorphic test.
- `AI_INTERACTION_LOG.md` — interaction-log template with simulated examples.

## Required commits

Create these commits in this order:

1. `lab3: raw AI hierarchy`
2. `lab3: review findings`
3. `lab3: refactored hierarchy`

The raw AI output must be committed before the refactor according to the lab instructions.

## Compile/run

From the source root:

```bash
javac -d out lab3/refactored/*.java
java -cp out ie.ucd.comp41670.lab3.refactored.PayrollTest
```

## Academic-integrity note

The AI interaction log in this generated package is intentionally labelled as simulated/template content. Replace it with the actual interactions used during your lab.
