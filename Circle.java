package Shapes;

class Circle extends Shape2D {
  public Circle(double newR) {
    r = newR;
  }
  public double getArea() {
    return Math.PI * Math.pow(r, 2);
  }
  private double r;
}
