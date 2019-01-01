import javax.swing.*;
import java.awt.*;


public class Gateau extends JLabel implements java.io.Serializable {
    ImageIcon img, img2;
    int type;
    public final int ICON_WIDTH = 32, ICON_HEIGHT = 32;

// TODO: placement alÃ©atoire des gateaux sur la map
    public Gateau(Map m) {
        super();

        img  = new ImageIcon("./resources/gateau.png");
        img2  = new ImageIcon("./resources/gateau2.png");
        // TODO: placement alÃ©atoire des gateaux sur la map	
        // dÃ©finir un type de gateau par dÃ©faut, 1 pour la vie, 2 pour le mana, et son icone associÃ©
        setIcon(img);
       



        Dimension ecran = Toolkit.getDefaultToolkit().getScreenSize();


        setLocation(20+ (int)  ((ecran.width-200)/2*Math.random()) , 20 + (int) ((ecran.height-200)/ 2 * Math.random() ) );



        this.setSize(this.getPreferredSize());
        setVisible(true);
        
        
        // ensuite placer alÃ©atoirement le gateau sur la map.
    }
    
    public void setIcon(int a){
    	if (a==1)
    	{	
	    	setIcon(img);
	    	this.type = 1;
    	}
    	if(a==2)
    	{	
    		setIcon(img2); 	
    		this.type = 2;
    	}
    }
    
    public int getGateau(){
    	
    	return this.type;
    }


}