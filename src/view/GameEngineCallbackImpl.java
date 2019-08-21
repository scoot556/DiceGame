package view;

import java.io.OutputStream;
import java.io.PrintStream;
import java.io.StringWriter;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTextArea;

import controller.TextAreaController;
import controller.TextAreaController.TextAreaOutputStream;
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
	//private ResultPanel resultPanel = new ResultPanel();
	//private JTextArea txtOutput = new JTextArea(); 

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
		String userInfo = "";
		
		userInfo = player.getPlayerName() + " : ROLLING Dice 1: " + dicePair.getDice1() +
				",  Dice 2: " + dicePair.getDice2()  + " .. Total: " + dicePair.getNumFaces() ;
		
		logger.log(Level.FINE, userInfo);
		//resultPanel.setTxt("Test1");
	}

	@Override
	public void result(Player player, DicePair result, GameEngine gameEngine)
	{
		logger.log(Level.INFO, player.toString());
		//resultPanel.setTxt(player.toString());
		//logger.log(Level.INFO, String.format("Player id: %s, Name: %s, Points: %s",player.getPlayerId(), player.getPlayerName(), player.getPoints()));
	}

	@Override
	public void intermediateHouseResult(DicePair dicePair, GameEngine gameEngine) 
	{
		logger.log(Level.FINE, String.format("HOUSE: ROLLING Dice 1: %d, Dice 2: %d.. Total: %d", dicePair.getDice1(), dicePair.getDice2(), dicePair.getDice1() + dicePair.getDice2()));
	}

	@Override
	public void houseResult(DicePair result, GameEngine gameEngine) 
	{
		logger.log(Level.INFO, String.format("HOUSE: *RESULT* Dice 1: %d, Dice 2: %d.. Total: %d",result.getDice1(), result.getDice2(), result.getDice1() + result.getDice2()));		
	}
	
	/*public void logPlayerResults(Player player, GameEngine gameEngine)
	{
		logger.log(Level.INFO, String.format("Player id: %s, Name: %s, Points: %s",player.getPlayerId(), player.getPlayerName(), player.getPoints()));
	}*/

}
