package libapp;

import java.util.ArrayList;

public class LibraryApp {

private BookRepository bookRepo = new BookRepository();


public void searchByIsbn(String isbn){
    System.out.printf("Searching for books with ISBN %s.\n", isbn);
    Book book = bookRepo.findByIsbn(isbn);
    if(book != null){
        System.out.printf("%s book found:\n\tTitle: %s\n\tGenre: %s\n\tAuthor: %s", book.getTitle(), book.getGenre(), book.getAuthor());
    }
    else{
        System.out.printf("O books found.");
    }
    System.out.print("\n\n");

}

public void searchByTitle(String keyword){

    System.out.printf("Searching for books with '%s' in the title...\n", keyword);
    ArrayList<Book> books = bookRepo.findByTitle(keyword);
    System.out.printf("%s book%s found%s\n", books.size(), books.size() > 1 ? "s" : "", books.size() > 0 ? ":" : ".");
    for (Book book : books){
    System.out.printf("\tTitle: %s\n\tGenre: %s\n\tAuthor: %s\n\t---\n", book.getTitle(), book.getGenre(), book.getAuthor());
    }
    System.out.println();
}


public void searchByAuthor(String keyword){
    System.out.printf("Searching for books written by '%s'...\n", keyword);
    ArrayList<Book> books = bookRepo.findByAuthor(keyword);
    System.out.printf("%s book%s written by " + keyword + " found%s\n", books.size(), books.size() > 1 ? "s" : "", books.size() > 0 ? ":" : "." );
    for (Book book : books){
        System.out.printf("\tTitle: %s\n\tGenre: %s\n\tAuthor: %s\n\t---\n", book.getTitle(), book.getGenre(), book.getAuthor());
    }
    System.out.println();
}

public void checkOutBook(String isbn){
    Book book = bookRepo.findByIsbn(isbn);
    if (book != null) {
        if (book.checkedOut()) {
            System.out.print("\nCheck out successful.");
            System.out.printf("\n\tISBN: %s\n\tTitle: %s\n\tAuthor: %s\n\t---\n", book.getIsbn(), book.getTitle(), book.getAuthor());
        }
        else{
            System.out.print("Check out failed.");
            System.out.printf("\n\tISBN: %s\n\tTitle: %s\n\tAuthor: %s\n\t---\n", book.getIsbn(), book.getTitle(), book.getAuthor());
            System.out.print("\nReason: More books checked out than recorded quantity.");
        }
    }
    else {
        System.out.printf("\nFailed to check out book.");
        System.out.printf("\nThere is not a book with that ISBN %s on record.\n", isbn);
    }
    System.out.println();

}

    public void checkInBook(String isbn){
        Book book = bookRepo.findByIsbn(isbn);
        if (book != null){
            book.checkedIn();
            System.out.print("\nBook checked in successfully.");
            System.out.printf("\n\tISBN: %s\n\tTitle: %s\n\tAuthor: %s\n\t---\n",book.getIsbn(), book.getTitle(), book.getAuthor());
        }
        else {
            System.out.printf("\nFailed to check in book.");
            System.out.printf("\nThere is not a book with that ISBN %s on record.\n", isbn);
        }
        System.out.println();

    }



}
