package Shapes;
import java.util.TreeSet;

class Knapsack {
  public Knapsack(double newVolume) {
    volume = newVolume;
    content = new TreeSet<Shape3D>();
  }
  public void Put(Shape3D shape) throws KnapsackFullException {
    double shapeVolume = shape.getVolume();
    if (volume < shapeVolume) {
      throw new KnapsackFullException(volume, shapeVolume);
    }
    volume -= shapeVolume;
    content.add(shape);
  }
  private TreeSet<Shape3D> content;
  private double volume;
}
