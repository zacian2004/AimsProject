package AimsProject;
import java.util.ArrayList;
import java.util.List;
public class Book extends Media{
    private List<String> authors = new ArrayList<String>();
    public Book(String title, String category, float cost){
        super(title, category, cost);
    }

    public void addAuthor(String... authorName){
        for (String x : authorName){
            if (this.authors.contains(x)){
                System.out.println("Author " + x + " has already exist in the book " + this.getTitle() + "\n");
            } else {
                this.authors.add(x);
                System.out.println("Successfully added author " + x + " into the book " + this.getTitle() + "\n");
            }
        }
    }

    public void removeAuthor(String... authorName){
        for (String x : authorName){
            if (this.authors.contains(x)){
                this.authors.remove(x);
                System.out.println("Successfully removed author " + x + " from the book " + this.getTitle() + "\n");
            } else {
                System.out.println("Author " + x + " has not exist in the book " + this.getTitle() + "yet\n");
            }
        }
    }

    public List<String> getAuthor(){
        return authors;
    }

    @Override
    public void printToString() {
        System.out.print(getID() + " "
                            + getTitle() + " - "
                            + getCategory() + " - ");
        for (String x : getAuthor()){
            System.out.print(x);
        }
        System.out.println(getCost() + " $\n");
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj)   
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Book book = (Book) obj;
        return getTitle().equals(book.getTitle());
    }
}