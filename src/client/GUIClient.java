package client;


import javax.swing.SwingUtilities;

import model.GameEngineImpl;
import model.interfaces.GameEngine;
import view.MainFrame;

public class GUIClient 
{
	public static void main(String args[])
	{
			final GameEngine GE = new GameEngineImpl();

        	SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run()
            {
                new MainFrame().setVisible(true);
            }
        });
	}
}
