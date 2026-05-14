# Credit Card Repayment Calculator

## Overview

A Java-based financial simulator that calculates credit card repayment schedules with interest.
The application demonstrates Object-Oriented Programming (OOP) principles and the Strategy Design Pattern to support multiple repayment methods.

## Features

* Calculate credit utilization and categorize credit score impact
* Simulate monthly repayment with interest
* Multiple repayment strategies:

    * Fixed Principal Strategy
    * Minimum Payment Strategy
    * Avalanche Strategy
    * Snowball Startegy
* Month-by-month breakdown of:

    * Payment
    * Interest
    * Remaining balance

## Technologies Used

* Java
* OOP (Encapsulation, Polymorphism, Abstraction)
* Strategy Design Pattern

## Project Structure

```
model/       -> Data classes (CreditCard)
strategy/    -> Payment strategies (interface + implementations)
service/     -> Business logic (PayoffCalculator)
```

## How to Run

1. Clone the repository:

```
git clone https://github.com/Ani-Peju/credit-card-calculator.git
```

2. Navigate to the project directory:

```
cd credit-card-calculator
```

3. Compile and run:

```
javac Main.java
java Main
```

## Example Output

```
Month 1: Payment = $750.00 | Interest = $71.20 | Balance = $2810.00
Month 2: Payment = $720.00 | Interest = $56.20 | Balance = $2060.00
```

## Future Improvements

* GUI using JavaFX
* Web version (Spring Boot + React)
* Support for multiple debts (loans, car payments)
* Data persistence (save/load scenarios)

## Author

Adepeju Animashaun
