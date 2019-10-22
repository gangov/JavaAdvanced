package LibraryLab;

import BookLab.Book;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Book one", 12);
        Book book2 = new Book("Book two", 13, "Author");
        Book book3 = new Book("Book three", 1555, "third author baby");

        Library<Book> library = new Library<>();

        Library<Book> library2 = new Library<>(book1);
        Library<Book> library3 = new Library<>(book1, book2, book3);

        for (Book book : library3) {
            System.out.println(book.getTitle());
        }
    }
}
