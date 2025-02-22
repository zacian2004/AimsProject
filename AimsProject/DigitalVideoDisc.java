package AimsProject;
public class DigitalVideoDisc extends Disc implements Playable{

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, cost, length, director);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public DigitalVideoDisc(String title) {
        super(title);
    }

    public boolean isMatchTitle(String titlePara) {
        return getTitle() == titlePara;
    }

    public boolean isMatchID(int idPara) {
        return getID() == idPara;
    }

    public void play(){
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj)   
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        DigitalVideoDisc disc = (DigitalVideoDisc) obj;
        return getTitle().equals(disc.getTitle());
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
}