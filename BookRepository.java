package libapp;

import java.util.ArrayList;
import java.util.Locale;

public class BookRepository {

private ArrayList<Book> Books = new ArrayList<>();


public BookRepository(){

    Books.add(new Book("12345","Cats and Dogs","Comedy","Dogs and Cats love each other","S.K. Elton",10, 7));
    Books.add(new Book("67891","Dragons and Cows","Horror","Dragons and Cats kill each other","Spartacus Shepherd", 3,2));
    Books.add(new Book("12131","Aliens","Suspense","Aliens are everywhere","Morgan Shepherd",4,2));
    Books.add(new Book("13141","Ally and Sparty","Musical","Ally loves Sparty","M. Shepherd",7, 4));
}

public Book findByIsbn(String isbn){

    for (Book book : Books){
       if (book.getIsbn().equals(isbn)){
           return book;
       }
    }
    return null;

}

public ArrayList<Book> findByTitle(String keyword){
    ArrayList<Book> booksFound = new ArrayList<>();
    for (Book book : Books){
        if (book.getTitle().toLowerCase().contains(keyword.toLowerCase())){
            booksFound.add(book);
        }
    }
    return booksFound;
}

public ArrayList<Book> findByAuthor(String keyword){
    ArrayList<Book> booksFound = new ArrayList<>();
    for (Book book : Books){
        if (book.getAuthor().toLowerCase().contains(keyword.toLowerCase())){
            booksFound.add(book);
        }
    }
    return booksFound;
}

}
