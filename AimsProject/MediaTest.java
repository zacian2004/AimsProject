package AimsProject;

import java.util.ArrayList;
import java.util.List;

public class MediaTest{
    public static void main(String args[]){
        List<Media> mediae = new ArrayList<Media>();

        CompactDisc cd = new CompactDisc(null, null, 0, 0, null, null);
        DigitalVideoDisc dvd = new DigitalVideoDisc(null);
        Book book = new Book(null, null, 0);

        mediae.add(cd);
        mediae.add(dvd);
        mediae.add(book);

        for (Media m : mediae){
            System.out.println(m.toString());
        }
    }
}