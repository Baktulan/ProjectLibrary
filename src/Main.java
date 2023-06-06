import lmsTaskModels.Book;
import lmsTaskModels.DataBase;
import lmsTaskModels.Library;
import lmsTaskModels.Reader;
import lmsTaskModels.enums.Gender;
import lmsTaskModels.enums.Genre;
import lmsTaskModels.serviceImpl.BookServiceImpl;
import lmsTaskModels.serviceImpl.LibraryServiceImpl;
import lmsTaskModels.serviceImpl.ReaderServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>(
                List.of(new Book(1L, "Martin Iden", "Djek London", Genre.DRAMA),
                        new Book(2L, "Kyzyl Alma", "Chyngyz Aitmatov", Genre.DRAMA),
                        new Book(3L, "Time-Managment", "Brain Trayc", Genre.NONFICTION)));
        Book martinIden = books.get(0);
        Book kyzylAlma = books.get(1);
        Book timeManagment = books.get(2);

        ArrayList<Book> books1 = new ArrayList<>(
                List.of(new Book(4L, "Toolor Kulaganda", "Chyngyz Aitmatov", Genre.THRILLER),
                        new Book(5L, "Asyl Oilor", "Kachkynaaly Sydygaliev", Genre.NONFICTION),
                        new Book(6L, "Oilon oigon", "Kasymbek Junusaliev", Genre.NONFICTION)));
        Book toolorKulaganda = books1.get(0);
        Book asylOilor = books1.get(1);
        Book oilonOigon = books1.get(2);


        ArrayList<Reader> readers = new ArrayList<>(Arrays.asList(
                new Reader(11L, "Baktulan nazirbek uulu", "baktulan@mail.ru", 996552931005L, Gender.MALE),
                new Reader(12L, "Asanov Asan", "asan@mail.ru", 996553889705L, Gender.MALE),
                new Reader(13L, "Uson Usonov", "uson@mail.ru", 996551931005L, Gender.MALE),
                new Reader(14L, "Kairat Sansyzbaev", "kairat@mail.ru", 996552938645L, Gender.MALE)));
        Reader baktulan = readers.get(0);
        Reader asan = readers.get(1);
        Reader uson = readers.get(2);
        Reader kairat = readers.get(3);
        ArrayList<Reader> readers1= new ArrayList<>(Arrays.asList(
                new Reader(17L,"Zhanuzak Anashov","zhanuzak@mail.ru",996551343131L,Gender.MALE)));
        Reader zhanuzak=readers1.get(0);

        ArrayList<Library> libraries = new ArrayList<>(Arrays.asList(
                new Library(20L, "Bayalinov", "Sovetskaya 12", books, readers),
                new Library(21L, "Alykul Osmonov", "Chui 14", books, readers),
                new Library(22L, "Chyngyz Aitmatov", "Ankara 28", books, readers)));
        Library bayalinov = libraries.get(0);
        Library alykulOsmonov = libraries.get(1);
        Library chyngyzAitmatov = libraries.get(2);


        ArrayList<Library> libraries2 = new ArrayList<>(List.of(
                new Library(23L, "Nataional Library", "Kalyk Akieava 21", books1, readers),
                new Library(24L, "Bishkek Library", "Manas 22", books1, readers),
                new Library(25L, "Kyrgyz State Library", "Bokonbaeva 76", books1, readers1)));
        Library nationalLibrary = libraries2.get(0);
        Library bishkeklibrary = libraries2.get(1);
        Library kyrgyzStateLibrary = libraries2.get(2);

        DataBase dataBase = new DataBase();
        LibraryServiceImpl libraryService = new LibraryServiceImpl(dataBase);
        BookServiceImpl bookService = new BookServiceImpl(dataBase);
        ReaderServiceImpl readerService = new ReaderServiceImpl(dataBase);
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                1.Save library 
                2.Get All library
                3.Save new Library
                4.Get library by id
                5.Update library 
                6.Delete library by Id
                7.Save book
                8.Get all books
                9.Get Book by Id
                10.Delete book
                11.Clear books by library id
                12.Save Reader
                13.Get all Readers
                14.Get Reader by id
                15.Update reader
                16.Assign reader to library""");
        int num;
        while (true) {
            num = scanner.nextInt();
            switch (num) {
                case 1 -> {
                    System.out.println(libraryService.saveLibrary(libraries));
                }
                case 2 -> {
                    System.out.println(libraryService.getAllLibraries());
                }
                case 3 -> {
                    System.out.println(libraryService.saveLibrary(libraries2));
                }
                case 4 -> {
                    System.out.println(libraryService.getLibraryById(20L));
                }
                case 5 -> {
                    System.out.println(libraryService.updateLibrary(21L, nationalLibrary));
                }
                case 6 -> {
                    System.out.println(libraryService.deleteLibrary(23L));
                }
                case 7 -> {
                    System.out.println(bookService.saveBook(20L, toolorKulaganda));
                }
                case 8 -> {
                    System.out.println(bookService.getAllBooks(20L));
                }
                case 9 -> {
                    System.out.println(bookService.getBookById(20L, 1L));
                }
                case 10 -> {
                    System.out.println(bookService.deleteBook(20L, 3L));
                }
                case 11 -> {
                    bookService.clearBooksByLibraryId(20L);
                }
                case 12 -> {
                    readerService.saveReader(zhanuzak);
                }
                case 13 -> {
                    System.out.println(readerService.getAllReaders());
                }
                case 14 -> {
                    System.out.println(readerService.getReaderById(17L));
                }
                case 15 -> {
                    System.out.println(readerService.updateReader(13L, asan));
                }
                case 16 -> {
                    readerService.assignReaderToLibrary(17L, 20L);
                }
            }

        }
    }
}