
## Singleton Pattern - ConfigManager & Logger Example

## Problem
Certain classes like configuration managers and loggers should have only one instance throughout the application. Creating multiple instances can lead to inconsistent configuration, fragmented logging, and unnecessary resource usage.  

## Solution  
I applied the Singleton Pattern:  

Made constructors private to prevent external instantiation.  
Created a private static instance variable inside the class.  
Provided a public `getInstance()` method to return the single instance.  
Example classes:  
  `ConfigManager` → Manages application configuration properties.  
  `Logger` → Handles logging messages consistently across the app.  
The client (`Main`) calls `getInstance()`, ensuring a single shared instance.  

## Design Decision**  
Option 1: Eager initialization – create the instance at class loading (simple but wastes memory if never used).  
Option 2 (Chosen): Lazy initialization with `synchronized` – instance created only when needed, thread-safe, and more efficient.  
