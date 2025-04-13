import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;

    public Library(){
        books = new ArrayList<>();
    }

    //Adding book
    public void addBook(Book book){
        books.add(book);
        System.out.println("Book added successfully!");
    }

    //display book
    public void displayBooks(){
        if(books.isEmpty()){
            System.out.println("No book in the Library!");
        }
        for(Book book: books){
            System.out.println(book);
        }
    }

    //search book by title
    public void searchBookByTitle(String title){
        boolean found = false;
        for(Book book: books){
            if(book.getTitle().equalsIgnoreCase(title)){
                System.out.println(book);
                found = true;
            }
        }
        if(!found){
            System.out.println("Book not found with title: " + title);
        }
    }

    //issue book
    public void issueBook(int id){
        for(Book book: books){
            if(book.getId() == id){
                if(book.isAvaialble()){
                    book.setAvailable(false);
                    System.out.println("Book issued successfully!");
                }else{
                    System.out.println("Book is already issued.");
                }
            }
            return;
        }
        System.out.println("Book not found with ID: " + id);
    }

    //return book
    public void returnBook(int id){
        for(Book book: books){
            if(book.getId() == id){
                if(!book.isAvaialble()){
                    book.setAvailable(true);
                    System.out.println("Book returned successfully.");
                }else{
                    System.out.println("Book was not issued.");
                }
            }
        }
    }
}
