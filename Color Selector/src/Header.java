import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.awt.*; //For graphics

public class Header extends JPanel{
    private BufferedImage mImage;
    private Subheader sub;
    private JLabel label;

    public Header(){
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(getWidth(), 65));

        sub = new Subheader();
        add(sub,BorderLayout.SOUTH);
        
        label = new JLabel("Default Color Matrix", JLabel.CENTER);
        label.setFont(new Font("Karla", Font.PLAIN, 30));
        label.setForeground(Color.WHITE);
        add(label);
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

    public void update(CustomColor c, String labelText){
        sub.refresh(c);
        if(labelText != null){
            label.setText(labelText);
        }
    }
}