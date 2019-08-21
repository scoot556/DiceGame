package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.BetController;
import model.interfaces.GameEngine;

public class BetFrame extends JFrame
{
	private JLabel lblBet = new JLabel("Enter Bet Amount:");
	private JTextField txtBet = new JTextField(20);
	private JButton btnBet = new JButton("Place Bet");
	private JButton btnCancel = new JButton("Cancel");	
	
	public BetFrame(GameEngine GE, MainFrame frame)
	{
		super("Place Bet");
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc_main = new GridBagConstraints();
		
		gbc_main.insets = new Insets(0, 0, 5, 5);
		gbc_main.gridx = 4;
		gbc_main.gridy = 2;
		add(lblBet, gbc_main);
		
		gbc_main.gridx = 5;
		gbc_main.gridy = 2;
		add(txtBet, gbc_main);
		
		gbc_main.gridx = 4;
		gbc_main.gridy = 4;
		btnBet.addActionListener(new BetController(GE, frame, this));
		add(btnBet, gbc_main);
		
		gbc_main.gridx = 5;
		gbc_main.gridy = 4;
		add(btnCancel, gbc_main);
		btnCancel.addActionListener(new BetController(GE, frame, this));
		
		pack();
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
	}
	
	public int getBet()
	{
		return Integer.parseInt(txtBet.getText());
	}
}
