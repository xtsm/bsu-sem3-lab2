package lab2.shapes.flat;

public class Circle extends Shape2D {
  private double r;

  public Circle(double newR) {
    r = newR;
  }

  public double getArea() {
    return Math.PI * Math.pow(r, 2);
  }
}
