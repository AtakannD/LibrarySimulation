import java.util.Scanner;

public class LibrarySimulation {
    private LibrarySystem librarySystem;
    private Scanner scanner;

    public LibrarySimulation() {
        librarySystem = new LibrarySystem();
        scanner = new Scanner(System.in);
    }

    public void createSimulation() {
        while (true) {
            System.out.println("----- Library System Menu -----");
            System.out.println("1. Add new book to the library system");
            System.out.println("2. Add a new music recording to the library system");
            System.out.println("3. Add new member to the library system");
            System.out.println("4. Display media items by genre");
            System.out.println("5. Add record for borrowing an item");
            System.out.println("6. Display most borrowed books and music recordings");
            System.out.println("7. Indicate whether a person is an author or producer");
            System.out.println("8. Save data to file");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            String choiceStr = scanner.nextLine();

            if (!choiceStr.matches("[0-8]")) {
                System.out.println("Please enter a valid choice.");
                continue;
            }

            int choice = Integer.parseInt(choiceStr);

            switch (choice) {
                case 1:
                    addNewBook();
                    break;
                case 2:
                    addNewMusicRecording();
                    break;
                case 3:
                    addNewMember();
                    break;
                case 4:
                    displayMediaByGenre();
                    break;
                case 5:
                    addBorrowingRecord();
                    break;
                case 6:
                    displayMostBorrowedMedia();
                    break;
                case 7:
                    indicatePersonType();
                    break;
                case 8:
                    saveDataToFile();
                    break;
                case 0:
                    System.out.println("Exiting the program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        }
    }

    private void addNewBook() {
        System.out.print("Enter the title of the book: ");
        String bookTitle = scanner.nextLine();
        System.out.print("Enter the genre of the book: ");
        String bookGenre = scanner.nextLine();
        System.out.print("Enter the author of the book: ");
        String authorName = scanner.nextLine();
        Author author = new Author(authorName);
        librarySystem.addBook(bookTitle, bookGenre, author);
        System.out.println("Book added to the library system.");
    }

    private void addNewMusicRecording() {
        System.out.print("Enter the title of the music recording: ");
        String recordingTitle = scanner.nextLine();
        System.out.print("Enter the genre of the music recording: ");
        String recordingGenre = scanner.nextLine();
        System.out.print("Enter the producer of the music recording: ");
        String producerName = scanner.nextLine();
        Person producer = new Person(producerName);
        librarySystem.addMusicRecording(recordingTitle, recordingGenre, producer);
        System.out.println("Music recording added to the library system.");
    }

    private void addNewMember() {
        System.out.print("Enter the name of the library member: ");
        String memberName = scanner.nextLine();
        librarySystem.addLibraryMember(memberName);
        System.out.println("Library member added to the library system.");
    }

    private void displayMediaByGenre() {
        System.out.print("Enter the genre to display media items: ");
        String displayGenre = scanner.nextLine();
        librarySystem.displayMediaByGenre(displayGenre);
    }

    private void displayMostBorrowedMedia() {
        librarySystem.displayMostBorrowedMedia();
    }

    private void indicatePersonType() {
        System.out.print("Enter the name of the person: ");
        String personName = scanner.nextLine();
        Person person = new Person(personName);
        Author author = new Author(personName);
        Producer producer = new Producer(personName);

        if (librarySystem.isPersonAuthor(person)) {
            librarySystem.indicatePersonType(author);
        } else if (librarySystem.isPersonProducer(person)) {
            librarySystem.indicatePersonType(producer);
        } else {
            System.out.println(person.getName() + " is neither an Author nor a Producer.");
        }
    }

    private void addBorrowingRecord() {
        System.out.print("Enter the title of the item to borrow: ");
        String itemTitle = scanner.nextLine();
        Media mediaItem = librarySystem.findMediaItemByTitle(itemTitle);
        if (mediaItem != null) {
            if (mediaItem.isBorrowed()) {
                System.out.println("The item is already borrowed.");
            } else {
                librarySystem.incrementBorrowCount(mediaItem);
                System.out.println("Borrowing record added.");
            }
        } else {
            System.out.println("Item not found in the library system.");
        }
    }

    private void saveDataToFile() {
        librarySystem.saveDataToFile();
        System.out.println("Data saved to file.");
    }

    public static void main(String[] args) {
        LibrarySimulation simulation = new LibrarySimulation();
        simulation.createSimulation();
    }
}
