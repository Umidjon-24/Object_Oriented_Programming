public class Main {
    public static void main(String[] args) {
//        Flight myFlight = new Flight("AAA", "Tashkent", "1", "11");
//        myFlight.show();

//        SmartDevice myLight = new SmartDevice("Apple", true);
//        Hub<SmartDevice> homeHub = new Hub<>();
//        homeHub.storeDevice(myLight);
//        homeHub.getDevice();
//        homeHub.statusReport();
//
//        homeHub = null;
//        System.out.print(myLight);

        Professor professor = new Professor("Pinto");
        Book book = new Book("Maths", "Someone");
        LibrarySystem Library = new LibrarySystem();
        Library.checkout(professor, book);

    }
}
