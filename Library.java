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
}
