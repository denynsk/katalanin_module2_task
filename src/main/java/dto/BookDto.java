package dto;

import java.util.UUID;

public class BookDto {
    private UUID id;
    private String name;
    private String author;
    private int year;

    public UUID getId() {
        return id;
    }

    public BookDto setId(UUID id) {
        this.id = id;
        return this;
    }
    public String getName() {
        return name;
    }

    public BookDto setName(String name) {
        this.name = name;
        return this;
    }
    public String getAuthor() {
        return author;
    }

    public BookDto setAuthor(String author) {
        this.author = author;
        return this;
    }

    public int getYear() {
        return year;
    }

    public BookDto setYear(int year) {
        this.year = year;
        return this;
    }

}
