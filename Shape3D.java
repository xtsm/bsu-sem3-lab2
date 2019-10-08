package Shapes;

abstract class Shape3D implements Comparable<Shape3D> {
  public abstract double getVolume();
  public int compareTo(Shape3D rhs) {
    return Double.valueOf(getVolume()).compareTo(Double.valueOf(rhs.getVolume()));
  }
}
