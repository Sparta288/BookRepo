package libapp;


import java.util.InputMismatchException;
import java.util.Scanner;



public class Main {


    public static void main(String[] args) {

        LibraryApp app = new LibraryApp();
        Scanner sc = new Scanner(System.in);
        boolean invalidEntry = true;
        int option = 0;
        try {

            do {

                System.out.print("\nSearch for books from the library.\n");
                System.out.print("\n1. Title: ");
                System.out.print("\n2. Author: ");
                System.out.print("\n3. ISBN: ");
                System.out.print("\n4. Exit ");
                System.out.print("\n Choose a search method: ");
                option = sc.nextInt();


                if (option == 1) {
                    invalidEntry = false;
                    System.out.print("\nTitle: ");
                    String title = sc.next();
                    app.searchByTitle(title.toLowerCase());
                }

                if (option == 2) {
                    invalidEntry = false;
                    System.out.print("\nAuthor: ");
                    String author = sc.next();
                    app.searchByAuthor(author.toLowerCase());
                    sc.nextLine();
                }
                if (option == 3) {
                    System.out.print("\n5. Check out: ");
                    System.out.print("\n6. Check in: ");
                    System.out.print("\nChoose option '5' or '6': ");
                    int checkChoice = sc.nextInt();
                    if (checkChoice == 5) {
                        System.out.print("ISBN: ");
                        String isbn = sc.next();
                        app.checkOutBook(isbn.toLowerCase());
                    }
                    if (checkChoice == 6) {
                        System.out.print("ISBN: ");
                        String isbn = sc.next();
                        app.checkInBook(isbn.toLowerCase());
                    }
                }
                if (option == 4){
                    System.out.print("\nGoodbye!");
                }

                else if (option != 1) {
                    System.out.print("\nInvalid Entry.");
                }


            } while (option != 4);

        } catch (InputMismatchException e) {
            invalidEntry = false;
            System.out.print("\nInvalid Entry...");


        }
    }
}






