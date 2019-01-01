import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


// TODO: barre des infos du personnage en bas de l'Ã©cran
public class infosJeu extends JPanel {

	public JLabel energie = new JLabel("energie");
	public JLabel mana= new JLabel("mana");
	public JLabel text = new JLabel("info");
	public JLabel niveau= new JLabel("niveau");
     
	  public infosJeu() {
		  
		 this.setLayout(new GridLayout(1,4));
			

	    Dimension ecran = Toolkit.getDefaultToolkit().getScreenSize();

		
		this.energie.setText("energie 10");
		
		this.mana.setText("mana 100");
		
		this.text.setText("info");
		
		this.niveau.setText("niveau 1");
		
		this.setBackground(new Color(100, 255, 255));
		

		
		add(this.energie);
		
		add(this.mana);
		
		add(this.text);
		
		add(this.niveau);
		
	}

	  
}