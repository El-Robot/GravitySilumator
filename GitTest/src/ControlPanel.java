import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;

public class ControlPanel extends JPanel {

	private JSlider mass;
	private JSlider xVel;
	private JSlider yVel;
	private JRadioButton shape;

	public ControlPanel() {
		
		setLayout(new GridLayout(0,1));
		
		JSlider mass = new JSlider(JSlider.HORIZONTAL, 0, 10, 5);
		mass.setMajorTickSpacing(5);
		mass.setMinorTickSpacing(1);
		mass.setPaintTicks(true);
		mass.setPaintLabels(true);
		
		JSlider xVel = new JSlider(JSlider.HORIZONTAL, -5, 5, 0);
		xVel.setMajorTickSpacing(5);
		xVel.setMinorTickSpacing(1);
		xVel.setPaintTicks(true);
		xVel.setPaintLabels(true);
		
		JSlider yVel = new JSlider(JSlider.HORIZONTAL, -5, 5, 0);
		yVel.setMajorTickSpacing(5);
		yVel.setMinorTickSpacing(1);
		yVel.setPaintTicks(true);
		yVel.setPaintLabels(true);
		
		JRadioButton circle = new JRadioButton("Circles");
		JRadioButton square = new JRadioButton("Squares");
		
		ButtonGroup shapes = new ButtonGroup();
		
		this.setSize(200, 200);
		
		add(mass);
		add(xVel);
		add(yVel);
		add(circle);
		add(square);
		
	
	}
	
	public double getMass() {
		return mass.getValue();
	}
	
}
