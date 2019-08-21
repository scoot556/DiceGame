package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.AddController;
import model.interfaces.GameEngine;

public class AddFrame extends JFrame
{
	private JLabel lblName = new JLabel("Player Name: ");
	private JLabel lblPoints = new JLabel("Points: ");
	private JLabel lblID = new JLabel("ID: ");
	
	private JTextField txtName = new JTextField(20);
	private JTextField txtPoints = new JTextField(20);
	private JTextField txtID = new JTextField(20);
	
	private JButton btnAdd = new JButton("Add Player");
	private JButton btnCancel = new JButton("Cancel");

	
	public AddFrame(GameEngine GE, MainFrame frame){
		super("Add player");
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc_main = new GridBagConstraints();
		
		gbc_main.insets = new Insets(0, 0, 5, 5);
		gbc_main.gridx = 0;
		gbc_main.gridy = 0;
		add(lblName, gbc_main);
		gbc_main.gridy = 1;
		add(lblPoints, gbc_main);
		gbc_main.gridy = 2;
		add(lblID, gbc_main);
		gbc_main.gridx = 1;
		gbc_main.gridy = 0;
		add(txtName, gbc_main);
		gbc_main.gridy = 1;
		add(txtPoints, gbc_main);
		gbc_main.gridy = 2;
		add(txtID, gbc_main);
		gbc_main.gridx = 0;
		gbc_main.gridwidth = 1;
		gbc_main.gridy = 3;
		btnAdd.addActionListener(new AddController(GE, frame, this));
		add(btnAdd, gbc_main);
		
		gbc_main.gridx = 1;
		gbc_main.gridwidth = 1;
		gbc_main.gridy = 3;
		add(btnCancel, gbc_main);
		btnCancel.addActionListener(new AddController(GE, frame, this));

		pack();
		
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
	}

	public String getPName()
	{
		return txtName.getText();
	}
	
	public String getPPoint()
	{
		return txtPoints.getText();
	}
	
	public String getPID()
	{
		return txtID.getText();
	}
}
