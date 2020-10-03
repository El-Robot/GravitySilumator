import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GravityPanel extends JPanel implements ActionListener {

	ArrayList<Planet> planets = new ArrayList<Planet>();
	private Timer timer;
	private int delay = 1;
	int x = 0;

	public GravityPanel() {

		timer = new Timer(delay, this);
		timer.start();

		//Dual Orbiting
		planets.add(new Planet(200, 200, 5, .1));
		planets.add(new Planet(200, 300, 5, -.1));
		
		//Orbiting
		//planets.add(new Planet(300, 200, 300000, 1.5));
		//planets.add(new Planet(300, 300, 300000000, 0));
		
		
		addMouseListener(new MouseAdapter() { 
	          public void mousePressed(MouseEvent me) { 
	            planets.add(new Planet(me.getX(), me.getY(),5,0)); 
	          } 
	        }); 

	}

	public void paint(Graphics g) {

		g.setColor(Color.black);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());

		// set color
		g.setColor(Color.white);

		// loop through planets
		for (Planet p : planets) {
			g.fillOval((int) p.getX(), (int) p.getY(), 20, 20);
		}

		g.dispose();
	}


	public void actionPerformed(ActionEvent e) {

		timer.start();

		for (Planet p : planets) {
			for (Planet p2 : planets) {
				p.updateV(p2);
			}
		}

		for (Planet p : planets) {
			p.updatePos();
		}

		repaint();
	}
}
