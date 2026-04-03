public class DigitalProduct extends TaxableProduct {
    private String downloadUrl; 
    public DigitalProduct(String name, double price, String downloadUrl) {
        super(name, price);
        this.downloadUrl = downloadUrl;
    }
    public void print() {
        super.print();
        System.out.println("Download URL: " + downloadUrl);
    }
}
