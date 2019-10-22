package lab2.shapes.plump;

public class Cuboid extends Shape3D {
  private double a, b, c;

  public Cuboid(double newA, double newB, double newC) {
    a = newA;
    b = newB;
    c = newC;
  }

  public double getVolume() {
    return a * b * c;
  }
}
