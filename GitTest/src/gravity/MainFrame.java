package gravity;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

public class MainFrame extends JFrame {

	private GravityPanel gravityPanel;
	private ControlPanel2 controlPanel;
	
	public MainFrame() {
		super("Gravity is Fun");

		getContentPane().setLayout(new BorderLayout());
		setLocation(100, 100);
		//setResizable(false);

		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		gravityPanel = new GravityPanel();
		gravityPanel.setBackground(Color.BLACK);
		
		controlPanel = new ControlPanel2();
		controlPanel.setVisible(false);
		controlPanel.setToolTipText("");
		
		getContentPane().add(gravityPanel, BorderLayout.CENTER);
		getContentPane().add(controlPanel, BorderLayout.EAST);
		
		controlPanel.setInfoListener(new InformationListener() {

			public void informationEventOccured(InformationEvent e) {

				gravityPanel.setMass(e.getMass());
				gravityPanel.setxVel(e.getxV());
				gravityPanel.setyVel(e.getyV());
				
				
			}
			
		});
		
		// menu bar
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnOptions = new JMenu("Options");
		menuBar.add(mnOptions);
		
		JCheckBoxMenuItem chckbxmntmShowOptions = new JCheckBoxMenuItem("Show options");
		chckbxmntmShowOptions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem) e.getSource();

				controlPanel.setVisible(menuItem.isSelected());
			}
		});
		mnOptions.add(chckbxmntmShowOptions);
		
		JMenu mnSaveSystem = new JMenu("Save/Load");
		mnSaveSystem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Saved!");
			}
		});
		menuBar.add(mnSaveSystem);
		
		JMenuItem mntmSaveCurrentSystem = new JMenuItem("Save Current System");
		mntmSaveCurrentSystem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Saved!");
			}
		});
		mnSaveSystem.add(mntmSaveCurrentSystem);
		
		JMenuItem mntmLoadSystem = new JMenuItem("Load System");
		mnSaveSystem.add(mntmLoadSystem);
		
		JMenuItem mntmPause = new JMenuItem("Pause");
		mntmPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gravityPanel.toggleOn();
				if (mntmPause.getText().equals("Pause"))
					mntmPause.setText("Play");
				else
					mntmPause.setText("Pause");
			}
		});
		menuBar.add(mntmPause);
	}
	
	
}
