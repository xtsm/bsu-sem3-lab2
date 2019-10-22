package lab2.gui;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import lab2.gui.dialog.addshape.AddShapeDialog;
import lab2.shapes.plump.Shape3D;
import lab2.knapsack.Knapsack;
import lab2.knapsack.KnapsackFullException;

public class MainFrame extends JFrame {
  private JPanel mainPanel;

  private JList<Shape3D> itemsList;

  private Knapsack knapsack;

  public MainFrame() {
    super("Shapes");
    this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    mainPanel = new JPanel();
    mainPanel.setLayout(new GridBagLayout());
    GridBagConstraints gridConfig = new GridBagConstraints();
    gridConfig.fill = GridBagConstraints.BOTH;
    gridConfig.weightx = 1;
    gridConfig.weighty = 1;
    gridConfig.insets = new Insets(5, 5, 5, 5);

    knapsack = new Knapsack(100);
    itemsList = new JList<Shape3D>(knapsack);
    itemsList.setBorder(BorderFactory.createEtchedBorder());
    gridConfig.gridwidth = 1;
    gridConfig.gridheight = GridBagConstraints.REMAINDER;
    mainPanel.add(itemsList, gridConfig);

    JButton addButton = new JButton("Add shape");
    addButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        AddShapeDialog dialog = new AddShapeDialog(MainFrame.this);
        dialog.setLocationRelativeTo(MainFrame.this);
        dialog.setVisible(true);
        Object result = dialog.getValue();
        if (result instanceof Shape3D) {
          try {
            knapsack.put((Shape3D) result);
          } catch (KnapsackFullException e) {
            JOptionPane.showMessageDialog(MainFrame.this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
          }
        }
      }
    });
    gridConfig.gridheight = 1;
    mainPanel.add(addButton, gridConfig);

    JButton deleteButton = new JButton("Delete shape");
    deleteButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        int index = itemsList.getSelectedIndex();
        if (index < 0) {
          return;
        }
        knapsack.remove(index);
      }
    });
    mainPanel.add(deleteButton, gridConfig);
    
    JButton saveButton = new JButton("Save");
    saveButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        JFileChooser chooser = new JFileChooser();
        int ret = chooser.showOpenDialog(MainFrame.this);
        if (ret == JFileChooser.APPROVE_OPTION) {
          try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(chooser.getSelectedFile()));
            out.writeObject(knapsack);
          } catch (Exception e) {
            JOptionPane.showMessageDialog(MainFrame.this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
          } 
        }
      }
    });
    mainPanel.add(saveButton, gridConfig);

    JButton loadButton = new JButton("Load");
    loadButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        JFileChooser chooser = new JFileChooser();
        int ret = chooser.showOpenDialog(MainFrame.this);
        if (ret == JFileChooser.APPROVE_OPTION) {
          try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(chooser.getSelectedFile()));
            knapsack = (Knapsack) in.readObject();
            itemsList.setModel(knapsack);
          } catch (Exception e) {
            JOptionPane.showMessageDialog(MainFrame.this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
          } 
        }
      }
    });
    mainPanel.add(loadButton, gridConfig);

    this.add(mainPanel);
    this.pack();
    this.setVisible(true);
  }
}
