package Shapes;

class Ball extends Shape3D {
  public Ball(double newR) {
    r = newR;
  }
  public double getVolume() {
    return (4.0 / 3) * Math.PI * Math.pow(r, 3);
  }
  private double r;
}
