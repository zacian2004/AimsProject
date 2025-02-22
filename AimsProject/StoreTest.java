package AimsProject;
public class StoreTest {
    public static void main(String[] args) {
        //Create a new store
        Store store = new Store();

        //Create new dvd objects and add them to the store 
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
        new StoreScreen(store);
    }
}