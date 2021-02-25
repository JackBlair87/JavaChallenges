import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.awt.*; //For graphics

public class ColorDisplay extends JPanel{
    private static final long serialVersionUID = 1L;
    private BufferedImage mImage;
    public ColorMatrix colors;

    private Subbar sub;

    public int xSelected;
    public int ySelected;

    public ColorDisplay(){
        setLayout(new BorderLayout());
        colors = new ColorMatrix(10);
        
        xSelected = -1;
        ySelected = -1;

        sub = new Subbar(this);
        add(sub, BorderLayout.SOUTH);
    }

     @Override
    public void paintComponent(Graphics g){ 
        draw();
        g.drawImage(mImage,0,0,getWidth(),getHeight(),null);
    }

    public void draw(){
        mImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);     
        Graphics g = mImage.getGraphics();  

        int height = getHeight() - sub.getHeight();
        int width = getWidth();

        g.setColor(new Color(30, 31, 28));
        g.fillRect(0, 0, width, height);

        int gapW = (int) (width*0.9)/colors.resolution;
        int gapH = (int) (height*0.9)/colors.resolution;

        int xOffset = (width - (gapW*colors.resolution))/2;
        int yOffset = (height - (gapH*colors.resolution))/2;

        for(int x = 0; x < colors.resolution; x++){
            for(int y = 0; y < colors.resolution; y++){
                g.setColor(colors.colorAt(x, y).color);
                g.fillRect(x*gapW + xOffset, y*gapH + yOffset, gapW, gapH);
            }
        }

        if(xSelected > -1 && ySelected > -1 && xSelected < colors.resolution && ySelected < colors.resolution){
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(4.0f));
            
            g.setColor(Color.WHITE);
            g.drawRect(xSelected*gapW + xOffset, ySelected*gapH + yOffset, gapW, gapH);
        }
    }

    public CustomColor shift(int x, int y){
        if(xSelected + x >= 0 && xSelected + x < colors.resolution){
            xSelected += x;
        }
        if(ySelected + y >= 0 && ySelected + y < colors.resolution){
            ySelected += y;
        }

        return colors.colorAt(xSelected, ySelected);
    }

    public CustomColor select(int newX, int newY){
        int gapW = (int) (getWidth()*0.9)/colors.resolution;
        int gapH = (int) (getHeight()*0.9)/colors.resolution;

        int xOffset = (getWidth() - (gapW*colors.resolution))/2;
        int yOffset = (getHeight() - (gapH*colors.resolution))/2;

        if(newX < xOffset || newX > getWidth()-xOffset){
            xSelected = -1;
            ySelected = -1;
            return null;
        }
        else if(newY < yOffset || newY > getHeight()-yOffset){
            xSelected = -1;
            ySelected = -1;
            return null;
        }
        else{
            for(int x = 0; x < colors.resolution; x++){
                for(int y = 0; y < colors.resolution; y++){
                    if(newX > x*gapW + xOffset && newX <= x*gapW + xOffset + gapW){
                        if(newY > y*gapH + yOffset && newY <= y*gapH + yOffset + gapH){
                            xSelected = x;
                            ySelected = y;
                            break;
                        }
                    }
                }
            }
            return colors.colorAt(xSelected, ySelected);
        }
    }

    public void setColor(String value, String color){
        //colors
    }

    public void update(CustomColor c){
        sub.update(c);
    }

    public void setRandom(){
        colors.randomInterplolation();
        repaint();
    }

    public void setResolution(String newValue){
        colors.setResolution(newValue);
        repaint();
    }
}