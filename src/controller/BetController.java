package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.interfaces.GameEngine;
import view.BetFrame;
import view.MainFrame;

public class BetController implements ActionListener
{
	private GameEngine GE;
	private MainFrame frame;
	private BetFrame bet;
	
	public BetController(GameEngine GE, MainFrame frame, BetFrame bet)
	{
		this.GE = GE;
		this.frame = frame;
		this.bet = bet;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		if(arg0.getActionCommand().equals("Place Bet"))
			{
				GE.placeBet(frame.getPlayer(), bet.getBet());
				frame.getRes().updateRes(frame.getPlayer());
				bet.dispose();
			}
		else if(arg0.getActionCommand().equals("Cancel"))
		{
			bet.dispose();
		}
		
	}
}
