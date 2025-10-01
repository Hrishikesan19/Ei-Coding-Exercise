# Iterator Pattern - Channel Collection Example

**Problem**  
When working with collections (like lists of channels), exposing the underlying structure to the client makes the code dependent on the collection’s implementation. The client has to manage indexing and traversal, which reduces flexibility and breaks encapsulation.  

**Solution**  
I applied the Iterator Pattern:  

- Created a `ChannelIterator` interface with `hasNext()` and `next()` methods.  
- Implemented `ChannelIteratorImpl` to traverse the collection internally.  
- Built a `ChannelCollection` class to store channels and provide an iterator.  
- The client (`Main`) uses the iterator to loop through channels without knowing how they are stored.  
