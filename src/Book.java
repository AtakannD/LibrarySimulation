class Book extends Media {
    private Author author;

    public Book(String title, String genre, Author author) {
        super(title, genre);
        this.author = author;
    }

    public Author getAuthor() {
        return author;
    }
}
