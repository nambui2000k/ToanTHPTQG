package vn.poly.toanthptqg.model;

public class Sentence {
    private int idSentence;
    private String content;
    private String author;

    public Sentence(int idSentence, String content, String author) {
        this.idSentence = idSentence;
        this.content = content;
        this.author = author;
    }

    public int getIdSentence() {
        return idSentence;
    }

    public void setIdSentence(int idSentence) {
        this.idSentence = idSentence;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
