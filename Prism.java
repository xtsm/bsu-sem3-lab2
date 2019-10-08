package Shapes;

class Prism extends Shape3D {
  public Prism(Shape2D newBase, double newH) {
    base = newBase;
    h = newH;
  }
  public double getVolume() {
    return base.getArea() * h;
  }
  private Shape2D base;
  private double h;
}
