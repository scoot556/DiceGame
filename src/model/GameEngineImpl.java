package model;

import java.util.Collection;
import java.util.*;

import model.interfaces.GameEngine;
import model.interfaces.GameEngineCallback;
import model.interfaces.Player;
import view.GameEngineCallbackImpl;

public class GameEngineImpl implements GameEngine 
{
	private DicePairImpl dicePair;
	private int dice1 = 0;
	private int dice2 = 0;
	private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<GameEngineCallback> callList = new ArrayList<>();

	@Override
	public boolean placeBet(Player player, int bet) 
	{
		return player.placeBet(bet);
	}

	@Override
	public void rollPlayer(Player player, int initialDelay, int finalDelay, int delayIncrement) 
	{		
		for (int i = initialDelay; i < finalDelay; i += delayIncrement) 
		{		
			dice1 = (int) (Math.random() * NUM_FACES) + 1;
			dice2 = (int) (Math.random() * NUM_FACES) + 1;
			dicePair = new DicePairImpl(dice1, dice2, 6);
			
			for(GameEngineCallback GE : callList)
			{
				GE.intermediateResult(player, dicePair, this);
			}
		}
		dice1 = (int) (Math.random() * NUM_FACES) + 1;
		dice2 = (int) (Math.random() * NUM_FACES) + 1;
		dicePair = new DicePairImpl(dice1, dice2, 6);
		player.setRollResult(dicePair);
		for(GameEngineCallback GE : callList)
		{
			GE.result(player, dicePair, this);
		}
	}

	private GameEngineCallback getGameEngineCallback() 
	{
		return (GameEngineCallbackImpl) callList.get(0);
	}

	@Override
	public void rollHouse(int initialDelay, int finalDelay, int delayIncrement) 
	{
		for (int i = initialDelay; i < finalDelay; i += delayIncrement) 
		{
        	dice1 = (int) (Math.random() * NUM_FACES) + 1;
			dice2 = (int) (Math.random() * NUM_FACES) + 1;
			dicePair = new DicePairImpl(dice1, dice2, NUM_FACES);

			for(GameEngineCallback GE : callList)
			{
				GE.intermediateHouseResult(dicePair, this);
			}
		}

		for (Player player : players) 
		{
			if (player.getRollResult().getNumFaces() > dicePair.getNumFaces()) 
			{
				player.setPoints(player.getPoints() + player.getBet() * 2);
			}

			else if (player.getRollResult().getNumFaces() < dicePair.getNumFaces()) 
			{
				player.setPoints(player.getPoints());
			}

			else 
			{
				player.setPoints(player.getPoints() + player.getBet());
			}

			for(GameEngineCallback GE : callList)
			{
				GE.houseResult(dicePair, this);
			}
		}
		
		
	}

	@Override
	public void addPlayer(Player player) 
	{
		players.add(player);
	}

	@Override
	public Player getPlayer(String id) 
	{
		for(Player player : players)
		{
			if (player.getPlayerId().equals(id))
			{
				return player;
			}
		}
		return null;
	}

	@Override
	public boolean removePlayer(Player player) 
	{
		if(players.contains(player))
		{
			players.remove(player);
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void addGameEngineCallback(GameEngineCallback gameEngineCallback) 
	{
		callList.add(gameEngineCallback);
	}

	@Override
	public boolean removeGameEngineCallback(GameEngineCallback gameEngineCallback) 
	{
		if(callList.contains(gameEngineCallback))
		{
			callList.remove(gameEngineCallback);
			return true;
		}
		return false;
	}

	@Override
	public Collection<Player> getAllPlayers() 
	{
		return players;
	}
}
