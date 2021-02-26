import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.image.BufferedImage;
import java.awt.*; //For graphics
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Sidebar extends JPanel{
    private BufferedImage mImage;
    private ColorDisplay colors;

    private JTextField TLred;
    private JTextField TLgreen;
    private JTextField TLblue;

    private JTextField TRred;
    private JTextField TRgreen;
    private JTextField TRblue;

    private JTextField BLred;
    private JTextField BLgreen;
    private JTextField BLblue;

    private JTextField BRred;
    private JTextField BRgreen;
    private JTextField BRblue;

    private JTextField dimension;

    public Sidebar(ColorDisplay colors){
        this.colors = colors;
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(250, getHeight()));

        JLabel image = new JLabel(new ImageIcon("/Users/jackblair/Desktop/Code/Java/JavaChallenges/Color Selector/lib/images/ColorMatrix.icns"));
        add(image);

        JLabel text = new JLabel("RGB Matrix Generator");
        text.setFont(new Font("Karla", Font.PLAIN, 20));
        text.setForeground(Color.GRAY);
        add(text);

        JLabel label = new JLabel("Top Left Color RGB", JLabel.CENTER);
        label.setFont(new Font("Karla", Font.PLAIN, 15));
        label.setForeground(Color.WHITE);
        add(label);

        TLred = new JTextField(""+colors.getColor("tl").red);
        TLred.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                CustomColor newColor = colors.setColor("tl", TLred.getText(), "Red");
                update(newColor, "tl");
            }
          });
        add(TLred);

        TLgreen = new JTextField(""+colors.getColor("tl").green);
        TLgreen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                CustomColor newColor = colors.setColor("tl", TLgreen.getText(), "Green");
                update(newColor, "tl");
            }
          });
        add(TLgreen);

        TLblue = new JTextField(""+colors.getColor("tl").blue);
        TLblue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                CustomColor newColor = colors.setColor("tl", TLblue.getText(), "Blue");
                update(newColor, "tl");
            }
          });
        add(TLblue);
        //----------------------------------------------------------------
        label = new JLabel("Top Right Color RGB", JLabel.CENTER);
        label.setFont(new Font("Karla", Font.PLAIN, 15));
        label.setForeground(Color.WHITE);
        add(label);

        TRred = new JTextField(""+colors.getColor("tr").red);
        TRred.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                CustomColor newColor = colors.setColor("tr", TRred.getText(), "Red");
                update(newColor, "tr");
            }
          });
        add(TRred);

        TRgreen = new JTextField(""+colors.getColor("tr").green);
        TRgreen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                CustomColor newColor = colors.setColor("tr", TRgreen.getText(), "Green");
                update(newColor, "tr");
            }
          });
        add(TRgreen);

        TRblue = new JTextField(""+colors.getColor("tr").blue);
        TRblue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                CustomColor newColor = colors.setColor("tr", TRblue.getText(), "Blue");
                update(newColor, "tr");
            }
          });
        add(TRblue);
        //-------------------------------------------------------------
        label = new JLabel("Bottom Left Color RGB", JLabel.CENTER);
        label.setFont(new Font("Karla", Font.PLAIN, 15));
        label.setForeground(Color.WHITE);
        add(label);

        BLred = new JTextField(""+colors.getColor("bl").red);
        BLred.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                CustomColor newColor = colors.setColor("bl", BLred.getText(), "Red");
                update(newColor, "bl");
            }
          });
        add(BLred);

        BLgreen = new JTextField(""+colors.getColor("bl").green);
        BLgreen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                CustomColor newColor = colors.setColor("bl", BLgreen.getText(), "Green");
                update(newColor, "bl");
            }
          });
        add(BLgreen);

        BLblue = new JTextField(""+colors.getColor("bl").blue);
        BLblue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                CustomColor newColor = colors.setColor("bl", BLblue.getText(), "Blue");
                update(newColor, "bl");
            }
          });
        add(BLblue);
        //---------------------------------------------------------
        label = new JLabel("Bottom Right Color RGB", JLabel.CENTER);
        label.setFont(new Font("Karla", Font.PLAIN, 15));
        label.setForeground(Color.WHITE);
        add(label);

        BRred = new JTextField(""+colors.getColor("br").red);
        BRred.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                CustomColor newColor = colors.setColor("br", BRred.getText(), "Red");
                update(newColor, "br");
            }
          });
        add(BRred);

        BRgreen = new JTextField(""+colors.getColor("br").green);
        BRgreen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                CustomColor newColor = colors.setColor("br", BRgreen.getText(), "Green");
                update(newColor, "br");
            }
          });
        add(BRgreen);

        BRblue = new JTextField(""+colors.getColor("br").blue);
        BRblue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                CustomColor newColor = colors.setColor("br", BRblue.getText(), "Blue");
                update(newColor, "br");
            }
          });
        add(BRblue);
        
        JButton button = new JButton("Random");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                ColorMatrix newColors = colors.setRandom();
                update(newColors.topLeft, "tl");
                update(newColors.topRight, "tr");
                update(newColors.bottomLeft, "bl");
                update(newColors.bottomRight, "br");
            }
          });
        add(button);

        dimension = new JTextField("" + colors.colors.resolution);
        dimension.setSize(new Dimension(50, 10));
        dimension.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                colors.setResolution(dimension.getText());
            }
          });
        add(dimension);

        JButton save = new JButton("Save to Desktop");
        save.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                colors.save();
            }
          });
        add(save);
    }

     @Override
    public void paintComponent(Graphics g){ 
        draw();
        g.drawImage(mImage,0,0,getWidth(),getHeight(),null);
    }

    public void draw(){
        mImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);     
        Graphics g = mImage.getGraphics();  

        g.setColor(new Color(20, 20, 20));
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    public void update(CustomColor c, String location){
        dimension.setText("" + colors.colors.resolution);
        if(c != null){
            if(location == "tl"){
                TLred.setText("" + c.red);
                TLgreen.setText("" + c.green);
                TLblue.setText("" + c.blue);
            }
            else if(location == "tr"){
                TRred.setText("" + c.red);
                TRgreen.setText("" + c.green);
                TRblue.setText("" + c.blue);
            } 
            else if(location == "br"){
                BRred.setText("" + c.red);
                BRgreen.setText("" + c.green);
                BRblue.setText("" + c.blue);
            } 
            else if(location == "bl"){
                BLred.setText("" + c.red);
                BLgreen.setText("" + c.green);
                BLblue.setText("" + c.blue);
            } 
        }
    }
}