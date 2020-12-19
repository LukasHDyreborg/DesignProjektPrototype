import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// vi implamentere ActionListener Interface
public class GUI implements ActionListener {

    // vi instanciere en række af components som skal bruges til  udregning
    private JFrame frame = new JFrame();
    private JTextField textInside = new JTextField();
    private JTextField textOutside = new JTextField();
    private JTextField textExtra = new JTextField();
    private JTextField textShrink = new JTextField();
    private JLabel calculateInside = new JLabel("Inside: ??");
    private JLabel calculateOutside = new JLabel("Outside: ??");

    // constructor
    public GUI() {

        // vi sætter frame location til null for at den starter midt på skærmen og ikke oppe i venstre hjørne
        frame.setLocationRelativeTo(null);

        // vi instanciere et panel og benytter Grid bag layout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // vi har sat border på vinduet
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        // vi skaber 4 labels
        JLabel labelInside = new JLabel("Inside: ");
        JLabel labelOutside = new JLabel("Outside: ");
        JLabel labelExtra = new JLabel("Extra: ");
        JLabel labelShrink = new JLabel("Shrink: ");

        // Insætter labels via gridBagConstraints
        c.gridx=0;
        c.gridy=0;
        panel.add(labelInside, c);

        c.gridy=1;
        panel.add(labelOutside, c);

        c.gridy=2;
        panel.add(labelExtra, c);

        c.gridy=3;
        panel.add(labelShrink, c);

        // Insætter textfields via gridBagConstraints
        c.gridx=1;
        c.gridy=0;
        c.ipadx=25;
        panel.add(textInside, c);

        c.gridy=1;
        panel.add(textOutside, c);

        c.gridy=2;
        panel.add(textExtra, c);

        c.gridy=3;
        panel.add(textShrink, c);

        // Vi skaber en knap og tilføjer action listener
        JButton button = new JButton("Calculate");
        button.addActionListener(this);

        // tilføjer knappen via gridBagConstraints
        c.gridx=3;
        c.gridy=4;
        panel.add(button, c);

        // tilføjer 2 labels via gridBagConstraints
        c.gridx=3;
        c.gridy=0;
        panel.add(calculateInside, c);
        c.gridx=3;
        c.gridy=1;
        panel.add(calculateOutside, c);

        // vi tilføjer panel til frame
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Prototype");
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int extra = Integer.parseInt(textExtra.getText());

        double shrink = (Double.parseDouble(textShrink.getText())/100);

        double inside = (Double.parseDouble(textInside.getText()) - extra) - ((Double.parseDouble(textInside.getText()) - extra) * shrink);

        double outside = (Double.parseDouble(textOutside.getText()) + extra) + ((Double.parseDouble(textOutside.getText()) + extra) * shrink);
        
        calculateInside.setText("Inside: " + inside);
        calculateOutside.setText("Outside: " + outside);
    }
}
