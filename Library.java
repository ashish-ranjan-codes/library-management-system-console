import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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

    //load data from file
    public void loadFromFile(String filename){
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while((line = br.readLine()) != null){
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String title = parts[1];
                String author = parts[2];
                boolean isAvaialble = Boolean.parseBoolean(parts[3]);

                Book book = new Book(id, title, author);
                book.setAvailable(isAvaialble);
                books.add(book);
            }
            System.out.println("Library data loaded from file.");
        } catch(IOException e){
            System.out.println("Error loading files: " + e.getMessage());
        }
    }

    //save data to file
    public void saveToFile(String filename){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))){
            for(Book book: books){
                bw.write(book.getId() + ", " + book.getTitle() + ", " + book.getAuthor() + ", "
                + book.isAvaialble());
                bw.newLine();
            }
            System.out.println("Library data saved to file.");
        } catch(IOException e){
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}
