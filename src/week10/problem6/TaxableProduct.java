public class TaxableProduct extends Product implements Taxable {
    
    public TaxableProduct(String name, double price) {
        super(name, price);
    }
    public double calculateTax() {
        return getPrice() * TAX_RATE;
    }
    public void print() {
        super.print();
        double tax = calculateTax();
        double total = getPrice() + tax;
        System.out.println("  Tax: $" + tax + ", Total: $" + total);
    }
}
