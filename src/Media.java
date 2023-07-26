class Media {
    private String title;
    private String genre;
    private int borrowCount;
    private boolean borrowed;

    public Media(String title, String genre) {
        this.title = title;
        this.genre = genre;
        this.borrowCount = 0;
        this.borrowed = false;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getBorrowCount() {
        return borrowCount;
    }

    public void incrementBorrowCount() {
        borrowCount++;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }
}