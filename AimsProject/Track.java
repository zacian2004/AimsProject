package AimsProject;
public class Track implements Playable{
    private String title;
    private int length;

    public String getTitle(){
        return this.title;
    }

    public int getLength(){
        return this.length;
    }

    public void setTitle(String s){
        this.title = s;
    }

    public void setLength(int i){
        this.length = i;
    }

    public Track(String title, int length){
        this.setLength(length);
        this.setTitle(title);
    }

    public void play() {
        System.out.println("Now playing: " + this.getTitle() + "\n");
        System.out.println("Track's length: " + this.getLength() + "\n");
    }

    public boolean equals(Object obj){
        if (this == obj)   
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Track t = (Track) obj;
        return getTitle().equals(t.getTitle()) && getLength() == t.getLength();
    }
}