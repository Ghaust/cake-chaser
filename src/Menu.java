

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


public class Menu
  extends JMenuBar
{
  public JMenu jeu = new JMenu("Jeu");
  private JMenu aide = new JMenu("Aide");
  private JMenu Source = new JMenu("Source");
  private JMenuItem item1 = new JMenuItem("Quitter");
  private JMenuItem item2 = new JMenuItem("A propos");
  private JMenuItem item6 = new JMenuItem("Changer Touche");
  private JMenuItem item3 = new JMenuItem("Github");
  private GateauArrayList cake;
  private NutritionisteArrayList nut;
  private Personnage perso;
  private MoveNutritionisteArrayList mnal;
  private ShowOnMap som;
  private UIKey u;
  private Move mov;
  private Map map;
  JOptionPane jop = new JOptionPane();
  
  public Menu(GateauArrayList g, NutritionisteArrayList n, Personnage p, MoveNutritionisteArrayList mnalp, ShowOnMap somp, UIKey up, Map mp, Move movp)
  {
    this.cake = g;
    this.perso = p;
    this.nut = n;
    this.mnal = mnalp;
    this.som = somp;
    this.u = up;
    this.map = mp;
    this.mov = movp;
    
    this.item1.addActionListener(new Menu.QuitActionListener());
    this.item2.addActionListener(new Menu.AproposActionListener());
    this.item6.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        Menu.this.mnal.stopwork = true;
        Menu.this.perso.stopwork = true;
        Menu.this.som.stopwork = true;
        
        String inputKeyW = JOptionPane.showInputDialog(null, "Entrer la touche que vous souhaitez modifier : 1:HAUT,2:BAS,3:GAUCHE,4:DROITE,5:Katon,6:Pause");
        
        int inputKey = Integer.parseInt(inputKeyW);
        String newKeyS = JOptionPane.showInputDialog(null, "Entrer la nouvelle touche pour " + inputKeyW);
        int newKey = KeyEvent.getExtendedKeyCodeForChar(newKeyS.charAt(0));
        
        System.out.println(inputKey);
        if ((inputKey <= 0) || (inputKey >= 7) || (Menu.this.u.alreadyUsed(newKey))) {
          JOptionPane.showMessageDialog(null, "touche déjà utilisé");
        }
        Menu.this.u.changeSetting(inputKey, newKey);
        Menu.this.mnal.stopwork = false;
        Menu.this.perso.stopwork = false;
        Menu.this.som.stopwork = false;
      }
    });
    this.item3.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
    	  Desktop desktop = null; 
    	  java.net.URI url; 
    	  try { 
    	  url =  new java.net.URI("https://github.com/etienneamiche/Chasse-aux-Gateaux"); 
    	  if (Desktop.isDesktopSupported()) 
    	  { 
    	  desktop = Desktop.getDesktop(); 
    	  desktop.browse(url); 
    	  } 
    	  } 
    	  catch (Exception ex) { 
    	  Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex); 
    	  }
      }
    });
    this.aide.add(this.item2);
    this.jeu.add(this.item6);
    this.jeu.add(this.item1);
    this.Source.add(this.item3);
    add(this.jeu);
    add(this.aide);
    add(this.Source);
  }
  
  class QuitActionListener
    implements ActionListener
  {
    QuitActionListener() {}
    
    public void actionPerformed(ActionEvent e)
    {
      System.exit(0);
    }
  }
  
  class AproposActionListener
    implements ActionListener
  {
    AproposActionListener() {}
    
    public void actionPerformed(ActionEvent e)
    {
      JOptionPane jop1 = new JOptionPane();
      JOptionPane.showMessageDialog(null, "Structure de base du jeu : Mr. Osmani \n Modifié par : Etienne Amiche", "A propos du jeu Chasse aux Gateaux", 1);
    }
  }
}