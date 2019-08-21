package view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import view.GameEngineCallbackImpl;
import model.GameEngineImpl;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.GameEngineCallbackGUI;
import view.DicePanel;


public class MainFrame extends JFrame
{
	private GameEngine GE = new GameEngineImpl();
	private Player player;
	
	private GamePanel gamePanel = new GamePanel(GE, this);
	private DicePanel dicePanel = new DicePanel();
	private JPanel block;
	private JMenuBar menuBar = new MenuBar(this);
	private ResultPanel resultPanel = new ResultPanel();
	
	
	
	public MainFrame()
	{
		super("Dice Game Sadi");
		GE.addGameEngineCallback(new GameEngineCallbackImpl());
		GE.addGameEngineCallback(new GameEngineCallbackGUI(this));
		setJMenuBar(menuBar);
		populate();
	}
	
	public void populate()
	{
		setResizable(false);
		setBounds(100, 100, 640, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		block = new JPanel();
		block.setBorder(new EmptyBorder(5,5,5,5));
		add(gamePanel, BorderLayout.EAST);
		add(dicePanel, BorderLayout.CENTER);
		add(resultPanel, BorderLayout.SOUTH);
	}	
	
	
	public GamePanel getGP()
	{
		return gamePanel;
	}
	
	public ResultPanel getRes()
	{
		return resultPanel;
	}
	
	public DicePanel getDP()
	{
		return dicePanel;
	}
	
	public Player getPlayer()
	{
		return player;
	}
	
	public void setPlayer(Player player)
	{
		this.player = player;
	}
}
