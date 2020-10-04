package gravity;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MainFrame extends JFrame {

	private GravityPanel gravityPanel;
	private ControlPanel2 controlPanel;
	private JFileChooser fileChooser;
	
	
	public MainFrame() {
		super("Gravity is Fun");

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
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
		
		
		//////////////////////////////// INFORMATION LISTENER /////////////////////////////////
		controlPanel.setInfoListener(new InformationListener() {

			public void informationEventOccured(InformationEvent e) {

				gravityPanel.setMass(e.getMass());
				gravityPanel.setxVel(e.getxV());
				gravityPanel.setyVel(e.getyV());
				gravityPanel.setShape(e.getShape());
				
				if (e.isClear())
					gravityPanel.setPlanets(new ArrayList<Planet>());
				
				
			}
			
		});
		
		//////////////////////////////// MENU BAR /////////////////////////////////////////////
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnOptions = new JMenu("Options");
		menuBar.add(mnOptions);
		
		fileChooser = new JFileChooser();
		fileChooser.addChoosableFileFilter(new PersonFileFilter());
		
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
				
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				
				if(fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
					
					System.out.println(fileChooser.getSelectedFile());
					
					
					
				}
				
			}
		});
		mnSaveSystem.add(mntmSaveCurrentSystem);
		
		JMenuItem mntmLoadSystem = new JMenuItem("Load System"); //loads a txt file into the board
		mntmLoadSystem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
					System.out.println(fileChooser.getSelectedFile());
					
					gravityPanel.setPlanets(FileConverter.fileToSystem(fileChooser.getSelectedFile()));
					
				}
			}
		});
		mnSaveSystem.add(mntmLoadSystem);
		
		JMenuItem mntmPause = new JMenuItem("Pause"); //PAUSE BUTTON
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
