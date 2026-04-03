public class Triangle extends Shape {
    private double sideA;
    private double sideB;
    private double sideC; 
    public Triangle(String color, double sideA, double sideB, double sideC) {
        super(color);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }
    public double getPerimeter() {
        return sideA + sideB + sideC;
    }
    public double getArea() {
        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }
}
