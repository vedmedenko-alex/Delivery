# Food Delivery
A Java project demonstrating object-oriented programming concepts with a focus on food delivery operations, collections, and generics.

## Project Structure
```
src/main/java/com/solvd/delivery
├── exceptions/             # Custom exceptions
├── interfaces/             # Interface definitions
├── classes/                # Domain models
│   └── abstracts/          # abstract models
│   └── delivery/           # delivery-related models
│   └── food/               # food-related models
│   └── humans/             # people-related models
│   └── places/             # classes with addresses
│   └── customLinkedList/   # realization of a custom linked list
└── App.java                # Application entry point
```
## Features

- Comprehensive exception handling
- Generic classes for type safety
- Custom LinkedList implementation
- Multiple collection types (List, Set, Map, Queue, Tree)
- Proper encapsulation with getters and setters

## Collections and Generics
The project demonstrates the use of various collection types and generic classes:

- CustomLinkedList<T> - A custom implementation of a linked list with basic operations
Contains a private inner Node<T> class with encapsulated data
Provides methods like add, get, print
Full encapsulation with proper getters and setters



## Custom Exceptions

The project includes several custom exceptions:



## Encapsulation
All classes follow proper encapsulation principles:

- Private fields with public getters and setters
- Inner classes (like Node in LinkedList) properly encapsulated
- Logger instances are private and static final

## Build and Run
```bash
# The project uses *Maven* for dependency management and building.

# Compile the project
mvn compile

# Run the application
mvn exec:java

# Package the application
mvn package
```


## Requirements
```
Java 21
Maven 3.8+
```