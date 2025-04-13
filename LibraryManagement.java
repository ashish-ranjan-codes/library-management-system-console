import java.util.Scanner;

public class LibraryManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Library library = new Library();
        int choice;

        do{
            System.out.println("\n---- Library Menu ----");
            System.out.println("1. Add a Book");
            System.out.println("2. Display Books");
            System.out.println("0. Exit");
            System.out.print("\nEnter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1:{
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    Book book = new Book(id, title, author);
                    library.addBook(book);
                    break;
                }
                case 2:{
                    library.displayBooks();
                    break;
                }
                case 0:{
                    System.out.println("Exited...!");
                    break;
                }
                default: System.out.println("Invalid choice.");
            }
        }while(choice!=0);

        sc.close();
    }
}
