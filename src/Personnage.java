import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Personnage extends JLabel implements java.io.Serializable {


    private int posX = 100;
    private int posY = 100;
    private int energy = 10;
    private int mana = 100;
    private int niveau = 0;


    
    private boolean regime=false;

    ImageIcon HAUT, BAS, GAUCHE, DROITE;
    public boolean stopwork = false;


    public final int ICON_WIDTH = 48, ICON_HEIGHT = 48;


    // TODO:
    public int getMana(){
    	return this.mana;
    }
    // TODO: 
    public void setMana(int n)
    	  {
    		    if (n >= 100) {
    		      this.mana = 100;
    		    } else if (n <= 0) {
    		      this.mana = 0;
    		    } else {
    		      this.mana = n;
    		    }
    		  }
    
    
    // TODO: 
    public int getEnergy(){
    	return this.energy;
    }
    
    // TODO:
    public void setEnergy(int n){
    	  if (n >= 10) {
    	      this.energy = 10;
    	    } else if (n <= 0) {
    	      this.energy = 0;
    	    } else {
    	      this.energy = n;
    	    }
    }
    // TODO: 
    public int getPosX() {
        return this.posX;
    }
    // TODO: 
    public int getPosY() {
        return this.posY;
    }

    // TODO: constructeur pour positionner le perso dans la frame avec le bon icone
    public Personnage() {
        super();
        	

            DROITE = new ImageIcon("./resources/joueur_droite.png");
            GAUCHE = new ImageIcon("./resources/joueur_gauche.png");
            BAS    = new ImageIcon("./resources/joueur_bas.png");
            HAUT   = new ImageIcon("./resources/joueur_haut.png");
            setIcon(BAS);
            setLocation(getPosX(),getPosY());
            this.setSize(this.getPreferredSize());
            
            setVisible(true);
            
    }
    // fin TODO
    
    public int getNiveau() {
        return niveau;
    }
    public void setNiveau(int n) {
        niveau = n;
    }

    public void setRegime (boolean r){
    	regime=r;
    }
    public boolean getRegime (){
    	return regime;
    }    

    

    
    public void bouger(int i, int nposx, int nposy, Map m) {
        if(stopwork)
            return;

        if (i==1)
    		setIcon(HAUT);
    	else if(i==2)
    		setIcon(BAS);
      	else if(i==3)
    		setIcon(GAUCHE);
      	else setIcon(DROITE);
        if(nposx<m.getWidth()-48 && nposx>0  ) this.posX =nposx;
       
        if(nposy > 1 && nposy <m.getHeight() -48) this.posY = nposy;
        
        setLocation(posX,posY);
    }
    
}