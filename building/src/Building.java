import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Building extends JPanel{
	private static final long serialVersionUID = 1L;
	public static Dimension size;
	
	public Building(){
		super();
		setBackground(Color.BLACK);
	}
	@Override
public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		BasicStroke bsl = new BasicStroke(10,
				BasicStroke.CAP_BUTT, 
				BasicStroke.JOIN_ROUND,
				100.0f);
		//building
		Rectangle2D building = new Rectangle2D.Double(1162, 107, 730, 1588);
		g2.drawRect(1162, 107, 730, 1588);
		
		Color b = new Color (255, 255, 255);
		g2.setColor(b);
		g2.fillRect(1162, 107, 730, 1588);
		
		//windows
		
		int boxesWidth = 22;
		int boxesHeight = 17;
		
		for (int x = 0; x < boxesWidth; x++){
			for (int y = 0; y < boxesHeight; y++){
				//int v = 100 / (boxesWidth + boxesHeight) * (x+y);
				Color c = new Color (0, 0, 0);
				g2.setColor(c);
				
				Rectangle2D rec = new Rectangle2D.Double(
						x*size.getWidth()/boxesWidth,
						y*size.getHeight()/boxesHeight, 
						size.getWidth()/boxesWidth, 
						size.getHeight()/boxesHeight
						);
				
				g2.draw(rec);
			}
		}
		
		//door
		Rectangle2D doorLeft = new Rectangle2D.Double(1308, 1376, 220, 317);
		g2.drawRect(1308, 1376, 220, 317);
		Rectangle2D doorRight = new Rectangle2D.Double(1528, 1376, 220, 317);
		g2.drawRect(1528, 1376, 220, 317);

		Color dLeft = new Color (135, 206, 250);
		g2.setColor(dLeft);
		g2.fillRect(1308, 1376, 220, 317);
		
		Color dRight = new Color (135, 206, 250);
		g2.setColor(dRight);
		g2.fillRect(1528, 1376, 220, 317);
		
		//door separation line
		Color black = new Color (0, 0, 0);
		g2.setColor(black);
		g2.drawLine(1528, 1376, 1528, 1693);
		
	}
	
public void setupDisplay(){
	JFrame application = new JFrame();
	application.add(this);
	application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	application.setSize(3200, 1800);
	application.setExtendedState(JFrame.MAXIMIZED_BOTH);
	application.setUndecorated(true);
	application.setVisible(true);
	
	size = application.getSize();
	
	//Dimension size = application.getSize();
	//System.out.println(size.getWidth()+","+size.getHeight());
}

public static void main(String[] args){
	Building program = new Building();
	program.setupDisplay();
	
	program.repaint();
}
}
