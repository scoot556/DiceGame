package model.interfaces;

/**
 * Assignment interface for SADI representing the player
 * to be implemented by SimplePlayer class with the following constructor:
 * 	  public SimplePlayer(String playerId, String playerName, int initialPoints)
 * 
 * @author Caspar Ryan
 * 
 */
public interface Player
{	
	/**
	 * @return human readable player name
	 */
	public abstract String getPlayerName();

	/**
	 * @param playerName
	 *            human readable player name
	 */
	public abstract void setPlayerName(String playerName);

	/**
	 * 
	 * @return number of points from setPoints()
	 */
	public abstract int getPoints();

	/**
	 * @param points
	 *            for betting (updated by GameEngineImpl with each win or loss)
	 */
	public abstract void setPoints(int points);

	/**
	 * @return the player ID which is generated by the implementing class
	 */
	public abstract String getPlayerId();

	/**
	 * 
	 * @param bet
	 *            the bet in points
	 * @return true if the player had sufficient points and the bet was placed
	 */
	public abstract boolean placeBet(int bet);

	/**
	 * @return the bet as set with placeBet()
	 */
	public abstract int getBet();

	/**
	 * @return a DicePair containing both dice values (updated from the
	 *         GameEngine)
	 * @see model.interfaces.GameEngineCallback
	 */
	public abstract DicePair getRollResult();

	/**
	 * 
	 * @param rollResult
	 *            a DicePair containing both dice values (updated from the
	 *            GameEngine)
	 * @see model.interfaces.GameEngineCallback
	 */
	public abstract void setRollResult(DicePair rollResult);

	/**
	 * 
	 * @return a human readable String that lists the values of this Player
	 *         instance (see OutputTrace.txt)
	 */
	@Override
	public abstract String toString();
}