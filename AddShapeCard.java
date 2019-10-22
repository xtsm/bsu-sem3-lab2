package lab2.gui.dialog.addshape;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import lab2.shapes.plump.Shape3D;

abstract class AddShapeCard extends JPanel {
  public abstract String getTitle();

  public abstract Shape3D getValue();
}
