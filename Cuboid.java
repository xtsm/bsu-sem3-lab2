package Shapes;

class Cuboid extends Shape3D {
  public Cuboid(double newA, double newB, double newC) {
    a = newA;
    b = newB;
    c = newC;
  }
  public double getVolume() {
    return a * b * c;
  }
  private double a, b, c;
}
