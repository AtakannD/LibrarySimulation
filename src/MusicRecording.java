class MusicRecording extends Media {
    private Person producer;

    public MusicRecording(String title, String genre, Person producer) {
        super(title, genre);
        this.producer = producer;
    }

    public Person getProducer() {
        return producer;
    }
}