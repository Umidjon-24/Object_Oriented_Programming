public class Product implements Printable {
    private String name;
    private double price; 
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    } 
    public double getPrice() {
        return price;
    }
    public void print() {
        System.out.println("Product: " + name + ", Price: $" + price);
    }
}
