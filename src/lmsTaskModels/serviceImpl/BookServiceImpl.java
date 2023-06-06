package lmsTaskModels.serviceImpl;

import lmsTaskModels.Book;
import lmsTaskModels.DataBase;
import lmsTaskModels.Library;
import lmsTaskModels.service.BookService;

import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements BookService {
    private DataBase dataBase;

    public BookServiceImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public Book saveBook(Long libraryId, Book book) {
        for (Library l : this.dataBase.getLibraries()) {
            if (l.getId().equals(libraryId)) {
                l.getBooks().add(book);
            }
        }
        return book;
    }

    @Override
    public List<Book> getAllBooks(Long libraryId) {
        for (Library l : dataBase.getLibraries()) {
            if (l.getId().equals(libraryId)) {
                return l.getBooks();
            }
        }
        return null;

    }

    @Override
    public Book getBookById(Long libraryId, Long bookId) {
        for (int i = 0; i < dataBase.getLibraries().size(); i++) {
            if (dataBase.getLibraries().get(i).getId().equals(libraryId)) {
                List<Book> books = dataBase.getLibraries().get(i).getBooks();
                for (int j = 0; j < books.size(); j++) {
                    if (books.get(j).getId().equals(bookId)) {
                        return books.get(j);
                    }
                }
            }
        }
        return null;
    }

    @Override
    public String deleteBook(Long libraryId, Long bookId) {
        for (int i = 0; i < dataBase.getLibraries().size(); i++) {
            if (dataBase.getLibraries().get(i).getId().equals(libraryId)) {
                List<Book> books = dataBase.getLibraries().get(i).getBooks();
                for (int j = 0; j < books.size(); j++) {
                    if (books.get(j).getId().equals(bookId)) {
                        dataBase.getLibraries().get(i).getBooks().remove(j);
                        return "Successfully deleted";
                    }
                }
            }
        }
        return null;
    }

    @Override
    public void clearBooksByLibraryId(Long libraryId) {
        for (Library library : dataBase.getLibraries()) {
            if (library.getId().equals(libraryId)) {
                List<Book> books = library.getBooks();
                books.clear();
            }
        }
        System.out.println(dataBase.getLibraries());
    }
}
