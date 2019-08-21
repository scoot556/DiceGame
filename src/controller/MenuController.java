package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MainFrame;

public class MenuController implements ActionListener
{
	public MenuController(MainFrame frame)
	{
		super();
	}


	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals("Place Bet"))
		{
			
		}
		
		else if(e.getActionCommand().equals("Roll House"))
		{
			
		}
		
		else if(e.getActionCommand().equals("Help"))
		{
			
		}
		
		else if(e.getActionCommand().equals("Quit"))
		{
			System.exit(0);
		}		
	}	
}
