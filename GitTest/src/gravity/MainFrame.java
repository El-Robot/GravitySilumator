package gravity;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

	private GravityPanel gravityPanel;
	private ControlPanel controlPanel;
	
	public MainFrame() {
		super("Gravity is Fun");

		setLayout(new BorderLayout());
		setLocation(100, 100);
		//setResizable(false);

		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		gravityPanel = new GravityPanel();
		gravityPanel.setBackground(Color.BLACK);
		
		controlPanel = new ControlPanel();
		
		add(gravityPanel, BorderLayout.CENTER);
		add(controlPanel, BorderLayout.EAST);
	}
	
	
}
