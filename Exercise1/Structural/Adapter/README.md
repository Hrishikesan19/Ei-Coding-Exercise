# Adapter Pattern - Payment Gateway Example

## Problem

Different payment services like PayPal and Stripe use different methods and formats. Our system, however, expects payments to be handled in one fixed way. Calling each gateway directly would make the code complex and hard to maintain.

## Solution

I introduced the **Adapter Pattern**:

* Created a common interface `PaymentProcessor` with `processPayment(amount)`.
* Built adapters (`PayPalAdapter`, `StripeAdapter`) that translate our interface into each gateway’s format.
* The client (`Main`) only calls `PaymentProcessor`, while adapters handle the details.

## Design Decision

* **Option 1:** Create the gateway object inside the adapter - simple but tightly coupled.
* **Option 2 (Chosen):** Pass the gateway object from the client to the adapter - more flexible and testable.
