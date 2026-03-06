public class Product {
    protected String ProductID, name;
    protected double price;

    public Product(String ProductID, String name, double price){
        this.ProductID=ProductID;
        this.name=name;
        this.price=price;
    }
    public void displayProductDetails(){
        System.out.println(name+" has "+ProductID+" Product ID and costs "+price+"$");
    }
}

class Electronics extends Product{
    private int warranty;
    private String brand;
    public Electronics(String ProductID, String name, double price, int warranty, String brand){
        super(ProductID, name, price);
        this.warranty=warranty;
        this.brand=brand;
    }
    public String getWarrantyDetails(){
        return (name+" with "+brand+" brand has " +warranty+" year");
    }
}

class Clothing extends Product{
    private int size;
    private String color;

    public Clothing(String ProductID, String name, double price, int size, String color){
        super(ProductID, name, price);
        this.size=size;
        this.color=color;
    }
    public void checkSizeAvailability(){
        System.out.println(name +" has size "+ size+" and color "+color);
    }
}

class Book extends Product{
    private String author;
    private String ISBN;

    public Book(String ProductID, String name, double price, String author, String ISBN){
        super(ProductID, name, price);
        this.author=author;
        this.ISBN=ISBN;
    }

    public String getAuthorInfo(){
        return (author+"is the author of "+name);
    }
}
