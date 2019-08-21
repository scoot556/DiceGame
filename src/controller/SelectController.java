package controller;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.MainFrame;

public class SelectController implements ItemListener 
{
	private GameEngine GE;
	private MainFrame frame;
	
	public SelectController(GameEngine GE, MainFrame frame)
	{
		this.GE = GE;
		this.frame = frame;
	}
	
	@Override
	public void itemStateChanged(ItemEvent arg0) 
	{
		for(Player player : GE.getAllPlayers())
		{
			if(arg0.getItem().equals(player.getPlayerName()))
			{
				frame.getRes().updateRes(player);
				frame.setPlayer(player);
			}
		}

	}

}
