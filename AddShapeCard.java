package Shapes;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

abstract class AddShapeCard extends JPanel {
  public abstract String getTitle();
  public abstract Shape3D getValue();
}
