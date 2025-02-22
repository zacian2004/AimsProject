package AimsProject;

import java.util.Collections;

public class CartTest {
    public static void main(String[] args) {
        //Create a new cart
        Cart cart = new Cart();

        //Create new dvd objects and add them to the cart 
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 30.95f);
        cart.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 48.99f);
        cart.addMedia(dvd3);
        
        //Test the sorting
        Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_TITLE_COST);

        //Test the print method 
        cart.print();
        
        //To-do: Test the search methods here
        
        cart.searchByTitle("Ala");
        cart.searchByTitle("Aladdin");
        cart.searchByID(2);
        cart.searchByID(4);
    }
}