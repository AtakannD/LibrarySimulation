import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class LibrarySystem {
    private List<Book> books;
    private List<MusicRecording> musicRecordings;
    private List<LibraryMember> libraryMembers;

    public LibrarySystem() {
        books = new ArrayList<>();
        musicRecordings = new ArrayList<>();
        libraryMembers = new ArrayList<>();
    }

    public void addBook(String title, String genre, Author author) {
        Book book = new Book(title, genre, author);
        books.add(book);
    }

    public void addMusicRecording(String title, String genre, Person producer) {
        MusicRecording musicRecording = new MusicRecording(title, genre, producer);
        musicRecordings.add(musicRecording);
    }

    public boolean isPersonAuthor(Person person) {
        for (Book book : books) {
            if (book.getAuthor().getName().equals(person.getName())) {
                return true;
            }
        }
        return false;
    }

    public boolean isPersonProducer(Person person) {
        for (MusicRecording musicRecording : musicRecordings) {
            if (musicRecording.getProducer().getName().equals(person.getName())) {
                return true;
            }
        }
        return false;
    }


    public void addLibraryMember(String name) {
        LibraryMember member = new LibraryMember(name);
        libraryMembers.add(member);
    }

    public void displayMediaByGenre(String genre) {
        System.out.println("Media items in the library with genre '" + genre + "':");
        for (Book book : books) {
            if (book.getGenre().equalsIgnoreCase(genre)) {
                System.out.println("Book: " + book.getTitle() + ", Author: " + book.getAuthor().getName());
            }
        }
        for (MusicRecording musicRecording : musicRecordings) {
            if (musicRecording.getGenre().equalsIgnoreCase(genre)) {
                System.out.println("Music Recording: " + musicRecording.getTitle() +
                        ", Producer: " + musicRecording.getProducer().getName());
            }
        }
    }

    public void displayMostBorrowedMedia() {
        List<Media> mediaList = new ArrayList<>();
        mediaList.addAll(books);
        mediaList.addAll(musicRecordings);

        mediaList.sort((m1, m2) -> Integer.compare(m2.getBorrowCount(), m1.getBorrowCount()));

        System.out.println("Most borrowed books and music recordings:");
        for (int i = 0; i < Math.min(5, mediaList.size()); i++) {
            Media media = mediaList.get(i);
            String mediaType = (media instanceof Book) ? "Book" : "Music Recording";
            System.out.println(mediaType + ": " + media.getTitle() +
                    ", Genre: " + media.getGenre() +
                    ", Borrow Count: " + media.getBorrowCount());
        }
    }

    public Media findMediaItemByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        for (MusicRecording musicRecording : musicRecordings) {
            if (musicRecording.getTitle().equals(title)) {
                return musicRecording;
            }
        }
        return null;
    }

    public void incrementBorrowCount(Media mediaItem) {
        mediaItem.incrementBorrowCount();
    }


    public void indicatePersonType(Person person) {
        if (person instanceof Author) {
            System.out.println(person.getName() + " is an Author.");
        } else if (person instanceof Producer) {
            System.out.println(person.getName() + " is a Producer.");
        } else {
            System.out.println(person.getName() + " is neither an Author nor a Producer.");
        }
    }

    public void saveDataToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("library_data.txt"))) {
            for (Book book : books) {
                writer.write("Book: " + book.getTitle() + ", Genre: " + book.getGenre() + ", Author: " + book.getAuthor().getName());
                writer.newLine();
            }

            for (MusicRecording musicRecording : musicRecordings) {
                writer.write("Music Recording: " + musicRecording.getTitle() + ", Genre: " + musicRecording.getGenre() +
                        ", Producer: " + musicRecording.getProducer().getName());
                writer.newLine();
            }

            for (LibraryMember member : libraryMembers) {
                writer.write("Library Member: " + member.getName());
                writer.newLine();
            }

            System.out.println("Data saved to file 'library_data.txt'.");
        } catch (IOException e) {
            System.out.println("Error occurred while saving data to file.");
        }
    }
}