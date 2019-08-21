package model;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.interfaces.DicePair;
import model.interfaces.GameEngine;
import model.interfaces.GameEngineCallback;
import model.interfaces.Player;

/**
 * 
 * Skeleton example implementation of GameEngineCallback showing Java logging behaviour
 * 
 * @author Caspar Ryan
 * @see model.interfaces.GameEngineCallback
 * 
 */
public class GameEngineCallbackImpl implements GameEngineCallback
{
	private Logger logger = Logger.getLogger("assignment1");

	public GameEngineCallbackImpl()
	{
		// FINE shows rolling output, INFO only shows result
		logger.setLevel(Level.FINE);
		ConsoleHandler conHandler = new ConsoleHandler();
		conHandler.setLevel(Level.FINE);
		logger.addHandler(conHandler);
	}

	@Override
	public void intermediateResult(Player player, DicePair dicePair, GameEngine gameEngine)
	{
		// intermediate results logged at Level.FINE
		logger.log(Level.FINE, String.format("%s: ROLLING Dice 1: %d, Dice 2: %d.. Total: %d",player.getPlayerName(), dicePair.getDice1(), dicePair.getDice2(),dicePair.getDice1() + dicePair.getDice2()));
	}

	@Override
	public void result(Player player, DicePair result, GameEngine gameEngine)
	{
		logger.log(Level.INFO, String.format("%s RESULT: Dice 1: %d, Dice 2: %d.. Total: %d", player.getPlayerName(), result.getDice1(), result.getDice2(),result.getDice1() + result.getDice2()));
	}

	@Override
	public void intermediateHouseResult(DicePair dicePair, GameEngine gameEngine) 
	{
		logger.log(Level.FINE, String.format("HOUSE: ROLLING Dice 1: %d, Dice 2: %d.. Total: %d", dicePair.getDice1(), dicePair.getDice2(), dicePair.getDice1() + dicePair.getDice2()));
	}

	@Override
	public void houseResult(DicePair result, GameEngine gameEngine) 
	{
		logger.log(Level.INFO, String.format("HOUSE: *RESULT* Dice 1: %d, Dice 2: %d.. Total: %d",result.getDice1(), result.getDice2(), result.getDice1(), result.getDice2()));
	}
	
	public void logPlayerResults(Player player, GameEngine gameEngine)
	{
		logger.log(Level.INFO, String.format("Player id: %s, Name: %s, Points: %s",player.getPlayerId(), player.getPlayerName(), player.getPoints()));
	}

}
