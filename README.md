# LibrarySimulation

This Java console-based program simulates a library system. The library contains media, which consists of books and music records. Each media item (book or music record) has a title, genre, and borrow information. The library also includes members who can borrow media items.

## Media Class

The `Media` class represents a generic media item in the library system. It has the following attributes:

- `title`: A String representing the title of the media item.
- `genre`: A String representing the genre of the media item.
- `borrowCount`: An integer keeping track of how many times the media item has been borrowed.
- `isBorrowed`: A boolean indicating whether the media item is currently borrowed or not.

## Book Class

The `Book` class extends the `Media` class and represents a book in the library system. In addition to the attributes inherited from the `Media` class, a book has an author, represented by a `Person` object.

## MusicRecording Class

The `MusicRecording` class extends the `Media` class and represents a music recording in the library system. In addition to the attributes inherited from the `Media` class, a music recording has a producer, represented by a `Person` object.

## Person Class

The `Person` class represents a person who can be either an author (for books) or a producer (for music recordings). It has the following attributes:

- `name`: A String representing the name of the person.
- `age`: An integer representing the age of the person.

## Library Class

The `Library` class handles the main functionalities of the library system. It includes methods for adding new books, music recordings, and members to the library system. It also provides options to display media items based on genres, view the most borrowed books and music recordings, and determine whether a given person is an author or a producer. Additionally, the library can save all new media items and members to a text file.

## Menu Options

The `Library` class provides the following menu options for the user:

1. Add new book to the library system
2. Add a new music recording to the library system
3. Add new member to the library system
4. Display all media items in a given genre
5. View the most borrowed books and music recordings
6. Check if a person is an author or a producer
7. Save all new media items and members to a text file

Note: This is a console-based program and does not include any user interface. The user interacts with the program through the console.

## How to Run the Program

1. Clone the repository or download the Java program files.

2. Compile and run the `LibrarySystemApp.java` file using a Java IDE or the command line.

3. Follow the on-screen instructions to interact with the library system and choose from the menu options.

## Data Storage

The program uses text files to save all new media items and members added to the library system. The text files are automatically created and updated when the program adds new items.
