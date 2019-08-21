package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.interfaces.GameEngine;
import view.AddFrame;
import view.BetFrame;
import view.MainFrame;

public class ToolController implements ActionListener
{
	private GameEngine GE;
	private MainFrame frame;
	
	public ToolController(GameEngine GE, MainFrame frame)
	{
		this.GE = GE;
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		if(arg0.getActionCommand().equals("Add Player")) 
		{
			new AddFrame(GE, frame);
		}
		
		else if(arg0.getActionCommand().equals("Bet"))
		{
			new BetFrame(GE, frame);
		}
		
		else if(arg0.getActionCommand().equals("Roll Player"))
		{
			Thread thread = new Thread()
			{
				public void run()
				{
					GE.rollPlayer(frame.getPlayer(), 1, 100, 20);
				}
			};
			thread.start();
		}
		
		else if(arg0.getActionCommand().equals("Roll House"))
		{
			Thread thread = new Thread()
			{
				public void run()
				{
					GE.rollHouse(1, 100, 20);
				}
			};
			thread.start();
		}
	
	}
}
