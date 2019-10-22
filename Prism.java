package lab2.shapes.plump;
import lab2.shapes.flat.Shape2D;

public class Prism extends Shape3D {
  private Shape2D base;

  private double h;

  public Prism(Shape2D newBase, double newH) {
    base = newBase;
    h = newH;
  }

  public double getVolume() {
    return base.getArea() * h;
  }
}
