
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class Main
{
  public static void main(String[] args)
  {
    SwingUtilities.invokeLater(new Runnable()
    {
      public void run()
      {
        JFrame frame = new JFrame("Jeu");
        Dimension ecran = Toolkit.getDefaultToolkit().getScreenSize();
        
        frame.setPreferredSize(new Dimension(ecran.width / 2, ecran.height / 2));
        frame.setLocation(ecran.width / 4, ecran.height / 4);
        
        Map map = new Map(frame.getSize());
        
        Personnage p = new Personnage();
        infosJeu bm = new infosJeu();
        
        UIKey u = new UIKey();
        u.setPerso(p);
        map.add(p);
        u.setMap(map);
        
        IncreaseMana im = new IncreaseMana(p, map);
        im.start();
        
        Move move = new Move();
        u.setMove(move);
        
        NutritionisteArrayList nuts = new NutritionisteArrayList(10, map);
        u.setNutritionisteArrayList(nuts);
        nuts.addToMap(map);
        
        GateauArrayList cakes = new GateauArrayList(5000, map);
        u.setGateauArrayList(cakes);
        
        ShowOnMap sgal = new ShowOnMap(cakes, map);
        move.setShowOnMap(sgal);
        sgal.start();
        
        MoveNutritionisteArrayList mnal = new MoveNutritionisteArrayList(nuts, p, map, sgal);
        mnal.start();
        u.setMNAL(mnal);
        
        Menu menubar = new Menu(cakes, nuts, p, mnal, sgal, u, map, move);
        frame.setJMenuBar(menubar);
        frame.setLayout(new BorderLayout());
        frame.add(bm, BorderLayout.SOUTH);
        frame.add(map, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(3);
        frame.pack();
        frame.setVisible(true);
        frame.addKeyListener(u);
      }
    });
  }
}