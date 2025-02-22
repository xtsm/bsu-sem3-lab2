package lab2.gui.dialog.addshape;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import lab2.shapes.plump.Ball;
import lab2.shapes.plump.Shape3D;

class AddBallCard extends AddShapeCard {
  private JTextField size;

  public AddBallCard() {
    this.setLayout(new GridLayout(1, 2));
    
    this.add(new JLabel("Radius:"));
    size = new JTextField();
    this.add(size);
  }

  public String getTitle() {
    return "Ball";
  }

  public Shape3D getValue() {
    double a;
    try {
      a = Double.parseDouble(size.getText());
    } catch (NumberFormatException e) {
      JOptionPane.showMessageDialog(this, "Radius value is invalid", "Error", JOptionPane.ERROR_MESSAGE);
      return null;
    }
    return new Ball(a);
  }
}
