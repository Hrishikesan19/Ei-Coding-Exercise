## Factory Pattern - Notification Example

## Problem
Different notification channels like SMS, WhatsApp, and Email require different implementations. Directly instantiating each type in the client code makes it complex and hard to maintain. Adding a new notification type would require modifying the client code.  

## Solution
I applied the Factory Pattern:  

Created a common `Notification` interface with a method `notifyUser()`.  
Built concrete classes (`SMSNotification`, `WhatsAppNotification`, `EmailNotification`) implementing the interface.  
Introduced a `NotificationFactory` that decides which notification object to create based on input type.  
The client (`Main`) calls the factory to get a `Notification` object and uses it, without knowing the concrete class details.  

## Design Decision
Option 1: Let the client create notification objects directly – simple but tightly coupled and less maintainable.  
Option 2 (Chosen): Use a factory – decouples object creation from client, easier to extend with new notification types.
