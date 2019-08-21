package model;

import model.interfaces.DicePair;
import model.interfaces.Player;

public class SimplePlayer implements Player 
{
	private String playerName;
	private String playerId;
	private int bet;
	private int points;
	private DicePair rollResult;
	
	public SimplePlayer(String playerId, String playerName, int initialPoints)
	{
		this.playerId = playerId;
		this.playerName = playerName;
		this.points = initialPoints;
	}
	
	@Override
	public String getPlayerName() 
	{
		return playerName;
	}

	@Override
	public void setPlayerName(String playerName) 
	{
		this.playerName = playerName;
	}

	@Override
	public int getPoints() 
	{
		return points;
	}

	@Override
	public void setPoints(int points) 
	{
		this.points = points;
	}

	@Override
	public String getPlayerId() 
	{
		return playerId;
	}

	@Override
	public boolean placeBet(int bet) 
	{
		this.bet = bet;
		
		if(this.getPoints() < bet)
		{
			return false;
		}
		this.setPoints(this.getPoints() - bet);
		return true;
	}

	@Override
	public int getBet() 
	{
		return bet;
	}
	
	public void setBet(int bet)
	{
		this.bet = bet;
	}

	@Override
	public DicePair getRollResult()
	{
		return rollResult; 
	}

	@Override
	public void setRollResult(DicePair rollResult) 
	{
		this.rollResult = rollResult;
	}
	
	public String toString()
	{
		String playerInfo = "";
		
		playerInfo = "Player: id = " + this.playerId +
				", name = " + this.playerName  + ", points = " + this.points;
		
		return playerInfo;
	}

}
