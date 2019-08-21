package model;

import model.interfaces.DicePair;

public class DicePairImpl implements DicePair 
{
	private int dice1;
	private int dice2;
	private int numFaces;
	
	public DicePairImpl(int dice1, int dice2, int numFaces)
	{
		this.dice1 = dice1;
		this.dice2 = dice2;
		this.numFaces = numFaces;
	}
	
	public void rollDice()
	{
		this.dice1=(int)(Math.random()*6+1);
		this.dice2=(int)(Math.random()*6+1);
	}
	
	@Override
	public int getDice1()
	{
		return dice1;
	}

	@Override
	public int getDice2()
	{
		return dice2;
	}

	@Override
	public int getNumFaces()
	{
		numFaces = dice1 + dice2;
		return numFaces;
	}
}
