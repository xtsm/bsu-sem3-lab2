package lab2.shapes.plump;
import java.io.Serializable;

abstract public class Shape3D implements Comparable<Shape3D>, Serializable {
  public abstract double getVolume();

  public int compareTo(Shape3D rhs) {
    return Double.valueOf(getVolume()).compareTo(Double.valueOf(rhs.getVolume()));
  }

  public String toString() {
    return this.getClass().getName() + ", volume " + getVolume();
  }
}
