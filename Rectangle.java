package lab2.shapes.flat;

public class Rectangle extends Shape2D {
  private double a, b;

  public Rectangle(double newA, double newB) {
    a = newA;
    b = newB;
  }

  public double getArea() {
    return a * b;
  }
}
