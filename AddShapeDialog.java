package lab2.gui.dialog.addshape;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import lab2.shapes.plump.Shape3D;

public class AddShapeDialog extends JDialog {
  private JPanel mainPanel;

  private JPanel cardPanel;

  private JComboBox<String> chooser;

  private Shape3D value;

  public AddShapeDialog(JFrame owner) {
    super(owner, "Add shape...", true);
    this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
    value = null;

    mainPanel = new JPanel();
    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

    chooser = new JComboBox<String>();
    chooser.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        CardLayout cl = (CardLayout) cardPanel.getLayout();
        cl.show(cardPanel, (String) chooser.getSelectedItem());
      }
    });
    mainPanel.add(chooser);

    cardPanel = new JPanel();
    cardPanel.setLayout(new CardLayout());

    AddShapeCard[] cards = {new AddCubeCard(), new AddCuboidCard(), new AddBallCard(), new AddCylinderCard()};
    for (AddShapeCard card : cards) {
      JPanel cardButtonPanel = new JPanel();
      cardButtonPanel.setLayout(new BoxLayout(cardButtonPanel, BoxLayout.Y_AXIS));
      cardButtonPanel.add(card);
      JButton submitButton = new JButton("Add");
      submitButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
          setValue(card.getValue());
        }
      });
      cardButtonPanel.add(submitButton);

      chooser.addItem(card.getTitle());
      cardPanel.add(cardButtonPanel, card.getTitle());
    }

    mainPanel.add(cardPanel);

    this.add(mainPanel);
    this.pack();
  }

  public void setValue(Shape3D shape) {
    value = shape;
    setVisible(false);
  }

  public Shape3D getValue() {
    return value;
  }
}
