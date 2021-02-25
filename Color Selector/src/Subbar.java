import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.image.BufferedImage;
import java.awt.*; //For graphics
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Subbar extends JPanel{
    private BufferedImage mImage;
    private ColorDisplay colors;

    private JTextField red;
    private JTextField green;
    private JTextField blue;

    private JTextField dimension;

    public Subbar(ColorDisplay colors){
        this.colors = colors;

        setLayout(new FlowLayout());

        red = new JTextField("000");
        red.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //colors.set(red.getText(), "Red");
            }
          });
        add(red);

        green = new JTextField("000");
        green.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //screen.modify(green.getText(), "Green");
            }
          });
        add(green);

        blue = new JTextField("000");
        blue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //screen.modify(blue.getText(), "Blue");
            }
          });
        add(blue);
        
        JLabel label = new JLabel("", JLabel.CENTER);
        label.setFont(new Font("Karla", Font.PLAIN, 15));
        label.setForeground(Color.WHITE);
        add(label);

        JButton button = new JButton("Random");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                colors.setRandom();
            }
          });
        add(button);

        dimension = new JTextField(colors.colors.resolution);
        dimension.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                colors.setResolution(dimension.getText());
            }
          });
        add(dimension);
    }

     @Override
    public void paintComponent(Graphics g){ 
        draw();
        g.drawImage(mImage,0,0,getWidth(),getHeight(),null);
    }

    public void draw(){
        mImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);     
        Graphics g = mImage.getGraphics();  

        g.setColor(new Color(38, 39, 33));
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    public void update(CustomColor c){
        red.setText("" + c.red);
        green.setText("" + c.green);
        blue.setText("" + c.blue);
    }
}