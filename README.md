# Stamford Library Management System

## Written in Java

## Project Requirement

The project should cover at least **85%** of the topics covered during the 11-weeks of the course of ITE222.

#### Topics covered includes:

- [x] Loops- For while, do while, if and nested if , switch case
- [x] Constructors (Signatures) and methods
- [ ] Method overaloading
- [ ] creating classes and sub classes
- [x] Instantiating Objects
- [x] This keyword/ pointer , dot operator
- [x] Packages (Scanner, Random, Math, Joption pane)
- [x] Encapsulation
- [x] Object Interface and interactions
- [x] Dimensional Arrays
- [x] Static and variable methods
- [x] Declaring methods and fileds in proper names
- [x] Commenting
- [x] Access specifier/ Modifier.

_Note:_ No other topics shouldn't be  (which is not included in the syllabus ) used in the project. If so project with be cancelled and marked as Zero.

## Class Diagram

```mermaid
    graph TD
    A[Start] --> B{Declare App Name & Arrays}
    B --> C{Populate Book Details Array}
    B --> D{Populate Student Details Array}
    C --> E{Create Book Database Object}
    D --> F{Create Student Database Object}
    E,F --> G{Create Librarian Object}
    G --> H{Login Prompt}
    H --> I{Get Librarian ID & Password}
    I --> J{Login Verification}
    J -- Yes --> K{Welcome Message & Main Menu}
    J -- No --> L{Login Failed}
    K --> M{Display Total Books Borrowed}
    K --> N{Menu Options}
    N --> O{Choice Selection}
    O -- 1 --> P{Get Book ID, Student ID, Borrow Date} --> Q{Borrow Book} --> K
    O -- 2 --> R{Get Book ID to Return} --> S{Return Book} --> K
    O -- 3 --> T{View Books} --> K
    O -- 4 --> U{View Student Borrow History} --> K
    O -- 5 --> V{Exit Program} --> W[End]
    O -- Other --> X{Invalid Option} --> N

```

```mermaid
---
title: Stamford Library Management System
---
classDiagram
    class App {
        +main(String[] args)
    }

    class BookDatabase {
        -BookDetail[][] books
        +BookDatabase(BookDetail[][] books)
        +setBooks(BookDetail[][] books)
        +getBooks(): BookDetail[][]
    }

    class BookDetail {
        -String bookID
        -String bookTitle
        -String bookAuthor
        -String bookPublication
        -boolean isAvailable
        +BookDetail(String bookID, String title, String author, String publication)
        +boolean borrowBook()
        +void returnBook()
        +String getBookID()
        +String getBookTitle()
        +void getBookTable()
    }

    class Librarian {
        -int id
        -String password
        -static int totalBooksBorrowed
        +Librarian(int id, String password)
        +boolean login(int id, String password)
        +void viewBooks(BookDatabase bookDB)
        +void borrowBook(BookDatabase bookDB, String bookID)
        +void returnBook(BookDatabase bookDB, String bookID)
        +static int getTotalBooksBorrowed()
    }

    App --> BookDatabase
    App --> Librarian
    BookDatabase --> BookDetail
    Librarian --> BookDatabase
    Librarian --> BookDetail
```
