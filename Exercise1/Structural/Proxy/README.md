## Proxy Pattern

## Problem

Large images are expensive to load from disk or a server. If we load them immediately when creating objects, the application becomes slow and consumes unnecessary resources, even if some images are never displayed.

## Solution

I applied the **Proxy Pattern (Virtual Proxy)**:

* Created a common interface `Image` with a method `display()`.
* Built a `RealImage` class that loads and displays the actual image (heavy object).
* Introduced a `ProxyImage` that acts as a placeholder and only creates/loads the `RealImage` when `display()` is called.
* The client (`Main`) works with the `Image` interface, unaware whether it’s dealing with a proxy or the real object.

## Design Decision

* **Eager Loading:** Directly creating `RealImage` objects at startup would load all images immediately, wasting time and memory.
* **Lazy Loading (Chosen):** Use `ProxyImage` to delay creation of `RealImage` until the image is actually displayed, improving performance and resource usage.
