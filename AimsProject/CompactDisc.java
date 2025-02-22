package AimsProject;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();

    public String getArtist(){
        return this.artist;
    }

    public void setArtist(String s){
        this.artist = s;
    }

    public CompactDisc(String title, String category, float cost, int length, String director, String artist){
        super(title, category, cost, length, director);
        this.setArtist(artist);
    }

    public void addTrack(Track... trackLists){
        for(Track x : trackLists){
            if(tracks.contains(x)){
                System.out.println("The track " + x.getTitle() + " has already exist in the disc\n");
                continue;
            }
            tracks.add(x);
            System.out.println("Successfully added the disc " + x.getTitle() + " to the disc\n");
        }
    }

    public void removeTrack(Track t){
        if (tracks.remove(t)){
            System.out.println("Successfully removed the track " + t.getTitle() + " from the disc\n");
        } else {
            System.out.println("The track " + t.getTitle() + " has not exist in the disc\n");
        }
    }

    public int getLength(){
        int i = 0;
        for (Track x : tracks){
            i += x.getLength();
        }
        return i;
    }

    @Override
    public void printToString() {
        System.out.println(getID() + " "
                            + getTitle() + " - "
                            + getCategory() + " - "
                            + getLength() + " s - "
                            + getDirector() + " : "
                            + getCost() + " $\n");
    }

    public void play(){
        System.out.println("CD name: " + this.getTitle() + "\n");
        System.out.println("Artist: " + this.getArtist() + "\n");
        for(Track x : tracks){
            x.play();
        }
    }
}