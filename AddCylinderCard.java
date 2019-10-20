package Shapes;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class AddCylinderCard extends AddShapeCard {
  public String getTitle() {
    return "Cylinder";
  }
  public Shape3D getValue() {
    double a, h;
    try {
      a = Double.parseDouble(sizea.getText());
    } catch (NumberFormatException e) {
      JOptionPane.showMessageDialog(this, "Radius value is invalid", "Error", JOptionPane.ERROR_MESSAGE);
      return null;
    }
    try {
      h = Double.parseDouble(sizeh.getText());
    } catch (NumberFormatException e) {
      JOptionPane.showMessageDialog(this, "Height value is invalid", "Error", JOptionPane.ERROR_MESSAGE);
      return null;
    }
    return new Prism(new Circle(a), h);
  }
  public AddCylinderCard() {
    this.setLayout(new GridLayout(2, 2));
    
    this.add(new JLabel("Radius:"));
    sizea = new JTextField();
    this.add(sizea);
    this.add(new JLabel("Height:"));
    sizeh = new JTextField();
    this.add(sizeh);
  }
  private JTextField sizea, sizeh;
}
