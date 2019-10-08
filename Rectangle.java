package Shapes;

class Rectangle extends Shape2D {
  public Rectangle(double newA, double newB) {
    a = newA;
    b = newB;
  }
  public double getArea() {
    return a * b;
  }
  private double a, b;
}
