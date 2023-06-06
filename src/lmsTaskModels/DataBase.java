package lmsTaskModels;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private List<Book>books= new ArrayList<>();
    private List<Library>libraries= new ArrayList<>();
    private List<Reader>readers= new ArrayList<>();

    public DataBase(List<Book> books, List<Library> libraries, List<Reader> readers) {
        this.books = books;
        this.libraries = libraries;
        this.readers = readers;
    }

    public DataBase() {
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Library> getLibraries() {
        return libraries;
    }

    public void setLibraries(List<Library> libraries) {
        this.libraries = libraries;
    }

    public List<Reader> getReaders() {
        return readers;
    }

    public void setReaders(List<Reader> readers) {
        this.readers = readers;
    }
}
