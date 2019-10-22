package lab2.knapsack;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.AbstractListModel;
import lab2.shapes.plump.Shape3D;

public class Knapsack extends AbstractListModel<Shape3D> implements Serializable {
  private List<Shape3D> content;

  private double volume;

  public Knapsack(double newVolume) {
    volume = newVolume;
    content = new ArrayList<Shape3D>();
  }

  public void put(Shape3D shape) throws KnapsackFullException {
    double shapeVolume = shape.getVolume();
    if (volume < shapeVolume) {
      throw new KnapsackFullException(volume, shapeVolume);
    }
    volume -= shapeVolume;
    int insertionPoint = Collections.binarySearch(content, shape);
    if (insertionPoint < 0) {
      insertionPoint = ~insertionPoint;
    }
    content.add(insertionPoint, shape);
    fireIntervalAdded(this, insertionPoint, insertionPoint);
  }

  public void remove(int index) {
    content.remove(index);
    fireIntervalRemoved(this, index, index);
  }

  public Shape3D getElementAt(int index) {
    return content.get(index);
  }

  public int getSize() {
    return content.size();
  }
}
