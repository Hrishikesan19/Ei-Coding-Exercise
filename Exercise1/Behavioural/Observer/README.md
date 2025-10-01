## Observer Pattern - Stock & Trader Example

## Problem
In applications where multiple objects need to be notified automatically when another object’s state changes (e.g., traders watching stock prices), tightly coupling them leads to complex and hard-to-maintain code. Without a proper mechanism, each dependent object would need to check for updates manually.  

## Solution  
I applied the Observer Pattern:  

Created a `Trader` interface with an `update()` method for receiving notifications.  
Built `ConcreteTrader` to implement `Trader` and display updates when notified.  
Implemented a `Stock` class that maintains a list of traders (observers) and notifies them whenever its price changes.  
The client (`Main`) attaches/detaches traders and updates stock prices. Traders are automatically notified of changes.  
