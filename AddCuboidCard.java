package lab2.gui.dialog.addshape;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import lab2.shapes.plump.Cuboid;
import lab2.shapes.plump.Shape3D;

class AddCuboidCard extends AddShapeCard {
  private JTextField sizea, sizeb, sizec;

  public AddCuboidCard() {
    this.setLayout(new GridLayout(3, 2));
    
    this.add(new JLabel("Width:"));
    sizea = new JTextField();
    this.add(sizea);
    this.add(new JLabel("Height:"));
    sizeb = new JTextField();
    this.add(sizeb);
    this.add(new JLabel("Depth:"));
    sizec = new JTextField();
    this.add(sizec);
  }

  public String getTitle() {
    return "Cuboid";
  }

  public Shape3D getValue() {
    double a, b, c;
    try {
      a = Double.parseDouble(sizea.getText());
    } catch (NumberFormatException e) {
      JOptionPane.showMessageDialog(this, "Width value is invalid", "Error", JOptionPane.ERROR_MESSAGE);
      return null;
    }
    try {
      b = Double.parseDouble(sizeb.getText());
    } catch (NumberFormatException e) {
      JOptionPane.showMessageDialog(this, "Height value is invalid", "Error", JOptionPane.ERROR_MESSAGE);
      return null;
    }
    try {
      c = Double.parseDouble(sizec.getText());
    } catch (NumberFormatException e) {
      JOptionPane.showMessageDialog(this, "Depth value is invalid", "Error", JOptionPane.ERROR_MESSAGE);
      return null;
    }
    return new Cuboid(a, b, c);
  }
}
