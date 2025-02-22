package AimsProject;
public class Disc extends Media{
    private int length;
    private String director;

    public int getLength(){
        return this.length;
    }

    public void setLength(int i){
        this.length = i;
    }

    public String getDirector(){
        return this.director;
    }

    public void setDirector(String s){
        this.director = s;
    }

    public Disc(String title, String category, float cost, int length, String director){
        super(title, category, cost);
        this.setLength(length);
        this.setDirector(director);
    }

    public Disc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public Disc(String title) {
        super(title);
    }

    

}