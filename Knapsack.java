package Shapes;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.AbstractListModel;

class Knapsack extends AbstractListModel<Shape3D> implements Serializable {
  public Knapsack(double newVolume) {
    volume = newVolume;
    content = new ArrayList<Shape3D>();
  }
  public void Put(Shape3D shape) throws KnapsackFullException {
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
  public void Remove(int index) {
    content.remove(index);
    fireIntervalRemoved(this, index, index);
  }
  public Shape3D getElementAt(int index) {
    return content.get(index);
  }
  public int getSize() {
    return content.size();
  }
  private List<Shape3D> content;
  private double volume;
}
