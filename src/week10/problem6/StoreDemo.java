public class StoreDemo {
    public static void main(String[] args) {
        Printable[] items = new Printable[6];
        items[0] = new Product("Notebook", 5.99);
        items[1] = new Product("Pen", 1.50);
        items[2] = new TaxableProduct("Laptop", 999.99);
        items[3] = new TaxableProduct("Mouse", 25.00);
        items[4] = new DigitalProduct("E-book", 15.99, "https://example.com/ebook");
        items[5] = new DigitalProduct("Software", 49.99, "https://example.com/software");
        System.out.println("All items:");
        for (Printable item : items) {
            item.print();
            System.out.println();
        }
        double totalTax = 0;
        for (Printable item : items) {
            if (item instanceof Taxable) {
                totalTax += ((Taxable) item).calculateTax();
            }
        }
        System.out.println("Total tax collected: $" + totalTax);
    }
}
