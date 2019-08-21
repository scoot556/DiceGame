package view;

import model.interfaces.DicePair;
import model.interfaces.GameEngine;
import model.interfaces.GameEngineCallback;
import model.interfaces.Player;

public class GameEngineCallbackGUI implements GameEngineCallback
{
	private MainFrame frame;
	
	public GameEngineCallbackGUI(MainFrame frame)
	{
		this.frame = frame;
	}
	
	@Override
	public void intermediateResult(Player player, final DicePair dicePair, GameEngine GE)
	{
				frame.getDP().updateDP(dicePair);
	}
	
	@Override
	public void result(Player player, final DicePair result, GameEngine GE)
	{
				frame.getDP().updateDP(result);
				//frame.getRes().updateOutput();
	}
	
	@Override
	public void intermediateHouseResult(final DicePair dicePair, GameEngine GE)
	{
				frame.getDP().updateDP(dicePair);
				//frame.getRes().updateOutput();
	}
	
	@Override
	public void houseResult(final DicePair result, GameEngine GE)
	{
				frame.getDP().updateDP(result);
				frame.getRes().updateRes(frame.getPlayer());
				//frame.getRes().setTxt(frame.getDP().toString());
	}
}
