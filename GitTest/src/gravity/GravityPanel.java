package gravity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GravityPanel extends JPanel implements ActionListener {

	ArrayList<Planet> planets = new ArrayList<Planet>();
	private Timer timer;
	private int delay = 1;
	boolean paused = false;
	
	private double mass = 5;
	private double xVel = 0;
	private double yVel = 0;
	private String shape = "circle";

	public GravityPanel() {

		timer = new Timer(delay, this);
		timer.start();

		// Dual Orbiting
		// planets.add(new Planet(200, 200, 5, .1, 0));
		// planets.add(new Planet(200, 300, 5, -.1, 0));

		// Orbiting
		// planets.add(new Planet(300, 200, 1, 0.3, 0));
		// planets.add(new Planet(300, 300, 100, -0.003, 0));

		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				planets.add(new Planet(me.getX(), me.getY(), mass, xVel, yVel));
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
			if (shape.equals("circle"))
				g.fillOval((int) p.getX(), (int) p.getY(), 20, 20);
			else
				g.fillRect((int) p.getX(), (int) p.getY(), 20, 20);
		}

		g.dispose();
	}

	

	public void actionPerformed(ActionEvent e) {

		timer.start();

		if (!paused) {
			for (Planet p : planets) {
				for (Planet p2 : planets) {
					p.updateV(p2);
				}
			}

			for (Planet p : planets) {
				p.updatePos();
			}
		}
		repaint();
	}

	public void toggleOn() {
		paused = !paused;
	}

	public ArrayList<Planet> getPlanets() {
		return planets;
	}

	public void setPlanets(ArrayList<Planet> planets) {
		this.planets = planets;
	}

	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}

	public int getDelay() {
		return delay;
	}

	public void setDelay(int delay) {
		this.delay = delay;
	}

	public boolean isPaused() {
		return paused;
	}

	public void setPaused(boolean paused) {
		this.paused = paused;
	}

	public double getMass() {
		return mass;
	}

	public void setMass(double mass) {
		this.mass = mass;
	}

	public double getxVel() {
		return xVel;
	}

	public void setxVel(double xVel) {
		this.xVel = xVel;
	}

	public double getyVel() {
		return yVel;
	}

	public void setyVel(double yVel) {
		this.yVel = yVel;
	}
	
	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}
	
}