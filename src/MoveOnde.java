import javax.swing.JLabel;


public class MoveOnde extends Thread {
	Oonde onde;
	Map map;
    JLabel KATON = new JLabel("KATON : HOUSENKA NO JUTSU !!!");


	public MoveOnde(Oonde o, Map m){
		super();
		onde=o;
		map=m;
		KATON.setSize(300, 50);
	}

	

	public void run(){
		// TODO: dÃ©placement de l'onde sur la map en 3 images. Placer la premiere autour du personnage, 
		// puis la seconde, puis la troisiÃ¨me, puis cela disparaÃ®t.
		KATON.setLocation(onde.getPosX(),onde.getPosY());
		onde.setIcon(1);
		map.add(KATON);
		map.add(onde);
		map.validate();
	
		try {
            Thread.sleep(100);
          } catch (InterruptedException e){}
		
		KATON.setLocation(onde.getPosX(),onde.getPosY());
		onde.setIcon(2);
		map.add(onde);
		map.validate();
		
		try {
            Thread.sleep(100);
          } catch (InterruptedException e){}
		
		KATON.setLocation(onde.getPosX(),onde.getPosY());
		onde.setIcon(3);
		map.add(onde);
		map.validate();
		


		try {
            Thread.sleep(100);
          } catch (InterruptedException e){}
		map.remove(KATON);
		map.remove(onde);
		//KATON.setLocation(...,...);
		//map.add(KATON);
		// ....
	}
	
	
}