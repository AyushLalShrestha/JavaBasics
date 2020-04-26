# Key points (for Collection)
1. Collections interface extends the Iterable interface which provides method like forEach
2. Collections interface is implemented by most collections except Map  
3. few common collection methods are as:
    - size: returns number of elements
    - clear: removes all elements
    - isEmpty: returns true if zero elements
    - add: add a single element
    - addAll: adds all members of another collection
    - contains: check if an element is present
    - containsAll: check if all members of another collection is present
    - remove: removes an element
    - removeAll: removes all members of present in another collection
    - retainAll: removes all element not contained in another collection
    - toArray: returns Object array
    - toArray(new ClassType[0]): returns ClassType array
4. Convert Array to List:
    - Arrays.asList(collection_object) can also be used for conversion
        eg. `Collection<MyClass> list = Arrays.toList({new Myclass(1), new MyClass(2)})`

# Common collection interfaces:
1. Collection: basic collection interface
2. List: collection that maintains a particular order
3. Queue: collection with concept of Order & specific head element
4. Set: collection that contains no duplicate values
5. SortedSet: a Set whose members are sorted

# Common Collection classes i.e implementation
1. ArrayList: A List backed by resizable array. Effecient random access but ineffecient random inserts
2. LinkedList: A List and Queue backed by Doubly linked list. Effecient for random inserts but ineffecient random access
3. HashSet: A Set impelmented as a Hash table
4. TreeSet: A SortedSet implemented as a balanced binary tree

# Maps & Sorted Map with implementation
1. Map: HashMap - An effecient general purpose implementation
2. SortedMap: TreeMap - Supports comparable & comparator
3. few common map methods are as:
    - put
    - putIfAbsent
    - get
    - getOrDefault
    - values: return a collection of contained values
    - keySet: return a set of contained keys
    - forEach: perform action for each entry
    - replaceAll: perform action for each entry replacing the each key's value with the action's result
