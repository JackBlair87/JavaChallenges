import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.awt.*; //For graphics

public class Subheader extends JPanel{
    private static final long serialVersionUID = -6812699994428865518L;
    private BufferedImage mImage;

    private JLabel red;
    private JLabel green;
    private JLabel blue;

    private JLabel hue;
    private JLabel saturation;
    private JLabel lightness;

    private JLabel hex;

    private JLabel labelHex;
    private JLabel labelRGB;
    private JLabel labelHSL;

    public Subheader() {
        labelRGB = new JLabel("RGB", JLabel.CENTER);
        labelRGB.setFont(new Font("Karla", Font.PLAIN, 12));
        labelRGB.setForeground(Color.GRAY);
        add(labelRGB);

        red = new JLabel("", JLabel.CENTER);
        red.setFont(new Font("Karla", Font.PLAIN, 15));
        red.setForeground(new Color(255, 100, 100));
        add(red);

        green = new JLabel("", JLabel.CENTER);
        green.setFont(new Font("Karla", Font.PLAIN, 15));
        green.setForeground(new Color(100, 255, 100));
        add(green);

        blue = new JLabel("", JLabel.CENTER);
        blue.setFont(new Font("Karla", Font.PLAIN, 15));
        blue.setForeground(new Color(100, 100, 255));
        add(blue);

        labelHex = new JLabel("HEX", JLabel.CENTER);
        labelHex.setFont(new Font("Karla", Font.PLAIN, 12));
        labelHex.setForeground(Color.GRAY);
        add(labelHex);

        hex = new JLabel("", JLabel.CENTER);
        hex.setFont(new Font("Karla", Font.PLAIN, 15));
        hex.setForeground(Color.WHITE);
        add(hex);

        labelHSL = new JLabel("HSL", JLabel.CENTER);
        labelHSL.setFont(new Font("Karla", Font.PLAIN, 12));
        labelHSL.setForeground(Color.GRAY);
        add(labelHSL);

        hue = new JLabel("", JLabel.CENTER);
        hue.setFont(new Font("Karla", Font.PLAIN, 15));
        hue.setForeground(new Color(203, 118, 64));
        add(hue);

        saturation = new JLabel("", JLabel.CENTER);
        saturation.setFont(new Font("Karla", Font.PLAIN, 15));
        saturation.setForeground(new Color(129, 235, 203));
        add(saturation);

        lightness = new JLabel("", JLabel.CENTER);
        lightness.setFont(new Font("Karla", Font.PLAIN, 15));
        lightness.setForeground(new Color(204, 57, 202));
        add(lightness);
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
        red.setText(""+c.red);
        green.setText(""+c.green);
        blue.setText(""+c.blue);

        hex.setText(c.hex);

        hue.setText(""+c.hue);
        saturation.setText(""+c.saturation);
        lightness.setText(""+c.lightness);
    }
}