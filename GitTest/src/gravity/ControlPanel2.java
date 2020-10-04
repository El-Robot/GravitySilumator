package gravity;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.factories.DefaultComponentFactory;

public class ControlPanel2 extends JPanel {
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private InformationListener infoListener;
	private JFormattedTextField massTF;
	private JLabel xVelLbl;
	private JFormattedTextField xVelTF;
	private JFormattedTextField yVelTF;
	private JRadioButton circleOpt;
	private JRadioButton squareOpt;
	private JButton clear;
	/**
	 * Create the panel.
	 */
	public ControlPanel2() {
		setBorder(new EmptyBorder(15, 15, 15, 15));
		setLayout(new GridLayout(0, 1, 0, 0));

		JPanel numbersPanel = new JPanel();
		numbersPanel.setBorder(new EmptyBorder(0, 0, 0, 0));

		add(numbersPanel);

		GridBagLayout gbl_numbersPanel = new GridBagLayout();
		gbl_numbersPanel.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_numbersPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_numbersPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_numbersPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		numbersPanel.setLayout(gbl_numbersPanel);

		JLabel massLbl = DefaultComponentFactory.getInstance().createLabel("Mass: ");
		GridBagConstraints gbc_massLbl = new GridBagConstraints();
		gbc_massLbl.insets = new Insets(0, 0, 5, 5);
		gbc_massLbl.gridx = 1;
		gbc_massLbl.gridy = 1;
		numbersPanel.add(massLbl, gbc_massLbl);

		massTF = new JFormattedTextField();
		massTF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateInfoEvent();
			}
		});
		GridBagConstraints gbc_massTF = new GridBagConstraints();
		gbc_massTF.insets = new Insets(0, 0, 5, 0);
		gbc_massTF.gridx = 2;
		gbc_massTF.gridy = 1;
		numbersPanel.add(massTF, gbc_massTF);
		massTF.setColumns(7);
		massTF.setText("10");

		xVelLbl = DefaultComponentFactory.getInstance().createLabel("X Velocity: ");
		GridBagConstraints gbc_xVelLbl = new GridBagConstraints();
		gbc_xVelLbl.insets = new Insets(0, 0, 5, 5);
		gbc_xVelLbl.gridx = 1;
		gbc_xVelLbl.gridy = 2;
		numbersPanel.add(xVelLbl, gbc_xVelLbl);

		xVelTF = new JFormattedTextField();
		xVelTF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateInfoEvent();
			}
		});
		GridBagConstraints gbc_xVelTF = new GridBagConstraints();
		gbc_xVelTF.insets = new Insets(0, 0, 5, 0);
		gbc_xVelTF.gridx = 2;
		gbc_xVelTF.gridy = 2;
		numbersPanel.add(xVelTF, gbc_xVelTF);
		xVelTF.setColumns(7);
		xVelTF.setText("0");

		JLabel yVelLbl = DefaultComponentFactory.getInstance().createLabel("Y Velocity: ");
		GridBagConstraints gbc_yVelLbl = new GridBagConstraints();
		gbc_yVelLbl.insets = new Insets(0, 0, 5, 5);
		gbc_yVelLbl.gridx = 1;
		gbc_yVelLbl.gridy = 3;
		numbersPanel.add(yVelLbl, gbc_yVelLbl);

		yVelTF = new JFormattedTextField();
		yVelTF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateInfoEvent();
			}
		});
		GridBagConstraints gbc_yVelTF = new GridBagConstraints();
		gbc_yVelTF.insets = new Insets(0, 0, 5, 0);
		gbc_yVelTF.gridx = 2;
		gbc_yVelTF.gridy = 3;
		numbersPanel.add(yVelTF, gbc_yVelTF);
		yVelTF.setColumns(7);
		yVelTF.setText("0");

		circleOpt = new JRadioButton("Circle");
		circleOpt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateInfoEvent();
			}
		});
		buttonGroup.add(circleOpt);
		circleOpt.setSelected(true);
		GridBagConstraints gbc_circleOpt = new GridBagConstraints();
		gbc_circleOpt.insets = new Insets(0, 0, 5, 5);
		gbc_circleOpt.gridx = 1;
		gbc_circleOpt.gridy = 4;
		numbersPanel.add(circleOpt, gbc_circleOpt);

		squareOpt = new JRadioButton("Square");
		squareOpt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateInfoEvent();
			}
		});
		buttonGroup.add(squareOpt);
		GridBagConstraints gbc_squareOpt = new GridBagConstraints();
		gbc_squareOpt.insets = new Insets(0, 0, 5, 0);
		gbc_squareOpt.gridx = 2;
		gbc_squareOpt.gridy = 4;
		numbersPanel.add(squareOpt, gbc_squareOpt);

		clear = new JButton("Clear Planets");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				updateInfoEvent(true);
			}
		});
		GridBagConstraints gbc_clear = new GridBagConstraints();
		gbc_clear.gridwidth = 2;
		gbc_clear.insets = new Insets(0, 0, 0, 5);
		gbc_clear.gridx = 1;
		gbc_clear.gridy = 6;
		numbersPanel.add(clear, gbc_clear);

	}
	
	public void setInfoListener(InformationListener listener) {
		this.infoListener = listener;
	}
	
	private void updateInfoEvent() {
		updateInfoEvent(false);
	}
	
	private void updateInfoEvent(boolean clear) {
		double mass = Double.parseDouble(massTF.getText());
		double xV = Double.parseDouble(xVelTF.getText());
		double yV = Double.parseDouble(yVelTF.getText());
		String shape = circleOpt.isSelected() ? "circle" : "square";

		InformationEvent info = new InformationEvent(this, mass, xV, yV, shape, clear);

		if (infoListener != null) {
			infoListener.informationEventOccured(info);
		}
	}

}
