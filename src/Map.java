
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.JPanel;

public class Map
  extends JPanel
{
  public static final Color CITY = new Color(214, 217, 223);
  public static final Color DESERT = new Color(255, 204, 102);
  public static final Color DIRT_ROAD = new Color(153, 102, 0);
  public static final Color FOREST = new Color(0, 102, 0);
  public static final Color HILLS = new Color(51, 153, 0);
  public static final Color LAKE = new Color(0, 153, 153);
  public static final Color MOUNTAINS = new Color(102, 102, 255);
  public static final Color OCEAN = new Color(0, 0, 153);
  public static final Color PAVED_ROAD = new Color(51, 51, 0);
  public static final Color PLAINS = new Color(102, 153, 0);
  public static final Color[] TERRAIN = {
    CITY, 
    DESERT, 
    DIRT_ROAD, 
    FOREST, 
    HILLS, 
    LAKE, 
    MOUNTAINS, 
    OCEAN, 
    PAVED_ROAD, 
    PLAINS };
  
  int indexTile = 0;
 
  private Dimension jframedim;
  
  public Map(Dimension d)
  {
    super(null);
    this.jframedim = d;

  }
  
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    
    g.clearRect(0, 0, getWidth(), getHeight());
    
    Dimension ecran = Toolkit.getDefaultToolkit().getScreenSize();
    
    int rectWidth = ecran.width; 
    int rectHeight = ecran.height;
    if (this.indexTile > 9) {
    
      
    	 indexTile = 0;
    }
        Color terrainColor = TERRAIN[this.indexTile];
        
        g.setColor(terrainColor);
        g.fillRect(0, 0, rectWidth, rectHeight);
      }
    
  
}