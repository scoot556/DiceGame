package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import model.GameEngineImpl;
import model.interfaces.GameEngine;
import model.interfaces.Player;

public class ResultPanel extends JPanel
{
	private JLabel lblPlayer = new JLabel("Player:");
	private JLabel lblPlayInfo = new JLabel("...");
	
	private JLabel lblPoints = new JLabel("Points:");
	private JLabel lblPointInfo = new JLabel("...");
	
	/*private JTextArea txtOutput = new JTextArea();
	private JScrollPane spOutput = new JScrollPane(txtOutput);*/
	
	private JLabel lblBet = new JLabel("Bet:");
	private JLabel lblBetInfo = new JLabel("...");
	
	private GameEngine GE = new GameEngineImpl();
	
	public ResultPanel()
	{
		setBorder(new TitledBorder(null, "Results", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		GridBagLayout gbl_resultPanel = new GridBagLayout();
		gbl_resultPanel.columnWidths = new int[]{4, 95, 241, 0};
		gbl_resultPanel.rowHeights = new int[]{14, 5, 14, 0};
		gbl_resultPanel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_resultPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gbl_resultPanel);
		
		
		lblPlayer.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblPlayer = new GridBagConstraints();
		gbc_lblPlayer.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPlayer.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlayer.gridx = 0;
		gbc_lblPlayer.gridy = 0;
		add(lblPlayer, gbc_lblPlayer);
		
		
		GridBagConstraints gbc_lblPInfo = new GridBagConstraints();
		gbc_lblPInfo.weightx = 300.0;
		gbc_lblPInfo.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPInfo.insets = new Insets(0, 0, 5, 5);
		gbc_lblPInfo.gridx = 1;
		gbc_lblPInfo.gridy = 0;
		add(lblPlayInfo, gbc_lblPInfo);
		
		lblPoints.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblPoints = new GridBagConstraints();
		gbc_lblPoints.weightx = 1000.0;
		gbc_lblPoints.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPoints.insets = new Insets(0, 0, 5, 5);
		gbc_lblPoints.gridx = 0;
		gbc_lblPoints.gridy = 1;
		add(lblPoints, gbc_lblPoints);
		
		GridBagConstraints gbc_lblPointInfo = new GridBagConstraints();
		gbc_lblPointInfo.anchor = GridBagConstraints.WEST;
		gbc_lblPointInfo.insets = new Insets(0, 0, 5, 5);
		gbc_lblPointInfo.gridx = 1;
		gbc_lblPointInfo.gridy = 1;
		add(lblPointInfo, gbc_lblPointInfo);
		
		/*txtOutput.setRows(5);
		//txtOutput.setRows(3);
		//txtOutput.setColumns(50);
		//txtOutput.setSize(400,10);
		txtOutput.setEditable(false);
		txtOutput.setLineWrap(true);
		txtOutput.setWrapStyleWord(true);
		GridBagConstraints gbc_txtOutput = new GridBagConstraints();
		gbc_txtOutput.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtOutput.ipady = 90;
		gbc_txtOutput.ipadx = 90;
		gbc_txtOutput.insets = new Insets(0, 0, 0, 10);
		gbc_txtOutput.gridx = 2;
		gbc_txtOutput.gridy = 1;
		//add(txtOutput, gbc_txtOutput);
		spOutput.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		spOutput.setSize(20, 20);
		add(spOutput, gbc_txtOutput);*/
		
		lblBet.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblBet = new GridBagConstraints();
		gbc_lblBet.weightx = 1000.0;
		gbc_lblBet.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblBet.insets = new Insets(0, 0, 0, 5);
		gbc_lblBet.gridx = 0;
		gbc_lblBet.gridy = 2;
		add(lblBet, gbc_lblBet);
		
		
		GridBagConstraints gbc_lblBetInfo = new GridBagConstraints();
		gbc_lblBetInfo.weightx = 300.0;
		gbc_lblBetInfo.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblBetInfo.insets = new Insets(0, 0, 0, 5);
		gbc_lblBetInfo.gridx = 1;
		gbc_lblBetInfo.gridy = 2;
		add(lblBetInfo, gbc_lblBetInfo);
	}
	
	
	public void setPName(String PName)
	{
		lblPlayInfo.setText(PName);
	}
	
	public void setPBet(int PBet)
	{
		lblBetInfo.setText(Integer.toString(PBet));
	}
	
	public void setPPoint(int PPoint)
	{
		lblPointInfo.setText(Integer.toString(PPoint));
	}
	
	public void updateRes(Player player)
	{
		setPName(player.getPlayerName());
		setPBet(player.getBet());
		setPPoint(player.getPoints());
	}
	
	/*public void setTxt(String txt)
	{
		txtOutput.append(txt);
	}*/
}
