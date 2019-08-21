package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.BevelBorder;
import controller.SelectController;
import controller.ToolController;
import model.interfaces.GameEngine;
import model.interfaces.Player;

public class GamePanel extends JToolBar
{
	private JLabel lblSelectPlayer = new JLabel("Select Player");
	
	private JButton btnBet = new JButton("Bet");
	private JButton btnRollP = new JButton("Roll Player");
	private JButton btnRollH = new JButton("Roll House");
	
	private JButton btnAdd = new JButton("Add Player");
	private JComboBox<String> cmbSelect = new JComboBox<String>();

	
	public GamePanel(GameEngine GE, MainFrame frame)
	{
		ToolController tc = new ToolController(GE, frame);
		
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		GridBagLayout gbl_AddPanel = new GridBagLayout();
		gbl_AddPanel.columnWidths = new int[]{85, 85, 0};
		gbl_AddPanel.rowHeights = new int[]{140, 140, 140, 0};
		gbl_AddPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_AddPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gbl_AddPanel);
		
		GridBagConstraints gbc_lblSelectPlayer = new GridBagConstraints();
		gbc_lblSelectPlayer.anchor = GridBagConstraints.SOUTH;
		gbc_lblSelectPlayer.insets = new Insets(0, 0, 5, 5);
		gbc_lblSelectPlayer.gridx = 0;
		gbc_lblSelectPlayer.gridy = 0;
		add(lblSelectPlayer, gbc_lblSelectPlayer);
		
		
		GridBagConstraints gbc_cmbSelect = new GridBagConstraints();
		gbc_cmbSelect.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbSelect.anchor = GridBagConstraints.SOUTH;
		gbc_cmbSelect.insets = new Insets(40, 0, 0, 0);
		gbc_cmbSelect.gridx = 1;
		gbc_cmbSelect.gridy = 0;
		add(cmbSelect, gbc_cmbSelect);
		cmbSelect.addItemListener(new SelectController(GE, frame));
		
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAdd.insets = new Insets(0, 0, 5, 5);
		gbc_btnAdd.gridx = 0;
		gbc_btnAdd.gridy = 1;
		add(btnAdd, gbc_btnAdd);
		btnAdd.addActionListener(tc);
		
		GridBagConstraints gbc_btnBet = new GridBagConstraints();
		gbc_btnBet.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBet.insets = new Insets(0, 0, 5, 0);
		gbc_btnBet.gridx = 1;
		gbc_btnBet.gridy = 1;
		add(btnBet, gbc_btnBet);
		btnBet.addActionListener(tc);
		
		GridBagConstraints gbc_btnRollP = new GridBagConstraints();
		gbc_btnRollP.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnRollP.anchor = GridBagConstraints.NORTH;
		gbc_btnRollP.insets = new Insets(0, 0, 0, 5);
		gbc_btnRollP.gridx = 0;
		gbc_btnRollP.gridy = 2;
		add(btnRollP, gbc_btnRollP);
		btnRollP.addActionListener(tc);
		
		GridBagConstraints gbc_RollH = new GridBagConstraints();
		gbc_RollH.fill = GridBagConstraints.HORIZONTAL;
		gbc_RollH.anchor = GridBagConstraints.NORTH;
		gbc_RollH.gridx = 1;
		gbc_RollH.gridy = 2;
		add(btnRollH, gbc_RollH);
		btnRollH.addActionListener(tc);
	}	
	
	public void setPName(Player player)
	{
		cmbSelect.addItem(player.getPlayerName());
	}
}
