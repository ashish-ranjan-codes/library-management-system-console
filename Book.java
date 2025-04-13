public class Book{
    private int id;
    private String title;
    private String author;
    private boolean isAvaialble;

    //constructor
    public Book(int id, String title, String author){
        this.id = id;
        this.title = title;
        this.author = author;
        this.isAvaialble = true;
    }

    //Getters
    public int getId(){
        return id;
    }
    public String title(){
        return title;
    }
    public String author(){
        return author;
    }
    public boolean isAvaialble(){
        return isAvaialble;
    }

    //Setter
    public void setAvailable(boolean available){
        isAvaialble = available;
    }

    @Override
    public String toString(){
        return "ID: " + id + ", Title: " + title + ", Author: " + author + 
        ", Available: " + (isAvaialble ? "Yes" : "No");
    }
}