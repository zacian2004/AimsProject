package AimsProject;
import java.util.ArrayList;
public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();
    public ArrayList<Media> getItemsInstore(){
        return itemsInStore;
    }

    public void addMedia(Media... discLists) {
        for (Media x : discLists) {
            //check if the disc exist in the store
            if (itemsInStore.contains(x)) {
                System.out.println("The disc " + x.getTitle() + " has already existed\n");
                return;
            }
            itemsInStore.add(x);
            System.out.println("Successfully added the disc " + x.getTitle() + "\n");
        }
    }

    public void print() {
        System.out.println("***********************STORE***********************\n");
        System.out.println("Items in store:\n");
        for (Media x : itemsInStore){
            x.printToString();
        }
    }

    public void removeMedia(Media... discLists) {
        for (Media x : discLists) {
            boolean found = false;
            //check if the disc exist in the store
            for (Media y : itemsInStore) {
                if (y.equals(x)) {
                    found = true;
                    itemsInStore.remove(y);
                    System.out.println("Successfully removed the disc " + y.getTitle() + "\n");
                    break;
                }
            }
            if (!found) System.out.println("The disc " + x.getTitle() + " has not existed\n");
        }
    }

    public boolean isFound(String titlePara) {
        boolean found = false;
        for (Media i : itemsInStore){
            if (i.getTitle().equals(titlePara)){
                found = true;
            }
        }
        return found;
    }

    public Media fetchItem(String titlePara) {
        for (Media i : itemsInStore){
            if (i.getTitle().equals(titlePara)){
                i.printToString();
                return i;
            }
        }
        return null;
    }
}