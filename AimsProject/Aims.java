package AimsProject;
import java.util.Collections;
import java.util.Scanner;
public class Aims {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Store store = new Store();
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 120, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);

        Book book1 = new Book("The Catcher in the Rye", "Fiction", 10.99f);
        Book book2 = new Book("1984", "Dystopian", 12.99f);
        Book book3 = new Book("To Kill a Mockingbird", "Classic", 15.50f);

        CompactDisc cd1 = new CompactDisc("Thriller", "Pop", 25.00f, 10, "Quincy Jones", "Michael Jackson");
        CompactDisc cd2 = new CompactDisc("Back in Black", "Rock", 20.50f, 8, "Robert John Lange", "AC/DC");
        CompactDisc cd3 = new CompactDisc("The Dark Side of the Moon", "Rock", 30.00f, 11, "Alan Parsons", "Pink Floyd");

        store.addMedia(dvd1, dvd2, dvd3);
        store.addMedia(book1, book2, book3);
        store.addMedia(cd1, cd2, cd3);
        while(true){
            showMenu();
            String option1 = scanner.nextLine();
            if(option1.equals("0")){//Exit
                System.out.println("See you next time");
                return;
            } else if (option1.equals("1")){//View store
                store.print();
                while(true){
                    storeMenu();
                    String option2 = scanner.nextLine();
                    if(option2.equals("0")){//Back
                        break;
                    } else if (option2.equals("1")){//See media's detail
                        System.out.println("Which item do you want to choose?");
                        while(true){
                            String item = scanner.nextLine();
                            if (store.isFound(item)){
                                Media x = store.fetchItem(item);
                                mediaDetailsMenu();
                                while(true){
                                    String option3 = scanner.nextLine();
                                    if(option3.equals("0")){//Back
                                        break;
                                    } else if (option3.equals("1")){//Add to cart
                                        cart.addMedia(x);
                                        break;
                                    } else if (option3.equals("2")){//Play
                                        if(x instanceof DigitalVideoDisc){
                                            DigitalVideoDisc disc = (DigitalVideoDisc) x;
                                            disc.play();
                                            break;
                                        } else if (x instanceof CompactDisc){
                                            CompactDisc disc = (CompactDisc) x;
                                            disc.play();
                                            break;
                                        } else {
                                            System.out.println("This item cannot be played");
                                            break;
                                        }
                                    } else {
                                        System.out.println("Insufficient option. Try again");
                                    } 
                                }
                                break;
                            } else {
                                System.out.println("Item not found. Try again");
                            }
                        }
                    } else if (option2.equals("2")){//Add to cart
                        System.out.println("Which item do you want to add?");
                        while(true){
                            String item = scanner.nextLine();
                            if (store.isFound(item)){
                                Media x = store.fetchItem(item);
                                cart.addMedia(x);
                                System.out.println("Current quantity in the cart: " + cart.qtyOrdered());
                                break;
                            } else {
                                System.out.println("Item not found. Try again");
                            }
                        }
                    } else if (option2.equals("3")){//Play
                        System.out.println("Which item do you want to play?");
                        while(true){
                            String item = scanner.nextLine();
                            if (store.isFound(item)){
                                Media x = store.fetchItem(item);
                                if(x instanceof DigitalVideoDisc){
                                    DigitalVideoDisc disc = (DigitalVideoDisc) x;
                                    disc.play();
                                    break;
                                } else if (x instanceof CompactDisc){
                                    CompactDisc disc = (CompactDisc) x;
                                    disc.play();
                                    break;
                                } else {
                                    System.out.println("This item cannot be played");
                                    break;
                                }
                            } else {
                                System.out.println("Item not found. Try again");
                            }
                        }
                    } else if (option2.equals("4")){//See current cart
                        cart.print();
                        while(true){
                            cartMenu();
                            String option4 = scanner.nextLine();
                            if (option4.equals("0")){//Back
                                break;
                            } else if (option4.equals("1")){//Filter medias
                                System.out.println("Error: feature is not completed");
                                break;
                            } else if (option4.equals("2")){//Sort medias
                                System.out.println("Choose sorting option (1: by title or 2: by cost):");
                                while(true){
                                    String option5 = scanner.nextLine();
                                    if (option5.equals("1")){
                                        Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_TITLE_COST);
                                        cart.print();
                                        break;
                                    } else if (option5.equals("2")){
                                        Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_COST_TITLE);
                                        cart.print();
                                        break;
                                    } else {
                                        System.out.println("Insufficient option. Try again");
                                    }
                                }
                            } else if (option4.equals("3")){//Remove media
                                if (cart.qtyOrdered() == 0){
                                    System.out.println("The cart is empty");
                                } else {
                                    System.out.println("Which item do you want to remove?");
                                    while(true){
                                        String item = scanner.nextLine();
                                        if (cart.isFound(item)){
                                            Media x = store.fetchItem(item);
                                            cart.removeMedia(x);
                                            break;
                                        } else {
                                            System.out.println("Item not found. Try again");
                                        }
                                    }
                                }
                            } else if (option4.equals("4")){//Play a media
                                if (cart.qtyOrdered() == 0){
                                    System.out.println("The cart is empty");
                                } else {
                                    System.out.println("Which item do you want to play?");
                                    while(true){
                                        String item = scanner.nextLine();
                                        if (cart.isFound(item)){
                                            Media x = store.fetchItem(item);
                                            if(x instanceof DigitalVideoDisc){
                                                DigitalVideoDisc disc = (DigitalVideoDisc) x;
                                                disc.play();
                                                break;
                                            } else if (x instanceof CompactDisc){
                                                CompactDisc disc = (CompactDisc) x;
                                                disc.play();
                                                break;
                                            } else {
                                                System.out.println("This item cannot be played");
                                                break;
                                            }
                                        } else {
                                        System.out.println("Item not found. Try again");
                                        }
                                    }
                                }
                            } else {
                                System.out.println("Insufficient option. Try again");
                            }
                        }
                    } else {
                        System.out.println("Insufficient option. Try again");
                    }
                }
            } else if(option1.equals("2")){//Update store
                System.out.println("Error: feature is not completed");
            } else if(option1.equals("3")){//See current cart
                cart.print();
                while(true){
                    cartMenu();
                    String option4 = scanner.nextLine();
                    if (option4.equals("0")){//Back
                        break;
                    } else if (option4.equals("1")){//Filter medias
                        System.out.println("Error: feature is not completed");
                    } else if (option4.equals("2")){//Sort medias
                        System.out.println("Choose sorting option (1: by title or 2: by cost):");
                        while(true){
                            String option5 = scanner.nextLine();
                            if (option5.equals("1")){
                                Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_TITLE_COST);
                                cart.print();
                                break;
                            } else if (option5.equals("2")){
                                Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_COST_TITLE);
                                cart.print();
                                break;
                            } else {
                                System.out.println("Insufficient option. Try again");
                            }
                        }
                    } else if (option4.equals("3")){//Remove media
                        if (cart.qtyOrdered() == 0){
                            System.out.println("The cart is empty");
                        } else {
                            System.out.println("Which item do you want to remove?");
                            while(true){
                                String item = scanner.nextLine();
                                if (cart.isFound(item)){
                                    Media x = store.fetchItem(item);
                                    cart.removeMedia(x);
                                    break;
                                } else {
                                    System.out.println("Item not found. Try again");
                                }
                            }
                        }
                    } else if (option4.equals("4")){//Play a media
                        if (cart.qtyOrdered() == 0){
                            System.out.println("The cart is empty");
                        } else {
                            System.out.println("Which item do you want to play?");
                            while(true){
                                String item = scanner.nextLine();
                                if (cart.isFound(item)){
                                    Media x = store.fetchItem(item);
                                    if(x instanceof DigitalVideoDisc){
                                            DigitalVideoDisc disc = (DigitalVideoDisc) x;
                                        disc.play();
                                        break;
                                    } else if (x instanceof CompactDisc){
                                        CompactDisc disc = (CompactDisc) x;
                                        disc.play();
                                        break;
                                    } else {
                                        System.out.println("This item cannot be played");
                                        break;
                                    }
                                } else {
                                System.out.println("Item not found. Try again");
                                }
                            }
                        }
                    } else {
                        System.out.println("Insufficient option. Try again");
                    }
                }
            }
            else {
                System.out.println("Insufficient option. Try again");
            }
        }
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }
}
