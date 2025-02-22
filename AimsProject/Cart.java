package AimsProject;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class Cart {
    public static final int MAX_NUMBER_ORDERED = 20;
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public int qtyOrdered() {
        return itemsOrdered.size();
    }

    public ObservableList<Media> getItemsOrdered(){
        return itemsOrdered;
    }

    public void addMedia(Media... mediaLists){
        for (Media x : mediaLists) {
            //check if the disc exist in the cart
            if (itemsOrdered.contains(x)) {
                System.out.println("The item " + x.getTitle() + " has already been added\n");
                continue;
            }
            //check if the cart is full
            if (qtyOrdered() == MAX_NUMBER_ORDERED) {
                System.out.println("The cart is full\n");
                return;
            }
            itemsOrdered.add(x);
            System.out.println("Successfully added the item " + x.getTitle() + " \n");
        }
        //check if the cart is almost full
        if (qtyOrdered() >= MAX_NUMBER_ORDERED * 3 / 4) {
            System.out.println("The cart is almost full\n");
        }
    }

    public void removeMedia(Media m) {
        if (itemsOrdered.remove(m)){
            System.out.println("Successfully removed " + m.getTitle() + " \n");
        } else {
            System.out.println("The item " + m.getTitle() + " has not exist in the cart\n");
        }
    }

    public float totalCost() {
        float x = 0;
        for (Media m : itemsOrdered) {
            x += m.getCost();
        }
        return x;
    }

    public void print() {
        System.out.println("***********************CART***********************\n");
        System.out.println("Ordered Items:\n");
        for (Media x : itemsOrdered){
            x.printToString();
        }
        System.out.println("Total cost: " + totalCost() + "\n");
        System.out.println("***************************************************\n");
    }

    public void searchByID(int idPara) {
        boolean found = false;
        for (Media i : itemsOrdered){
            if (i.getID() == idPara){
                i.printToString();
                found = true;
            }
        }
        if (found == false){
            System.out.println("No match found\n");
        }
    }

    public void searchByTitle(String titlePara) {
        boolean found = false;
        for (Media i : itemsOrdered){
            if (i.getTitle().equals(titlePara)){
                i.printToString();
                found = true;
            }
        }
        if (found == false){
            System.out.println("No match found\n");
        }
    }
    public boolean isFound(String titlePara) {
        boolean found = false;
        for (Media i : itemsOrdered){
            if (i.getTitle().equals(titlePara)){
                found = true;
            }
        }
        return found;
    }

    public Media fetchItem(String titlePara) {
        for (Media i : itemsOrdered){
            if (i.getTitle().equals(titlePara)){
                i.printToString();
                return i;
            }
        }
        return null;
    }
}

