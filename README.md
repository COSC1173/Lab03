# Lab 03 — Grade Advisor

| | |
|---|---|
| **Week** | 3 |
| **Textbook** | Liang — **Chapter 3** (Selections) |
| **Time budget** | 60 minutes |
| **Points** | 100 |

---

## Learning Objectives

1. Validate input with a compound boolean expression before trusting it.
2. Build a multi-way `if / else if / else` chain and explain why the order of the tests matters.
3. Write a two-way `if-else`.
4. Store the result of a boolean expression in a `boolean` variable.
5. Translate an English rule ("divisible by 4 but not by 100, or divisible by 400") into Java operators.

---

## Background

**Boundary conditions.** `>= 90` and `> 90` differ for exactly one input: 90. That single input is
where most selection defects hide, so the test driver checks scores of exactly 90 and exactly 70.

**Order matters in a multi-way chain.** Java takes the first branch that is true and skips the rest:

```java
if (score >= 60)      System.out.println("D");   // WRONG ORDER: 95 stops here
else if (score >= 90) System.out.println("A");   // unreachable for any passing score
```

Test the **largest** boundary first.

**Compound conditions.** `&&` is *and*, `||` is *or*, `!` is *not*. A leap year is a year
divisible by 4 **but not** by 100, **or** divisible by 400:

```java
boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
```

The parentheses are not required by the precedence rules, but include them: they make the intent
unambiguous to a human reader.

**Do not compare booleans to literals.** Write `if (isLeapYear)`, never `if (isLeapYear == true)`.

---

## Instructions

### Part A — Grade Classification

**Step 1 — Validate.** If the score is below 0 **or** above 100, print exactly `Invalid score` and
print nothing else for Part A. Use `||`, and put Steps 2 and 3 in the `else` branch so they are
skipped for bad input. The test driver verifies that no letter grade appears for a score of 105.

**Step 2 — Assign the letter.** Using `if / else if / else`, print one of:

| Score | Output |
|---|---|
| 90 and above | `Letter grade: A` |
| 80–89.99 | `Letter grade: B` |
| 70–79.99 | `Letter grade: C` |
| 60–69.99 | `Letter grade: D` |
| below 60 | `Letter grade: F` |

**Step 3 — Pass or fail.** With a two-way `if-else`, print `Status: PASS` when the score is 70 or
higher, otherwise `Status: FAIL`.

### Part B — Leap Year

**Step 4 — Evaluate the rule.** Store the leap-year test in a `boolean` variable named `isLeapYear`.

**Step 5 — Report.** Print either

```
2024 is a leap year
1900 is not a leap year
```

The year must come from the variable, so that any year the grader supplies is echoed correctly.

---

## Commenting Standard (20 points)

```java
// WEAK
if (score < 0 || score > 100) { // check score

// STRONG
// A score outside 0-100 cannot be graded, so it is rejected before the
// grading chain runs; || means the score is invalid if EITHER test is true.
if (score < 0 || score > 100) {
```

---

## Compile, Run, and Test

```bash

```

---

## Sample Runs

```
Enter the exam score (0-100): 87
Letter grade: B
Status: PASS
Enter a year: 2024
2024 is a leap year
```

```
Enter the exam score (0-100): 105
Invalid score
Enter a year: 1900
1900 is not a leap year
```

**Cases the test driver checks:** 87/2024 · 58/1900 · 70/2000 (both boundaries) · 90/2023 ·
105/2020 (invalid) · −4/2019 (invalid).

Note the three century years: 1900 is **not** a leap year, 2000 **is**. If your program disagrees,
your condition is missing the `% 400` clause or the `% 100` clause.

---

## Grading Rubric

| Criterion | Points |
|---|---|
| All 18 checks pass | 60 |
| Line comments explain every statement and every condition | 20 |
| Correct chain ordering, no `== true`, sensible indentation | 10 |
| Committed and pushed on time | 10 |

---

## Submission Checklist

- [ ] `bash tools/run_lab.sh lab03` reports 18 of 18.
- [ ] Score 105 produces `Invalid score` and no letter grade.
- [ ] Score exactly 90 produces an `A`; exactly 70 produces a `C` and `PASS`.

```bash
git add . && git commit -m "Lab 03 complete - all 18 checks passing" && git push
```

---

## Stretch Goal

Add a plus/minus refinement: 87 becomes `B+`, 83 becomes `B`, 81 becomes `B-`. Do this with nested
selection inside each branch rather than by writing fifteen `else if` clauses.

---

## Troubleshooting

| Symptom | Cause | Fix |
|---|---|---|
| Every score prints `D` | Chain tests the smallest boundary first | Reorder from highest to lowest |
| A score of 90 prints `B` | Used `>` where `>=` is required | Correct the operator |
| 1900 reported as a leap year | Missing the "not divisible by 100" clause | Add `&& year % 100 != 0` |
| 2000 reported as not a leap year | Missing the `% 400` clause | Add `|| year % 400 == 0` |
| A letter grade appears for score 105 | Steps 2–3 are outside the `else` | Nest them inside the `else` block |
