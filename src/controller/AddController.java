package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.SimplePlayer;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.AddFrame;
import view.MainFrame;

public class AddController implements ActionListener
{
	GameEngine GE;
	MainFrame frame;
	AddFrame af;
	
	public AddController(GameEngine GE, MainFrame frame, AddFrame af)
	{
		this.GE = GE;
		this.frame = frame;
		this.af = af;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		if(arg0.getActionCommand().equals("Add Player"))
		{
			Player newPlayer = new SimplePlayer(af.getPID(), af.getPName(), Integer.parseInt(af.getPPoint()));
			GE.addPlayer(newPlayer);
			frame.getGP().setPName(newPlayer);
			af.dispose();
		}
		else if(arg0.getActionCommand().equals("Cancel"))
		{
			af.dispose();
		}
	}
}
