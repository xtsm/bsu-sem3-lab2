package lab2.shapes.plump;

public class Ball extends Shape3D {
  private double r;

  public Ball(double newR) {
    r = newR;
  }

  public double getVolume() {
    return (4.0 / 3) * Math.PI * Math.pow(r, 3);
  }
}
