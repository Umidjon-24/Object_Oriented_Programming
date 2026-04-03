public class ShapeDemo {
    
    public static Shape findLargest(Shape[] shapes) {
        Shape largest = shapes[0];
        for (int i = 1; i < shapes.length; i++) {
            if (shapes[i].getArea() > largest.getArea()) {
                largest = shapes[i];
            }
        }
        return largest;
    } 
    public static void main(String[] args) {
        Shape[] shapes = new Shape[6];
        shapes[0] = new Circle("Red", 5);
        shapes[1] = new Circle("Blue", 3);
        shapes[2] = new Rectangle("Green", 4, 6);
        shapes[3] = new Rectangle("Yellow", 5, 5);
        shapes[4] = new Triangle("Purple", 3, 4, 5);
        shapes[5] = new Triangle("Orange", 6, 8, 10); 
        System.out.println("All shapes:");
        for (Shape shape : shapes) {
            shape.displayInfo();
        } 
        System.out.println("\nLargest shape:");
        Shape largest = findLargest(shapes);
        largest.displayInfo(); 
        double totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.getArea();
        }
        System.out.println("\nTotal combined area: " + totalArea);
    }
}
