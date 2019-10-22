package lab2.gui.dialog.addshape;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import lab2.shapes.plump.Cube;
import lab2.shapes.plump.Shape3D;

class AddCubeCard extends AddShapeCard {
  private JTextField size;
  
  public AddCubeCard() {
    this.setLayout(new GridLayout(1, 2));
    
    this.add(new JLabel("Size:"));
    size = new JTextField();
    this.add(size);
  }
  
  public String getTitle() {
    return "Cube";
  }
  
  public Shape3D getValue() {
    double a;
    try {
      a = Double.parseDouble(size.getText());
    } catch (NumberFormatException e) {
      JOptionPane.showMessageDialog(this, "Size value is invalid", "Error", JOptionPane.ERROR_MESSAGE);
      return null;
    }
    return new Cube(a);
  }
}
