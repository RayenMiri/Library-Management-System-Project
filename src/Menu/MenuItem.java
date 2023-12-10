package Menu;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import javax.swing.border.EmptyBorder;

public class MenuItem extends JButton {
    private int index;
    private RippleEffect rippleEffect;
    public int getIndex(){
        return this.index;
    }
    public void setIndex(int index){
        this.index = index;
    }
    public MenuItem(String name , int index){
        super(name);
        this.index = index;
        setContentAreaFilled(false);
        setForeground(new Color(254,254,254));
        setBorder(new EmptyBorder(9,10,9,10));
        setIconTextGap(10);
        rippleEffect = new RippleEffect(this);
        rippleEffect.setRippleColor(new Color(220,220,220));
    }
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        rippleEffect.render(graphics, new Rectangle2D.Double(20,0,getWidth(),getHeight()));
    }
    
    
}
